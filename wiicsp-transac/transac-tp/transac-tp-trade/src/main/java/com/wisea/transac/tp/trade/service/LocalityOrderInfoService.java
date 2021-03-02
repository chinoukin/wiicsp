package com.wisea.transac.tp.trade.service;

import ch.qos.logback.classic.Logger;
import com.google.common.collect.Maps;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.dao.LocalityOrderInfoMapper;
import com.wisea.transac.common.entity.LocalityOrderInfo;
import com.wisea.transac.common.entity.MembBaseInfo;
import com.wisea.transac.common.po.trade.LocalityOrderInfoListPo;
import com.wisea.transac.common.po.trade.OrderInfoPo;
import com.wisea.transac.common.utils.DeadLineUtils;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.PageStateCountResultVo;
import com.wisea.transac.common.vo.StateTypeVo;
import com.wisea.transac.common.vo.trade.MerchantOrderInfoListVo;
import com.wisea.transac.common.vo.trade.OrderInfoVo;
import com.wisea.transac.tp.trade.constants.OrdOperateEnum;
import com.wisea.transac.tp.trade.utils.OrderLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author jirg
 * @version 1.0
 * @className BaseOrderInfoService
 * @date 2020/7/3 15:53
 * @Description
 */
@Service
public class LocalityOrderInfoService extends BaseService {
    @Autowired
    private LocalityOrderInfoMapper mapper;
    @Autowired
    private LocalityOrdOpreateInfoService ordOpreateService;

    /**
     * @author jirg
     * @date 2020/7/3 16:02
     * @Description 查询数字基地订单列表
     */
    public ResultPoJo<PageStateCountResultVo<MerchantOrderInfoListVo>> findMerchantOrderList(LocalityOrderInfoListPo po) {
        LoggerUtil.infoWithContext("【findMerchantOrderList】商家/市场查询订单列表：", po);
        ResultPoJo<PageStateCountResultVo<MerchantOrderInfoListVo>> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        PageStateCountResultVo vo = new PageStateCountResultVo();

        User user = SystemUtils.getUser();
        MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(user.getId());
        po.setSellerId(membInfo.getMembId());

        Page<MerchantOrderInfoListVo> page = po.getPage();
        Map<String, Integer> stateCountMap = Maps.newHashMap();
        //查询各个订单状态下的数量
        po.setPage(null);
        List<StateTypeVo> typeVos = mapper.findCountByState(po);
        stateCountMap = typeVos.stream().collect(Collectors.toMap(StateTypeVo::getStateType, StateTypeVo::getCount));
        vo.setStateCountMap(stateCountMap);
        //查询订单列表
        po.setPage(page);
        List<MerchantOrderInfoListVo> list = mapper.findMerchantOrderList(po);
        page.setList(list);
        vo.setPage(page);
        resultPoJo.setResult(vo);
        return resultPoJo;
    }

    /**
     * 查询订单详细信息
     * @param po
     * @return
     */
    public ResultPoJo<OrderInfoVo> findOrderInfo(OrderInfoPo po) {
        LoggerUtil.infoWithContext("【findOrderInfo】查询订单详细信息：", po);
        ResultPoJo<OrderInfoVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        OrderInfoVo vo = mapper.findOrderInfo(po);
        if(ConverterUtil.isNotEmpty(vo)){
            vo.setNowDateTime(OffsetDateTime.now());
            resultPoJo.setResult(vo);


            //测试
        }else{
            resultPoJo.setCode(ConstantCodeMsg.ERR_004);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * @Author jirg
     * @Date 2020/5/6 16:47
     * @Description 确认订单
     **/
    @Transactional(readOnly = false)
    public ResultPoJo<?> confirmOrd(LongIdPo po) {
        LoggerUtil.infoWithContext("【updateDelivery】修改提货信息：", po);
        ResultPoJo<OrderInfoVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        LocalityOrderInfo orderInfo = mapper.selectByPrimaryKey(po.getId());
        if(ConverterUtil.isNotEmpty(orderInfo)){
            if(orderInfo.getBaseOrderStateType().equals(DictConstants.ORDER_STATE_TYPE_0)){
                orderInfo.setBaseOrderStateType(DictConstants.ORDER_STATE_TYPE_1);
                //计算付款截止日
                Integer reconcDeadlineDays = DeadLineUtils.getLimitDaysByType(DictConstants.DEAD_LINE_TYPE_1);
                orderInfo.setBuyPayClosingDate(OffsetDateTime.now().plusHours(reconcDeadlineDays));
                orderInfo.setSellerSureDate(OffsetDateTime.now());
                orderInfo.preUpdate();
                mapper.updateByPrimaryKey(orderInfo);
                Logger logger = OrderLogger.getLogger(orderInfo.getId());
                logger.info("【卖家】确认订单：{}", orderInfo);
                //插入订单操作记录
                ordOpreateService.saveOrdOperate(orderInfo.getId(), OrdOperateEnum.CONFIRMORD, null);
            }else{
                resultPoJo.setCode(ConstantCodeMsg.ERR_403);
                resultPoJo.setMsg(ConstantCodeMsg.MSG_403);
            }
        }else{
            resultPoJo.setCode(ConstantCodeMsg.ERR_004);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
        }
        return resultPoJo;
    }
}
