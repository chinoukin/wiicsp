package com.wisea.cultivar.infomanage.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;

import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.po.*;
import com.wisea.cultivar.common.vo.SearchTagsMageGetVo;
import com.wisea.cultivar.common.vo.SearchTagsMageListVo;
import com.wisea.cultivar.infomanage.service.SearchTagsMageService;
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
 * SearchTagsMageController
 * 搜索标签设置 Controller
 * 2020/08/04 09:36:59
 */
@Api(tags = "搜索标签设置相关接口")
@RequestMapping(value = "/w/SearchTagsMage")
@PreAuthorize("hasAuthority('im:set')")
@RestController
public class SearchTagsMageController {
    @Autowired
    protected SearchTagsMageService searchTagsMageService;

    @ApiOperation(value = "获取搜索标签设置分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<SearchTagsMageListVo>> findPage(@RequestBody SearchTagsMagePagePo searchTagsMagePagePo) {
        return searchTagsMageService.findPage(searchTagsMagePagePo);
    }

    @ApiOperation(value = "获取搜索标签设置列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<SearchTagsMageListVo>> list(@RequestBody SearchTagsMageListPo searchTagsMageListPo) {
        return searchTagsMageService.findList(searchTagsMageListPo);
    }

    @ApiOperation(value = "查询搜索标签设置")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<SearchTagsMageGetVo> get(@RequestBody SearchTagsMageGetPo searchTagsMageGetPo) {
        return searchTagsMageService.get(searchTagsMageGetPo);
    }

    @ApiOperation(value = "新增搜索标签设置")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody SearchTagsMageInsertPo searchTagsMageInsertPo) {
        return searchTagsMageService.insert(searchTagsMageInsertPo);
    }

    @ApiOperation(value = "修改搜索标签设置")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody SearchTagsMageUpdatePo searchTagsMageUpdatePo) {
        return searchTagsMageService.update(searchTagsMageUpdatePo);
    }

    @ApiOperation(value = "批量删除搜索标签设置")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody SearchTagsMageBatDeletePo searchTagsMageBatDeletePo) {
        return searchTagsMageService.batDelete(searchTagsMageBatDeletePo);
    }
}
