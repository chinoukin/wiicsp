package com.wisea.cultivar.standards.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.standards.po.LinkMageBatDeletePo;
import com.wisea.cultivar.standards.po.LinkMageGetPo;
import com.wisea.cultivar.standards.po.LinkMageInsertPo;
import com.wisea.cultivar.standards.po.LinkMageListPo;
import com.wisea.cultivar.standards.po.LinkMagePagePo;
import com.wisea.cultivar.standards.po.LinkMageUpdatePo;
import com.wisea.cultivar.standards.service.LinkMageService;
import com.wisea.cultivar.standards.vo.LinkMageGetVo;
import com.wisea.cultivar.standards.vo.LinkMageListVo;
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
 * LinkMageController
 * 环节管理 Controller
 * 2020/07/24 11:21:45
 */
@Api(tags = "环节管理相关接口")
@RequestMapping(value = "/w/LinkMage")
@PreAuthorize("hasAuthority('st:lik')")
@RestController
public class LinkMageController {
    @Autowired
    protected LinkMageService linkMageService;

    @ApiOperation(value = "获取环节管理分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<LinkMageListVo>> findPage(@RequestBody LinkMagePagePo linkMagePagePo) {
        return linkMageService.findPage(linkMagePagePo);
    }

    @ApiOperation(value = "获取环节管理列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<LinkMageListVo>> list(@RequestBody LinkMageListPo linkMageListPo) {
        return linkMageService.findList(linkMageListPo);
    }

    @ApiOperation(value = "查询环节管理")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<LinkMageGetVo> get(@RequestBody LinkMageGetPo linkMageGetPo) {
        return linkMageService.get(linkMageGetPo);
    }

    @ApiOperation(value = "新增环节管理")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody LinkMageInsertPo linkMageInsertPo) {
        return linkMageService.insert(linkMageInsertPo);
    }

    @ApiOperation(value = "修改环节管理")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody LinkMageUpdatePo linkMageUpdatePo) {
        return linkMageService.update(linkMageUpdatePo);
    }

    @ApiOperation(value = "批量删除环节管理")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody LinkMageBatDeletePo linkMageBatDeletePo) {
        return linkMageService.batDelete(linkMageBatDeletePo);
    }
}
