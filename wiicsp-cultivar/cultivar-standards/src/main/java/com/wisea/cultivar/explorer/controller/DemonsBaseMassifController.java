package com.wisea.cultivar.explorer.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.explorer.po.DemonsBaseMassifBatDeletePo;
import com.wisea.cultivar.explorer.po.DemonsBaseMassifGetPo;
import com.wisea.cultivar.explorer.po.DemonsBaseMassifInsertPo;
import com.wisea.cultivar.explorer.po.DemonsBaseMassifListPo;
import com.wisea.cultivar.explorer.po.DemonsBaseMassifPagePo;
import com.wisea.cultivar.explorer.po.DemonsBaseMassifUpdatePo;
import com.wisea.cultivar.explorer.service.DemonsBaseMassifService;
import com.wisea.cultivar.explorer.service.RelationIotInfoService;
import com.wisea.cultivar.explorer.vo.DemonsBaseMassifGetVo;
import com.wisea.cultivar.explorer.vo.DemonsBaseMassifListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * DemonsBaseMassifController
 * 示范基地地块信息 Controller
 * 2020/08/11 13:21:46
 */
@Api(tags = "示范基地地块信息相关接口")
@RequestMapping(value = "/w/DemonsBaseMassif")
@RestController
@PreAuthorize("hasAuthority('ep:bse')")
public class DemonsBaseMassifController {
    @Autowired
    protected DemonsBaseMassifService demonsBaseMassifService;
    @Autowired
    protected RelationIotInfoService relationIotInfoService;


    @ApiOperation(value = "获取示范基地地块信息分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<DemonsBaseMassifListVo>> findPage(@RequestBody DemonsBaseMassifPagePo demonsBaseMassifPagePo) {
        return demonsBaseMassifService.findPage(demonsBaseMassifPagePo);
    }

    @ApiOperation(value = "获取示范基地地块信息列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<HashMap<String,Object>> list(@RequestBody DemonsBaseMassifListPo demonsBaseMassifListPo) {
        return demonsBaseMassifService.findList(demonsBaseMassifListPo);
    }

    @ApiOperation(value = "查询示范基地地块信息")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<DemonsBaseMassifGetVo> get(@RequestBody DemonsBaseMassifGetPo demonsBaseMassifGetPo) {
        return demonsBaseMassifService.get(demonsBaseMassifGetPo);
    }

    @ApiOperation(value = "新增示范基地地块信息")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody DemonsBaseMassifInsertPo demonsBaseMassifInsertPo) {
        return demonsBaseMassifService.insert(demonsBaseMassifInsertPo);
    }

    @ApiOperation(value = "修改示范基地地块信息")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody DemonsBaseMassifUpdatePo demonsBaseMassifUpdatePo) {
        return demonsBaseMassifService.update(demonsBaseMassifUpdatePo);
    }

    @ApiOperation(value = "批量删除示范基地地块信息")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody DemonsBaseMassifBatDeletePo demonsBaseMassifBatDeletePo) {
        return demonsBaseMassifService.batDelete(demonsBaseMassifBatDeletePo);
    }

}
