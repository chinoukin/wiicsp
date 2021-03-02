package com.wisea.cultivar.portal.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.portal.po.*;
import com.wisea.cultivar.portal.service.UserMageService;
import com.wisea.cultivar.portal.vo.UserMageGetVo;
import com.wisea.cultivar.portal.vo.UserMageListVo;
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
 * UserMageController
 * 成员管理 Controller
 * 2020/08/24 20:28:13
 */
@Api(tags = "成员管理相关接口")
@RequestMapping(value = "/w/UserMage")
@PreAuthorize("hasAnyAuthority('pt:urm','sys:org')")
@RestController
public class UserMageController {
    @Autowired
    protected UserMageService userMageService;

    @ApiOperation(value = "获取成员管理分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<UserMageListVo>> findPage(@RequestBody UserMagePagePo userMagePagePo) {
        return userMageService.findPage(userMagePagePo);
    }

    @ApiOperation(value = "获取成员管理列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<UserMageListVo>> list(@RequestBody UserMageListPo userMageListPo) {
        return userMageService.findList(userMageListPo);
    }

    @ApiOperation(value = "查询成员管理")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<UserMageGetVo> get(@RequestBody UserMageGetPo userMageGetPo) {
        return userMageService.get(userMageGetPo);
    }

    @ApiOperation(value = "新增成员管理")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody UserMageInsertPo userMageInsertPo) {
        return userMageService.insert(userMageInsertPo);
    }

    @ApiOperation(value = "修改成员管理")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody UserMageUpdatePo userMageUpdatePo) {
        return userMageService.update(userMageUpdatePo);
    }

    @ApiOperation(value = "批量删除成员管理")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody UserMageBatDeletePo userMageBatDeletePo) {
        return userMageService.batDelete(userMageBatDeletePo);
    }

    @ApiOperation(value = "账号状态")
    @RequestMapping(value = "status", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> status(@RequestBody UserMageActiveFlagPo po) {
        return userMageService.status(po);
    }
}
