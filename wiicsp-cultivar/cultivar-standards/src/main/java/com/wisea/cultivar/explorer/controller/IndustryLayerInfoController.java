package com.wisea.cultivar.explorer.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.explorer.po.IndustryLayerInfoBatDeletePo;
import com.wisea.cultivar.explorer.po.IndustryLayerInfoGetPo;
import com.wisea.cultivar.explorer.po.IndustryLayerInfoInsertPo;
import com.wisea.cultivar.explorer.po.IndustryLayerInfoListPo;
import com.wisea.cultivar.explorer.po.IndustryLayerInfoPagePo;
import com.wisea.cultivar.explorer.po.IndustryLayerInfoUpdatePo;
import com.wisea.cultivar.explorer.service.IndustryLayerInfoService;
import com.wisea.cultivar.explorer.vo.IndustryLayerInfoGetVo;
import com.wisea.cultivar.explorer.vo.IndustryLayerInfoListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * IndustryLayerInfoController
 * 产业图层信息 Controller
 * 2020/08/11 13:21:46
 */
@Api(tags = "产业图层信息相关接口")
@RequestMapping(value = "/w/IndustryLayerInfo")
@RestController
@PreAuthorize("hasAuthority('ep:ind')")
public class IndustryLayerInfoController {
    @Autowired
    protected IndustryLayerInfoService industryLayerInfoService;

    @ApiOperation(value = "获取产业图层信息分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<IndustryLayerInfoListVo>> findPage(@RequestBody IndustryLayerInfoPagePo industryLayerInfoPagePo) {
        return industryLayerInfoService.findPage(industryLayerInfoPagePo);
    }

    @ApiOperation(value = "获取产业图层信息列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<IndustryLayerInfoListVo>> list(@RequestBody IndustryLayerInfoListPo industryLayerInfoListPo) {
        return industryLayerInfoService.findList(industryLayerInfoListPo);
    }

    @ApiOperation(value = "查询产业图层信息")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<IndustryLayerInfoGetVo> get(@RequestBody IndustryLayerInfoGetPo industryLayerInfoGetPo) {
        return industryLayerInfoService.get(industryLayerInfoGetPo);
    }

    @ApiOperation(value = "新增产业图层信息")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody IndustryLayerInfoInsertPo industryLayerInfoInsertPo) {
        return industryLayerInfoService.insert(industryLayerInfoInsertPo);
    }

    @ApiOperation(value = "修改产业图层信息")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody IndustryLayerInfoUpdatePo industryLayerInfoUpdatePo) {
        return industryLayerInfoService.update(industryLayerInfoUpdatePo);
    }

    @ApiOperation(value = "批量删除产业图层信息")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody IndustryLayerInfoBatDeletePo industryLayerInfoBatDeletePo) {
        return industryLayerInfoService.batDelete(industryLayerInfoBatDeletePo);
    }
}
