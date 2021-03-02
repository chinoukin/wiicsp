package com.wisea.cultivar.bigdata.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.bigdata.service.ZdInfoMageService;
import com.wisea.cultivar.common.po.bigdata.UpdJyKtJy;
import com.wisea.cultivar.common.po.bigdata.ZdInfoMageGetPo;
import com.wisea.cultivar.common.po.bigdata.ZdInfoMageInsertPo;
import com.wisea.cultivar.common.po.bigdata.ZdInfoMageListPo;
import com.wisea.cultivar.common.po.bigdata.ZdInfoMagePagePo;
import com.wisea.cultivar.common.po.bigdata.ZdInfoMageUpdatePo;
import com.wisea.cultivar.common.vo.bigdata.ZdInfoMageGetVo;
import com.wisea.cultivar.common.vo.bigdata.ZdInfoMageListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * ZdInfoMageController
 * 站点信息管理 Controller
 * 2019/12/02 11:02:15
 */
@Api(tags = "站点信息管理相关接口")
@RequestMapping(value = "/w/ZdInfoMage/")
@RestController
public class ZdInfoMageController {
    @Autowired
    protected ZdInfoMageService zdInfoMageService;

    @ApiOperation(value = "获取站点信息管理分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<ZdInfoMageListVo>> findPage(@RequestBody ZdInfoMagePagePo zdInfoMagePagePo) {
        return zdInfoMageService.findPage(zdInfoMagePagePo);
    }

    @ApiOperation(value = "获取站点信息管理列表（前端展示用）")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<ZdInfoMageListVo>> list(@RequestBody ZdInfoMageListPo zdInfoMageListPo) {
        return zdInfoMageService.findList(zdInfoMageListPo);
    }

    @ApiOperation(value = "导出列表")
    @RequestMapping(value = "exportZdList", method = RequestMethod.POST)
    public ResultPoJo<Object> exportZdList(@RequestBody ZdInfoMagePagePo zdInfoMagePagePo, HttpServletResponse response)  throws IOException  {
        return zdInfoMageService.exportZdList(zdInfoMagePagePo, response);
    }

    @ApiOperation(value = "查询站点信息管理")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<ZdInfoMageGetVo> get(@RequestBody ZdInfoMageGetPo zdInfoMageGetPo) {
        return zdInfoMageService.get(zdInfoMageGetPo);
    }

    @ApiOperation(value = "新增站点信息管理")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody ZdInfoMageInsertPo zdInfoMageInsertPo) {
        return zdInfoMageService.insert(zdInfoMageInsertPo);
    }

    @ApiOperation(value = "修改站点信息管理")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody ZdInfoMageUpdatePo zdInfoMageUpdatePo) {
        return zdInfoMageService.update(zdInfoMageUpdatePo);
    }

    @ApiOperation(value = "删除、开通、禁用采购商名录管理")
    @RequestMapping(value = "updState", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> updState(@RequestBody UpdJyKtJy po) {
        return zdInfoMageService.updState(po);
    }

    @ApiOperation(value = "模版下载")
    @RequestMapping(value = "downloadTemplate", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> downloadTemplate(HttpServletResponse response) throws UnsupportedEncodingException {
        return zdInfoMageService.downloadTemplate(response);
    }

    @ApiOperation(value = "导入站点信息")
    @RequestMapping(value = "importExcel", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> importExcel(@RequestParam Long cgsId, MultipartFile upfile, MultipartHttpServletRequest request) throws UnsupportedEncodingException {
        return zdInfoMageService.importExcel(cgsId, upfile, request);
    }
}
