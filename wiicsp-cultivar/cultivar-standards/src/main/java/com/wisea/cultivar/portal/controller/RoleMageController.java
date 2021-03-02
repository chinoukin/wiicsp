package com.wisea.cultivar.portal.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.portal.po.RoleMageBatDeletePo;
import com.wisea.cultivar.portal.po.RoleMageGetPo;
import com.wisea.cultivar.portal.po.RoleMageInsertPo;
import com.wisea.cultivar.portal.po.RoleMageListPo;
import com.wisea.cultivar.portal.po.RoleMagePagePo;
import com.wisea.cultivar.portal.po.RoleMageUpdatePo;
import com.wisea.cultivar.portal.service.RoleMageService;
import com.wisea.cultivar.portal.vo.RoleMageGetVo;
import com.wisea.cultivar.portal.vo.RoleMageListVo;
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
 * RoleMageController
 * 角色管理 Controller
 * 2020/08/24 20:28:13
 */
@Api(tags = "角色管理相关接口")
@RequestMapping(value = "/w/RoleMage")
@PreAuthorize("hasAnyAuthority('pt:rlm')")
@RestController
public class RoleMageController {
    @Autowired
    protected RoleMageService roleMageService;

    @ApiOperation(value = "获取角色管理分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<RoleMageListVo>> findPage(@RequestBody RoleMagePagePo roleMagePagePo) {
        return roleMageService.findPage(roleMagePagePo);
    }

    @ApiOperation(value = "获取角色管理列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<RoleMageListVo>> list(@RequestBody RoleMageListPo roleMageListPo) {
        return roleMageService.findList(roleMageListPo);
    }

    @ApiOperation(value = "查询角色管理")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<RoleMageGetVo> get(@RequestBody RoleMageGetPo roleMageGetPo) {
        return roleMageService.get(roleMageGetPo);
    }

    @ApiOperation(value = "新增角色管理")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody RoleMageInsertPo roleMageInsertPo) {
        return roleMageService.insert(roleMageInsertPo);
    }

    @ApiOperation(value = "修改角色管理")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody RoleMageUpdatePo roleMageUpdatePo) {
        return roleMageService.update(roleMageUpdatePo);
    }

    @ApiOperation(value = "批量删除角色管理")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody RoleMageBatDeletePo roleMageBatDeletePo) {
        return roleMageService.batDelete(roleMageBatDeletePo);
    }

    @ApiOperation(value = "查询角色菜单树")
    @RequestMapping(value = "tree", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> tree(@RequestBody String sysUserId) {
        return roleMageService.tree(Long.valueOf(sysUserId));
    }
}
