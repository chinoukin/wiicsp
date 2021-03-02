package com.wisea.cultivar.seedlings.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.po.trade.EntpInfoMagePo;
import com.wisea.cultivar.explorer.vo.EntpInfoMageGetVo;
import com.wisea.cultivar.seedlings.po.*;
import com.wisea.cultivar.seedlings.service.SproutCatalogMageService;
import com.wisea.cultivar.seedlings.vo.BuySproutIndividualInfoListVo;
import com.wisea.cultivar.seedlings.vo.SproutCatalogMageGetVo;
import com.wisea.cultivar.seedlings.vo.SproutCatalogMageListVo;
import com.wisea.cultivar.seedlings.vo.SproutMageGetVo;
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
 * SproutCatalogMageController
 * 种苗目录管理 Controller
 * 2020/08/06 14:19:24
 */
@Api(tags = "种苗目录管理相关接口")
@RequestMapping(value = "/w/SproutCatalogMage")
@RestController
@PreAuthorize("hasAnyAuthority('se:cal')")
public class SproutCatalogMageController {
    @Autowired
    protected SproutCatalogMageService sproutCatalogMageService;

    @ApiOperation(value = "获取种苗目录管理分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<SproutCatalogMageListVo>> findPage(@RequestBody SproutCatalogMagePagePo sproutCatalogMagePagePo) {
        return sproutCatalogMageService.findPage(sproutCatalogMagePagePo);
    }

    @ApiOperation(value = "获取种苗目录管理列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<SproutCatalogMageListVo>> list(@RequestBody SproutCatalogMageListPo sproutCatalogMageListPo) {
        return sproutCatalogMageService.findList(sproutCatalogMageListPo);
    }

    @ApiOperation(value = "查询种苗目录管理")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<SproutCatalogMageGetVo> get(@RequestBody SproutCatalogMageGetPo sproutCatalogMageGetPo) {
        return sproutCatalogMageService.get(sproutCatalogMageGetPo);
    }

    @ApiOperation(value = "新增种苗目录管理",notes = "错误代码 50002:该年份已发布种苗目录，不可重复!")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody SproutCatalogMageInsertPo sproutCatalogMageInsertPo) {
        return sproutCatalogMageService.insert(sproutCatalogMageInsertPo);
    }

    @ApiOperation(value = "修改种苗目录管理",notes = "错误代码 50002:该年份已发布种苗目录，不可重复!")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody SproutCatalogMageUpdatePo sproutCatalogMageUpdatePo) {
        return sproutCatalogMageService.update(sproutCatalogMageUpdatePo);
    }

    @ApiOperation(value = "批量删除种苗目录管理")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody SproutCatalogMageBatDeletePo sproutCatalogMageBatDeletePo) {
        return sproutCatalogMageService.batDelete(sproutCatalogMageBatDeletePo);
    }

    @ApiOperation(value = "定点种苗企业列表")
    @RequestMapping(value = "findEntpInfoList", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<EntpInfoMageGetVo>> findEntpInfoList(@RequestBody EntpInfoMagePo entpInfoMagePo) {
        return sproutCatalogMageService.findEntpInfoList(entpInfoMagePo);
    }

    @ApiOperation(value = "发布历年种苗")
    @RequestMapping(value = "releaseSeedlings", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> releaseSeedlings(@RequestBody SproutCatalogMageGetPo sproutCatalogMageGetPo) {
        return sproutCatalogMageService.releaseSeedlings(sproutCatalogMageGetPo);
    }

    @ApiOperation(value = "查询历年种苗目录信息")
    @RequestMapping(value = "sproutCataLogDetails", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<SproutCatalogMageGetVo> sproutCataLogDetails(@RequestBody SproutCatalogMageGetPo sproutCatalogMageGetPo) {
        return sproutCatalogMageService.sproutCataLogDetails(sproutCatalogMageGetPo);
    }

    @ApiOperation(value = "查询历年种苗详情信息")
    @RequestMapping(value = "sproutDetails", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<SproutMageGetVo> sproutDetails(@RequestBody SproutCatalogMageGetPo sproutCatalogMageGetPo) {
        return sproutCatalogMageService.sproutDetails(sproutCatalogMageGetPo);
    }

    @ApiOperation(value = "查询种植户种植详情")
    @RequestMapping(value = "buyDetails", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<BuySproutIndividualInfoListVo>> buyDetails(@RequestBody SproutBuyGetPo sproutBuyGetPo) {
        return sproutCatalogMageService.buyDetails(sproutBuyGetPo);
    }
}
