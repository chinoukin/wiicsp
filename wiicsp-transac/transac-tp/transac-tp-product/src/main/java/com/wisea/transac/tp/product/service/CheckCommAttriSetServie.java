package com.wisea.transac.tp.product.service;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.exception.VerifyException;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.entity.CommAttri;
import com.wisea.transac.common.po.product.CommAttriMagePo;
import com.wisea.transac.common.po.product.CommMageGetPo;
import com.wisea.transac.common.vo.product.CommAttriMageListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description:
 * @author: wangs
 * @date :2020/5/8
 */
@Service
public class CheckCommAttriSetServie {

    @Autowired
    CommAttriSetService commAttriSetService;
    /**
     * 设置发布商品属性
     *
     * @param commAttriPoList
     * @param commId
     * @param id
     * @return
     */
    public List<CommAttri> setCommAttris(List<CommAttriMagePo> commAttriPoList, Long commId, Long id) {

        List<CommAttri> commAttris = Lists.newArrayList();
        if (ConverterUtil.isNotEmpty(commAttriPoList)) {
            Map<Long, CommAttriMagePo> attriMageMap = commAttriPoList.stream().collect(Collectors.toMap(CommAttriMagePo::getCommAttriId, Function.identity(), (dto1, dto2) -> dto1));
            CommMageGetPo attriSet = new CommMageGetPo();
            attriSet.setId(commId);
            // 根据商品Id查询属性设置列表
            ResultPoJo<List<CommAttriMageListVo>> commAttriSets = commAttriSetService.findCommAttSetListByMageId(attriSet);
            List<CommAttriMageListVo> attriSetsResult = commAttriSets.getResult();
            if (ConverterUtil.isNotEmpty(attriSetsResult)) {
                //校验属性参数
                checkCommAttris(attriMageMap, attriSetsResult);
                //校验通过
                attriSetsResult.forEach(e -> {
                    CommAttri commAttri = new CommAttri();
                    commAttri.setCommPubId(id);
                    commAttri.setCommAttriName(e.getCommAttriName());
                    commAttri.setCommAttriColumn(e.getCommAttriColumn());
                    commAttri.setCommAttriType(e.getCommAttriType());
                    commAttri.setLength(e.getLength());
                    commAttri.setIfRequ(e.getIfRequ());
                    commAttri.setSort(e.getCamSort());
                    commAttri.setCommAttriId(e.getAttriId());
                    CommAttriMagePo commAttriPo = attriMageMap.get(e.getAttriId());
                    if (ConverterUtil.isNotEmpty(commAttriPo)) {
                        commAttri.setCommAttriVal(commAttriPo.getCommAttriVal());
                    }
                    commAttri.setDictVal(e.getDictTest());
                    commAttri.preInsert();
                    commAttris.add(commAttri);
                });
            }
        }
        return commAttris;
    }

    /**
     * 校验商品属性
     *
     * @param attriMageMap
     * @param attriSetsResult
     */
    private void checkCommAttris(Map<Long, CommAttriMagePo> attriMageMap, List<CommAttriMageListVo> attriSetsResult) {
        List<String> msgList = Lists.newArrayList();
        attriSetsResult.forEach(e -> {
            if (e.getIfRequ().equals(DictConstants.IF_REQU_0)) {
                //必填项
                CommAttriMagePo commAttriDto = attriMageMap.get(e.getAttriId());
                if (ConverterUtil.isNotEmpty(commAttriDto)) {
                    if (ConverterUtil.isEmpty(commAttriDto.getCommAttriVal())) {
                        msgList.add("【" + e.getCommAttriName() + "】 不能为空");
                    }
                } else {
                    msgList.add("【" + e.getCommAttriName() + "】 不能为空");
                }
            }

            //属性类型校验
            CommAttriMagePo commAttriDto = attriMageMap.get(e.getAttriId());
            if (ConverterUtil.isNotEmpty(commAttriDto)) {
                String commAttribtVal = commAttriDto.getCommAttriVal();
                try {
                    if (ConverterUtil.isNotEmpty(commAttribtVal)) {
                        if (e.getCommAttriType().equals(DictConstants.COMM_ATTRI_TYPE_0)) {
                            //文本，校验最大长度
                            if (commAttribtVal.trim().length() > e.getLength()) {
                                msgList.add("【" + e.getCommAttriName() + "】 最大长度不能超过" + e.getLength().toString());
                            }
                        } else if (e.getCommAttriType().equals(DictConstants.COMM_ATTRI_TYPE_2) || e.getCommAttriType().equals(DictConstants.COMM_ATTRI_TYPE_3)) {
                            //百分位数/整数， 校验最大值、最小值
                            Integer d = Integer.valueOf(commAttribtVal);
                            if (d < e.getMinVal()) {
                                msgList.add("【" + e.getCommAttriName() + "】 必须大于等于" + e.getMinVal().toString());
                            }
                            if (d > e.getMaxVal()) {
                                msgList.add("【" + e.getCommAttriName() + "】 必须小于等于" + e.getMaxVal().toString());
                            }
                        } else if (e.getCommAttriType().equals(DictConstants.COMM_ATTRI_TYPE_4)) {
                            //浮点数，校验小数位、最大值、最小值
                            if (e.getDecimalDig() > 0) {
                                String[] split = commAttribtVal.split("\\.");
                                if (split.length == 2) {
                                    //判断小数位最大值，最小值
                                    Double d = Double.valueOf(commAttribtVal);
                                    if (d < e.getMinVal().doubleValue()) {
                                        msgList.add("【" + e.getCommAttriName() + "】 必须大于等于" + e.getMinVal().toString());
                                    }
                                    if (d > e.getMaxVal().doubleValue()) {
                                        msgList.add("【" + e.getCommAttriName() + "】 必须小于等于" + e.getMaxVal().toString());
                                    }
                                } else {
                                    msgList.add("【" + e.getCommAttriName() + "】 需保留" + e.getDecimalDig().toString() + "位小数");
                                }
                            } else {
                                //判断最大值，最小值
                                try {
                                    Integer d = Integer.valueOf(commAttribtVal);
                                    if (d < e.getMinVal()) {
                                        msgList.add("【" + e.getCommAttriName() + "】 必须大于等于" + e.getMinVal().toString());
                                    }
                                    if (d > e.getMaxVal()) {
                                        msgList.add("【" + e.getCommAttriName() + "】 必须小于等于" + e.getMaxVal().toString());
                                    }
                                } catch (NumberFormatException e1) {
                                    msgList.add("【" + e.getCommAttriName() + "】 不能是小数");
                                }
                            }
                        }
                    }
                } catch (NumberFormatException e1) {
                    msgList.add("【" + e.getCommAttriName() + "】 格式输入错误");
                }
            }
        });

        if (ConverterUtil.isNotEmpty(msgList)) {
            String msg = msgList.stream().collect(Collectors.joining(";"));
            throw new VerifyException(ConstantError.ERR_005, msg);
        }
    }
}
