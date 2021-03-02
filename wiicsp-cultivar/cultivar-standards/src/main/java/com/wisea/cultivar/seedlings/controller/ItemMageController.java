package com.wisea.cultivar.seedlings.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.DateUtils;
import com.wisea.cloud.common.util.OffsetDateTimeUtils;
import com.wisea.cloud.common.util.excel.ExportExcel;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.seedlings.po.*;
import com.wisea.cultivar.seedlings.service.ItemMageService;
import com.wisea.cultivar.seedlings.vo.ItemMageExportVo;
import com.wisea.cultivar.seedlings.vo.ItemMageGetVo;
import com.wisea.cultivar.seedlings.vo.ItemMageListVo;
import com.wisea.cultivar.seedlings.vo.ItemSisyAppExportVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * ItemMageController
 * 项目管理 Controller
 * 2020/08/06 14:19:24
 */
@Api(tags = "项目管理相关接口")
@RequestMapping(value = "/w/ItemMage")
@RestController
@PreAuthorize("hasAnyAuthority('se:cgp','se:asd')")
public class ItemMageController {

    private static Logger logger = LoggerFactory.getLogger(ItemMageController.class);
    @Autowired
    protected ItemMageService itemMageService;

    @ApiOperation(value = "获取项目管理分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<ItemMageListVo>> findPage(@RequestBody ItemMagePagePo itemMagePagePo) {
        return itemMageService.findPage(itemMagePagePo);
    }

    @ApiOperation(value = "获取项目管理列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<ItemMageListVo>> list(@RequestBody ItemMageListPo itemMageListPo) {
        return itemMageService.findList(itemMageListPo);
    }

    @ApiOperation(value = "【项目管理】-获取补贴申请管理分页列表")
    @RequestMapping(value = "findSubsidyPage", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<ItemMageListVo>> findSubsidyPage(@RequestBody ItemMagePagePo itemMagePagePo) {
        return itemMageService.findSubsidyPage(itemMagePagePo);
    }

    @ApiOperation(value = "【项目管理】-获取补贴申请管理列表")
    @RequestMapping(value = "subsidyList", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<ItemMageListVo>> subsidyList(@RequestBody ItemMageListPo itemMageListPo) {
        return itemMageService.subsidyList(itemMageListPo);
    }


    @ApiOperation(value = "查询项目管理")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<ItemMageGetVo> get(@RequestBody ItemMageGetPo itemMageGetPo) {
        return itemMageService.get(itemMageGetPo);
    }

    @ApiOperation(value = "新增项目管理")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody ItemMageInsertPo itemMageInsertPo) {
        return itemMageService.insert(itemMageInsertPo);
    }

    @ApiOperation(value = "修改项目管理")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody ItemMageUpdatePo itemMageUpdatePo) {
        return itemMageService.update(itemMageUpdatePo);
    }

    @ApiOperation(value = "批量删除项目管理")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody ItemMageBatDeletePo itemMageBatDeletePo) {
        return itemMageService.batDelete(itemMageBatDeletePo);
    }
    @ApiOperation(value = "批量结束项目管理")
    @RequestMapping(value = "itemMageOver", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> itemMageOver(@RequestBody ItemMageOverPo itemMageOverPo) {
        return itemMageService.itemMageOver(itemMageOverPo);
    }

    @ApiOperation(value = "导出项目管理信息")
    @RequestMapping(value = "excelExport", method = RequestMethod.POST)
    @DataCheck
    public void excelExport(@RequestBody ItemMageListPo itemMageListPo, HttpServletResponse response) {
        ResultPoJo<List<ItemMageListVo>> excelExportList = null;
        excelExportList = itemMageService.findList(itemMageListPo);
        try {
            String fileName = "项目管理信息"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            new ExportExcel("项目管理列表信息", ItemMageExportVo.class).setDataList(excelExportList.getResult()).writeWithAjaxHeader(response, fileName).dispose();
        } catch (IOException e) {
            throw new RuntimeException("Excel导出失败："+e.getMessage(), e);
        }
    }

    @ApiOperation(value = "【项目管理】-导出申请补贴管理信息")
    @RequestMapping(value = "excelSidyExport", method = RequestMethod.POST)
    @DataCheck
    public void excelSidyExport(@RequestBody ItemMageListPo itemMageListPo, HttpServletResponse response) {
        ResultPoJo<List<ItemMageListVo>> excelExportList = null;
        excelExportList = itemMageService.subsidyList(itemMageListPo);
        String fileName = "补贴申请管理信息"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
        try {
            new ExportExcel("补贴申请管理列表信息", ItemSisyAppExportVo.class).setDataList(excelExportList.getResult()).writeWithAjaxHeader(response, fileName).dispose();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ApiOperation(value = "【项目管理】-定时结束项目")
    @RequestMapping(value = "checkItemStateType", method = RequestMethod.POST)
    @Scheduled(cron = "0 0 0 * * ?") // 0 0 0 * * ？ 凌晨执行
    public void checkItemStateType() {
            logger.info("每分钟检查项目状态定时任务");
            OffsetDateTime startDate = OffsetDateTimeUtils.getDateNow();
            logger.info("checkItemStateType 开始时间{}", startDate);
            boolean flag = false;
            try {
                itemMageService.checkItemStateType();
                OffsetDateTime endDate = OffsetDateTimeUtils.getDateNow();
                logger.info("checkItemStateType 结束时间{}", endDate);
                flag = true;
            }catch (Exception e) {
                flag = false;
                e.printStackTrace();
                logger.error("checkItemStateType，异常:{}", e.getMessage());
            } finally {
                logger.info("checkItemStateType检测结束,用时:" + (OffsetDateTimeUtils.getDateNow().getMinute() - startDate.getMinute()) + ",运行结果：" + flag);
            }
    }
}
