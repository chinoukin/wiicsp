package com.wisea.cultivar.standards.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.standards.po.*;
import com.wisea.cultivar.standards.service.ChinaStandardTypeMageService;
import com.wisea.cultivar.standards.vo.ChinaStandardTypeMageGetVo;
import com.wisea.cultivar.standards.vo.ChinaStandardTypeMageListVo;
import com.wisea.cultivar.standards.vo.ChinaStandardTypeMageTreeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ChinaStandardTypeMageController
 * 中标分类管理 Controller
 * 2020/07/24 11:21:45
 */
@Api(tags = "中标分类管理相关接口")
@RequestMapping(value = "/w/ChinaStandardTypeMage")
@PreAuthorize("hasAuthority('st:stc')")
@RestController
public class ChinaStandardTypeMageController {
    @Autowired
    protected ChinaStandardTypeMageService chinaStandardTypeMageService;

    @ApiOperation(value = "获取中标分类管理分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<ChinaStandardTypeMageListVo>> findPage(@RequestBody ChinaStandardTypeMagePagePo chinaStandardTypeMagePagePo) {
        return chinaStandardTypeMageService.findPage(chinaStandardTypeMagePagePo);
    }

    @ApiOperation(value = "获取中标分类管理列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<ChinaStandardTypeMageListVo>> list(@RequestBody ChinaStandardTypeMageListPo chinaStandardTypeMageListPo) {
        return chinaStandardTypeMageService.findList(chinaStandardTypeMageListPo);
    }

    @ApiOperation(value = "查询中标分类管理")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<ChinaStandardTypeMageGetVo> get(@RequestBody ChinaStandardTypeMageGetPo chinaStandardTypeMageGetPo) {
        return chinaStandardTypeMageService.get(chinaStandardTypeMageGetPo);
    }

    @ApiOperation(value = "新增中标分类管理")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody ChinaStandardTypeMageInsertPo chinaStandardTypeMageInsertPo) {
        return chinaStandardTypeMageService.insert(chinaStandardTypeMageInsertPo);
    }

    @ApiOperation(value = "修改中标分类管理")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody ChinaStandardTypeMageUpdatePo chinaStandardTypeMageUpdatePo) {
        return chinaStandardTypeMageService.update(chinaStandardTypeMageUpdatePo);
    }

    @ApiOperation(value = "批量删除中标分类管理")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody ChinaStandardTypeMageBatDeletePo chinaStandardTypeMageBatDeletePo) {
        return chinaStandardTypeMageService.oneDelete(chinaStandardTypeMageBatDeletePo);
    }
    @ApiOperation(value = "树形结构数据")
    @RequestMapping(value = "getTreeVue",method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<ChinaStandardTypeMageTreeVo>> ChinaStandardTypeMageGetTree(@RequestBody ChinaStandardTypeMageTreePo chinaStandardTypeMageTreePo){
        ResultPoJo<List<ChinaStandardTypeMageTreeVo>> resultPoJo = new ResultPoJo<List<ChinaStandardTypeMageTreeVo>>();
        List<ChinaStandardTypeMageTreeVo> chinaStandardTypeMageTreeVos = chinaStandardTypeMageService.ChinaStandardTypeMageGetTree(chinaStandardTypeMageTreePo);
        resultPoJo.setResult(chinaStandardTypeMageTreeVos);
        return resultPoJo;
    }

    @ApiOperation(value = "异步加载中标分类")
    @RequestMapping(value = "asyTreeVue",method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<ChinaStandardTypeMageTreeVo>> asyTreeVue(@RequestBody ChinaStandardTypeMageTreeVo chinaStandardTypeMageTreeVo){
        ResultPoJo<List<ChinaStandardTypeMageTreeVo>> resultPoJo = new ResultPoJo<List<ChinaStandardTypeMageTreeVo>>();
        List<ChinaStandardTypeMageTreeVo> chinaStandardTypeMageTreeVos = chinaStandardTypeMageService.asyTreeVue(chinaStandardTypeMageTreeVo);
        resultPoJo.setResult(chinaStandardTypeMageTreeVos);
        return resultPoJo;
    }
    @ApiOperation(value = "异步加载中标分类返回上一级")
    @RequestMapping(value = "asyTreeVuePS",method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<ChinaStandardTypeMageTreeVo>> asyTreeVuePS(@RequestBody ChinaStandardTypeMageTreeVo chinaStandardTypeMageTreeVo){
        ResultPoJo<List<ChinaStandardTypeMageTreeVo>> resultPoJo = new ResultPoJo<List<ChinaStandardTypeMageTreeVo>>();
        List<ChinaStandardTypeMageTreeVo> chinaStandardTypeMageTreeVos = chinaStandardTypeMageService.asyTreeVuePS(chinaStandardTypeMageTreeVo);
        resultPoJo.setResult(chinaStandardTypeMageTreeVos);
        return resultPoJo;
    }
}
