package com.wisea.cultivar.explorer.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.explorer.po.*;
import com.wisea.cultivar.explorer.service.DemonsBaseInfoService;
import com.wisea.cultivar.explorer.vo.DemonsBaseInfoGetVo;
import com.wisea.cultivar.explorer.vo.DemonsBaseInfoListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * DemonsBaseInfoController
 * 示范基地信息 Controller
 * 2020/08/11 13:21:46
 */
@Api(tags = "示范基地信息相关接口")
@RequestMapping(value = "/w/DemonsBaseInfo")
@RestController
@PreAuthorize("hasAuthority('ep:bse')")
public class DemonsBaseInfoController {
    @Autowired
    protected DemonsBaseInfoService demonsBaseInfoService;

    @ApiOperation(value = "获取示范基地信息分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<DemonsBaseInfoListVo>> findPage(@RequestBody DemonsBaseInfoPagePo demonsBaseInfoPagePo) {
        return demonsBaseInfoService.findPage(demonsBaseInfoPagePo);
    }

    @ApiOperation(value = "获取示范基地信息列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<DemonsBaseInfoListVo>> list(@RequestBody DemonsBaseInfoListPo demonsBaseInfoListPo) {
        return demonsBaseInfoService.findList(demonsBaseInfoListPo);
    }

    @ApiOperation(value = "查询示范基地信息")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<DemonsBaseInfoGetVo> get(@RequestBody DemonsBaseInfoGetPo demonsBaseInfoGetPo) {
        return demonsBaseInfoService.get(demonsBaseInfoGetPo);
    }

    @ApiOperation(value = "新增示范基地信息")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody DemonsBaseInfoInsertPo demonsBaseInfoInsertPo) {
        return demonsBaseInfoService.insert(demonsBaseInfoInsertPo);
    }

    @ApiOperation(value = "修改示范基地信息")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody DemonsBaseInfoUpdatePo demonsBaseInfoUpdatePo) {
        return demonsBaseInfoService.update(demonsBaseInfoUpdatePo);
    }

    @ApiOperation(value = "批量删除示范基地信息")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody DemonsBaseInfoBatDeletePo demonsBaseInfoBatDeletePo) {
        return demonsBaseInfoService.batDelete(demonsBaseInfoBatDeletePo);
    }
}
