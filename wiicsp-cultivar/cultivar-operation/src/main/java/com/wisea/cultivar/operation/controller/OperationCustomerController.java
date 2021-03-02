package com.wisea.cultivar.operation.controller;

import com.wisea.cultivar.operation.service.OperationCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.common.po.customer.OperationCustomerConfigGetVo;
import com.wisea.cultivar.common.po.customer.OperationCustomerSavePo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "运营平台客服管理接口")
@RequestMapping(value = "/w/operation/customer/config/")
@RestController
public class OperationCustomerController {
    @Autowired
    private OperationCustomerService operationCustomerService;

    @ApiOperation(value = "查询客服管理配置", notes = "登录用户:运营平台管理员->系统的客服配置")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<OperationCustomerConfigGetVo> get() {
        return operationCustomerService.getConfig();
    }

    @ApiOperation(value = "新增或修改客服管理配置", notes = "新增或修改客服管理配置")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(OperationCustomerSavePo updatePo) {
        return operationCustomerService.save(updatePo);
    }
}
