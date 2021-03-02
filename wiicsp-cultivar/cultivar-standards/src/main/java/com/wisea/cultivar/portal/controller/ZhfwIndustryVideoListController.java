package com.wisea.cultivar.portal.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.portal.po.ZhfwIndustryVideoListBatDeletePo;
import com.wisea.cultivar.portal.po.ZhfwIndustryVideoListGetPo;
import com.wisea.cultivar.portal.po.ZhfwIndustryVideoListInsertPo;
import com.wisea.cultivar.portal.po.ZhfwIndustryVideoListListPo;
import com.wisea.cultivar.portal.po.ZhfwIndustryVideoListPagePo;
import com.wisea.cultivar.portal.po.ZhfwIndustryVideoListUpdatePo;
import com.wisea.cultivar.portal.service.ZhfwIndustryVideoListService;
import com.wisea.cultivar.portal.vo.ZhfwIndustryVideoListGetVo;
import com.wisea.cultivar.portal.vo.ZhfwIndustryVideoListListVo;
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
 * ZhfwIndustryVideoListController
 * 种植服务产业视频列表 Controller
 * 2020/08/24 20:28:13
 */
@Api(tags = "种植服务产业视频列表相关接口")
@RequestMapping(value = "/w/ZhfwIndustryVideoList")
@PreAuthorize("hasAuthority('pt:plc')")
@RestController
public class ZhfwIndustryVideoListController {
    @Autowired
    protected ZhfwIndustryVideoListService zhfwIndustryVideoListService;

    @ApiOperation(value = "获取种植服务产业视频列表分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<ZhfwIndustryVideoListListVo>> findPage(@RequestBody ZhfwIndustryVideoListPagePo zhfwIndustryVideoListPagePo) {
        return zhfwIndustryVideoListService.findPage(zhfwIndustryVideoListPagePo);
    }

    @ApiOperation(value = "获取种植服务产业视频列表列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<ZhfwIndustryVideoListListVo>> list(@RequestBody ZhfwIndustryVideoListListPo zhfwIndustryVideoListListPo) {
        return zhfwIndustryVideoListService.findList(zhfwIndustryVideoListListPo);
    }

    @ApiOperation(value = "查询种植服务产业视频列表")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<ZhfwIndustryVideoListGetVo> get(@RequestBody ZhfwIndustryVideoListGetPo zhfwIndustryVideoListGetPo) {
        return zhfwIndustryVideoListService.get(zhfwIndustryVideoListGetPo);
    }

    @ApiOperation(value = "新增种植服务产业视频列表")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody ZhfwIndustryVideoListInsertPo zhfwIndustryVideoListInsertPo) {
        return zhfwIndustryVideoListService.insert(zhfwIndustryVideoListInsertPo);
    }

    @ApiOperation(value = "修改种植服务产业视频列表")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody ZhfwIndustryVideoListUpdatePo zhfwIndustryVideoListUpdatePo) {
        return zhfwIndustryVideoListService.update(zhfwIndustryVideoListUpdatePo);
    }

    @ApiOperation(value = "批量删除种植服务产业视频列表")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody ZhfwIndustryVideoListBatDeletePo zhfwIndustryVideoListBatDeletePo) {
        return zhfwIndustryVideoListService.batDelete(zhfwIndustryVideoListBatDeletePo);
    }
}
