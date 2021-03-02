package com.wisea.cultivar.operation.customer.controller;

import com.wisea.cultivar.operation.customer.service.SysImCustomerConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.common.po.customer.SysImCustomerConfigGetPo;
import com.wisea.cultivar.common.po.customer.SysImCustomerConfigGetVo;
import com.wisea.cultivar.common.po.customer.SysImCustomerConfigInsertPo;
import com.wisea.cultivar.common.po.customer.SysImCustomerConfigUpdatePo;
import com.wisea.cultivar.common.po.customer.SysImCustomerListDeletePo;
import com.wisea.cultivar.common.po.customer.SysImCustomerListInsertPo;
import com.wisea.cultivar.common.po.customer.SysImCustomerListUpdatePo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * SysImCustomerConfigController 客服管理配置表 Controller 2018/09/29 13:46:47
 */
@Api(tags = "客服管理配置表相关接口")
@RequestMapping(value = "/w/im/customer/config")
@RestController
public class SysImCustomerConfigController {
    @Autowired
    protected SysImCustomerConfigService sysImCustomerConfigService;

    @ApiOperation(value = "查询客服管理配置")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<SysImCustomerConfigGetVo> get(@RequestBody SysImCustomerConfigGetPo po) {
        ResultPoJo<SysImCustomerConfigGetVo> result = new ResultPoJo<SysImCustomerConfigGetVo>();
        SysImCustomerConfigGetVo res = sysImCustomerConfigService.get(po.getGroupId());
        result.setResult(res);
        return result;
    }

    @ApiOperation(value = "新增客服管理配置")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody SysImCustomerConfigInsertPo sysImCustomerConfigInsertPo) {
        return sysImCustomerConfigService.insert(sysImCustomerConfigInsertPo);
    }

    @ApiOperation(value = "修改客服管理配置")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody SysImCustomerConfigUpdatePo sysImCustomerConfigUpdatePo) {
        return sysImCustomerConfigService.update(sysImCustomerConfigUpdatePo);
    }

    @ApiOperation(value = "增加客服列表")
    @RequestMapping(value = "customerListInsert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> customerListInsert(@RequestBody SysImCustomerListInsertPo po) {
        return sysImCustomerConfigService.customerListInsert(po);
    }

    @ApiOperation(value = "修改客服列表")
    @RequestMapping(value = "customerListUpdate", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> customerListUpdate(@RequestBody SysImCustomerListUpdatePo po) {
        return sysImCustomerConfigService.customerListUpdate(po);
    }

    @ApiOperation(value = "删除客服列表")
    @RequestMapping(value = "customerListDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> customerListDelete(@RequestBody SysImCustomerListDeletePo po) {
        return sysImCustomerConfigService.customerListDelete(po);
    }
}
