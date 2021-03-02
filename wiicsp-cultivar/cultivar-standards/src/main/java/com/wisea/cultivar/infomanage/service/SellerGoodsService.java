package com.wisea.cultivar.infomanage.service;

import com.google.common.collect.Maps;
import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.service.SystemCacheService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cultivar.common.constants.ConstantCodeMsg;
import com.wisea.cultivar.common.constants.DictConstants;
import com.wisea.cultivar.common.dao.*;
import com.wisea.cultivar.common.entity.CommPubInfo;
import com.wisea.cultivar.common.po.product.CommPubInfoGetPo;
import com.wisea.cultivar.common.po.product.UpdateCommPubInfoStatesPo;
import com.wisea.cultivar.common.vo.product.CommPubInfoInfoVo;
import com.wisea.cultivar.constants.QdcyStandardsError;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description: 商家商品service
 * @author: wangs
 * @date :2018/9/18
 */
@Service
@Transactional(readOnly = true)
public class SellerGoodsService extends BaseService {

    @Autowired
    CommPubInfoMapper commPubInfoMapper;
    @Autowired
    JedisDao jedisDao;
    @Autowired
    SystemCacheService systemCacheService;
    @Autowired
    MeasUnitMageMapper measUnitMageMapper;
    @Autowired
    LevelSpecQuoteMapper levelSpecQuoteMapper;
    @Autowired
    PlaceOriginMageMapper placeOriginMageMapper;
    @Autowired
    CommSaleSetMapper commSaleSetMapper;
    @Autowired
    NoticeService noticeService;
    /**
     * 销售中的商品 - 批量驳回操作
     *
     * @param info
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo updateCommPubInfoState(UpdateCommPubInfoStatesPo info) {
        ResultPoJo poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        if (checkChooseOne(info, poJo)) {
            return poJo;
        }
        User user = SystemUtils.getUser();
        if(ConverterUtil.isEmpty(user)){
            poJo.setCode(ConstantCodeMsg.ERR_912);
            poJo.setMsg(ConstantCodeMsg.MSG_912);
            return poJo;
        }
        CommPubInfo commPubInfo = new CommPubInfo();
        commPubInfo.setCommStateType(info.getStateType());
        commPubInfo.setRejectReason(info.getRejectReason());
        commPubInfo.setExamId(user.getParentId());
        commPubInfo.preUpdate();
        Map<String, Object> maps = Maps.newHashMap();
        maps.put("commPubInfo", commPubInfo);
        maps.put("ids", info.getIds());

        if (info.getStateType().equals(DictConstants.COMM_STATE_TYPE_4)) {
            // 只有销售中和待审核状态下的商品可以进行驳回
            maps.put("stateType", DictConstants.COMM_STATE_TYPE_0);
            maps.put("commStateType", DictConstants.COMM_STATE_TYPE_2);
            List<CommPubInfo> commPubInfos = commPubInfoMapper.findListByCommPubInfoStateType(maps);
            if (CollectionUtils.isNotEmpty(commPubInfos)) {
                // 修改发布商品状态
                List<Long> ids = commPubInfos.stream().map(CommPubInfo::getId).collect(Collectors.toList());
                maps.put("ids", ids);
                commPubInfoMapper.updateCommPubInfoState(maps);
                return poJo;
            } else {
                poJo.setCode(QdcyStandardsError.ERR_60002);
                poJo.setMsg(QdcyStandardsError.MSG_60002);
                LoggerUtil.infoWithContext("批量修改商品发布状态-错误信息【{}】", info, QdcyStandardsError.MSG_60002);
                return poJo;
            }
        }
        if (info.getStateType().equals(DictConstants.COMM_STATE_TYPE_0)) {
            // 只有待审核中状态下的商品可以批量审核状态为销售中
            maps.put("stateType", DictConstants.COMM_STATE_TYPE_2);
            List<CommPubInfo> commPubInfos = commPubInfoMapper.findListByCommPubInfoStateType(maps);
            if (CollectionUtils.isNotEmpty(commPubInfos)) {
                // 修改发布商品状态
                List<Long> ids = commPubInfos.stream().map(CommPubInfo::getId).collect(Collectors.toList());
                maps.put("ids", ids);
                commPubInfoMapper.updateCommPubInfoState(maps);
                return poJo;
            } else {
                poJo.setCode(ConstantCodeMsg.ERR_403);
                poJo.setMsg(ConstantCodeMsg.MSG_403);
                LoggerUtil.infoWithContext("批量修改商品发布状态-错误信息【{}】", info, ConstantCodeMsg.MSG_403);
                return poJo;
            }
        }
        return poJo;
    }
    /**
     * 商品详情
     *
     * @param commPubInfoGetPo
     * @return
     */
    public ResultPoJo<CommPubInfoInfoVo> details(CommPubInfoGetPo commPubInfoGetPo) {

        ResultPoJo<CommPubInfoInfoVo> poJo = new ResultPoJo<>(ConstantCodeMsg.ERR_000);

        if (ConverterUtil.isEmpty(commPubInfoGetPo.getId())) {
            poJo.setCode(ConstantCodeMsg.ERR_385);
            poJo.setMsg(ConstantCodeMsg.MSG_385);
            return poJo;
        }
        CommPubInfoInfoVo infoVo = commPubInfoMapper.findById(commPubInfoGetPo);
        if (ConverterUtil.isEmpty(infoVo)) {
            poJo.setCode(ConstantCodeMsg.ERR_377);
            poJo.setMsg(ConstantCodeMsg.MSG_377);
            return poJo;
        }

        poJo.setResult(infoVo);
        return poJo;
    }

    /**
     * 至少勾选一个信息
     *
     * @param info
     * @param poJo
     * @return
     */
    private boolean checkChooseOne(UpdateCommPubInfoStatesPo info, ResultPoJo poJo) {
        if (CollectionUtils.isEmpty(info.getIds())) {
            poJo.setCode(ConstantCodeMsg.ERR_362);
            poJo.setMsg(ConstantCodeMsg.MSG_362);
            LoggerUtil.infoWithContext("修改商品发布状态-错误信息【{}】", info, ConstantCodeMsg.MSG_362);
            return true;
        }
        return false;
    }
}
