package com.wisea.transac.tp.trade.service;

import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.transac.common.dao.LocalityOrdOpreateInfoMapper;
import com.wisea.transac.common.entity.LocalityOrdOpreateInfo;
import com.wisea.transac.common.entity.MembBaseInfo;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.tp.trade.constants.OrdOperateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.time.OffsetDateTime;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className OrdOpreateInfoService
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Service
public class LocalityOrdOpreateInfoService extends BaseService {
    @Autowired
    private LocalityOrdOpreateInfoMapper mapper;

	/**
	 * @Author jirg
	 * @Date 2020/5/6 16:47
	 * @Description 保存订单操作记录
	 **/
	@Transactional(readOnly = false)
	public void saveOrdOperate(Long ordId, OrdOperateEnum ordOperateEnum, String remarks) {
		LoggerUtil.infoWithContext("【saveOrdOperate】保存订单操作记录：", ordId);
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
			userName = ConverterUtil.isNotEmpty(membInfo.getContName()) ? membInfo.getContName() : ConverterUtil.isNotEmpty(membInfo.getLoginName()) ? membInfo.getLoginName() : membInfo.getRegistTel();
		}else{
			userName = "系统";
		}
		if(ordOperateEnum.equals(OrdOperateEnum.SUBMIT)){
			//买家提交订单
			operator = MessageFormat.format(operatorFormat, buyer, userName);
			opreatContent = "提交订单";
		}else if(ordOperateEnum.equals(OrdOperateEnum.CONFIRMORD)){
			//卖家确认订单
			operator = MessageFormat.format(operatorFormat, seller, userName);
			opreatContent = "确认订单";
		}else if(ordOperateEnum.equals(OrdOperateEnum.PAY)){
			//买家支付订单
			operator = MessageFormat.format(operatorFormat, buyer, userName);
			opreatContent = "支付订单";
		}else if(ordOperateEnum.equals(OrdOperateEnum.DELIVERY)){
			//买家提货
			operator = MessageFormat.format(operatorFormat, seller, userName);
			opreatContent = "订单提货完成";
		}else if(ordOperateEnum.equals(OrdOperateEnum.PROPOSECANCEL)){
			//买家提出取消订单申请
			operator = MessageFormat.format(operatorFormat, buyer, userName);
			opreatContent = "买家提出取消订单申请".concat(ConverterUtil.isNotEmpty(remarks)? "，原因：".concat(remarks) : "");
		}else if(ordOperateEnum.equals(OrdOperateEnum.CANCEL)){
			//买家取消订单
			operator = MessageFormat.format(operatorFormat, buyer, userName);
			opreatContent = "取消订单";
		}else if(ordOperateEnum.equals(OrdOperateEnum.REJECTCANCEL)){
			//卖家拒绝取消订单
			operator = seller;
			opreatContent = "卖家拒绝取消申请".concat(ConverterUtil.isNotEmpty(remarks)? "，备注：".concat(remarks) : "");
		}else if(ordOperateEnum.equals(OrdOperateEnum.ASSENTCANCEL)){
			//卖家同意取消订单
			operator = seller;
			opreatContent = "卖家同意取消申请，订单已取消。";
		}else if(ordOperateEnum.equals(OrdOperateEnum.TIMEOUTDELIVERY)){
			//订单自提超时
			operator = system;
			opreatContent = "超时未提货，备注：争议订单";
		}else if(ordOperateEnum.equals(OrdOperateEnum.DISPUTEHANDLE)){
			//处理争议订单
			operator = MessageFormat.format(operatorFormat, system, userName);
			opreatContent = "争议处理完成".concat(ConverterUtil.isNotEmpty(remarks)? "，备注：".concat(remarks) : "");
		}else if(ordOperateEnum.equals(OrdOperateEnum.TIMEOUTCONFIRM)){
            //待确认超时订单
            operator = MessageFormat.format(operatorFormat, system, userName);
            opreatContent = "超时未确认订单，备注：确认超时";
        }else if(ordOperateEnum.equals(OrdOperateEnum.TIMEOUTPAY)){
            //代付款超时订单
            operator = MessageFormat.format(operatorFormat, system, userName);
            opreatContent = "超时未付款订单，备注：付款超时";
        }else if(ordOperateEnum.equals(OrdOperateEnum.INVOICING)){
            //卖家开票
            operator = MessageFormat.format(operatorFormat, system, userName);
            opreatContent = "卖家开票";
        }else if(ordOperateEnum.equals(OrdOperateEnum.RENEWINVOICING)){
            //卖家重新开票
            operator = MessageFormat.format(operatorFormat, system, userName);
            opreatContent = "卖家重新开票";
        }

		//记录订单操作记录
		LocalityOrdOpreateInfo ordOpreateInfo = new LocalityOrdOpreateInfo();
		ordOpreateInfo.setOperator(operator);
		ordOpreateInfo.setOrdId(ordId);
		ordOpreateInfo.setOpreatDate(OffsetDateTime.now());
		ordOpreateInfo.setOpreatContent(opreatContent);
		ordOpreateInfo.preInsert();
		mapper.insert(ordOpreateInfo);
	}
}
