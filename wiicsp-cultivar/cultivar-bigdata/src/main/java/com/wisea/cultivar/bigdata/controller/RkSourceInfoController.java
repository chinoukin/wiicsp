package com.wisea.cultivar.bigdata.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.bigdata.service.RkSourceInfoService;
import com.wisea.cultivar.common.po.bigdata.RkSourceInfoBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.RkSourceInfoGetPo;
import com.wisea.cultivar.common.po.bigdata.RkSourceInfoPagePo;
import com.wisea.cultivar.common.po.bigdata.RkSourceInfoUpdatePo;
import com.wisea.cultivar.common.vo.bigdata.RkSourceInfoGetVo;
import com.wisea.cultivar.common.vo.bigdata.RkSourceInfoListVo;
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
 * RkSourceInfoController
 * 入库货源信息 Controller
 * 2019/12/02 11:02:15
 */
@Api(tags = "入库货源信息相关接口")
@RequestMapping(value = "/w/rkSourceInfo")
@RestController
public class RkSourceInfoController {
    @Autowired
    protected RkSourceInfoService rkSourceInfoService;

    @ApiOperation(value = "获取入库货源信息分页列表")
    @RequestMapping(value = "findPageList", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<RkSourceInfoListVo>> findPage(@RequestBody RkSourceInfoPagePo rkSourceInfoPagePo) {
        return rkSourceInfoService.findPage(rkSourceInfoPagePo);
    }

    @ApiOperation(value = "查询入库货源信息")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<RkSourceInfoGetVo> get(@RequestBody RkSourceInfoGetPo rkSourceInfoGetPo) {
        return rkSourceInfoService.get(rkSourceInfoGetPo);
    }

    @ApiOperation(value = "新增/修改入库货源信息")
    @RequestMapping(value = "saveOrUpdate", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> saveOrUpdate(@RequestBody RkSourceInfoUpdatePo rkSourceInfoUpdatePo) {
        return rkSourceInfoService.saveOrUpdate(rkSourceInfoUpdatePo);
    }

    @ApiOperation(value = "批量删除入库货源信息")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody RkSourceInfoBatDeletePo rkSourceInfoBatDeletePo) {
        return rkSourceInfoService.batDelete(rkSourceInfoBatDeletePo);
    }

    @ApiOperation(value = "模版下载")
    @RequestMapping(value = "downloadTemplate", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> downloadTemplate(HttpServletResponse response) throws UnsupportedEncodingException {
        return rkSourceInfoService.downloadTemplate(response);
    }

    @ApiOperation(value = "导出入库货源信息列表")
    @RequestMapping(value = "exportExcel", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> exportExcel(@RequestBody RkSourceInfoPagePo po, HttpServletResponse response) throws UnsupportedEncodingException {
        return rkSourceInfoService.exportExcel(po, response);
    }

    @ApiOperation(value = "导入入库货源信息")
    @RequestMapping(value = "importExcel", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> importExcel(MultipartFile upfile, MultipartHttpServletRequest request) throws UnsupportedEncodingException {
        return rkSourceInfoService.importExcel(upfile, request);
    }
}
