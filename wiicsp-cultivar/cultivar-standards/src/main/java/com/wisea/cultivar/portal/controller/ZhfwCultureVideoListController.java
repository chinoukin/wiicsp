package com.wisea.cultivar.portal.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.portal.po.ZhfwCultureVideoListBatDeletePo;
import com.wisea.cultivar.portal.po.ZhfwCultureVideoListGetPo;
import com.wisea.cultivar.portal.po.ZhfwCultureVideoListInsertPo;
import com.wisea.cultivar.portal.po.ZhfwCultureVideoListListPo;
import com.wisea.cultivar.portal.po.ZhfwCultureVideoListPagePo;
import com.wisea.cultivar.portal.po.ZhfwCultureVideoListUpdatePo;
import com.wisea.cultivar.portal.service.ZhfwCultureVideoListService;
import com.wisea.cultivar.portal.vo.ZhfwCultureVideoListGetVo;
import com.wisea.cultivar.portal.vo.ZhfwCultureVideoListListVo;
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
 * ZhfwCultureVideoListController
 * 种植服文化视频列表 Controller
 * 2020/08/24 20:28:13
 */
@Api(tags = "种植服文化视频列表相关接口")
@RequestMapping(value = "/w/ZhfwCultureVideoList")
@RestController
@PreAuthorize("hasAuthority('pt:clv')")
public class ZhfwCultureVideoListController {
    @Autowired
    protected ZhfwCultureVideoListService zhfwCultureVideoListService;

    @ApiOperation(value = "获取种植服文化视频列表分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<ZhfwCultureVideoListListVo>> findPage(@RequestBody ZhfwCultureVideoListPagePo zhfwCultureVideoListPagePo) {
        return zhfwCultureVideoListService.findPage(zhfwCultureVideoListPagePo);
    }

    @ApiOperation(value = "获取种植服文化视频列表列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<ZhfwCultureVideoListListVo>> list(@RequestBody ZhfwCultureVideoListListPo zhfwCultureVideoListListPo) {
        return zhfwCultureVideoListService.findList(zhfwCultureVideoListListPo);
    }

    @ApiOperation(value = "查询种植服文化视频列表")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<ZhfwCultureVideoListGetVo> get(@RequestBody ZhfwCultureVideoListGetPo zhfwCultureVideoListGetPo) {
        return zhfwCultureVideoListService.get(zhfwCultureVideoListGetPo);
    }

    @ApiOperation(value = "新增种植服文化视频列表")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody ZhfwCultureVideoListInsertPo zhfwCultureVideoListInsertPo) {
        return zhfwCultureVideoListService.insert(zhfwCultureVideoListInsertPo);
    }

    @ApiOperation(value = "修改种植服文化视频列表")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody ZhfwCultureVideoListUpdatePo zhfwCultureVideoListUpdatePo) {
        return zhfwCultureVideoListService.update(zhfwCultureVideoListUpdatePo);
    }

    @ApiOperation(value = "批量删除种植服文化视频列表")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody ZhfwCultureVideoListBatDeletePo zhfwCultureVideoListBatDeletePo) {
        return zhfwCultureVideoListService.batDelete(zhfwCultureVideoListBatDeletePo);
    }
}
