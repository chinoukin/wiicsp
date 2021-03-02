package com.wisea.cultivar.portal.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.portal.po.ZhfwAdverSpaceMageBatDeletePo;
import com.wisea.cultivar.portal.po.ZhfwAdverSpaceMageGetPo;
import com.wisea.cultivar.portal.po.ZhfwAdverSpaceMageInsertPo;
import com.wisea.cultivar.portal.po.ZhfwAdverSpaceMageListPo;
import com.wisea.cultivar.portal.po.ZhfwAdverSpaceMagePagePo;
import com.wisea.cultivar.portal.po.ZhfwAdverSpaceMageUpdatePo;
import com.wisea.cultivar.portal.service.ZhfwAdverSpaceMageService;
import com.wisea.cultivar.portal.vo.ZhfwAdverSpaceMageGetVo;
import com.wisea.cultivar.portal.vo.ZhfwAdverSpaceMageListVo;
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
 * ZhfwAdverSpaceMageController
 * 种植服务广告位管理 Controller
 * 2020/08/24 20:28:13
 */
@Api(tags = "种植服务广告位管理相关接口")
@RequestMapping(value = "/w/ZhfwAdverSpaceMage")
@PreAuthorize("hasAuthority('pt:adm')")
@RestController
public class ZhfwAdverSpaceMageController {
    @Autowired
    protected ZhfwAdverSpaceMageService zhfwAdverSpaceMageService;

    @ApiOperation(value = "获取种植服务广告位管理分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<ZhfwAdverSpaceMageListVo>> findPage(@RequestBody ZhfwAdverSpaceMagePagePo zhfwAdverSpaceMagePagePo) {
        return zhfwAdverSpaceMageService.findPage(zhfwAdverSpaceMagePagePo);
    }

    @ApiOperation(value = "获取种植服务广告位管理列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<ZhfwAdverSpaceMageListVo>> list(@RequestBody ZhfwAdverSpaceMageListPo zhfwAdverSpaceMageListPo) {
        return zhfwAdverSpaceMageService.findList(zhfwAdverSpaceMageListPo);
    }

    @ApiOperation(value = "查询种植服务广告位管理")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<ZhfwAdverSpaceMageGetVo> get(@RequestBody ZhfwAdverSpaceMageGetPo zhfwAdverSpaceMageGetPo) {
        return zhfwAdverSpaceMageService.get(zhfwAdverSpaceMageGetPo);
    }

    @ApiOperation(value = "新增种植服务广告位管理")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody ZhfwAdverSpaceMageInsertPo zhfwAdverSpaceMageInsertPo) {
        return zhfwAdverSpaceMageService.insert(zhfwAdverSpaceMageInsertPo);
    }

    @ApiOperation(value = "修改种植服务广告位管理")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody ZhfwAdverSpaceMageUpdatePo zhfwAdverSpaceMageUpdatePo) {
        return zhfwAdverSpaceMageService.update(zhfwAdverSpaceMageUpdatePo);
    }

    @ApiOperation(value = "批量删除种植服务广告位管理")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody ZhfwAdverSpaceMageBatDeletePo zhfwAdverSpaceMageBatDeletePo) {
        return zhfwAdverSpaceMageService.batDelete(zhfwAdverSpaceMageBatDeletePo);
    }
}
