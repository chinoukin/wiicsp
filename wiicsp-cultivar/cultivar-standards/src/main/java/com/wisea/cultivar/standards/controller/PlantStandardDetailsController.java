package com.wisea.cultivar.standards.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.standards.po.PlantStandardDetailsBatDeletePo;
import com.wisea.cultivar.standards.po.PlantStandardDetailsGetPo;
import com.wisea.cultivar.standards.po.PlantStandardDetailsInsertPo;
import com.wisea.cultivar.standards.po.PlantStandardDetailsListPo;
import com.wisea.cultivar.standards.po.PlantStandardDetailsPagePo;
import com.wisea.cultivar.standards.po.PlantStandardDetailsUpdatePo;
import com.wisea.cultivar.standards.service.PlantStandardDetailsService;
import com.wisea.cultivar.standards.vo.PlantStandardDetailsGetVo;
import com.wisea.cultivar.standards.vo.PlantStandardDetailsListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * PlantStandardDetailsController
 * 标准详情 Controller
 * 2020/07/24 11:21:45
 */
@Api(tags = "标准详情相关接口")
@RequestMapping(value = "/w/PlantStandardDetails")
@RestController
public class PlantStandardDetailsController {
    @Autowired
    protected PlantStandardDetailsService plantStandardDetailsService;

    @ApiOperation(value = "获取标准详情分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<PlantStandardDetailsListVo>> findPage(@RequestBody PlantStandardDetailsPagePo plantStandardDetailsPagePo) {
        return plantStandardDetailsService.findPage(plantStandardDetailsPagePo);
    }

    @ApiOperation(value = "获取标准详情列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<PlantStandardDetailsListVo>> list(@RequestBody PlantStandardDetailsListPo plantStandardDetailsListPo) {
        return plantStandardDetailsService.findList(plantStandardDetailsListPo);
    }

    @ApiOperation(value = "查询标准详情")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<PlantStandardDetailsGetVo> get(@RequestBody PlantStandardDetailsGetPo plantStandardDetailsGetPo) {
        return plantStandardDetailsService.get(plantStandardDetailsGetPo);
    }

    @ApiOperation(value = "新增标准详情")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody PlantStandardDetailsInsertPo plantStandardDetailsInsertPo) {
        return plantStandardDetailsService.insert(plantStandardDetailsInsertPo);
    }

    @ApiOperation(value = "修改标准详情")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody PlantStandardDetailsUpdatePo plantStandardDetailsUpdatePo) {
        return plantStandardDetailsService.update(plantStandardDetailsUpdatePo);
    }

    @ApiOperation(value = "批量删除标准详情")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody PlantStandardDetailsBatDeletePo plantStandardDetailsBatDeletePo) {
        return plantStandardDetailsService.batDelete(plantStandardDetailsBatDeletePo);
    }
}
