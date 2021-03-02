package com.wisea.transac.tp.trade.controller.seller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.StringPo;
import com.wisea.transac.common.po.trade.*;
import com.wisea.transac.common.vo.PageStateCountResultVo;
import com.wisea.transac.tp.trade.service.OrderInfoService;
import com.wisea.transac.common.vo.trade.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 卖家订单Controller
 */
@Api(tags = "【卖家/市场】订单管理接口")
@RestController
@RequestMapping("/w/seller/order")
public class OrderInfoController {
    @Autowired
    private OrderInfoService service;

    /**
     * 卖家查询订单列表
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/findList", method = RequestMethod.POST)
    @ApiOperation(nickname = "卖家/市场查询订单列表", value = "【订单】卖家查询订单列表", notes = "卖家查询订单列表", httpMethod = "POST")
    public ResultPoJo<PageStateCountResultVo<MerchantOrderInfoListVo>> findList(@RequestBody MerchantOrderInfoListPo po){
        return service.findMerchantOrderList(po);
    }

    /**
     * 查询订单详细信息
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "卖家/市场查询订单详细信息", value = "【订单】查询订单详细信息", notes = "查询订单详细信息", httpMethod = "POST")
    public ResultPoJo<OrderInfoVo> findInfo(@RequestBody OrderInfoPo po){
        return service.findOrderInfo(po);
    }

    /**
     * 卖家/买家查询提货信息详情
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/findDeliveryInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "卖家/买家查询提货信息详情", value = "【订单】卖家/买家查询提货信息详情", notes = "卖家/买家查询提货信息详情", httpMethod = "POST")
    public ResultPoJo<DeliveryInfoVo> findDeliveryInfo(@RequestBody LongIdPo po){
        return service.findDeliveryInfo(po);
    }

    /**
     * 修改提货信息
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/updateDelivery", method = RequestMethod.POST)
    @ApiOperation(nickname = "卖家/买家修改提货信息", value = "【订单】卖家/买家修改提货信息", notes = "卖家/买家修改提货信息", httpMethod = "POST")
    public ResultPoJo<?> updateDelivery(@RequestBody UpdateDeliveryPo po){
        return service.updateDelivery(po);
    }

    /**
     * 修改报价
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/updateQuoted", method = RequestMethod.POST)
    @ApiOperation(nickname = "卖家修改报价", value = "【订单】卖家修改报价", notes = "卖家修改报价", httpMethod = "POST")
    public ResultPoJo<?> updateQuoted(@RequestBody UpdateQuotedPo po){
        return service.updateQuoted(po);
    }

    /**
     * 卖家确认订单
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/confirmOrd", method = RequestMethod.POST)
    @ApiOperation(nickname = "卖家确认订单", value = "【订单】卖家确认订单", notes = "卖家确认订单", httpMethod = "POST")
    public ResultPoJo<?> confirmOrd(@RequestBody LongIdPo po){
        return service.confirmOrd(po);
    }

    /**
     * 生成提货/发货单
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/billOfLading", method = RequestMethod.POST)
    @ApiOperation(nickname = "生成提货/发货单", value = "【订单】生成提货/发货单", notes = "生成提货/发货单", httpMethod = "POST")
    public ResultPoJo<String> billOfLading(@RequestBody LongIdPo po){
        return service.billOfLading(po);
    }

    /**
     * 订单发货
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/orderDelive", method = RequestMethod.POST)
    @ApiOperation(nickname = "订单发货", value = "【订单】订单发货", notes = "订单发货", httpMethod = "POST")
    public ResultPoJo<?> orderDelive(@RequestBody OrderDelivePo po){
        return service.orderDelive(po);
    }

    /**
     * 订单跟踪（查询订单物流公司编码及物流单号）
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/orderTrack", method = RequestMethod.POST)
    @ApiOperation(nickname = "订单跟踪", value = "【订单】订单跟踪", notes = "订单跟踪", httpMethod = "POST")
    public ResultPoJo<LogisticsInfoVo> orderTrack(@RequestBody LongIdPo po){
        return service.orderTrack(po);
    }

    /**
     * 根据自提码查询自提订单详情
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/findByZtNum", method = RequestMethod.POST)
    @ApiOperation(nickname = "根据自提码查询自提订单详情", value = "【订单】根据自提码查询自提订单详情", notes = "根据自提码查询自提订单详情", httpMethod = "POST")
    public ResultPoJo<ZtOrderInfoVo> findByZtNum(@RequestBody StringPo po){
        return service.findByZtNum(po);
    }

    /**
     * 提货金额明细
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/deliveryAmountDetails", method = RequestMethod.POST)
    @ApiOperation(nickname = "提货金额明细", value = "【订单】提货金额明细", notes = "提货金额明细", httpMethod = "POST")
    public ResultPoJo<DeliveryAmountDetailsVo> deliveryAmountDetails(@RequestBody OrderDeliveryPo po){
        return service.deliveryAmountDetails(po);
    }

    /**
     * 订单提货
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/orderDelivery", method = RequestMethod.POST)
    @ApiOperation(nickname = "订单提货", value = "【订单】订单提货", notes = "订单提货", httpMethod = "POST")
    public ResultPoJo<?> orderDelivery(@RequestBody OrderDeliveryPo po){
        return service.orderDelivery(po);
    }


    /**
     * @Author jirg
     * @Date 2020/5/18 14:35
     * @Description 【卖家/市场】未出账单列表
     **/
    @DataCheck
    @RequestMapping(value = "/outstandingBill", method = RequestMethod.POST)
    @ApiOperation(nickname = "【卖家/市场】未出账单列表", value = "【后台/商家】未出账单列表", notes = "【后台/商家】未出账单列表", httpMethod = "POST")
    public ResultPoJo<List<OutstandingBillVo>> outstandingBill(@RequestBody OutstandingBillPo po) {
        return service.outstandingBill(po);
    }

    /**
     * @Author jirg
     * @Date 2020/5/18 14:35
     * @Description 【卖家/市场】未出账单详细信息
     **/
    @DataCheck
    @RequestMapping(value = "/outstandingBillInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "【卖家/市场】未出账单详细信息", value = "【后台/商家】未出账单详细信息", notes = "【后台/商家】未出账单详细信息", httpMethod = "POST")
    public ResultPoJo<OutstandingBillInfoVo> outstandingBillInfo(@RequestBody OutstandingBillInfoPo po) {
        return service.outstandingBillInfo(po);
    }

    /**
     * @Author jirg
     * @Date 2020/5/18 14:35
     * @Description 【市场】处理争议订单
     **/
    @DataCheck
    @RequestMapping(value = "/handleDisputes", method = RequestMethod.POST)
    @ApiOperation(nickname = "【市场】处理争议订单", value = "【市场】处理争议订单", notes = "【市场】处理争议订单", httpMethod = "POST")
    public ResultPoJo<?> handleDisputes(@RequestBody OrderHandleDisputesPo po) {
        return service.handleDisputes(po);
    }
}
