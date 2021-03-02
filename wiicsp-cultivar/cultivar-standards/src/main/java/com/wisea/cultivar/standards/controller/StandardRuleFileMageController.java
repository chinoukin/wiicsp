package com.wisea.cultivar.standards.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.standards.po.StandardRuleFileMageBatDeletePo;
import com.wisea.cultivar.standards.po.StandardRuleFileMageGetPo;
import com.wisea.cultivar.standards.po.StandardRuleFileMageInsertPo;
import com.wisea.cultivar.standards.po.StandardRuleFileMageListPo;
import com.wisea.cultivar.standards.po.StandardRuleFileMagePagePo;
import com.wisea.cultivar.standards.po.StandardRuleFileMageUpdatePo;
import com.wisea.cultivar.standards.service.StandardRuleFileMageService;
import com.wisea.cultivar.standards.vo.StandardRuleFileMageGetVo;
import com.wisea.cultivar.standards.vo.StandardRuleFileMageListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * StandardRuleFileMageController
 * 标准规范附件管理 Controller
 * 2020/07/24 11:21:45
 */
@Api(tags = "标准规范附件管理相关接口")
@RequestMapping(value = "/w/StandardRuleFileMage")
@RestController
public class StandardRuleFileMageController {
    @Autowired
    protected StandardRuleFileMageService standardRuleFileMageService;

    @ApiOperation(value = "获取标准规范附件管理分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<StandardRuleFileMageListVo>> findPage(@RequestBody StandardRuleFileMagePagePo standardRuleFileMagePagePo) {
        return standardRuleFileMageService.findPage(standardRuleFileMagePagePo);
    }

    @ApiOperation(value = "获取标准规范附件管理列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<StandardRuleFileMageListVo>> list(@RequestBody StandardRuleFileMageListPo standardRuleFileMageListPo) {
        return standardRuleFileMageService.findList(standardRuleFileMageListPo);
    }
    @ApiOperation(value = "根据标准规范管理id查询标准规范附件管理")
    @RequestMapping(value = "getById", method = RequestMethod.POST)
    public ResultPoJo<List<StandardRuleFileMageListVo>> getById(@RequestBody StandardRuleFileMageUpdatePo standardRuleFileMageUpdatePo) {
        return standardRuleFileMageService.getById(standardRuleFileMageUpdatePo.getStandardRuleMageId());
    }
    @ApiOperation(value = "查询标准规范附件管理")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<StandardRuleFileMageGetVo> get(@RequestBody StandardRuleFileMageGetPo standardRuleFileMageGetPo) {
        return standardRuleFileMageService.get(standardRuleFileMageGetPo);
    }

    @ApiOperation(value = "新增标准规范附件管理")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody List<StandardRuleFileMageInsertPo> standardRuleFileMageInsertPo) {
        return standardRuleFileMageService.insert(standardRuleFileMageInsertPo);
    }

    @ApiOperation(value = "修改标准规范附件管理")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody List<StandardRuleFileMageUpdatePo> standardRuleFileMageUpdatePo) {
        return standardRuleFileMageService.update(standardRuleFileMageUpdatePo);
    }

    @ApiOperation(value = "批量删除标准规范附件管理")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody StandardRuleFileMageBatDeletePo standardRuleFileMageBatDeletePo) {
        return standardRuleFileMageService.batDelete(standardRuleFileMageBatDeletePo);
    }
}
