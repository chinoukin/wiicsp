package com.wisea.transac.tp.trade.service;

import java.time.OffsetDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.transac.common.dao.DivideEventMapper;
import com.wisea.transac.common.dao.IncomeDetailMapper;
import com.wisea.transac.common.dao.OrderInfoMapper;
import com.wisea.transac.common.dao.SettleBillMapper;
import com.wisea.transac.common.entity.DivideEvent;
import com.wisea.transac.common.entity.IncomeDetail;
import com.wisea.transac.common.entity.OrderInfo;
import com.wisea.transac.common.entity.SettleBill;
import com.wisea.tpb.common.pay.entity.DivideRecord;
import com.wisea.yspay.constants.DivisionStatusCode;
import com.wisea.yspay.notify.handler.DivisionNotificationHandler;

/**
 * 订单支付相关Service
 */
@Service
public class DividResponService extends DivisionNotificationHandler {
	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private SettleBillMapper settleBillMapper;
	@Autowired
    private DivideEventMapper divideEventMapper;
	@Autowired
    private OrderInfoMapper mapper;
	@Autowired
    private IncomeDetailMapper incomeDetailMapper;

    @Override
    protected void handle(DivideRecord record) {
        //查询分账事件
        DivideEvent divideEvent = divideEventMapper.selByOrdDateId(record.getOrdId());

        if (ConverterUtil.isNotEmpty(divideEvent)) {
            //成功
            if (DivisionStatusCode.ADVANCE_SUCCESS.code().equals(record.getDivideState())) {
                //解析分账信息
                String[] splt = divideEvent.getDivideDetail().split(";");
                //卖家收入信息
                String[] sellerParams = splt[0].split("\\^");
                Double divAmount = Double.valueOf(sellerParams[1]);
                //平台服务费信息
                String[] platParams = splt[1].split("\\^");
                Double platAmount = Double.valueOf(platParams[1]);
                //获取订单、结算单信息
                Long ordId = null;
                IncomeDetail incomeDetail = new IncomeDetail();
                //判断是账期还是订单
                if ("1".equals(divideEvent.getRemarks())) {
                    //账期
                    String[] spl = record.getOrdId().split("-");
                    Long sellId = ConverterUtil.toLong(spl[0]);
                    ordId = sellId;
                    SettleBill settleBill = settleBillMapper.selectByPrimaryKey(sellId);
                    incomeDetail.setMembId(settleBill.getSellerId());
                    incomeDetail.setSettleBillNumb(settleBill.getSettleBillNumb());
                }else {
                    //普通订单
                    ordId = ConverterUtil.toLong(divideEvent.getOrdId());
                    OrderInfo orderInfo = mapper.selectByPrimaryKey(ordId);
                    incomeDetail.setMembId(orderInfo.getSellerId());
                    incomeDetail.setOrdNum(orderInfo.getOrdNum());
                }
                incomeDetail.setSettOrdId(ordId);
                incomeDetail.setTradeNo(record.getTradeNo());
                //买家付款金额=卖家收入+平台服务费
                incomeDetail.setCommTotalPrice(ConverterUtil.add(divAmount, platAmount));
                incomeDetail.setFinishDate(OffsetDateTime.now());
                //分账收入=卖家收入
                incomeDetail.setSplitIncome(divAmount);
                //运营服务费=平台收入
                incomeDetail.setOperSerCharge(platAmount);
                incomeDetail.preInsert();
                incomeDetailMapper.insertSelective(incomeDetail);
            }else if (DivisionStatusCode.DIVISION_FAIL.code().equals(record.getDivideState())) {//失败
                //失败则重新调用分账
                divideEvent.setExeState("2");
                divideEvent.preUpdate();
                divideEventMapper.updateByPrimaryKeySelective(divideEvent);
            }else {
            }
        }
    }
}
