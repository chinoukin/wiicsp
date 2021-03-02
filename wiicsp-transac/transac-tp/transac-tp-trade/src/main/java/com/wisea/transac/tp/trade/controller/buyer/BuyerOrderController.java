package com.wisea.transac.tp.trade.controller.buyer;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.RefundApplPo;
import com.wisea.transac.common.po.StringIdsPo;
import com.wisea.transac.common.po.trade.BuyerOrderInfoListPo;
import com.wisea.transac.common.po.trade.BuyerPayRequestPo;
import com.wisea.transac.common.po.trade.BuyerRefundListPo;
import com.wisea.transac.common.po.trade.InvoApplPo;
import com.wisea.transac.common.po.trade.InvoicingPo;
import com.wisea.transac.common.po.trade.OrdInvoPagePo;
import com.wisea.transac.common.po.trade.OrderInfoPo;
import com.wisea.transac.common.vo.OrdInvoInfoVo;
import com.wisea.transac.common.vo.trade.BuyerOrderInfoListVo;
import com.wisea.transac.common.vo.trade.BuyerRefundInfoVo;
import com.wisea.transac.common.vo.trade.BuyerRefundListVo;
import com.wisea.transac.common.vo.trade.OrdCancelReasonMageListVo;
import com.wisea.transac.common.vo.trade.OrdInvoPageVo;
import com.wisea.transac.common.vo.trade.OrderInfoVo;
import com.wisea.transac.common.vo.trade.OrderListNumVo;
import com.wisea.transac.common.vo.trade.TopayInfoVo;
import com.wisea.transac.tp.trade.service.BuyerPayService;
import com.wisea.transac.tp.trade.service.OrderInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 买家订单Controller
 */
@Api(tags = "【买家】订单管理接口")
@RestController
@RequestMapping("/w/buyer")
public class BuyerOrderController {
    @Autowired
    private OrderInfoService service;
    @Autowired
    private BuyerPayService buyerPayService;

    /**
     * 买家查询订单列表
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/order/list", method = RequestMethod.POST)
    @ApiOperation(nickname = "买家查询订单列表", value = "【订单】买家查询订单列表", notes = "买家查询订单列表", httpMethod = "POST")
    public ResultPoJo<Page<BuyerOrderInfoListVo>> findList(@RequestBody BuyerOrderInfoListPo po){
        return service.findBuyerOrderList(po);
    }

    /**
     * 买家订单列表角标
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/order/list/numb", method = RequestMethod.POST)
    @ApiOperation(nickname = "买家查询订单列表", value = "【订单】买家订单列表角标", notes = "买家订单列表角标", httpMethod = "POST")
    public ResultPoJo<List<OrderListNumVo>> buyerOrderListNum(@RequestBody BuyerOrderInfoListPo po){
        return service.buyerOrderListNum(po);
    }

    /**
     * 基地买家端查询订单详情
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/order/baseBuyerOrderInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "基地买家端查询订单详情", value = "【订单】基地买家端查询订单详情", notes = "基地买家端查询订单详情", httpMethod = "POST")
    public ResultPoJo<OrderInfoVo> baseBuyerOrderInfo(@RequestBody OrderInfoPo po){
        return service.baseBuyerOrderInfo(po);
    }

    /**
     * 买家端查询订单详情
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/order/info", method = RequestMethod.POST)
    @ApiOperation(nickname = "买家端查询订单详情", value = "【订单】买家端查询订单详情", notes = "买家端查询订单详情", httpMethod = "POST")
    public ResultPoJo<OrderInfoVo> buyerOrderInfo(@RequestBody OrderInfoPo po){
        return service.buyerOrderInfo(po);
    }

    /**
     * 基地查看、修改发票详情页
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/order/baseInvoApplInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "基地查看、修改发票详情页", value = "【订单】基地查看、修改发票详情页", notes = "基地查看、修改发票详情页", httpMethod = "POST")
    public ResultPoJo<OrdInvoInfoVo> baseInvoApplInfo(@RequestBody LongIdPo po){
        return service.baseInvoApplInfo(po);
    }

    /**
     * 查看、修改发票详情页
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/order/invoInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查看、修改发票详情页", value = "【订单】查看、修改发票详情页", notes = "查看、修改发票详情页", httpMethod = "POST")
    public ResultPoJo<OrdInvoInfoVo> invoApplInfo(@RequestBody LongIdPo po){
        return service.invoApplInfo(po);
    }

    /**
     * 修改、新增订单/账期发票
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/order/invoUpd", method = RequestMethod.POST)
    @ApiOperation(nickname = "修改、新增订单/账期发票", value = "【订单】修改、新增订单/账期发票", notes = "修改、新增订单/账期发票", httpMethod = "POST")
    public ResultPoJo<Object> invoApplUpd(@RequestBody InvoApplPo po){
        return service.invoApplUpd(po);
    }

    /**
     * 买家端取消订单校验
     * @param
     * @return
     */
    @DataCheck
    @RequestMapping(value="/order/cancelChack",method=RequestMethod.POST)
    @ApiOperation(nickname = "取消订单校验", value="【订单】取消订单校验", notes="【订单】取消订单校验", httpMethod = "POST")
    public ResultPoJo<Object> orderCancelChack (@RequestBody LongIdPo longIdPo) {
        return service.cancelOrdChack(longIdPo);
    }

    /**
     * 取消订单原因列表
     * @param
     * @return
     */
    @ApiOperation(nickname = "取消订单原因列表", value="【订单】取消订单原因列表", notes="【订单】取消订单原因列表", httpMethod = "POST")
    @DataCheck
    @RequestMapping(value="/order/cancelReason",method=RequestMethod.POST)
    public ResultPoJo<List<OrdCancelReasonMageListVo>> findOrdCancelReason () {
        return service.findOrdCancelReason();
    }

    /**
     * 买家端取消订单
     * @param
     * @return
     */
    @ApiOperation(nickname = "取消订单", value="【订单】取消订单", notes="【订单】取消订单", httpMethod = "POST")
    @DataCheck
    @RequestMapping(value="/order/cancel",method=RequestMethod.POST)
    public ResultPoJo<Object> orderCancel (@RequestBody RefundApplPo refundApplPo) {
        return service.cancelOrd(refundApplPo);
    }

    /**
     * 去支付页面详情页
     * @param
     * @return
     */
    @ApiOperation(nickname = "去支付页面详情页", value="【订单】去支付页面详情页", notes="【订单】去支付页面详情页", httpMethod = "POST")
    @DataCheck
    @RequestMapping(value="/order/toPayInfo",method=RequestMethod.POST)
    public ResultPoJo<TopayInfoVo> toPayInfo (@RequestBody LongIdPo po) {
        return service.toPayInfo(po);
    }

    /**
     * 基地去支付页面详情页
     * @param
     * @return
     */
    @ApiOperation(nickname = "基地去支付页面详情页", value="【订单】基地去支付页面详情页", notes="【订单】基地去支付页面详情页", httpMethod = "POST")
    @DataCheck
    @RequestMapping(value="/order/toPayLocalInfo",method=RequestMethod.POST)
    public ResultPoJo<TopayInfoVo> toPayLocalInfo (@RequestBody LongIdPo po) {
        return service.toPayLocalInfo(po);
    }

    /**
     * 买家查询退款列表
     * @param
     * @return
     */
    @ApiOperation(nickname = "买家查询退款列表", value="【订单】买家查询退款列表", notes="【订单】买家查询退款列表", httpMethod = "POST")
    @DataCheck
    @RequestMapping(value="/refund/list",method=RequestMethod.POST)
    public ResultPoJo<Page<BuyerRefundListVo>> buyerRefundList (@RequestBody BuyerRefundListPo po) {
        return service.buyerRefundList(po);
    }

    /**
     * 买家查询退款列表角标
     * @param
     * @return
     */
    @ApiOperation(nickname = "买家查询退款列表角标", value="【订单】买家查询退款列表角标", notes="【订单】买家查询退款列表角标", httpMethod = "POST")
    @DataCheck
    @RequestMapping(value="/refund/listNum",method=RequestMethod.POST)
    public ResultPoJo<List<OrderListNumVo>> buyerRefundListNum (@RequestBody BuyerRefundListPo po) {
        return service.buyerRefundListNum(po);
    }

    /**
     * 买家首页我的订单角标
     * @param
     * @return
     */
    @ApiOperation(nickname = "买家首页我的订单角标", value="【订单】买家首页我的订单角标", notes="【订单】买家首页我的订单角标", httpMethod = "POST")
    @DataCheck
    @RequestMapping(value="/order/myOrderNum",method=RequestMethod.POST)
    public ResultPoJo<Map<String, List<OrderListNumVo>>> myOrderNum () {
        return service.myOrderNum();
    }

    /**
     * 退款详情页
     * @param
     * @return
     */
    @ApiOperation(nickname = "退款详情页", value="【订单】退款详情页", notes="【订单】退款详情页", httpMethod = "POST")
    @DataCheck
    @RequestMapping(value="/refund/info",method=RequestMethod.POST)
    public ResultPoJo<BuyerRefundInfoVo> buyerRefundInfo (@RequestBody LongIdPo po) {
        return service.buyerRefundInfo(po);
    }

    /**
     * 撤销取消订单申请
     * @param
     * @return
     */
    @ApiOperation(nickname = "撤销取消订单申请", value="【订单】撤销取消订单申请", notes="【订单】撤销取消订单申请", httpMethod = "POST")
    @DataCheck
    @RequestMapping(value="/refund/revoke",method=RequestMethod.POST)
    public ResultPoJo<Object> refundCommConcel (@RequestBody LongIdPo po) {
        return service.refundCommConcel(po);
    }

    /**
     * 账期支付
     * @param
     * @return
     */
    @ApiOperation(nickname="【订单】-账期支付", value="【订单】账期支付", notes="账期支付", httpMethod = "POST")
    @DataCheck
    @RequestMapping(value="/order/accountPay",method=RequestMethod.POST)
    public ResultPoJo<Object> accountPay (@RequestBody StringIdsPo longIdPo) {
        return service.accountPay(longIdPo.getIds());
    }

    /**
     * 基地账期支付
     * @param
     * @return
     */
    @ApiOperation(nickname="【订单】-基地账期支付", value="【订单】基地账期支付", notes="基地账期支付", httpMethod = "POST")
    @DataCheck
    @RequestMapping(value="/order/localAccountPay",method=RequestMethod.POST)
    public ResultPoJo<Object> localAccountPay (@RequestBody StringIdsPo longIdPo) {
        return service.localAccountPay(longIdPo.getIds());
    }

    /**
     * 订单支付
     * @param po
     * @return
     * @throws Exception
     */
    @ApiOperation(nickname="【订单】订单支付", value="【订单】订单支付", notes="订单支付", httpMethod = "POST")
    @DataCheck
    @RequestMapping(value="/order/buyerPay",method=RequestMethod.POST)
    public ResultPoJo<Object> buyerPay (@RequestBody BuyerPayRequestPo po) throws Exception {
        return buyerPayService.buyerPay(po);
    }

    /**
     * 确认收货
     * @param po
     * @return
     * @throws Exception
     */
    @ApiOperation(nickname="【订单】确认收货", value="【订单】确认收货", notes="确认收货", httpMethod = "POST")
    @DataCheck
    @RequestMapping(value="/order/receCommit",method=RequestMethod.POST)
    public ResultPoJo<Object> receCommit (@RequestBody LongIdPo po) throws Exception {
        return service.receCommit(po.getId());
    }

    /**
     * 查询订单发票列表
     * @param po
     * @return
     */
    @ApiOperation(nickname="【订单】查询订单发票列表", value="【订单】查询订单发票列表", notes="查询订单发票列表", httpMethod = "POST")
    @DataCheck
    @RequestMapping(value="/order/ordInvoList",method=RequestMethod.POST)
    public ResultPoJo<Page<OrdInvoPageVo>> ordInvoList (@RequestBody OrdInvoPagePo po) {
        return service.ordInvoList(po);
    }

    /**
     * 查询订单发票角标
     * @param po
     * @return
     */
    @ApiOperation(nickname="【订单】查询订单发票角标", value="【订单】查询订单发票角标", notes="查询订单发票角标", httpMethod = "POST")
    @DataCheck
    @RequestMapping(value="/order/orderInvoListNum",method=RequestMethod.POST)
    public ResultPoJo<List<OrderListNumVo>> orderInvoListNum (@RequestBody OrdInvoPagePo po) {
        return service.orderInvoListNum(po);
    }

    /**
     * 商家开票、重新开票
     * @param po
     * @return
     */
    @ApiOperation(nickname="【订单】商家开票、重新开票", value="【订单】商家开票、重新开票", notes="商家开票、重新开票", httpMethod = "POST")
    @DataCheck
    @RequestMapping(value="/order/ordInvoicing",method=RequestMethod.POST)
    public ResultPoJo<Object> ordInvoicing (@RequestBody InvoicingPo po) {
        return service.ordInvoicing(po);
    }
}
