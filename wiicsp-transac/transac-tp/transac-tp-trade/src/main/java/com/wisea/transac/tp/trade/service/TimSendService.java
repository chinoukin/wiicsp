package com.wisea.transac.tp.trade.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.constants.TIMNoticeConstants;
import com.wisea.transac.common.dao.PurchaseStaffMageMapper;
import com.wisea.transac.common.dao.SaleStaffInfoMageMapper;
import com.wisea.transac.common.dao.StallsStaffRelaMageMapper;
import com.wisea.transac.common.entity.MembBaseInfo;
import com.wisea.transac.common.po.SaleStaffInfoMagePo;
import com.wisea.transac.common.po.seller.FindInfoByStallsMageIdPo;
import com.wisea.transac.common.service.TIMNoticeService;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.seller.SaleStaffInfoMageInfoVo;
import com.wisea.transac.common.vo.seller.SaleStaffInfoMagePageListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TimSendService {

    @Autowired
    private TIMNoticeService timNoticeService;
    @Autowired
    private StallsStaffRelaMageMapper stallsStaffRelaMageMapper;
    @Autowired
    private PurchaseStaffMageMapper purchaseStaffMageMapper;
    @Autowired
    private SaleStaffInfoMageMapper saleStaffInfoMageMapper;
    //跳订单页面
    private final static String ORDER = "0";
    //跳服务单页面
    private final static String REFUND = "1";
    //跳账期相关
    private final static String SETTLE = "2";
    //跳商品相关
    private final static String COMM = "3";
    //账期授信相关
    private final static String APPAY = "4";

    /**
     *
     * @param timType 消息类型
     * @param id 订单、账期或服务单ID
     * @param staffId 档口ID，可以为null
     * @param userId 当前登录ID或者用于查询的用户ID
     * @param map 消息模板中的参数
     *  消息列表中财务就是业务员，已跟产品沟通
     */
    public void sendTim (Map<String, Object> param) {
        try {
            //消息类型
            String timType = (String)param.get("timType");
            //订单、账期或服务单ID
            Long id = (Long)param.get("id");
            //档口ID，可以为null
            Long staffId = (Long)param.get("staffId");
            //当前登录ID或者用于查询的用户ID
            Long userId = (Long)param.get("userId");
            //订单、服务单、结算单编号
            String ordNum = (String)param.get("ordNum");
            //获取用户
            MembBaseInfo user = MembUtils.getMembInfoByUserId(userId);
            //获取所有业务员和管理员（采购员只取下单人）
            FindInfoByStallsMageIdPo spo = new FindInfoByStallsMageIdPo();
            //构造ID列表
            List<String> idList = Lists.newArrayList();
            //将采购人加入
            idList.add(userId.toString());
            //将主账户加入
            if (!userId.equals(user.getMembId())) {
                idList.add(user.getMembId().toString());
            }
            //发送消息参数
            Map<String, Object> dataModel = Maps.newHashMap();
            //给前端用的参数，比如订单ID
            Map<String, Object> payload = Maps.newHashMap();
            payload.put("id", id);
            //判断是那种消息，获取不同的发送用户
            //判断是那种用户类型
            String userType = null;
            switch (timType) {
                //待确认订单
                case TIMNoticeConstants.TPL_KEY_ORD_UN_COFM:
                    //获取相应的用户列表
                    dataModel.put("orderId", ordNum);
                    payload.put("flag", ORDER);
                    //设置该消息发送的用户类型，1买家、2卖家、12全部
                    userType = "2";
                    break;
                //买家取消订单
                case TIMNoticeConstants.TPL_KEY_ORD_CANCEL_TO_SALLER:
                    //获取相应的用户列表
                    dataModel.put("orderId", ordNum);
                    payload.put("flag", ORDER);
                    //设置该消息发送的用户类型，1买家、2卖家、12全部
                    userType = "1";
                    break;
                //超时未确认取消订单-发送给卖家
                case TIMNoticeConstants.TPL_KEY_ORD_CANCEL_TIMEOUT_TO_SALLER:
                    //获取相应的用户列表
                    dataModel.put("orderId", ordNum);
                    payload.put("flag", ORDER);
                    //设置该消息发送的用户类型，1买家、2卖家、12全部
                    userType = "2";
                    break;
                //超时未确认取消订单-发送给买家
                case TIMNoticeConstants.TPL_KEY_ORD_CANCEL_TIMEOUT_TO_BUYER:
                    //获取相应的用户列表
                    dataModel.put("orderId", ordNum);
                    payload.put("flag", ORDER);
                    //设置该消息发送的用户类型，1买家、2卖家、12全部
                    userType = "1";
                    break;
                //卖家确认订单-发送给买家
                case TIMNoticeConstants.TPL_KEY_ORD_UN_PAY_TO_BUYER:
                    //获取相应的用户列表
                    dataModel.put("orderId", ordNum);
                    payload.put("flag", ORDER);
                    //设置该消息发送的用户类型，1买家、2卖家、12全部
                    userType = "1";
                    break;
                //超时未支付取消订单-发送给卖家
                case TIMNoticeConstants.TPL_KEY_ORD_UN_PAY_CANCEL_TO_SALLER:
                    //获取相应的用户列表
                    dataModel.put("orderId", ordNum);
                    payload.put("flag", ORDER);
                    //设置该消息发送的用户类型，1买家、2卖家、12全部
                    userType = "2";
                    break;
                //超时未支付取消订单-发送给买家
                case TIMNoticeConstants.TPL_KEY_ORD_UN_PAY_CANCEL_TO_BUYER:
                    //获取相应的用户列表
                    dataModel.put("orderId", ordNum);
                    payload.put("flag", ORDER);
                    //设置该消息发送的用户类型，1买家、2卖家、12全部
                    userType = "1";
                    break;
                //买家提货完成后-发送给买家
                case TIMNoticeConstants.TPL_KEY_ORD_PICKUP_TO_BUYER:
                    //获取相应的用户列表
                    dataModel.put("orderId", ordNum);
                    payload.put("flag", ORDER);
                    //设置该消息发送的用户类型，1买家、2卖家、12全部
                    userType = "1";
                    break;
                //买家未完全提货，产生退款信息-发送给买家
                case TIMNoticeConstants.TPL_KEY_ORD_REFUND_INFO_TO_BUYER:
                    //获取相应的用户列表
                    dataModel.put("orderId", ordNum);
                    dataModel.put("refundId", param.get("refundNum"));
                    payload.put("flag", REFUND);
                    //设置该消息发送的用户类型，1买家、2卖家、12全部
                    userType = "1";
                    break;
                //退款审核通过-发送给买家
                case TIMNoticeConstants.TPL_KEY_ORD_REFUND_SUC_TO_BUYER:
                    //获取相应的用户列表
                    dataModel.put("refundId", ordNum);
                    payload.put("flag", REFUND);
                    //设置该消息发送的用户类型，1买家、2卖家、12全部
                    userType = "1";
                    break;
                //退款审核不通过-发送给买家
                case TIMNoticeConstants.TPL_KEY_ORD_REFUND_FAL_TO_BUYER:
                    //获取相应的用户列表
                    dataModel.put("refundId", ordNum);
                    payload.put("flag", REFUND);
                    //设置该消息发送的用户类型，1买家、2卖家、12全部
                    userType = "1";
                    break;
                //商品库存不足-发送给管理员。档口业务员
                case TIMNoticeConstants.TITLE_PRD_STOCK_ZERO:
                    //获取相应的用户列表
                    dataModel.put("commName", (String)param.get("commName"));
                    dataModel.put("commSpec", (String)param.get("commSpec"));
                    payload.put("flag", COMM);
                    //设置该消息发送的用户类型，1买家、2卖家、12全部
                    userType = "2";
                    break;
                //商品库存预警-发送给管理员。档口业务员
                case TIMNoticeConstants.TPL_KEY_PRD_STOCK_WAR:
                    //获取相应的用户列表
                    dataModel.put("commName", (String)param.get("commName"));
                    dataModel.put("commSpec", (String)param.get("commSpec"));
                    payload.put("flag", COMM);
                    //设置该消息发送的用户类型，1买家、2卖家、12全部
                    userType = "2";
                    break;
                //待提货消息，发送给卖家
                case TIMNoticeConstants.TPL_KEY_ORD_PAY_TO_SALLER:
                    //获取相应的用户列表
                    dataModel.put("orderId", ordNum);
                    payload.put("flag", ORDER);
                    //设置该消息发送的用户类型，1买家、2卖家、12全部
                    userType = "2";
                    break;
                //待提货消息发送个买家
                case TIMNoticeConstants.TPL_KEY_ORD_PAY_TO_BUYER:
                    //获取相应的用户列表
                    dataModel.put("orderId", ordNum);
                    payload.put("flag", ORDER);
                    //设置该消息发送的用户类型，1买家、2卖家、12全部
                    userType = "2";
                    break;
                //代开发票信息，发送给卖家
                case TIMNoticeConstants.TPL_KEY_ORD_UN_INVOICE_TO_SALLER:
                    //获取相应的用户列表
                    dataModel.put("orderId", ordNum);
                    dataModel.put("buyerName", param.get("buyerName"));
                    payload.put("flag", ORDER);
                    //设置该消息发送的用户类型，1买家、2卖家、12全部
                    userType = "2";
                    break;
                  //商家开票信息，发送给买家
                case TIMNoticeConstants.TPL_KEY_ORD_INVOICE_TO_BUYER:
                    //获取相应的用户列表
                    dataModel.put("orderId", ordNum);
                    payload.put("flag", ORDER);
                    //设置该消息发送的用户类型，1买家、2卖家、12全部
                    userType = "1";
                    break;
                  //商家重新开票信息，发送给买家
                case TIMNoticeConstants.TPL_KEY_ORD_RE_INVOICE_TO_BUYER:
                    //获取相应的用户列表
                    payload.put("flag", ORDER);
                    dataModel.put("orderId", ordNum);
                    //设置该消息发送的用户类型，1买家、2卖家、12全部
                    userType = "1";
                    break;
                //商家重新开票信息，发送给买家
                case TIMNoticeConstants.TPL_KEY_ORD_REFUND_TO_SALLER:
                    //获取相应的用户列表
                    payload.put("flag", ORDER);
                    dataModel.put("orderId", ordNum);
                    //设置该消息发送的用户类型，1买家、2卖家、12全部
                    userType = "2";
                    break;
                //商家提醒买家支付结算单（结算单已逾期）
                case TIMNoticeConstants.TPL_KEY_SETTLE_OVERDUE_PAY_REMINDER:
                    //获取相应的用户列表
                    payload.put("flag", SETTLE);
                    dataModel.put("settleBillNumb", ordNum);
                    dataModel.put("daysRemaining", param.get("daysRemaining"));
                    dataModel.put("lastPayDate", param.get("lastPayDate"));
                    dataModel.put("totalMoney", param.get("totalMoney"));
                    //设置该消息发送的用户类型，1买家、2卖家、12全部
                    userType = "2";
                    break;
                //商家提醒买家支付结算单（结算单未逾期）
                case TIMNoticeConstants.TPL_KEY_SETTLE_PAY_REMINDER:
                    //获取相应的用户列表
                    payload.put("flag", SETTLE);
                    dataModel.put("settleBillNumb", ordNum);
                    dataModel.put("daysOverdue", param.get("daysOverdue"));
                    dataModel.put("lateFee", param.get("lateFee"));
                    //设置该消息发送的用户类型，1买家、2卖家、12全部
                    userType = "2";
                    break;
                //商家为买家设置授信额度（发送给买家）
                case TIMNoticeConstants.TPL_KEY_CREDIT_INFO_SUC:
                    //获取相应的用户列表
                    payload.put("flag", APPAY);
                    dataModel.put("entpName", param.get("entpName"));
                    dataModel.put("acctCreditLine", param.get("acctCreditLine"));
                    //设置该消息发送的用户类型，1买家、2卖家、12全部
                    userType = "1";
                    break;
                //商家冻结买家授信额度（发送给买家）
                case TIMNoticeConstants.TPL_KEY_CREDIT_REMIND_SUC:
                    //获取相应的用户列表
                    payload.put("flag", APPAY);
                    dataModel.put("entpName", param.get("entpName"));
                    //设置该消息发送的用户类型，1买家、2卖家、12全部
                    userType = "1";
                    break;
                //结算单生成（发送给买卖家）
                case TIMNoticeConstants.TPL_KEY_RECON_TO_SALLER:
                    //获取相应的用户列表
                    payload.put("flag", SETTLE);
                    dataModel.put("settleBillNumb", ordNum);
                    //设置该消息发送的用户类型，1买家、2卖家、12全部
                    userType = (String)param.get("userType");
                    break;
                //结算单逾期（发送给买家）
                case TIMNoticeConstants.TPL_KEY_SETTLE_OVERDUE_REMINDER_TO_BUYER:
                    //获取相应的用户列表
                    payload.put("flag", SETTLE);
                    dataModel.put("settleBillNumb", ordNum);
                    dataModel.put("lateFee", param.get("lateFee"));
                    //设置该消息发送的用户类型，1买家、2卖家、12全部
                    userType = "1";
                    break;
                //结算单逾期（发送给卖家）
                case TIMNoticeConstants.TPL_KEY_SETTLE_OVERDUE_REMINDER_TO_SALLER:
                    //获取相应的用户列表
                    payload.put("flag", SETTLE);
                    dataModel.put("settleBillNumb", ordNum);
                    dataModel.put("lateFee", param.get("lateFee"));
                    dataModel.put("buyerName", param.get("buyerName"));
                    //设置该消息发送的用户类型，1买家、2卖家、12全部
                    userType = "2";
                    break;
                //对账完成（发送给买家）
                case TIMNoticeConstants.TPL_KEY_SETTLE_TO_BUYER:
                    //获取相应的用户列表
                    payload.put("flag", SETTLE);
                    dataModel.put("settleBillNumb", ordNum);
                    dataModel.put("lastPayDate", param.get("lastPayDate"));
                    dataModel.put("totalMoney", param.get("totalMoney"));
                    //设置该消息发送的用户类型，1买家、2卖家、12全部
                    userType = "1";
                    break;
                //对账完成（发送给卖家 - 买家对账时需要发票）
                case TIMNoticeConstants.TPL_KEY_SETTLE_TO_BE_INVOICED:
                    //获取相应的用户列表
                    payload.put("flag", SETTLE);
                    dataModel.put("settleBillNumb", ordNum);
                    dataModel.put("lastPayDate", param.get("lastPayDate"));
                    dataModel.put("totalMoney", param.get("totalMoney"));
                    dataModel.put("buyerName", param.get("buyerName"));
                    //设置该消息发送的用户类型，1买家、2卖家、12全部
                    userType = "2";
                    break;
                //结算单开票完成（发送给买家）
                case TIMNoticeConstants.TPL_KEY_SETTLE_TICKET_REMINDER:
                    //获取相应的用户列表
                    payload.put("flag", SETTLE);
                    dataModel.put("settleBillNumb", ordNum);
                    //设置该消息发送的用户类型，1买家、2卖家、12全部
                    userType = "1";
                    break;
            }
            //当期用户类型（用作查询标识 0买家则查询采购员，1卖家则查询档口下业务员）
            //判断是买家还是卖家
            if (userType.contains("2")) {
                //查询商家管理员列表
                spo.setMembId(user.getMembId());
                spo.setSfAdminFlag(DictConstants.SF_ADMIN_FLAG_0);
                List<SaleStaffInfoMageInfoVo> saleList = saleStaffInfoMageMapper.findListByMembId(spo);
                //查询该档口下员工列表
                if (staffId != null) {
                    SaleStaffInfoMagePo sspo = new SaleStaffInfoMagePo();
                    sspo.setSaleStaffId(staffId);
                    sspo.setSfAdminFlag(DictConstants.SF_ADMIN_FLAG_1);
                    List<SaleStaffInfoMagePageListVo> stafList = stallsStaffRelaMageMapper.findAll(sspo);
                    stafList.forEach(e -> {
                        idList.add(e.getMembId().toString());
                    });
                }
                saleList.forEach(e -> {
                    idList.add(e.getMembId().toString());
                });
            }
            if (userType.contains("1")) {
                //查询买家管理员列表
                List<String> puList = purchaseStaffMageMapper.findPurMageAdminList(user.getMembId());
                //去掉重复
                idList.addAll(puList);
            }
            if (param.get("transType") != null) {
                payload.put("transType", param.get("transType"));
            }
            //发送消息
            timNoticeService.sendTpl(timType, dataModel, idList.stream().distinct().collect(Collectors.toList()), payload);
        } catch (Exception e) {
            LoggerUtil.error("发送模版消息出现异常。参数：{}，异常信息：{}", param, e);
        }
    }
}
