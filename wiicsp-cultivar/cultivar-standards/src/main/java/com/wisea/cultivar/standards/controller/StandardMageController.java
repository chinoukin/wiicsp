package com.wisea.cultivar.standards.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.standards.po.*;
import com.wisea.cultivar.standards.service.StandardMageService;
import com.wisea.cultivar.standards.vo.StandardMageGetVo;
import com.wisea.cultivar.standards.vo.StandardMageListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * StandardMageController
 * 标准管理 Controller
 * 2020/07/24 11:21:45
 */
@Api(tags = "标准管理相关接口")
@RequestMapping(value = "/w/StandardMage")
@RestController
public class StandardMageController {
    @Autowired
    protected StandardMageService standardMageService;



    @ApiOperation(value = "获取标准管理分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<StandardMageListVo>> findPage(@RequestBody StandardMagePagePo standardMagePagePo) {
        return standardMageService.findPage(standardMagePagePo);
    }

    @ApiOperation(value = "获取标准管理列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<StandardMageListVo>> list(@RequestBody StandardMageListPo standardMageListPo) {
        return standardMageService.findList(standardMageListPo);
    }

    @ApiOperation(value = "查询标准管理")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<StandardMageGetVo> get(@RequestBody StandardMageGetPo standardMageGetPo) {
        return standardMageService.get(standardMageGetPo);
    }

    @ApiOperation(value = "新增标准管理")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody StandardMageInsertPo standardMageInsertPo) {
        return standardMageService.insert(standardMageInsertPo);
    }

    @ApiOperation(value = "修改标准管理")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody StandardMageUpdatePo standardMageUpdatePo) {
        return standardMageService.update(standardMageUpdatePo);
    }

    @ApiOperation(value = "批量删除标准管理")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody StandardMageBatDeletePo standardMageBatDeletePo) {
        return standardMageService.batDelete(standardMageBatDeletePo);
    }

    @ApiOperation(value = "删除标准管理")
    @RequestMapping(value = "oneDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> oneDelete(@RequestBody StandardMageOneDeletePo standardMageOneDeletePo) {
        return standardMageService.oneDelete(standardMageOneDeletePo);
    }


    @ApiOperation(value = "根据id获取单条数据-关联标准")
    @RequestMapping(value = "oneData", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<StandardMageGetVo> oneData(@RequestBody StandardMageGetPo standardMageGetPo) {
        return standardMageService.oneData(standardMageGetPo);
    }
}
