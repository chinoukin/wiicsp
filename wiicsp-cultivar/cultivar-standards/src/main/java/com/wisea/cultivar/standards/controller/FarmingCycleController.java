package com.wisea.cultivar.standards.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.standards.po.FarmingCycleBatDeletePo;
import com.wisea.cultivar.standards.po.FarmingCycleGetPo;
import com.wisea.cultivar.standards.po.FarmingCycleInsertPo;
import com.wisea.cultivar.standards.po.FarmingCycleListPo;
import com.wisea.cultivar.standards.po.FarmingCyclePagePo;
import com.wisea.cultivar.standards.po.FarmingCycleUpdatePo;
import com.wisea.cultivar.standards.service.FarmingCycleService;
import com.wisea.cultivar.standards.vo.FarmingCycleGetVo;
import com.wisea.cultivar.standards.vo.FarmingCycleListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * FarmingCycleController
 * 农事周期 Controller
 * 2020/07/24 11:21:45
 */
@Api(tags = "农事周期相关接口")
@RequestMapping(value = "/w/FarmingCycle")
@RestController
public class FarmingCycleController {
    @Autowired
    protected FarmingCycleService farmingCycleService;

    @ApiOperation(value = "获取农事周期分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<FarmingCycleListVo>> findPage(@RequestBody FarmingCyclePagePo farmingCyclePagePo) {
        return farmingCycleService.findPage(farmingCyclePagePo);
    }

    @ApiOperation(value = "获取农事周期列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<FarmingCycleListVo>> list(@RequestBody FarmingCycleListPo farmingCycleListPo) {
        return farmingCycleService.findList(farmingCycleListPo);
    }

    @ApiOperation(value = "查询农事周期")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<FarmingCycleGetVo> get(@RequestBody FarmingCycleGetPo farmingCycleGetPo) {
        return farmingCycleService.get(farmingCycleGetPo);
    }

    @ApiOperation(value = "新增农事周期")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody FarmingCycleInsertPo farmingCycleInsertPo) {
        return farmingCycleService.insert(farmingCycleInsertPo);
    }

    @ApiOperation(value = "修改农事周期")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody FarmingCycleUpdatePo farmingCycleUpdatePo) {
        return farmingCycleService.update(farmingCycleUpdatePo);
    }

    @ApiOperation(value = "批量删除农事周期")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody FarmingCycleBatDeletePo farmingCycleBatDeletePo) {
        return farmingCycleService.batDelete(farmingCycleBatDeletePo);
    }
}
