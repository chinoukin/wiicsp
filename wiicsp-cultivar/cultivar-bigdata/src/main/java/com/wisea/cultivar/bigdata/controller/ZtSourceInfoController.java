package com.wisea.cultivar.bigdata.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.bigdata.service.ZtSourceInfoService;
import com.wisea.cultivar.common.po.bigdata.ZtSourceInfoBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.ZtSourceInfoGetPo;
import com.wisea.cultivar.common.po.bigdata.ZtSourceInfoPagePo;
import com.wisea.cultivar.common.po.bigdata.ZtSourceInfoUpdatePo;
import com.wisea.cultivar.common.vo.bigdata.ZtSourceInfoGetVo;
import com.wisea.cultivar.common.vo.bigdata.ZtSourceInfoListVo;
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
import java.io.UnsupportedEncodingException;

/**
 * ZtSourceInfoController
 * 在途货源信息 Controller
 * 2019/12/02 11:02:15
 */
@Api(tags = "在途货源信息相关接口")
@RequestMapping(value = "/w/ztSourceInfo")
@RestController
public class ZtSourceInfoController {
    @Autowired
    protected ZtSourceInfoService ztSourceInfoService;

    @ApiOperation(value = "获取在途货源信息分页列表")
    @RequestMapping(value = "findPageList", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<ZtSourceInfoListVo>> findPage(@RequestBody ZtSourceInfoPagePo ztSourceInfoPagePo) {
        return ztSourceInfoService.findPage(ztSourceInfoPagePo);
    }

    @ApiOperation(value = "查询在途货源信息")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<ZtSourceInfoGetVo> get(@RequestBody ZtSourceInfoGetPo ztSourceInfoGetPo) {
        return ztSourceInfoService.get(ztSourceInfoGetPo);
    }


    @ApiOperation(value = "新增/修改在途货源信息")
    @RequestMapping(value = "saveOrUpdate", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> saveOrUpdate(@RequestBody ZtSourceInfoUpdatePo ztSourceInfoUpdatePo) {
        return ztSourceInfoService.saveOrUpdate(ztSourceInfoUpdatePo);
    }

    @ApiOperation(value = "批量删除在途货源信息")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody ZtSourceInfoBatDeletePo ztSourceInfoBatDeletePo) {
        return ztSourceInfoService.batDelete(ztSourceInfoBatDeletePo);
    }

    @ApiOperation(value = "模版下载")
    @RequestMapping(value = "downloadTemplate", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> downloadTemplate(HttpServletResponse response) throws UnsupportedEncodingException {
        return ztSourceInfoService.downloadTemplate(response);
    }

    @ApiOperation(value = "导出在途货源信息列表")
    @RequestMapping(value = "exportExcel", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> exportExcel(@RequestBody ZtSourceInfoPagePo po, HttpServletResponse response) throws UnsupportedEncodingException {
        return ztSourceInfoService.exportExcel(po, response);
    }

    @ApiOperation(value = "导入在途货源信息")
    @RequestMapping(value = "importExcel", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> importExcel(MultipartFile upfile, MultipartHttpServletRequest request) throws UnsupportedEncodingException {
        return ztSourceInfoService.importExcel(upfile, request);
    }
}
