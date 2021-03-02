package com.wisea.cultivar.common.constants;

import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cultivar.common.entity.TIMNoticeTpl;

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
    /** 消息类型：ser-服务单助手 */
    public static final String TYPE_SER = "ser";

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
    /** 模板标题   个人认证通过 */
    public static final String TITLE_PERSON_AUTH_SUC = "个人认证通过";
    /** 模板KEY  个人认证通过*/
    public static final String TPL_KEY_PERSON_AUTH_SUC = "person_auth_suc";
    /** 模板标题   个人认证不通过 */
    public static final String TITLE_PERSON_AUTH_FAL = "个人认证不通过";
    /** 模板KEY  个人认证不通过*/
    public static final String TPL_KEY_PERSON_AUTH_FAL = "person_auth_fal";
    /** 模板标题   求购商认证审核通过 */
    public static final String TITLE_ENTP_BUY_AUTH_SUC = "求购商认证审核通过";
    /** 模板KEY  求购商认证审核通过*/
    public static final String TPL_KEY_ENTP_BUY_AUTH_SUC = "entp_buy_auth_suc";
    /** 模板标题   供应商认证审核通过 */
    public static final String TITLE_ENTP_SEL_AUTH_SUC = "供应商认证审核通过";
    /** 模板KEY  供应商认证审核通过*/
    public static final String TPL_KEY_ENTP_SEL_AUTH_SUC = "entp_sel_auth_suc";
    /** 模板标题   企业认证不通过 */
    public static final String TITLE_ENTP_AUTH_FAL = "企业认证不通过";
    /** 模板KEY  企业认证不通过*/
    public static final String TPL_KEY_ENTP_AUTH_FAL = "entp_auth_fal";
    // /** 模板标题 开通帐期服务 */
    // public static final String TITLE_PER_AUTH_SUC = "开通帐期服务";
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

    /** 模板标题 服务单待确认信息 */
    public static final String TITLE_SER_UN_COFM = "待确认服务单";
    /** 模板KEY 待确认信息 */
    public static final String TPL_KEY_SER_UN_COFM = "ser_un_cofm";
    /** 模板标题 服务单取消信息 */
    public static final String TITLE_SER_CANCEL = "已取消服务单";
    /** 模板KEY 商家未及时确认取消 发给商家 */
    public static final String TPL_KEY_SER_CANCEL_TIMEOUT_TO_SALLER = "ser_cancel_timeout_to_saller";
    /** 模板KEY 商家未及时确认取消 发给买家 */
    public static final String TPL_KEY_SER_CANCEL_TIMEOUT_TO_BUYER = "ser_cancel_timeout_to_buyer";
    /** 模板KEY 买家取消服务单 */
    public static final String TPL_KEY_SER_CANCEL_TO_SALLER = "ser_cancel_buyer";
    /** 模板标题 服务单完成信息 */
    public static final String TITLE_SER_OVER = "确认完成服务单";
    /** 模板KEY 服务单自动完成信息 发给商家 */
    public static final String TPL_KEY_SER_OVER_TIMEOUT_TO_SALLER = "ser_over_timeout_to_saller";
    /** 模板KEY 服务单自动完成信息 发给买家 */
    public static final String TPL_KEY_SER_OVER_TIMEOUT_TO_BUYER = "ser_over_timeout_to_buyer";
    /** 模板KEY 买家完成服务单 */
    public static final String TPL_KEY_SER_OVER_TO_SALLER = "ser_over_buyer";
    /** 模板标题 服务单修改信息 */
    public static final String TITLE_SER_UPDATE = "已修改服务单";
    /** 模板KEY 服务单修改信息 发给商家 */
    public static final String TPL_KEY_SER_UPDATE_TO_SALLER = "ser_update_to_saller";
    /** 模板KEY 服务单修改信息 发给买家 */
    public static final String TPL_KEY_SER_UPDATE_TO_BUYER = "ser_update_to_buyer";
    /** 模板标题 服务单修改价格信息 */
    public static final String TITLE_SER_UPDATE_PRICE = "已修改服务单价格";
    /** 模板KEY 服务单修改价格信息 发给买家 */
    public static final String TPL_KEY_SER_UPDATE_PRICE_TO_BUYER = "ser_update_price_to_buyer";

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
            put(TPL_KEY_PERSON_AUTH_SUC, new TIMNoticeTpl(TYPE_NOTICE, TITLE_PERSON_AUTH_SUC, "恭喜您，您的认证系统已通过，您可以以买家身份采购产品祝您购物愉快！"));
            put(TPL_KEY_PERSON_AUTH_FAL, new TIMNoticeTpl(TYPE_NOTICE, TITLE_PERSON_AUTH_FAL, "您的认证系统未通过，未通过原因：${backReson}"));
            put(TPL_KEY_ENTP_BUY_AUTH_SUC, new TIMNoticeTpl(TYPE_NOTICE, TITLE_ENTP_BUY_AUTH_SUC, "恭喜您，您的认证系统已通过，您可以以买家身份采购产品祝您购物愉快."));
            put(TPL_KEY_ENTP_SEL_AUTH_SUC, new TIMNoticeTpl(TYPE_NOTICE, TITLE_ENTP_SEL_AUTH_SUC, "恭喜您，你的供货商认证系统已通过，您可以以买家身份采购及以商家身份销售商品."));
            put(TPL_KEY_ENTP_AUTH_FAL, new TIMNoticeTpl(TYPE_NOTICE, TITLE_ENTP_AUTH_FAL, "您的认证系统未通过，未通过原因：${backReson}"));
            // TODO 帐期暂时不做
            // put(TPL_KEY_PER_AUTH_SUC, new TIMNoticeTpl(TYPE_NOTICE, TITLE_PER_AUTH_SUC, "恭喜，帐期服务开通成功，可以为信任的会员设置授信"));
            put(TPL_KEY_BUYER_BIND_SUC, new TIMNoticeTpl(TYPE_NOTICE, TITLE_BUYER_BIND_SUC, "您在采购团队中绑定的采购员${membName}绑定成功；该采购员将以公司名义进行采购，如有疑问请联系平台"));
            put(TPL_KEY_BUYER_BIND_REFUSE_FAL, new TIMNoticeTpl(TYPE_NOTICE, TITLE_BUYER_BIND_FAL, "您在采购团队中绑定的采购员${membName}绑定失败；该用户拒绝成为公司采购员"));
            put(TPL_KEY_BUYER_BIND_IS_ENP_FAL, new TIMNoticeTpl(TYPE_NOTICE, TITLE_BUYER_BIND_FAL, "您在采购团队中绑定的采购员${membName}绑定失败；该用户是平台采购企业认证用户、如何可以成为采购员，1、换手机号2、注销账户"));
            put(TPL_KEY_INVITED_BUYER, new TIMNoticeTpl(TYPE_NOTICE, TITLE_INVITED_BUYER, "平台认证${membName}邀请您成为其采购员，如果同意则替换现账号信息"));
            put(TPL_KEY_DISSOLVE_BUYER, new TIMNoticeTpl(TYPE_NOTICE, TITLE_DISSOLVE_BUYER, "平台认证${membName}与您解除采购关系，即将为您恢复原有账户或新用户"));

            //服务单助手
            put(TPL_KEY_SER_UN_COFM, new TIMNoticeTpl(TYPE_SER, TITLE_SER_UN_COFM, "客户提交了服务单${serId}，请前往确认"));
            put(TPL_KEY_SER_CANCEL_TIMEOUT_TO_SALLER, new TIMNoticeTpl(TYPE_SER, TITLE_SER_CANCEL, "您的服务单${serId}未及时确认，因超时被自动取消"));
            put(TPL_KEY_SER_CANCEL_TIMEOUT_TO_BUYER, new TIMNoticeTpl(TYPE_SER, TITLE_SER_CANCEL, "您的服务单${serId}商家未及时确认，因超时被自动取消"));
            put(TPL_KEY_SER_CANCEL_TO_SALLER, new TIMNoticeTpl(TYPE_SER, TITLE_SER_CANCEL, "客户取消了服务单${serId}，请前往查看"));
            put(TPL_KEY_SER_OVER_TIMEOUT_TO_SALLER, new TIMNoticeTpl(TYPE_SER, TITLE_SER_OVER, "您的服务单${serId}未及时确认，因超时被自动确认"));
            put(TPL_KEY_SER_OVER_TIMEOUT_TO_BUYER, new TIMNoticeTpl(TYPE_SER, TITLE_SER_OVER, "您的服务单${serId}未及时确认，因超时被自动确认"));
            put(TPL_KEY_SER_OVER_TO_SALLER, new TIMNoticeTpl(TYPE_SER, TITLE_SER_OVER, "客户确认了服务单${serId}，请前往查看"));
            put(TPL_KEY_SER_UPDATE_TO_SALLER, new TIMNoticeTpl(TYPE_SER, TITLE_SER_UPDATE, "商家修改了服务单${serId}，请前往查看"));
            put(TPL_KEY_SER_UPDATE_TO_BUYER, new TIMNoticeTpl(TYPE_SER, TITLE_SER_UPDATE, "客户修改了服务单${serId}，请前往查看"));
            put(TPL_KEY_SER_UPDATE_PRICE_TO_BUYER, new TIMNoticeTpl(TYPE_SER, TITLE_SER_UPDATE_PRICE, "您的服务单${serId}商家已修改价格，请前往查看"));
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
