package com.wisea.transac.tp.trade.controller.seller.base;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.trade.LocalityOrderInfoListPo;
import com.wisea.transac.common.po.trade.OrderInfoPo;
import com.wisea.transac.common.vo.PageStateCountResultVo;
import com.wisea.transac.common.vo.trade.MerchantOrderInfoListVo;
import com.wisea.transac.common.vo.trade.OrderInfoVo;
import com.wisea.transac.tp.trade.service.LocalityOrderInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 卖家订单Controller
 */
@Api(tags = "【数字基地】卖家订单管理接口")
@RestController
@RequestMapping("/w/seller/base/order")
public class LocalityInfoController {
    @Autowired
    private LocalityOrderInfoService service;

    /**
     * 卖家查询订单列表
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/findList", method = RequestMethod.POST)
    @ApiOperation(nickname = "卖家查询订单列表", value = "【订单】卖家查询订单列表", notes = "卖家查询订单列表", httpMethod = "POST")
    public ResultPoJo<PageStateCountResultVo<MerchantOrderInfoListVo>> findList(@RequestBody LocalityOrderInfoListPo po){
        return service.findMerchantOrderList(po);
    }

    /**
     * 查询订单详细信息
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "卖家查询订单详细信息", value = "【订单】查询订单详细信息", notes = "查询订单详细信息", httpMethod = "POST")
    public ResultPoJo<OrderInfoVo> findInfo(@RequestBody OrderInfoPo po){
        return service.findOrderInfo(po);
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
}
