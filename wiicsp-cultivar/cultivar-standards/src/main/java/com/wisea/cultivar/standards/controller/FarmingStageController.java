package com.wisea.cultivar.standards.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.standards.po.FarmingStageBatDeletePo;
import com.wisea.cultivar.standards.po.FarmingStageGetPo;
import com.wisea.cultivar.standards.po.FarmingStageInsertPo;
import com.wisea.cultivar.standards.po.FarmingStageListPo;
import com.wisea.cultivar.standards.po.FarmingStagePagePo;
import com.wisea.cultivar.standards.po.FarmingStageUpdatePo;
import com.wisea.cultivar.standards.service.FarmingStageService;
import com.wisea.cultivar.standards.vo.FarmingStageGetVo;
import com.wisea.cultivar.standards.vo.FarmingStageListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * FarmingStageController
 * 农事阶段 Controller
 * 2020/07/24 11:21:45
 */
@Api(tags = "农事阶段相关接口")
@RequestMapping(value = "/w/FarmingStage")
@RestController
public class FarmingStageController {
    @Autowired
    protected FarmingStageService farmingStageService;

    @ApiOperation(value = "获取农事阶段分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<FarmingStageListVo>> findPage(@RequestBody FarmingStagePagePo farmingStagePagePo) {
        return farmingStageService.findPage(farmingStagePagePo);
    }

    @ApiOperation(value = "获取农事阶段列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<FarmingStageListVo>> list(@RequestBody FarmingStageListPo farmingStageListPo) {
        return farmingStageService.findList(farmingStageListPo);
    }

    @ApiOperation(value = "查询农事阶段")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<FarmingStageGetVo> get(@RequestBody FarmingStageGetPo farmingStageGetPo) {
        return farmingStageService.get(farmingStageGetPo);
    }

    @ApiOperation(value = "新增农事阶段")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody FarmingStageInsertPo farmingStageInsertPo) {
        return farmingStageService.insert(farmingStageInsertPo);
    }

    @ApiOperation(value = "修改农事阶段")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody FarmingStageUpdatePo farmingStageUpdatePo) {
        return farmingStageService.update(farmingStageUpdatePo);
    }

    @ApiOperation(value = "批量删除农事阶段")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody FarmingStageBatDeletePo farmingStageBatDeletePo) {
        return farmingStageService.batDelete(farmingStageBatDeletePo);
    }
}
