package com.wisea.cultivar.portal.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.portal.po.*;
import com.wisea.cultivar.portal.service.ZhfwZczxCatgMageService;
import com.wisea.cultivar.portal.vo.ZhfwZczxCatgMageGetVo;
import com.wisea.cultivar.portal.vo.ZhfwZczxCatgMageListVo;
import com.wisea.cultivar.portal.vo.ZhfwZczxCatgMageTreeVo;
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
 * ZhfwZczxCatgMageController
 * 种植服务资料分类管理 Controller
 * 2020/08/24 20:28:13
 */
@Api(tags = "种植服务资料分类管理相关接口")
@RequestMapping(value = "/w/ZhfwZczxCatgMage")
@PreAuthorize("hasAnyAuthority('pt:adm','pt:plc')")
@RestController
public class ZhfwZczxCatgMageController {
    @Autowired
    protected ZhfwZczxCatgMageService zhfwZczxCatgMageService;

    @ApiOperation(value = "获取种植服务资料分类管理分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<ZhfwZczxCatgMageListVo>> findPage(@RequestBody ZhfwZczxCatgMagePagePo zhfwZczxCatgMagePagePo) {
        return zhfwZczxCatgMageService.findPage(zhfwZczxCatgMagePagePo);
    }

    @ApiOperation(value = "获取种植服务资料分类管理列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<ZhfwZczxCatgMageListVo>> list(@RequestBody ZhfwZczxCatgMageListPo zhfwZczxCatgMageListPo) {
        return zhfwZczxCatgMageService.findList(zhfwZczxCatgMageListPo);
    }

    @ApiOperation(value = "查询种植服务资料分类管理")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<ZhfwZczxCatgMageGetVo> get(@RequestBody ZhfwZczxCatgMageGetPo zhfwZczxCatgMageGetPo) {
        return zhfwZczxCatgMageService.get(zhfwZczxCatgMageGetPo);
    }

    @ApiOperation(value = "新增种植服务资料分类管理")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody ZhfwZczxCatgMageInsertPo zhfwZczxCatgMageInsertPo) {
        return zhfwZczxCatgMageService.insert(zhfwZczxCatgMageInsertPo);
    }

    @ApiOperation(value = "修改种植服务资料分类管理")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody ZhfwZczxCatgMageUpdatePo zhfwZczxCatgMageUpdatePo) {
        return zhfwZczxCatgMageService.update(zhfwZczxCatgMageUpdatePo);
    }

    @ApiOperation(value = "批量删除种植服务资料分类管理")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody ZhfwZczxCatgMageBatDeletePo zhfwZczxCatgMageBatDeletePo) {
        return zhfwZczxCatgMageService.batDelete(zhfwZczxCatgMageBatDeletePo);
    }
    @ApiOperation(value = "种植服务资料分类管理树形结构数据")
    @RequestMapping(value = "tree", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<ZhfwZczxCatgMageTreeVo>> getTree(@RequestBody ZhfwZczxCatgMageTreePo zhfwZczxCatgMageTreePo) {
        return zhfwZczxCatgMageService.getTree(zhfwZczxCatgMageTreePo);
    }

}
