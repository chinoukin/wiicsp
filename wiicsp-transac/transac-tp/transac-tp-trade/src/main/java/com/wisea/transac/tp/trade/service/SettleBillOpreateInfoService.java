package com.wisea.transac.tp.trade.service;

import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.transac.common.dao.SettleBillOpreateInfoMapper;
import com.wisea.transac.common.entity.MembBaseInfo;
import com.wisea.transac.common.entity.SettleBillOpreateInfo;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.tp.trade.constants.SettleBillOperateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.time.OffsetDateTime;

/**
 * @author jirg
 * @version 1.0
 * @className SettleBillOpreateInfoService
 * @date 2020/5/20 14:12
 * @Description
 */
@Service
public class SettleBillOpreateInfoService extends BaseService {

    @Autowired
    private SettleBillOpreateInfoMapper mapper;

    /**
     * @Author jirg
     * @Date 2020/5/6 16:47
     * @Description 保存订单操作记录
     **/
    @Transactional(readOnly = false)
    public void saveSettleBillOperate(Long settleBillId, SettleBillOperateEnum operateEnum, String remarks) {
        LoggerUtil.infoWithContext("【saveSettleBillOperate】保存结算单操作记录：", settleBillId);
        User user = SystemUtils.getUser();
        MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(user.getId());
        String operatorFormat = "{0}({1})";
        String operator = ""; //操作者
        String opreatContent = ""; //操作记录

        String buyer = "买家";
        String seller = "卖家";
        String system = "系统";

        String userName = "";
        if(ConverterUtil.isNotEmpty(membInfo)){
            userName = ConverterUtil.isNotEmpty(membInfo.getContName()) ? membInfo.getContName() : membInfo.getRegistTel();
        }else{
            userName = "系统";
        }
        if(operateEnum.equals(SettleBillOperateEnum.SYSTEM_GENERATE)){
            //系统生成结算单
            operator = system;
            opreatContent = "系统生成结算单";
        }else if(operateEnum.equals(SettleBillOperateEnum.BUYER_GENERATE)){
            //买家提前生成结算单
            operator = MessageFormat.format(operatorFormat, buyer, userName);
            opreatContent = "买家提前生成结算单";
        }else if(operateEnum.equals(SettleBillOperateEnum.BUYER_RECON)){
            //买家对账完成
            operator = MessageFormat.format(operatorFormat, buyer, userName);
            opreatContent = "买家对账完成";
        }else if(operateEnum.equals(SettleBillOperateEnum.SELLER_RECON)){
            //卖家家对账完成
            operator = MessageFormat.format(operatorFormat, seller, userName);
            opreatContent = "卖家家对账完成";
        }else if(operateEnum.equals(SettleBillOperateEnum.INVOICING)){
            //供应商开票
            operator = MessageFormat.format(operatorFormat, seller, userName);
            opreatContent = "供应商开票";
        }else if(operateEnum.equals(SettleBillOperateEnum.RENEW_INVOICING)){
            //供应重新商开票
            operator = MessageFormat.format(operatorFormat, seller, userName);
            opreatContent = "供应重新商开票";
        }else if(operateEnum.equals(SettleBillOperateEnum.BUYER_PAY)){
            //采购商支付
            operator = MessageFormat.format(operatorFormat, buyer, userName);
            opreatContent = "采购商支付";
        }else if(operateEnum.equals(SettleBillOperateEnum.INVO_PASS)){
            //验票通过
            operator = MessageFormat.format(operatorFormat, buyer, userName);
            opreatContent = "验票通过";
        }else if(operateEnum.equals(SettleBillOperateEnum.INVO_DISSENT)){
            //验票异议
            operator = MessageFormat.format(operatorFormat, buyer, userName);
            opreatContent = "验票异议";
        }else if(operateEnum.equals(SettleBillOperateEnum.REMIND_PAYMENT)){
            //提醒采购商支付
            operator = MessageFormat.format(operatorFormat, seller, userName);
            opreatContent = "提醒采购商支付";
        }else if(operateEnum.equals(SettleBillOperateEnum.OUTTIME_RECON)){
            //对账超时自动对账
            operator = MessageFormat.format(operatorFormat, seller, userName);
            opreatContent = "对账超时自动对账";
        }else if(operateEnum.equals(SettleBillOperateEnum.OUTTIME_INVO_DISSENT)){
            //超时未验票自动验票
            operator = MessageFormat.format(operatorFormat, seller, userName);
            opreatContent = "超时未验票自动验票";
        }

        //记录订单操作记录
        SettleBillOpreateInfo opreateInfo = new SettleBillOpreateInfo();
        opreateInfo.setOperator(operator);
        opreateInfo.setSettleId(settleBillId);
        opreateInfo.setOpreatDate(OffsetDateTime.now());
        opreateInfo.setOperatorContent(opreatContent.concat(ConverterUtil.isNotEmpty(remarks) ? "  备注：".concat(remarks) : ""));
        opreateInfo.preInsert();
        mapper.insert(opreateInfo);
    }

}
