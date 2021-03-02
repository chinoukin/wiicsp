package com.wisea.cultivar.explorer.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.explorer.po.IndustryLayerAreaBatDeletePo;
import com.wisea.cultivar.explorer.po.IndustryLayerAreaGetPo;
import com.wisea.cultivar.explorer.po.IndustryLayerAreaInsertPo;
import com.wisea.cultivar.explorer.po.IndustryLayerAreaListPo;
import com.wisea.cultivar.explorer.po.IndustryLayerAreaPagePo;
import com.wisea.cultivar.explorer.po.IndustryLayerAreaUpdatePo;
import com.wisea.cultivar.explorer.service.IndustryLayerAreaService;
import com.wisea.cultivar.explorer.vo.IndustryLayerAreaGetVo;
import com.wisea.cultivar.explorer.vo.IndustryLayerAreaListVo;
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
 * IndustryLayerAreaController
 * 图层区域信息 Controller
 * 2020/08/11 13:21:46
 */
@Api(tags = "图层区域信息相关接口")
@RequestMapping(value = "/w/IndustryLayerArea")
@RestController
@PreAuthorize("hasAuthority('ep:ind')")
public class IndustryLayerAreaController {
    @Autowired
    protected IndustryLayerAreaService industryLayerAreaService;

    @ApiOperation(value = "获取图层区域信息分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<IndustryLayerAreaListVo>> findPage(@RequestBody IndustryLayerAreaPagePo industryLayerAreaPagePo) {
        return industryLayerAreaService.findPage(industryLayerAreaPagePo);
    }

    @ApiOperation(value = "获取图层区域信息列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<HashMap<String,Object>> list(@RequestBody IndustryLayerAreaListPo industryLayerAreaListPo) {
        return industryLayerAreaService.findList(industryLayerAreaListPo);
    }

    @ApiOperation(value = "查询图层区域信息")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<IndustryLayerAreaGetVo> get(@RequestBody IndustryLayerAreaGetPo industryLayerAreaGetPo) {
        return industryLayerAreaService.get(industryLayerAreaGetPo);
    }

    @ApiOperation(value = "新增图层区域信息")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody IndustryLayerAreaInsertPo industryLayerAreaInsertPo) {
        return industryLayerAreaService.insert(industryLayerAreaInsertPo);
    }

    @ApiOperation(value = "修改图层区域信息")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody IndustryLayerAreaUpdatePo industryLayerAreaUpdatePo) {
        return industryLayerAreaService.update(industryLayerAreaUpdatePo);
    }

    @ApiOperation(value = "批量删除图层区域信息")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody IndustryLayerAreaBatDeletePo industryLayerAreaBatDeletePo) {
        return industryLayerAreaService.batDelete(industryLayerAreaBatDeletePo);
    }
}
