package com.wisea.cultivar.infomanage.service;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.entity.DiffInfos;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.constants.ConstantCodeMsg;
import com.wisea.cultivar.common.dao.CommAttriMageMapper;
import com.wisea.cultivar.common.dao.CommAttriSetMapper;
import com.wisea.cultivar.common.dao.CommMageMapper;
import com.wisea.cultivar.common.entity.ZhfwCommAttriMage;
import com.wisea.cultivar.common.entity.ZhfwCommAttriSet;
import com.wisea.cultivar.common.po.DelAllPo;
import com.wisea.cultivar.common.po.product.CommAttriMageGetPo;
import com.wisea.cultivar.common.po.product.CommAttriMagePagePo;
import com.wisea.cultivar.common.vo.product.CommAttriMageGetVo;
import com.wisea.cultivar.common.vo.product.CommAttriMageListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @Author:Liangzy(Wisea)
 * @Date:Create in 2018/9/19 下午4:14
 * @Description:商品属性接口业务类
 */
@Service
@Transactional(readOnly = false)
public class CommAttriService {


    @Autowired
    CommAttriMageMapper commAttriMageMapper;

    @Autowired
    CommAttriSetMapper commAttriSetMapper;

    @Autowired
    CommMageMapper commMageMapper;

    /**
     * 商品属性列表
     */
    public Page<CommAttriMageListVo> selectList(CommAttriMagePagePo po) {
        Page<CommAttriMageListVo> page = po.getPage();
        List<CommAttriMageListVo> commAttriMageList = commAttriMageMapper.selectList(po);
        page.setList(commAttriMageList);
        return page;
    }

    /**
     * 添加商品属性
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public ResultPoJo addCommAttri(ZhfwCommAttriMage po) {
        ResultPoJo<Object> poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        po.preInsert();
        //如果是下拉框类型的时候
        if (po.getCommAttriType().equals("1")) {
            po.setRemarks(po.getDictVal());
            StringBuffer buffer = new StringBuffer();
            String str = null;
            buffer = getDictValueStringBuffer(po, buffer, str);

            po.setDictVal(buffer.toString());
        }
        commAttriMageMapper.insertSelective(po);
        return poJo;
    }

    /**
     * 组装下拉框的值
     *
     * @param po
     * @param buffer
     * @param str
     * @return
     */
    private StringBuffer getDictValueStringBuffer(ZhfwCommAttriMage po, StringBuffer buffer, String str) {
        //首先得到每个option
        String[] split = po.getDictVal().split(";");
        for (String singleString : split) {
            String[] key = singleString.split(",");
            //随机生成数字
            String value = getRandomNum(4);
            //组装字符串
            if (key.length == 2) {
                str = key[0] + ":" + value + "," + key[1] + ";";
            } else if (key.length == 1) {
                str = key[0] + ":" + value + "," + "NULL;";
            }
            //buffer累加
            buffer = buffer.append(str);
        }
        return buffer;
    }

    /**
     * 编辑商品属性
     */
    public ResultPoJo<ZhfwCommAttriMage> editCommAttri(CommAttriMageGetPo po) {
        ResultPoJo<ZhfwCommAttriMage> pojo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //如果属性已经与商品关联了，那么就不能进行修改
        List<ZhfwCommAttriSet> zhfwCommAttriSets = commAttriSetMapper.selectCommAttriById(po.getId());
        if (zhfwCommAttriSets.size() > 0) {
            pojo.setCode(ConstantCodeMsg.ERR_312);
            pojo.setMsg(ConstantCodeMsg.MSG_312);
            return pojo;
        }
        ZhfwCommAttriMage zhfwCommAttriMage = commAttriMageMapper.selectByPrimaryKey(po.getId());
        pojo.setResult(zhfwCommAttriMage);
        return pojo;
    }

    /**
     * 修改商品属性
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public ResultPoJo modifyCommAttri(ZhfwCommAttriMage po) {
        ResultPoJo resultPoJo = new ResultPoJo(ConstantCodeMsg.NOMAL);
        if (("1").equals(po.getCommAttriType())) {
            po.setDictVal(po.getRemarks());
            StringBuffer buffer = new StringBuffer();
            String str = null;
            //首先得到每个option
            buffer = getDictValueStringBuffer(po, buffer, str);
            po.setDictVal(buffer.toString());
            // 拆分字段
            String[] oriArray = po.getDictVal().split(";");
            String[] tarArray = po.getRemarks().split(";");
            //转化为数组
            List<String> oriList = Lists.newArrayList(oriArray);
            List<String> tarList = Lists.newArrayList(tarArray);
            //通过冒号以及逗号拆分为数组
            List<String> oriTextList = oriList.stream().map(o -> {
                return o.substring(0, o.indexOf(":"));
            }).collect(Collectors.toList());
            List<String> tarTextList = tarList.stream().map(o -> {
                return o.substring(0, o.indexOf(","));
            }).collect(Collectors.toList());
            //数据差分
            DiffInfos<String> diffInfos = ConverterUtil.diff(oriTextList, tarTextList);
            List<String> insList = diffInfos.getInsertList();
            List<String> delList = diffInfos.getDeleteList();
            List<Integer> delIndexs = Lists.newArrayList();
            for (String del : delList) {
                for (int i = 0; i < oriTextList.size(); i++) {
                    if (oriTextList.get(i).equals(del)) {
                        delIndexs.add(i);
                        break;
                    }
                }
            }
            for (Integer deli : delIndexs) {
                oriList.set(deli.intValue(), "false");
            }
            oriList.removeAll(Collections.singleton("false"));
            if (insList.size() > 0) {
                for (int y = 0; y < insList.size(); y++) {
                    String ins = insList.get(y);
                    for (int i = 0; i < tarTextList.size(); i++) {
                        if (tarTextList.get(i).equals(ins)) {
                            insList.set(y, tarList.get(i));
                            break;
                        }
                    }
                }
                List<String> insConvList = insList.stream().map(i -> {
                    return i.replace(",", ":" +
                            ConverterUtil.getCheckCode((ConverterUtil.RANDOM_TYPE_NUM_AND_TEXT).toLowerCase(), 3) + ",");
                }).collect(Collectors.toList());
                oriList.addAll(insConvList);
            }
            //入参修改dict_val字段
            po.setDictVal(oriList.stream().collect(Collectors.joining(";")) + ";");
        }
        commAttriMageMapper.updateByPrimaryKeySelective(po);
        return resultPoJo;
    }

    /**
     * 删除商品属性
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public ResultPoJo delCommAttri(ZhfwCommAttriMage po) {
        ResultPoJo pojo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //删除之前需要查询这个属性有没有与商品建立关系
        List<ZhfwCommAttriSet> zhfwCommAttriSets = commAttriSetMapper.selectCommAttriById(po.getId());
        if (zhfwCommAttriSets.size() > 0) {
            pojo.setCode(ConstantCodeMsg.ERR_322);
            pojo.setMsg(ConstantCodeMsg.MSG_322);
            return pojo;
        }
        commAttriMageMapper.deleteLogic(po);
        return pojo;
    }


    /**
     * 属性字段的唯一验证
     */
    public ResultPoJo getAttriColumnOnlyState(ZhfwCommAttriMage po) {
        ResultPoJo<Object> poJo = new ResultPoJo<>();
        List<CommAttriMageGetVo> attriColumnOnlyState = commAttriMageMapper.getAttriColumnOnlyState(po);
        if (attriColumnOnlyState.size() == 0) {
            poJo.setCode(ConstantCodeMsg.NOMAL);
            poJo.setMsg(ConstantCodeMsg.MSG_000);
        } else {
            poJo.setCode(ConstantCodeMsg.ERR_315);
            poJo.setMsg(ConstantCodeMsg.MSG_315);
        }
        return poJo;
    }

    /**
     * 用来随机生成几位数
     *
     * @param
     * @return String
     */
    public String getRandomNum(Integer num) {
        String s = UUID.randomUUID().toString();
        String substring = s.substring(1, num);
        return substring;
    }

    public ResultPoJo<Object> batDelete(DelAllPo po) {
        ResultPoJo pojo = new ResultPoJo<>();
        for (Long id : po.getIds()) {

            //删除之前需要查询这个属性有没有与商品建立关系
            List<ZhfwCommAttriSet> zhfwCommAttriSets = commAttriSetMapper.selectCommAttriById(id);
            if (zhfwCommAttriSets.size() > 0) {
                pojo.setCode(ConstantCodeMsg.ERR_322);
                pojo.setMsg(ConstantCodeMsg.MSG_322);
                return pojo;
            }
            ZhfwCommAttriMage zhfwCommAttriMage = new ZhfwCommAttriMage();
            zhfwCommAttriMage.setId(id);
            zhfwCommAttriMage.setDelFlag("1");
            commAttriMageMapper.updateByPrimaryKey(zhfwCommAttriMage);
        }
        pojo.setCode("000");
        return pojo;
    }
}
