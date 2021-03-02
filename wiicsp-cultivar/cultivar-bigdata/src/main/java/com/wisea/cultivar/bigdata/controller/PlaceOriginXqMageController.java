package com.wisea.cultivar.bigdata.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.po.bigdata.PlaceOriginXqMageBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.PlaceOriginXqMageGetPo;
import com.wisea.cultivar.common.po.bigdata.PlaceOriginXqMageInsertPo;
import com.wisea.cultivar.common.po.bigdata.PlaceOriginXqMageListPo;
import com.wisea.cultivar.common.po.bigdata.PlaceOriginXqMagePagePo;
import com.wisea.cultivar.common.po.bigdata.PlaceOriginXqMageUpdatePo;
import com.wisea.cultivar.bigdata.service.PlaceOriginXqMageService;
import com.wisea.cultivar.common.vo.bigdata.PlaceOriginXqMageGetVo;
import com.wisea.cultivar.common.vo.bigdata.PlaceOriginXqMageListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * PlaceOriginXqMageController
 * 产地详情管理 Controller
 * 2019/12/02 11:02:15
 */
@Api(tags = "产地详情管理相关接口")
@RequestMapping(value = "/w/placeOrigin")
@RestController
public class PlaceOriginXqMageController {
    @Autowired
    protected PlaceOriginXqMageService placeOriginXqMageService;

    @ApiOperation(value = "获取产地详情管理分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<PlaceOriginXqMageListVo>> findPage(@RequestBody PlaceOriginXqMagePagePo placeOriginXqMagePagePo) {
        return placeOriginXqMageService.findPage(placeOriginXqMagePagePo);
    }

    @ApiOperation(value = "获取产地详情管理列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<PlaceOriginXqMageListVo>> list(@RequestBody PlaceOriginXqMageListPo placeOriginXqMageListPo) {
        return placeOriginXqMageService.findList(placeOriginXqMageListPo);
    }

    @ApiOperation(value = "查询产地详情管理")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<PlaceOriginXqMageGetVo> get(@RequestBody PlaceOriginXqMageGetPo placeOriginXqMageGetPo) {
        return placeOriginXqMageService.get(placeOriginXqMageGetPo);
    }

    @ApiOperation(value = "新增产地详情管理")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody PlaceOriginXqMageInsertPo placeOriginXqMageInsertPo) {
        return placeOriginXqMageService.insert(placeOriginXqMageInsertPo);
    }

    @ApiOperation(value = "修改产地详情管理")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody PlaceOriginXqMageUpdatePo placeOriginXqMageUpdatePo) {
        return placeOriginXqMageService.update(placeOriginXqMageUpdatePo);
    }

    @ApiOperation(value = "批量删除产地详情管理")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody PlaceOriginXqMageBatDeletePo placeOriginXqMageBatDeletePo) {
        return placeOriginXqMageService.batDelete(placeOriginXqMageBatDeletePo);
    }
}
