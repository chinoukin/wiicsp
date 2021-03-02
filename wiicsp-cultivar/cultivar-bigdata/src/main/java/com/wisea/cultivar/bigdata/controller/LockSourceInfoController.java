package com.wisea.cultivar.bigdata.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.po.bigdata.LockSourceInfoBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.LockSourceInfoGetPo;
import com.wisea.cultivar.common.po.bigdata.LockSourceInfoPagePo;
import com.wisea.cultivar.common.po.bigdata.LockSourceInfoUpdatePo;
import com.wisea.cultivar.bigdata.service.LockSourceInfoService;
import com.wisea.cultivar.common.vo.bigdata.LockSourceInfoGetVo;
import com.wisea.cultivar.common.vo.bigdata.LockSourceInfoListVo;
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
 * LockSourceInfoController
 * 锁定货源信息 Controller
 * 2019/12/02 11:02:14
 */
@Api(tags = "锁定货源信息相关接口")
@RequestMapping(value = "/w/lockSourceInfo")
@RestController
public class LockSourceInfoController {
    @Autowired
    protected LockSourceInfoService lockSourceInfoService;

    @ApiOperation(value = "获取锁定货源信息分页列表")
    @RequestMapping(value = "findPageList", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<LockSourceInfoListVo>> findPage(@RequestBody LockSourceInfoPagePo lockSourceInfoPagePo) {
        return lockSourceInfoService.findPage(lockSourceInfoPagePo);
    }

    @ApiOperation(value = "查询锁定货源信息")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<LockSourceInfoGetVo> get(@RequestBody LockSourceInfoGetPo lockSourceInfoGetPo) {
        return lockSourceInfoService.get(lockSourceInfoGetPo);
    }

    @ApiOperation(value = "新增/修改锁定货源信息")
    @RequestMapping(value = "saveOrUpdate", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> saveOrUpdate(@RequestBody LockSourceInfoUpdatePo po) {
        return lockSourceInfoService.saveOrUpdate(po);
    }

    @ApiOperation(value = "批量删除锁定货源信息")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody LockSourceInfoBatDeletePo lockSourceInfoBatDeletePo) {
        return lockSourceInfoService.batDelete(lockSourceInfoBatDeletePo);
    }

    @ApiOperation(value = "模版下载")
    @RequestMapping(value = "downloadTemplate", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> downloadTemplate(HttpServletResponse response) throws UnsupportedEncodingException {
        return lockSourceInfoService.downloadTemplate(response);
    }

    @ApiOperation(value = "导出锁定货源信息列表")
    @RequestMapping(value = "exportExcel", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> exportExcel(@RequestBody LockSourceInfoPagePo po, HttpServletResponse response) throws UnsupportedEncodingException {
        return lockSourceInfoService.exportExcel(po, response);
    }

    @ApiOperation(value = "导入锁定货源信息")
    @RequestMapping(value = "importExcel", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> importExcel(MultipartFile upfile, MultipartHttpServletRequest request) throws UnsupportedEncodingException {
        return lockSourceInfoService.importExcel(upfile, request);
    }


}
