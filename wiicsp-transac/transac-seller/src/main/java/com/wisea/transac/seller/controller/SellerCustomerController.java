package com.wisea.transac.seller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.transac.common.po.customer.CustomerConfigUserInsertPo;
import com.wisea.transac.common.po.customer.SellerCustomerSavePo;
import com.wisea.transac.common.po.customer.SellerStallCustomerListVo;
import com.wisea.transac.common.po.customer.SysImCustomerConfigGetVo;
import com.wisea.transac.seller.service.SellerCustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "店铺客服管理接口")
@RequestMapping(value = "/w/sellerCustomer/config/")
@RestController
@PreAuthorize("hasAuthority('sel:cust')") // 必须有店铺客服权限
public class SellerCustomerController {
    @Autowired
    private SellerCustomerService sellerCustomerService;

    @ApiOperation(value = "查询当前登录用户的客服管理配置", notes = "登录用户:店铺/档口:只能能查询到自己的客服配置 (档口查的也是店铺的客服 档口权限跟菜单走)")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<SysImCustomerConfigGetVo> get() {
        return sellerCustomerService.getConfig();
    }

    @ApiOperation(value = "修改查询当前登录用户的客服管理配置", notes = "修改客服管理配置")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody SellerCustomerSavePo updatePo) {
        return sellerCustomerService.update(updatePo);
    }

    @ApiOperation(value = "查询当前登录用户的客服列表", notes = "查询当前登录用户的客服列表")
    @RequestMapping(value = "getCustomerList", method = RequestMethod.POST)
    public ResultPoJo<List<SellerStallCustomerListVo>> getCustomerList() {
        return sellerCustomerService.getCustomerList();
    }

    @ApiOperation(value = "新增查询当前登录用户的客服列表", notes = "新增客服列表")
    @RequestMapping(value = "customerListInsert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> customerListInsert(@RequestBody List<CustomerConfigUserInsertPo> po) {
        return sellerCustomerService.customerListInsert(po);
    }

    @ApiOperation(value = "修改查询当前登录用户的客服列表", notes = "修改客服列表")
    @RequestMapping(value = "customerListUpdate", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> customerListUpdate(@RequestBody List<CustomerConfigUserInsertPo> po) {
        return sellerCustomerService.customerListUpdate(po);
    }

    @ApiOperation(value = "删除查询当前登录用户的客服列表", notes = "删除客服列表")
    @RequestMapping(value = "customerListDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> customerListDelete(List<Long> po) {
        return sellerCustomerService.customerListDelete(po);
    }

}
