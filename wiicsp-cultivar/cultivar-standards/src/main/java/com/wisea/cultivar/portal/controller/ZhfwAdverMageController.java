package com.wisea.cultivar.portal.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.portal.po.ZhfwAdverMageBatDeletePo;
import com.wisea.cultivar.portal.po.ZhfwAdverMageGetPo;
import com.wisea.cultivar.portal.po.ZhfwAdverMageInsertPo;
import com.wisea.cultivar.portal.po.ZhfwAdverMageListPo;
import com.wisea.cultivar.portal.po.ZhfwAdverMagePagePo;
import com.wisea.cultivar.portal.po.ZhfwAdverMageUpdatePo;
import com.wisea.cultivar.portal.service.ZhfwAdverMageService;
import com.wisea.cultivar.portal.vo.ZhfwAdverMageGetVo;
import com.wisea.cultivar.portal.vo.ZhfwAdverMageListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ZhfwAdverMageController
 * 种植服务广告管理 Controller
 * 2020/08/24 20:28:13
 */
@Api(tags = "种植服务广告管理相关接口")
@RequestMapping(value = "/w/ZhfwAdverMage")
@RestController
public class ZhfwAdverMageController {
    @Autowired
    protected ZhfwAdverMageService zhfwAdverMageService;

    @ApiOperation(value = "获取种植服务广告管理分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<ZhfwAdverMageListVo>> findPage(@RequestBody ZhfwAdverMagePagePo zhfwAdverMagePagePo) {
        return zhfwAdverMageService.findPage(zhfwAdverMagePagePo);
    }

    @ApiOperation(value = "获取种植服务广告管理列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<ZhfwAdverMageListVo>> list(@RequestBody ZhfwAdverMageListPo zhfwAdverMageListPo) {
        return zhfwAdverMageService.findList(zhfwAdverMageListPo);
    }

    @ApiOperation(value = "查询种植服务广告管理")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<ZhfwAdverMageGetVo> get(@RequestBody ZhfwAdverMageGetPo zhfwAdverMageGetPo) {
        return zhfwAdverMageService.get(zhfwAdverMageGetPo);
    }

    @ApiOperation(value = "新增种植服务广告管理")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody ZhfwAdverMageInsertPo zhfwAdverMageInsertPo) {
        return zhfwAdverMageService.insert(zhfwAdverMageInsertPo);
    }

    @ApiOperation(value = "修改种植服务广告管理")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody ZhfwAdverMageUpdatePo zhfwAdverMageUpdatePo) {
        return zhfwAdverMageService.update(zhfwAdverMageUpdatePo);
    }

    @ApiOperation(value = "批量删除种植服务广告管理")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody ZhfwAdverMageBatDeletePo zhfwAdverMageBatDeletePo) {
        return zhfwAdverMageService.batDelete(zhfwAdverMageBatDeletePo);
    }
}
