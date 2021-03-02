package com.wisea.cultivar.bigdata.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.po.bigdata.MembInfoBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.MembInfoGetPo;
import com.wisea.cultivar.common.po.bigdata.MembInfoInsertPo;
import com.wisea.cultivar.common.po.bigdata.MembInfoListPo;
import com.wisea.cultivar.common.po.bigdata.MembInfoPagePo;
import com.wisea.cultivar.common.po.bigdata.MembInfoUpdatePo;
import com.wisea.cultivar.bigdata.service.MembInfoService;
import com.wisea.cultivar.common.vo.bigdata.MembInfoGetVo;
import com.wisea.cultivar.common.vo.bigdata.MembInfoListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * MembInfoController
 * 用户管理 Controller
 * 2019/12/02 11:02:14
 */
@Api(tags = "用户管理相关接口")
@RequestMapping(value = "/w/memb")
@RestController

public class MembInfoController {
    /*@Autowired
    protected MembInfoService membInfoService;

    @ApiOperation(value = "获取用户管理分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<MembInfoListVo>> findPage(@RequestBody MembInfoPagePo membInfoPagePo) {
        return membInfoService.findPage(membInfoPagePo);
    }

    @ApiOperation(value = "获取用户管理列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<MembInfoListVo>> list(@RequestBody MembInfoListPo membInfoListPo) {
        return membInfoService.findList(membInfoListPo);
    }

    @ApiOperation(value = "查询用户管理")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<MembInfoGetVo> get(@RequestBody MembInfoGetPo membInfoGetPo) {
        return membInfoService.get(membInfoGetPo);
    }

    @ApiOperation(value = "新增用户管理")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody MembInfoInsertPo membInfoInsertPo) {
        return membInfoService.insert(membInfoInsertPo);
    }

    @ApiOperation(value = "修改用户管理")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody MembInfoUpdatePo membInfoUpdatePo) {
        return membInfoService.update(membInfoUpdatePo);
    }

    @ApiOperation(value = "设置是否启用")
    @RequestMapping(value = "enable", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> enable(@RequestBody MembInfoUpdatePo membInfoUpdatePo) {
        return membInfoService.enable(membInfoUpdatePo);
    }


    @ApiOperation(value = "批量删除用户管理")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody MembInfoBatDeletePo membInfoBatDeletePo) {
        return membInfoService.batDelete(membInfoBatDeletePo);
    }

    @ApiOperation("导出")
    @PostMapping("/excel/export")
    @DataCheck
    public void excelExport(HttpServletResponse response) throws IOException {
        membInfoService.excelExport(response);
    }*/
}
