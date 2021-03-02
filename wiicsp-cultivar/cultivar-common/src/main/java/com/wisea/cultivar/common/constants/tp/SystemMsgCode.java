package com.wisea.cultivar.common.constants.tp;

/**
 * 系统消息CODE
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月14日
 * @version 1.0
 */
public class SystemMsgCode {

	/**-----个人企业审核的处理 ----开始---------------**/
	/** 个人认证  标题 **/
	public final static String SYSM_PERSON_AUTH_TITLE = "个人身份认证";
	/** 个人认证 -平台审核不通过时发送 */
    public final static String SYSM_PERSON_AUTH_UNPASS = "sysm_person_auth_unpass";
    /** 个人认证 -平台审核通过时发送 */
    public final static String SYSM_PERSON_AUTH_PASS = "sysm_person_auth_pass";
    /** 企业身份认证  标题 **/
	public final static String SYSM_ENTP_AUTH_TITLE = "企业身份认证";
    /** 企业认证 -审核不通过时发送*/
    public final static String SYSM_ENTP_AUTH_UNPASS = "sysm_entp_auth_unpass";
    /** 企业认证 -求购商审核通过时发送*/
    public final static String SYSM_ENTP_BUY_AUTH_UNPASS = "sysm_entp_buy_auth_pass";
    /** 企业认证 -供应商审核通过时发送*/
    public final static String SYSM_ENTP_SEL_AUTH_UNPASS = "sysm_entp_sel_auth_pass";
    /**-----个人企业审核的处理 ----结束---------------**/
    /**-----长协合同 ----开始---------------**/
    /** 长协合同标题*/
    public final static String SYSM_LTACONT_TITLE = "长期合同信息";
    /** 商家拟定合同成功时发送*/
    public final static String SYSM_LTACONT_CONF = "sysm_ltacont_conf";
    /** 买卖双方合同到期时同步发送*/
    public final static String SYSM_LTACONT_ENDDATE = "sysm_ltacont_enddate";
    /** 买卖双方一方发起时，另一方接收*/
    public final static String SYSM_LTACONT_APPLY_END = "sysm_ltacont_apply_end";
    /** 买卖双方一方确认终止时，另一方接收*/
    public final static String SYSM_LTACONT_END = "sysm_ltacont_end";
    /** 平台强制解除时，买卖双方接收*/
    public final static String SYSM_LTACONT_FORCE_END = "sysm_ltacont_force_end";
    /**-----长协合同 ----结束---------------**/


}
