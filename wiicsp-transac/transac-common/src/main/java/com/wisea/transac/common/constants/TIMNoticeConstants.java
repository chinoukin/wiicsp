package com.wisea.transac.common.constants;

import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.transac.common.entity.TIMNoticeTpl;

import java.util.HashMap;
import java.util.Map;

/**
 * 即时通讯通知消息常量
 *
 * @author XuDL(Wisea)
 *
 *         2020年5月6日 上午10:49:16
 */
public class TIMNoticeConstants {
    /** 消息类型：ord-订单助手 */
    public static final String TYPE_ORDER = "ord";
    /** 消息类型：ntc-通知消息 */
    public static final String TYPE_NOTICE = "ntc";
    /** 消息类型：sys-系统消息 */
    public static final String TYPE_SYSTEM = "sys";

    /** 模板标题 订单待确认信息 */
    public static final String TITLE_ORD_UN_COFM = "订单待确认信息";
    /** 模板KEY 待确认信息 */
    public static final String TPL_KEY_ORD_UN_COFM = "ord_un_cofm";
    /** 模板标题 订单取消信息 */
    public static final String TITLE_ORD_CANCEL = "订单取消信息";
    /** 模板KEY 商家未及时确认取消 发给商家 */
    public static final String TPL_KEY_ORD_CANCEL_TIMEOUT_TO_SALLER = "ord_cancel_timeout_to_saller";
    /** 模板KEY 商家未及时确认取消 发给买家 */
    public static final String TPL_KEY_ORD_CANCEL_TIMEOUT_TO_BUYER = "ord_cancel_timeout_to_buyer";
    /** 模板KEY 买家取消订单 */
    public static final String TPL_KEY_ORD_CANCEL_TO_SALLER = "ord_cancel_buyer";
    /** 模板标题 订单待付款信息 */
    public static final String TITLE_ORD_UN_PAY = "订单待付款信息";
    /** 模板KEY 订单待付款信息 */
    public static final String TPL_KEY_ORD_UN_PAY_TO_BUYER = "ord_un_pay_to_buyer";
    /** 模板KEY 买家未及时付款，因超时被自动取消 发给买家 */
    public static final String TPL_KEY_ORD_UN_PAY_CANCEL_TO_BUYER = "ord_un_pay_cancel_to_buyer";
    /** 模板KEY 买家未及时付款，因超时被自动取消 发给商家 */
    public static final String TPL_KEY_ORD_UN_PAY_CANCEL_TO_SALLER = "ord_un_pay_cancel_to_saller";
    /** 模板标题 订单待提货信息 */
    public static final String TITLE_ORD_UN_PICKUP = "订单待提货信息";
    /** 模板KEY 买家已完成支付 发给商家 */
    public static final String TPL_KEY_ORD_PAY_TO_SALLER = "ord_pay_to_saller";
    /** 模板KEY 买家已完成支付 发给买家 */
    public static final String TPL_KEY_ORD_PAY_TO_BUYER = "ord_pay_to_buyer";
    /** 模板标题 订单提货信息 */
    public static final String TITLE_ORD_PICKUP = "订单提货信息";
    /** 模板KEY 买家已完成支付 发给买家 */
    public static final String TPL_KEY_ORD_PICKUP_TO_BUYER = "ord_pickup_to_buyer";
    /** 模板标题 订单待开票信息 */
    public static final String TITLE_ORD_UN_INVOICE = "订单待开票信息";
    /** 模板KEY 买家提交了开票申请 发给商家 */
    public static final String TPL_KEY_ORD_UN_INVOICE_TO_SALLER = "ord_un_invoice_to_saller";
    /** 模板KEY 商家开票完成 发给买家 */
    public static final String TPL_KEY_ORD_INVOICE_TO_BUYER = "ord_invoice_to_buyer";
    /** 模板标题 订单开票信息 */
    public static final String TITLE_ORD_INVOICE = "订单开票信息";
    /** 模板KEY 商家重新开票完成 发给买家 */
    public static final String TPL_KEY_ORD_RE_INVOICE_TO_BUYER = "ord_re_invoice_to_buyer";
    /** 模板标题 订单退款信息 */
    public static final String TITLE_ORD_REFUND = "订单退款信息";
    /** 模板KEY 买家提交了退款申请 发给商家 */
    public static final String TPL_KEY_ORD_REFUND_TO_SALLER = "ord_refund_to_saller";
    /** 模板标题 订单退款成功 */
    public static final String TITLE_ORD_REFUND_SUC = "订单退款成功";
    /** 模板KEY 订单退款成功 发给买家 */
    public static final String TPL_KEY_ORD_REFUND_SUC_TO_BUYER = "ord_refund_suc_to_buyer";
    /** 模板标题 订单退款未通过 */
    public static final String TITLE_ORD_REFUND_FAL = "订单退款未通过";
    /** 模板KEY 订单退款未通过 发给买家 */
    public static final String TPL_KEY_ORD_REFUND_FAL_TO_BUYER = "ord_refund_fal_to_buyer";
    /** 模板标题 订单退款已取消 */
    public static final String TITLE_ORD_REFUND_CANCEL = "订单退款已取消";
    /** 模板KEY 买家取消了退款申请 发给商家 */
    public static final String TPL_KEY_ORD_REFUND_CANCEL_TO_SALLER = "ord_refund_cancel_to_saller";
    /** 模板标题 订单退款信息 */
    public static final String TITLE_ORD_REFUND_INFO = "订单退款信息";
    /** 模板KEY 订单发生退款 发给买家 */
    public static final String TPL_KEY_ORD_REFUND_INFO_TO_BUYER = "ord_refund_info_to_buyer";

    /** 模板标题 商品上架成功 */
    public static final String TITLE_PRD_PUB_SUC = "商品上架成功";
    /** 模板KEY 订单发生退款 */
    public static final String TPL_KEY_PRD_PUB_SUC = "prd_pub_suc";
    /** 模板标题 商品审核未通过 */
    public static final String TITLE_PRD_PUB_FAL = "商品审核未通过";
    /** 模板KEY 商品审核未通过 */
    public static final String TPL_KEY_PRD_PUB_FAL = "prd_pub_fal";
    /** 模板标题 商品被强制下架 */
    public static final String TITLE_PRD_PUB_OFF = "商品被强制下架";
    /** 模板KEY 商品被强制下架 */
    public static final String TPL_KEY_PRD_PUB_OFF = "prd_pub_off";
    /** 模板标题 商品库存预警 */
    public static final String TITLE_PRD_STOCK_WAR = "商品库存预警";
    /** 模板KEY 商品库存预警 */
    public static final String TPL_KEY_PRD_STOCK_WAR = "prd_stock_war";
    /** 模板标题 商品库存不足 */
    public static final String TITLE_PRD_STOCK_ZERO = "商品库存不足";
    /** 模板KEY 商品库存不足 */
    public static final String TPL_KEY_PRD_STOCK_ZERO = "prd_stock_zero";
    /** 模板标题 商家认证通过 */
    public static final String TITLE_SALLER_AUTH_SUC = "商家认证通过";
    /** 模板KEY 商家认证通过 */
    public static final String TPL_KEY_SALLER_AUTH_SUC = "saller_auth_suc";
    /** 模板标题 企业认证通过 */
    public static final String TITLE_ENP_AUTH_SUC = "企业认证通过";
    /** 模板KEY 企业认证通过 */
    public static final String TPL_KEY_ENP_AUTH_SUC = "enp_auth_suc";
    /** 模板标题 企业认证未通过 */
    public static final String TITLE_ENP_AUTH_FAL = "企业认证未通过";
    /** 模板KEY 企业认证未通过 */
    public static final String TPL_KEY_ENP_AUTH_FAL = "enp_auth_fal";
    /** 模板标题 个体工商户认证通过 */
    public static final String TITLE_PRI_AUTH_SUC = "个体工商户认证通过";
    /** 模板KEY 企业认证未通过 */
    public static final String TPL_KEY_PRI_AUTH_SUC = "pri_auth_suc";
    /** 模板标题 个体工商户认证未通过 */
    public static final String TITLE_PRI_AUTH_FAL = "个体工商户认证未通过";
    /** 模板KEY 个体工商户认证未通过 */
    public static final String TPL_KEY_PRI_AUTH_FAL = "pri_auth_fal";
    /** 模板标题 实人认证通过 */
    public static final String TITLE_PER_AUTH_SUC = "实人认证通过";
    /** 模板KEY 实人认证通过 */
    public static final String TPL_KEY_PER_AUTH_SUC = "per_auth_suc";

    /** 模板标题 开通帐期服务 */
    public static final String TITLE_OPEN_AP_PAY_SUC = "开通帐期服务";
    /** 模板KEY 开通帐期服务 */
    public static final String TPL_KEY_OPEN_AP_PAY_SUC = "open_ap_pay_suc";
    /** 模板标题 账期授信信息 */
    public static final String TITLE_CREDIT_INFO_SUC = "账期授信信息";
    /** 模板KEY 账期授信信息 */
    public static final String TPL_KEY_CREDIT_INFO_SUC = "credit_info_suc";
    /** 模板标题 账期授信提醒 */
    public static final String TITLE_CREDIT_REMIND_SUC = "账期授信提醒";
    /** 模板KEY 账期授信提醒 */
    public static final String TPL_KEY_CREDIT_REMIND_SUC = "credit_remind_suc";
    /** 模板标题 账期对账提醒 */
    public static final String TITLE_RECON_SUC = "账期对账提醒";
    /** 模板KEY 账期对账提醒(卖家) */
    public static final String TPL_KEY_RECON_TO_SALLER = "recon_to_saller";
    /** 模板KEY 账期对账提醒(买家) */
    public static final String TPL_KEY_RECON_TO_BUYER = "recon_to_buyer";
    /** 模板标题 账期结算提醒 */
    public static final String TITLE_SETTLE_SUC = "账期结算提醒";
    /** 模板KEY 账期结算提醒(卖家) */
    public static final String TPL_KEY_SETTLE_TO_SALLER = "settle_to_saller";
    /** 模板KEY 账期结算提醒(买家) */
    public static final String TPL_KEY_SETTLE_TO_BUYER = "settle_to_buyer";
    /** 模板标题 账期待开票提醒 */
    public static final String TITLE_SETTLE_TO_BE_INVOICED_SUC = "账期待开票提醒";
    /** 模板KEY 账期待开票提醒 */
    public static final String TPL_KEY_SETTLE_TO_BE_INVOICED = "settle_to_be_invoiced";
    /** 模板标题 账期验票提醒 */
    public static final String TITLE_SETTLE_TICKET_REMINDER_SUC = "账期验票提醒";
    /** 模板KEY 账期验票提醒 */
    public static final String TPL_KEY_SETTLE_TICKET_REMINDER = "settle_ticket_reminder";
    /** 模板标题 账期支付提醒 */
    public static final String TITLE_SETTLE_PAY_REMINDER_SUC = "账期支付提醒";
    /** 模板KEY 账期支付提醒 */
    public static final String TPL_KEY_SETTLE_PAY_REMINDER = "settle_pay_reminder";
    /** 模板标题 逾期账期支付提醒 */
    public static final String TITLE_SETTLE_OVERDUE_PAY_REMINDER_SUC = "逾期账期支付提醒";
    /** 模板KEY 逾期账期支付提醒 */
    public static final String TPL_KEY_SETTLE_OVERDUE_PAY_REMINDER = "settle_overdue_pay_reminder";
    /** 模板标题 账期支付成功 */
    public static final String TITLE_SETTLE_PAY_SUCCESS_SUC = "账期支付成功";
    /** 模板KEY 账期支付成功 */
    public static final String TPL_KEY_SETTLE_PAY_SUCCESS = "settle_pay_success";
    /** 模板标题 账期逾期提醒 */
    public static final String TITLE_SETTLE_OVERDUE_REMINDER_SUC = "账期逾期提醒";
    /** 模板KEY 账期逾期提醒（卖家） */
    public static final String TPL_KEY_SETTLE_OVERDUE_REMINDER_TO_SALLER = "settle_overdue_to_saller";
    /** 模板KEY 账期逾期提醒（买家） */
    public static final String TPL_KEY_SETTLE_OVERDUE_REMINDER_TO_BUYER = "settle_overdue_to_buyer";

    /** 采购员绑定成功 */
    public static final String TITLE_BUYER_BIND_SUC = "采购员绑定成功";
    /** 模板KEY 采购员绑定成功 */
    public static final String TPL_KEY_BUYER_BIND_SUC = "buyer_bind_fal";
    /** 采购员绑定失败 */
    public static final String TITLE_BUYER_BIND_FAL = "采购员绑定失败";
    /** 模板KEY 采购员绑定失败(拒绝) */
    public static final String TPL_KEY_BUYER_BIND_REFUSE_FAL = "buyer_bind_refuse_fal";
    /** 模板KEY 采购员绑定失败(已经是平台企业认证用户) */
    public static final String TPL_KEY_BUYER_BIND_IS_ENP_FAL = "buyer_bind_is_enp_fal";
    /** 邀请成为采购员 */
    public static final String TITLE_INVITED_BUYER = "邀请成为采购员";
    /** 模板KEY 邀请成为采购员 */
    public static final String TPL_KEY_INVITED_BUYER = "invited_buyer";
    /** 解除采购关系 */
    public static final String TITLE_DISSOLVE_BUYER = "解除采购关系";
    /** 模板KEY 解除采购关系 */
    public static final String TPL_KEY_DISSOLVE_BUYER = "dissolve_buyer";
    /**
     * 解除采购团队
     */
    public static final String TITLE_DISSOLVE_PURCHASE_TEAM = "解除采购团队";
    /**
     * 模板KEY 解散采购团队
     */
    public static final String TPL_KEY_DISSOLVE_PURCHASE_TEAM = "dissolve_purchase_team";

    protected static Map<String, TIMNoticeTpl> tplMap = new HashMap<String, TIMNoticeTpl>() {
        private static final long serialVersionUID = -4624489951743543699L;

        {
            // 一些固定的内置模板

            // 订单助手
            put(TPL_KEY_ORD_UN_COFM, new TIMNoticeTpl(TYPE_ORDER, TITLE_ORD_UN_COFM, "买家提交了订单${orderId}，请前往确认"));
            put(TPL_KEY_ORD_CANCEL_TIMEOUT_TO_SALLER, new TIMNoticeTpl(TYPE_ORDER, TITLE_ORD_CANCEL, "您的订单${orderId}未及时确认，因超时被自动取消"));
            put(TPL_KEY_ORD_CANCEL_TIMEOUT_TO_BUYER, new TIMNoticeTpl(TYPE_ORDER, TITLE_ORD_CANCEL, "您的订单${orderId}商家未及时确认，因超时被自动取消"));
            put(TPL_KEY_ORD_CANCEL_TO_SALLER, new TIMNoticeTpl(TYPE_ORDER, TITLE_ORD_CANCEL, "您的订单${orderId}买家已经取消，请前往查看"));
            put(TPL_KEY_ORD_UN_PAY_TO_BUYER, new TIMNoticeTpl(TYPE_ORDER, TITLE_ORD_UN_PAY, "您的订单${orderId}商家已经确认，请前往确认付款"));
            put(TPL_KEY_ORD_UN_PAY_CANCEL_TO_BUYER, new TIMNoticeTpl(TYPE_ORDER, TITLE_ORD_CANCEL, "您的订单${orderId}未及时付款，因超时被自动取消；若需购买请重新下单"));
            put(TPL_KEY_ORD_UN_PAY_CANCEL_TO_SALLER, new TIMNoticeTpl(TYPE_ORDER, TITLE_ORD_CANCEL, "您的订单${orderId}买家未及时付款，因超时被自动取消"));
            put(TPL_KEY_ORD_PAY_TO_SALLER, new TIMNoticeTpl(TYPE_ORDER, TITLE_ORD_UN_PICKUP, "您的订单${orderId}买家已完成支付，待买家前来提货"));
            put(TPL_KEY_ORD_PAY_TO_BUYER, new TIMNoticeTpl(TYPE_ORDER, TITLE_ORD_UN_PICKUP, "您有订单${orderId}已付款，请尽快提货，自提地址是：${ztAddr}，自提码：${ztNum}"));
            put(TPL_KEY_ORD_PICKUP_TO_BUYER, new TIMNoticeTpl(TYPE_ORDER, TITLE_ORD_PICKUP, "您的订单${orderId}已完成提货，请前往查看"));
            put(TPL_KEY_ORD_UN_INVOICE_TO_SALLER, new TIMNoticeTpl(TYPE_ORDER, TITLE_ORD_UN_INVOICE, "您的订单${orderId}买家提交了开票申请，采购商是：${buyerName}，请前往查看"));
            put(TPL_KEY_ORD_INVOICE_TO_BUYER, new TIMNoticeTpl(TYPE_ORDER, TITLE_ORD_INVOICE, "您的订单${orderId}开票完成，请前往查看"));
            put(TPL_KEY_ORD_RE_INVOICE_TO_BUYER, new TIMNoticeTpl(TYPE_ORDER, TITLE_ORD_INVOICE, "您的订单${orderId}重新开票完成，请前往查看"));
            put(TPL_KEY_ORD_REFUND_TO_SALLER, new TIMNoticeTpl(TYPE_ORDER, TITLE_ORD_REFUND, "您的订单${orderId}买家提交了退款申请，请前往处理"));
            put(TPL_KEY_ORD_REFUND_SUC_TO_BUYER, new TIMNoticeTpl(TYPE_ORDER, TITLE_ORD_REFUND_SUC, "您的服务单${refundId}退款申请商家审核已通过，退款金额将原路返回您的支付账户"));
            put(TPL_KEY_ORD_REFUND_FAL_TO_BUYER, new TIMNoticeTpl(TYPE_ORDER, TITLE_ORD_REFUND_FAL, "您的服务单${refundId}退款申请商家审核未通过，未通过原因：该货物已正常备货不允许取消"));
            put(TPL_KEY_ORD_REFUND_CANCEL_TO_SALLER, new TIMNoticeTpl(TYPE_ORDER, TITLE_ORD_REFUND_CANCEL, "您的订单${orderId}买家已取消退款申请，请前往查看"));
            put(TPL_KEY_ORD_REFUND_INFO_TO_BUYER, new TIMNoticeTpl(TYPE_ORDER, TITLE_ORD_REFUND_INFO, "您的订单${orderId}发生退款，退款申请服务单:${refundId}，请前往查看"));

            // 通知消息
            put(TPL_KEY_PRD_PUB_SUC, new TIMNoticeTpl(TYPE_NOTICE, TITLE_PRD_PUB_SUC, "您的商品${commName}审核通过，上架成功"));
            put(TPL_KEY_PRD_PUB_FAL, new TIMNoticeTpl(TYPE_NOTICE, TITLE_PRD_PUB_FAL, "您的商品${commName}审核未通过，未通过原因：${backReson}"));
            put(TPL_KEY_PRD_PUB_OFF, new TIMNoticeTpl(TYPE_NOTICE, TITLE_PRD_PUB_OFF, "您的商品${commName}被强制下架，下架原因：${backReson}"));
            put(TPL_KEY_PRD_STOCK_WAR, new TIMNoticeTpl(TYPE_NOTICE, TITLE_PRD_STOCK_WAR, "您的商品${commName}，${commSpec}库存紧张"));
            put(TPL_KEY_PRD_STOCK_ZERO, new TIMNoticeTpl(TYPE_NOTICE, TITLE_PRD_STOCK_ZERO, "您的商品${commName}，${commSpec}库存不足"));
            put(TPL_KEY_SALLER_AUTH_SUC, new TIMNoticeTpl(TYPE_NOTICE, TITLE_SALLER_AUTH_SUC, "恭喜，您的商家认证申请已经通过审核，请前往查看"));
            put(TPL_KEY_ENP_AUTH_SUC, new TIMNoticeTpl(TYPE_NOTICE, TITLE_ENP_AUTH_SUC, "恭喜，您的企业认证申请已经通过审核，请前往查看"));
            put(TPL_KEY_ENP_AUTH_FAL, new TIMNoticeTpl(TYPE_NOTICE, TITLE_ENP_AUTH_FAL, "您的企业认证申请未通过审核，未通过原因：${backReson}"));
            put(TPL_KEY_PRI_AUTH_SUC, new TIMNoticeTpl(TYPE_NOTICE, TITLE_PRI_AUTH_SUC, "恭喜，您的个体工商户认证申请已经通过审核，请前往查看"));
            put(TPL_KEY_PRI_AUTH_FAL, new TIMNoticeTpl(TYPE_NOTICE, TITLE_PRI_AUTH_FAL, "您的个体工商户认证申请未通过审核，未通过原因：${backReson}"));
            put(TPL_KEY_PER_AUTH_SUC, new TIMNoticeTpl(TYPE_NOTICE, TITLE_PER_AUTH_SUC, "恭喜，您的实人认证申请已经通过审核，您可以在平台进行采购，祝您购物愉快"));

            put(TPL_KEY_OPEN_AP_PAY_SUC, new TIMNoticeTpl(TYPE_NOTICE, TITLE_OPEN_AP_PAY_SUC, "恭喜，帐期服务开通成功，可以为信任的会员设置授信"));
            put(TPL_KEY_CREDIT_INFO_SUC, new TIMNoticeTpl(TYPE_NOTICE, TITLE_CREDIT_INFO_SUC, "恭喜，您以被${entpName}设为账期授信客户，授信额度为${acctCreditLine}元"));
            put(TPL_KEY_CREDIT_REMIND_SUC, new TIMNoticeTpl(TYPE_NOTICE, TITLE_CREDIT_REMIND_SUC, "您已被${entpName}冻结账期授信额度"));
            put(TPL_KEY_RECON_TO_SALLER, new TIMNoticeTpl(TYPE_NOTICE, TITLE_RECON_SUC, "您的账期结算单${settleBillNumb}已生成，请前往对账"));
            put(TPL_KEY_RECON_TO_BUYER, new TIMNoticeTpl(TYPE_NOTICE, TITLE_RECON_SUC, "您的账期结算单${settleBillNumb}商家已完成对账，请前往对账"));
            put(TPL_KEY_SETTLE_TO_SALLER, new TIMNoticeTpl(TYPE_NOTICE, TITLE_SETTLE_SUC, "您的账期结算单${settleBillNumb}，${buyerName}对账完成，最晚付款日${lastPayDate}，账期结算金额${totalMoney}"));
            put(TPL_KEY_SETTLE_TO_BUYER, new TIMNoticeTpl(TYPE_NOTICE, TITLE_SETTLE_SUC, "您的账期结算单${settleBillNumb}对账完成，最晚付款日${lastPayDate}、账期结算金额${totalMoney}"));
            put(TPL_KEY_SETTLE_TO_BE_INVOICED, new TIMNoticeTpl(TYPE_NOTICE, TITLE_SETTLE_TO_BE_INVOICED_SUC, "您的账期结算单${settleBillNumb}，${buyerName}对账完成，最晚付款日${lastPayDate}，账期结算金额${totalMoney}，请前往开票"));
            put(TPL_KEY_SETTLE_TICKET_REMINDER, new TIMNoticeTpl(TYPE_NOTICE, TITLE_SETTLE_TICKET_REMINDER_SUC, "您的账期结算单${settleBillNumb}商家已开票，请前往验票"));
            put(TPL_KEY_SETTLE_PAY_REMINDER, new TIMNoticeTpl(TYPE_NOTICE, TITLE_SETTLE_PAY_REMINDER_SUC, "您的账期结算单${settleBillNumb}还有${daysRemaining}天将逾期，最晚付款日${lastPayDate}、账期结算金额${totalMoney}"));
            put(TPL_KEY_SETTLE_OVERDUE_PAY_REMINDER, new TIMNoticeTpl(TYPE_NOTICE, TITLE_SETTLE_OVERDUE_PAY_REMINDER_SUC, "您的账期结算单${settleBillNumb}已经逾期${daysOverdue}天，逾期金额${lateFee}"));
            put(TPL_KEY_SETTLE_PAY_SUCCESS, new TIMNoticeTpl(TYPE_NOTICE, TITLE_SETTLE_PAY_SUCCESS_SUC, "您的账期结算单${settleBillNumb}，${buyerName}已支付，支付金额${paymentAmount}"));
            put(TPL_KEY_SETTLE_OVERDUE_REMINDER_TO_SALLER, new TIMNoticeTpl(TYPE_NOTICE, TITLE_SETTLE_OVERDUE_REMINDER_SUC, "您的账期结算单${settleBillNumb}，${buyerName}已逾期，逾期金额${lateFee}"));
            put(TPL_KEY_SETTLE_OVERDUE_REMINDER_TO_BUYER, new TIMNoticeTpl(TYPE_NOTICE, TITLE_SETTLE_OVERDUE_REMINDER_SUC, "您的账期结算单${settleBillNumb}已逾期，逾期金额${lateFee}"));

            put(TPL_KEY_BUYER_BIND_SUC, new TIMNoticeTpl(TYPE_NOTICE, TITLE_BUYER_BIND_SUC, "您在采购团队中绑定的采购员${membName}绑定成功；该采购员将以公司名义进行采购，如有疑问请联系平台"));
            put(TPL_KEY_BUYER_BIND_REFUSE_FAL, new TIMNoticeTpl(TYPE_NOTICE, TITLE_BUYER_BIND_FAL, "您在采购团队中绑定的采购员${membName}绑定失败；该用户拒绝成为公司采购员"));
            put(TPL_KEY_BUYER_BIND_IS_ENP_FAL, new TIMNoticeTpl(TYPE_NOTICE, TITLE_BUYER_BIND_FAL, "您在采购团队中绑定的采购员${membName}绑定失败；该用户是平台采购企业认证用户、如何可以成为采购员，1、换手机号2、注销账户"));
            put(TPL_KEY_INVITED_BUYER, new TIMNoticeTpl(TYPE_NOTICE, TITLE_INVITED_BUYER, "平台认证${membName}邀请您成为其采购员，如果同意则替换现账号信息"));
            put(TPL_KEY_DISSOLVE_BUYER, new TIMNoticeTpl(TYPE_NOTICE, TITLE_DISSOLVE_BUYER, "平台认证${membName}与您解除采购关系，即将为您恢复原有账户或新用户"));
            put(TPL_KEY_DISSOLVE_PURCHASE_TEAM, new TIMNoticeTpl(TYPE_NOTICE, TITLE_DISSOLVE_PURCHASE_TEAM, "平台认证${membName}邀请您成为其采购员，请您解散您的采购团队，再接受邀请"));

            // 系统消息因为标题和内容都是自定义的所以不在此处定义
        }
    };

    /**
     * 获取模板
     *
     * @param tplKey
     *            模板Key 请参考 TIMNoticeConstants.TPL_KEY_*
     * @return
     */
    public static TIMNoticeTpl getTpl(String tplKey) {
        return tplMap.get(tplKey);
    }

    /**
     * 添加模板
     *
     * @param tplKey
     * @param tpl
     */
    public static void addTpl(String tplKey, TIMNoticeTpl tpl) {
        if (ConverterUtil.isNotEmpty(tplKey, tpl)) {
            tplMap.put(tplKey, tpl);
        }
    }
}
