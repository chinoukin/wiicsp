package com.wisea.cultivar.seedlings.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.DateUtils;
import com.wisea.cloud.common.util.excel.ExportExcel;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.seedlings.po.*;
import com.wisea.cultivar.seedlings.service.SubsidyApplMageService;
import com.wisea.cultivar.seedlings.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * SubsidyApplMageController
 * 补贴申请管理 Controller
 * 2020/08/06 14:19:24
 */
@Api(tags = "补贴申请管理相关接口")
@RequestMapping(value = "/w/SubsidyApplMage")
@RestController
@PreAuthorize("hasAnyAuthority('se:asd')")
public class SubsidyApplMageController {
    @Autowired
    protected SubsidyApplMageService subsidyApplMageService;

    @ApiOperation(value = "获取补贴申请管理分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<SubsidyApplMageListVo>> findPage(@RequestBody SubsidyApplMagePagePo subsidyApplMagePagePo) {
        return subsidyApplMageService.findPage(subsidyApplMagePagePo);
    }

    @ApiOperation(value = "获取补贴申请管理列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<SubsidyApplMageListVo>> list(@RequestBody SubsidyApplMageListPo subsidyApplMageListPo) {
        return subsidyApplMageService.findList(subsidyApplMageListPo);
    }

    @ApiOperation(value = "查询补贴申请管理")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<SubsidyApplMageGetVo> get(@RequestBody SubsidyApplMageGetPo subsidyApplMageGetPo) {
        return subsidyApplMageService.get(subsidyApplMageGetPo);
    }

    @ApiOperation(value = "新增补贴申请管理")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody SubsidyApplMageInsertPo subsidyApplMageInsertPo) {
        return subsidyApplMageService.insert(subsidyApplMageInsertPo);
    }

    @ApiOperation(value = "修改补贴申请管理")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody SubsidyApplMageUpdatePo subsidyApplMageUpdatePo) {
        return subsidyApplMageService.update(subsidyApplMageUpdatePo);
    }

    @ApiOperation(value = "批量删除补贴申请管理")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody SubsidyApplMageBatDeletePo subsidyApplMageBatDeletePo) {
        return subsidyApplMageService.batDelete(subsidyApplMageBatDeletePo);
    }

    @ApiOperation(value = "批量审核/批量标记为已拨付")
    @RequestMapping(value = "batchEdit", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batchEdit(@RequestBody SubsidyApplMageBatDeletePo subsidyApplMageBatDeletePo) {
        return subsidyApplMageService.batchEdit(subsidyApplMageBatDeletePo);
    }

    @ApiOperation(value = "导出补贴申请详情管理列表")
    @RequestMapping(value = "excelExport", method = RequestMethod.POST)
    @DataCheck
    public void excelExport(@RequestBody SubsidyApplMageListPo listPo, HttpServletResponse response) {
        ResultPoJo<List<SubsidyApplMageListVo>> excelExportList = null;
        excelExportList = subsidyApplMageService.findList(listPo);
        String fileName = "补贴申请详情管理信息"+ DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
        try {
            new ExportExcel("补贴申请详情管理列表信息", SubsidyApplMageExportVo.class).setDataList(excelExportList.getResult()).writeWithAjaxHeader(response, fileName).dispose();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @ApiOperation(value = "种苗补助情况")
    @RequestMapping(value = "getAllowances", method = RequestMethod.POST)
    public ResultPoJo<SubsidyApplCountVo> getAllowances() {
        return subsidyApplMageService.getAllowances();
    }

}
