package com.wisea.cultivar.standards.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.standards.po.*;
import com.wisea.cultivar.standards.service.StandardTypeMageService;
import com.wisea.cultivar.standards.vo.StandardTypeMageGetVo;
import com.wisea.cultivar.standards.vo.StandardTypeMageListVo;
import com.wisea.cultivar.standards.vo.StandardTypeMageTreeVo;
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
 * StandardTypeMageController
 * 标准类型管理 Controller
 * 2020/07/24 11:21:45
 */
@Api(tags = "标准类型管理相关接口")
@RequestMapping(value = "/w/StandardTypeMage")
@PreAuthorize("hasAuthority('st:sdt')")
@RestController
public class StandardTypeMageController {
    @Autowired
    protected StandardTypeMageService standardTypeMageService;

    @ApiOperation(value = "获取标准类型管理分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<StandardTypeMageListVo>> findPage(@RequestBody StandardTypeMagePagePo standardTypeMagePagePo) {
        return standardTypeMageService.findPage(standardTypeMagePagePo);
    }

    @ApiOperation(value = "获取标准类型管理列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<StandardTypeMageListVo>> list(@RequestBody StandardTypeMageListPo standardTypeMageListPo) {
        return standardTypeMageService.findList(standardTypeMageListPo);
    }

    @ApiOperation(value = "查询标准类型管理")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<StandardTypeMageGetVo> get(@RequestBody StandardTypeMageGetPo standardTypeMageGetPo) {
        return standardTypeMageService.get(standardTypeMageGetPo);
    }

    @ApiOperation(value = "新增标准类型管理")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody StandardTypeMageInsertPo standardTypeMageInsertPo) {
        return standardTypeMageService.insert(standardTypeMageInsertPo);
    }

    @ApiOperation(value = "修改标准类型管理")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody StandardTypeMageUpdatePo standardTypeMageUpdatePo) {
        return standardTypeMageService.update(standardTypeMageUpdatePo);
    }

    @ApiOperation(value = "批量删除标准类型管理")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody StandardTypeMageBatDeletePo standardTypeMageBatDeletePo) {
        return standardTypeMageService.batDelete(standardTypeMageBatDeletePo);
    }

    @ApiOperation(value = "树形结构数据")
    @RequestMapping(value = "getTreeVue",method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<StandardTypeMageTreeVo>> standardTypeMageGetTree(@RequestBody StandardTypeMageTreePo standardTypeMageTreePo){
        return standardTypeMageService.standardTypeMageGetTree(standardTypeMageTreePo);
    }
}
