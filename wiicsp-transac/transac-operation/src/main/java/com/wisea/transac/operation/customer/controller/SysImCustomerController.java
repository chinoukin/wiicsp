package com.wisea.transac.operation.customer.controller;

import com.wisea.transac.operation.customer.service.SysImCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.transac.operation.customer.po.SysImCustomerAddSerCountPo;
import com.wisea.transac.operation.customer.po.SysImCustomerDispatchPo;
import com.wisea.transac.operation.customer.po.SysImCustomerSubSerCountPo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "客服分配接口")
@RequestMapping(value = "/w/im/customer")
@RestController
public class SysImCustomerController {
    @Autowired
    protected SysImCustomerService sysImCustomerService;

    @ApiOperation(value = "分配客服(所有组内客服分配)", notes = "按客服接待数量轮询分配 包括不在线的和最大接待数量超过的 如果传递分组id数组，将会遍历分配客服，直到分配成功立即返回。当入参的分组中没有分配成功任何一个客服，会自动分配平台客服。")
    @RequestMapping(value = "dispatch", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<String> dispatch(@RequestBody SysImCustomerDispatchPo po) {
        return sysImCustomerService.dispatch(po);
    }

    @ApiOperation(value = "为客服增加一个接待人数")
    @RequestMapping(value = "addSerCount", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> addSerCount(@RequestBody SysImCustomerAddSerCountPo po) {
        ResultPoJo<Object> result = new ResultPoJo<Object>();
        sysImCustomerService.addSerCount(po);
        return result;
    }

    @ApiOperation(value = "为客服减少一个接待人数")
    @RequestMapping(value = "subSerCount", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> subSerCount(@RequestBody SysImCustomerSubSerCountPo po) {
        return sysImCustomerService.subSerCount(po);
    }
}
