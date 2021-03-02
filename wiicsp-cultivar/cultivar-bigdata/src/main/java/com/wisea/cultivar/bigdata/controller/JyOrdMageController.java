package com.wisea.cultivar.bigdata.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.po.bigdata.JyOrdMageBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.JyOrdMageGetPo;
import com.wisea.cultivar.common.po.bigdata.JyOrdMagePagePo;
import com.wisea.cultivar.common.po.bigdata.JyOrdMageUpdatePo;
import com.wisea.cultivar.bigdata.service.JyOrdMageService;
import com.wisea.cultivar.common.vo.bigdata.JyOrdMageGetVo;
import com.wisea.cultivar.common.vo.bigdata.JyOrdMageListVo;
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
 * JyOrdMageController
 * 交易订单管理 Controller
 * 2019/12/02 11:02:14
 */
@Api(tags = "交易订单管理相关接口")
@RequestMapping(value = "/w/transactionOrdMage")
@RestController
public class JyOrdMageController {
    @Autowired
    protected JyOrdMageService jyOrdMageService;

    @ApiOperation(value = "获取交易订单管理分页列表")
    @RequestMapping(value = "findPageList", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<JyOrdMageListVo>> findPage(@RequestBody JyOrdMagePagePo po) {
        return jyOrdMageService.findPage(po);
    }

    @ApiOperation(value = "查询交易订单管理")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<JyOrdMageGetVo> get(@RequestBody JyOrdMageGetPo jyOrdMageGetPo) {
        return jyOrdMageService.get(jyOrdMageGetPo);
    }

    @ApiOperation(value = "修改交易订单管理")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody JyOrdMageUpdatePo jyOrdMageUpdatePo) {
        return jyOrdMageService.update(jyOrdMageUpdatePo);
    }

    @ApiOperation(value = "批量删除交易订单管理")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody JyOrdMageBatDeletePo jyOrdMageBatDeletePo) {
        return jyOrdMageService.batDelete(jyOrdMageBatDeletePo);
    }

    @ApiOperation(value = "导出交易订单列表")
    @RequestMapping(value = "exportExcel", method = RequestMethod.POST)
    public ResultPoJo<Object> exportExcel(@RequestBody JyOrdMagePagePo po, HttpServletResponse response) throws UnsupportedEncodingException {
        return jyOrdMageService.exportExcel(po, response);
    }

    @ApiOperation(value = "导入交易订单列表", notes = "上传文件,需要声明 Content-Type=multipart/form-data")
    @RequestMapping(value = "importExcel", method = RequestMethod.POST)
    public ResultPoJo<Object> importExcel(MultipartFile upfile, MultipartHttpServletRequest request){
        return jyOrdMageService.importExcel(upfile, request);
    }
}
