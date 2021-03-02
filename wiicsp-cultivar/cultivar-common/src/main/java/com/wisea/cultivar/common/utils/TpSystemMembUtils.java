package com.wisea.cultivar.common.utils;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.constants.Constants;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.OffsetDateTimeUtils;
import com.wisea.cultivar.common.constants.DictConstants;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

/**
 * 会员相关的工具类
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月25日
 * @version 1.0
 */
public class TpSystemMembUtils {

	/**
	 * 供应商审核标识
	 */
	public static String SELLER_AUTH_FLAG = "seller";
	/**
	 * 供应商审核标识
	 */
	public static String SUPPLIER_AUTH_FLAG = "supplier";

	public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	/**
	 * 状态的修改
	 *   用户表中0停用1启用 员工表中0启用1停用之间的转换
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月6日
	 * @version 1.0
	 */
	public static String changeFlag(String flag){
		// 启用
		if(DictConstants.EFFE_INVAL_STATE_0.equals(flag)){
			return Constants.YES;
		}
		// 停用
		if(DictConstants.EFFE_INVAL_STATE_1.equals(flag)){
			return Constants.NO;
		}
		return null;
	}
	/**
	 * 将用户表中的登录状态修改成会员中的状态
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月25日
	 * @version 1.0
	 */
	public static String changeAcctState(String acctState){
		// 启用
		if(DictConstants.ACCT_STATE_0.equals(acctState)){
			return Constants.YES;
		}
		// 停用
		if(DictConstants.ACCT_STATE_1.equals(acctState)){
			return Constants.NO;
		}
		return null;
	}
	/**
	 * 客户类型的转换
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月25日
	 * @version 1.0
	 */
	public static String changeCustType(String custType){
		// 企业
		if(DictConstants.CUST_TYPE_0.equals(custType)){
			return "B";
		}
		// 个体户
		if(DictConstants.CUST_TYPE_1.equals(custType)){
			return "C";
		}
		return null;
	}
	/**
	 * 账户类型的转换
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月25日
	 * @version 1.0
	 */
	public static String changeBankAcctType(String bankAcctType){
		// 企业
		if(DictConstants.BANK_ACCT_TYPE_0.equals(bankAcctType)){
			return "corporate";
		}
		// 个体户
		if(DictConstants.BANK_ACCT_TYPE_1.equals(bankAcctType)){
			return "personal";
		}
		return null;
	}
	/**
	 * 银盛企业入网的唯一标识(通过会员ID加密)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月25日
	 * @version 1.0
	 */
	public static String getMerchantNo(Long membId){
		if(ConverterUtil.isEmpty(membId)){
			return null;
		}
		return ConverterUtil.toString(OffsetDateTimeUtils.getLong()).concat("_").concat(ConverterUtil.toString(membId));
	}
	/**
	 * 解析唯一标识成会员ID
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月25日
	 * @version 1.0
	 */
	public static String parseMemb(String merchantNo){
		if(merchantNo != null && merchantNo.contains("_")) {
			return merchantNo.substring(merchantNo.indexOf("_")+1);
		}else{
			return null;
		}
	}
	/**
     * 获取本月的第一天
     *
     * @return
     */
    public static String getFirstDayOfThisMonth(OffsetDateTime date) {
        return date.with(TemporalAdjusters.firstDayOfMonth()).format(DATE_FORMATTER);
    }

    /**
     * 获取本月的最后一天
     *
     * @return
     */
    public static String getLastDayOfThisMonth(OffsetDateTime date) {
        return date.with(TemporalAdjusters.lastDayOfMonth()).format(DATE_FORMATTER);
    }
    /**
     * 获取某月的最大天数
     *
     * @author wangh(wisea)
     *
     * @date 2020年6月3日
     * @version 1.0
     */
	public static int getMonthAllDay(OffsetDateTime date){
		return ConverterUtil.toInteger(date.with(TemporalAdjusters.lastDayOfMonth()).format(DateTimeFormatter.ofPattern("dd")));
	}
	/**
	 * 获取当前某月天数的列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月3日
	 * @version 1.0
	 */
    public static List<String> getMonthDayList(OffsetDateTime date){
    	List<String> list = Lists.newArrayList();
    	String yyyymm = OffsetDateTimeUtils.formatDateTime(date, "yyyy-MM");
    	for(int i = 1; i <= getMonthAllDay(date); i++){
    		list.add(yyyymm+"_"+String.format("%02d",i));
    	}
    	return list;
    }
	public static void main(String[] args) {
		 Double interval = ConverterUtil.div(ConverterUtil.sub(43.0, 0), 8, 0);
		 System.out.println("1".equals(null));

	}
}
