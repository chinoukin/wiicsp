package com.wisea.cultivar.standards.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.standards.po.*;
import com.wisea.cultivar.standards.service.StandardRuleMageService;
import com.wisea.cultivar.standards.vo.StandardMageListVo;
import com.wisea.cultivar.standards.vo.StandardRuleMageGetVo;
import com.wisea.cultivar.standards.vo.StandardRuleMageListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * StandardRuleMageController
 * 标准规范管理 Controller
 * 2020/07/24 11:21:45
 */
@Api(tags = "标准规范管理相关接口")
@RequestMapping(value = "/w/StandardRuleMage")
@PreAuthorize("hasAuthority('st:reg')")
@RestController
public class StandardRuleMageController {
    @Autowired
    protected StandardRuleMageService standardRuleMageService;

    @ApiOperation(value = "获取标准规范管理分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<StandardRuleMageListVo>> findPage(@RequestBody StandardRuleMagePagePo standardRuleMagePagePo) {
        return standardRuleMageService.findPage(standardRuleMagePagePo);
    }

    @ApiOperation(value = "标准大数据接口")//获取标准规范管理列表
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<StandardRuleMageListVo>> list(@RequestBody StandardRuleMageListPo standardRuleMageListPo) {
        return standardRuleMageService.findList(standardRuleMageListPo);
    }

    @ApiOperation(value = "查询标准规范管理")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<StandardRuleMageGetVo> get(@RequestBody StandardRuleMageGetPo standardRuleMageGetPo) {
        return standardRuleMageService.get(standardRuleMageGetPo);
    }

    @ApiOperation(value = "新增标准规范管理")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public  ResultPoJo<Object> insert(@RequestBody StandardRuleMageInsertPo standardRuleMageInsertPo) {
        return standardRuleMageService.insert(standardRuleMageInsertPo);
    }

    @ApiOperation(value = "修改标准规范管理")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody StandardRuleMageUpdatePo standardRuleMageUpdatePo) {
        return standardRuleMageService.update(standardRuleMageUpdatePo);
    }

    @ApiOperation(value = "批量删除标准规范管理")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody StandardRuleMageBatDeletePo standardRuleMageBatDeletePo) {
        return standardRuleMageService.batDelete(standardRuleMageBatDeletePo);
    }

    @ApiOperation(value = "种植,采收，加工列表")
    @RequestMapping(value = "queryList", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<StandardMageListVo>> queryList(@RequestBody StandardMageListPo standardMageListPo) {
        return standardRuleMageService.queryList(standardMageListPo);
    }
}
