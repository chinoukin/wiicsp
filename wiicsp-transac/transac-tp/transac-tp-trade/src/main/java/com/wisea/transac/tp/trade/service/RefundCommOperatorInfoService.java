package com.wisea.transac.tp.trade.service;

import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.transac.common.dao.RefundCommOperatorInfoMapper;
import com.wisea.transac.common.entity.MembBaseInfo;
import com.wisea.transac.common.entity.RefundCommOperatorInfo;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.tp.trade.constants.RefundOperateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.time.OffsetDateTime;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className RefundCommOperatorInfoService
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Service
public class RefundCommOperatorInfoService extends BaseService {
    @Autowired
    private RefundCommOperatorInfoMapper mapper;

	/**
	 * @Author jirg
	 * @Date 2020/5/6 16:47
	 * @Description 保存订单操作记录
	 **/
	@Transactional(readOnly = false)
	public void saveRefundOperate(Long refundId, RefundOperateEnum refundOperateEnum, String remarks) {
		LoggerUtil.infoWithContext("【saveRefundOperate】保存订单操作记录：", refundId);
		User user = SystemUtils.getUser();
		MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(user.getId());
		String operatorFormat = "{0}({1})";
		String operator = ""; //操作者
		String opreatContent = ""; //操作记录

		String buyer = "买家";
		String seller = "卖家";
		String system = "系统";
		String userName = ConverterUtil.isNotEmpty(membInfo.getContName()) ? membInfo.getContName() : ConverterUtil.isNotEmpty(membInfo.getLoginName()) ? membInfo.getLoginName() : membInfo.getRegistTel();
		if(refundOperateEnum.equals(RefundOperateEnum.SUBMIT)){
			//卖家提交取消订单申请
			operator = MessageFormat.format(operatorFormat, buyer, userName);
			opreatContent = "提交取消订单申请至商家审核，原因：".concat(ConverterUtil.isNotEmpty(remarks)? "，备注：".concat(remarks) : "");
		}else if(refundOperateEnum.equals(RefundOperateEnum.ASSENT)){
			//卖家同意退款申请
			operator = MessageFormat.format(operatorFormat, seller, userName);
			opreatContent = "审核通过，退款金额将原路返回支付账户。";
		}else if(refundOperateEnum.equals(RefundOperateEnum.CANCEL)){
            //买家取消退款申请
            operator = MessageFormat.format(operatorFormat, buyer, userName);
            opreatContent = "买家取消退款申请。";
        }else if(refundOperateEnum.equals(RefundOperateEnum.REJECT)){
			//卖家拒绝退款申请
			operator = MessageFormat.format(operatorFormat, seller, userName);
			opreatContent = "审核不通过".concat(ConverterUtil.isNotEmpty(remarks)? "，备注：".concat(remarks) : "");
		}else if(refundOperateEnum.equals(RefundOperateEnum.DELIVERY)){
			//卖家提货，未全部提完产生的自动退款
			operator = MessageFormat.format(operatorFormat, seller, userName);
			opreatContent = "商家提交了退款单，退款金额将原路返回支付账户。";
		}

		//记录订单操作记录
		RefundCommOperatorInfo refundOpreateInfo = new RefundCommOperatorInfo();
		refundOpreateInfo.setOperator(operator);
		refundOpreateInfo.setRefundApplId(refundId);
		refundOpreateInfo.setOpreatDate(OffsetDateTime.now());
		refundOpreateInfo.setOpreatContent(opreatContent);
		refundOpreateInfo.preInsert();
		mapper.insert(refundOpreateInfo);
	}

}
