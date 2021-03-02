package com.wisea.cultivar.bigdata.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.po.bigdata.CgsNameMageGetPo;
import com.wisea.cultivar.common.po.bigdata.CgsNameMageInsertPo;
import com.wisea.cultivar.common.po.bigdata.CgsNameMagePagePo;
import com.wisea.cultivar.common.po.bigdata.CgsNameMageUpdatePo;
import com.wisea.cultivar.common.po.bigdata.UpdJyKtJy;
import com.wisea.cultivar.bigdata.service.CgsNameMageService;
import com.wisea.cultivar.common.vo.bigdata.CgsNameMageGetVo;
import com.wisea.cultivar.common.vo.bigdata.CgsNameMageListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * CgsNameMageController
 * 采购商名录管理 Controller
 * 2019/12/02 11:02:14
 * @author yangtao
 */
@Api(tags = "采购商名录管理相关接口")
@RequestMapping(value = "/w/cgs/")
@RestController
public class CgsNameMageController {
    @Autowired
    protected CgsNameMageService cgsNameMageService;

    @ApiOperation(value = "获取采购商名录管理分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<CgsNameMageListVo>> findPage(@RequestBody CgsNameMagePagePo cgsNameMagePagePo) {
        return cgsNameMageService.findPage(cgsNameMagePagePo);
    }

    @ApiOperation(value = "获取采购商名录管理列表")
    @RequestMapping(value = "findList", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<CgsNameMageListVo>> findList(@RequestBody CgsNameMagePagePo cgsNameMagePagePo) {
        return cgsNameMageService.findList(cgsNameMagePagePo);
    }

    @ApiOperation(value = "导出列表")
    @RequestMapping(value = "exportCgsList", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> exportCgsList(@RequestBody CgsNameMagePagePo po, HttpServletResponse response)  throws IOException {
        return cgsNameMageService.exportCgsList(po, response);
    }

    @ApiOperation(value = "查询采购商名录管理")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<CgsNameMageGetVo> get(@RequestBody CgsNameMageGetPo cgsNameMageGetPo) {
        return cgsNameMageService.get(cgsNameMageGetPo);
    }

    @ApiOperation(value = "新增采购商名录管理")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody CgsNameMageInsertPo cgsNameMageInsertPo) {
        return cgsNameMageService.insert(cgsNameMageInsertPo);
    }

    @ApiOperation(value = "修改采购商名录管理")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody CgsNameMageUpdatePo cgsNameMageUpdatePo) {
        return cgsNameMageService.update(cgsNameMageUpdatePo);
    }

    @ApiOperation(value = "删除、开通、禁用采购商名录管理")
    @RequestMapping(value = "updState", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> updState(@RequestBody UpdJyKtJy po) {
        return cgsNameMageService.updState(po);
    }

    @ApiOperation(value = "模版下载")
    @RequestMapping(value = "downloadTemplate", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> downloadTemplate(HttpServletResponse response) throws UnsupportedEncodingException {
        return cgsNameMageService.downloadTemplate(response);
    }

    @ApiOperation(value = "导入采购商名录")
    @RequestMapping(value = "importExcel", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> importExcel(MultipartFile upfile, MultipartHttpServletRequest request) throws UnsupportedEncodingException {
        return cgsNameMageService.importExcel(upfile, request);
    }
}
