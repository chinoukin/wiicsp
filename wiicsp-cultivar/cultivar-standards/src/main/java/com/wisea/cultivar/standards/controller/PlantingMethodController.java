package com.wisea.cultivar.standards.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.po.product.CommMageTreePo;
import com.wisea.cultivar.standards.po.*;
import com.wisea.cultivar.standards.service.PlantingMethodService;
import com.wisea.cultivar.standards.vo.PlantingMethodGetVo;
import com.wisea.cultivar.standards.vo.PlantingMethodListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * PlantingMethodController
 * 种植方法 Controller
 * 2020/07/24 11:21:45
 */
@Api(tags = "种植方法相关接口")
@RequestMapping(value = "/w/PlantingMethod")
@PreAuthorize("hasAuthority('st:pwm')")
@RestController
public class PlantingMethodController {
    @Autowired
    protected PlantingMethodService plantingMethodService;

    @ApiOperation(value = "获取种植方法分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<PlantingMethodListVo>> findPage(@RequestBody PlantingMethodPagePo plantingMethodPagePo) {
        return plantingMethodService.findPage(plantingMethodPagePo);
    }

    @ApiOperation(value = "获取种植方法列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<PlantingMethodListVo>> list(@RequestBody PlantingMethodListPo plantingMethodListPo) {
        return plantingMethodService.findList(plantingMethodListPo);
    }

    @ApiOperation(value = "查询种植方法")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<PlantingMethodGetVo> get(@RequestBody PlantingMethodGetPo plantingMethodGetPo) {
        return plantingMethodService.get(plantingMethodGetPo);
    }

    @ApiOperation(value = "新增种植方法")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody PlantingMethodInsertPo plantingMethodInsertPo) {
        return plantingMethodService.insert(plantingMethodInsertPo);
    }

    @ApiOperation(value = "修改种植方法")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody PlantingMethodUpdatePo plantingMethodUpdatePo) {
        return plantingMethodService.update(plantingMethodUpdatePo);
    }

    @ApiOperation(value = "批量删除种植方法")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody PlantingMethodBatDeletePo plantingMethodBatDeletePo) {
        return plantingMethodService.batDelete(plantingMethodBatDeletePo);
    }

    @ApiOperation(value = "获取分类")
    @RequestMapping(value = "getCommId", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> getCommId(@RequestBody CommMageTreePo commMageTreePo) {
        return plantingMethodService.getCommId(commMageTreePo);
    }

    @ApiOperation(value = "获取关联标准")
    @RequestMapping(value = "getPlantStandardMageFindList", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> getPlantStandardMageFindList(@RequestBody StandardMageListPo standardMageListPo) {

        return plantingMethodService.getPlantStandardMageFindList(standardMageListPo);
    }

    @ApiOperation(value = "删除种植方法")
    @RequestMapping(value = "oneDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> oneDelete(@RequestBody PlantingMethodOneDeletePo plantingMethodOneDeletePo) {
        return plantingMethodService.oneDelete(plantingMethodOneDeletePo);
    }

}
