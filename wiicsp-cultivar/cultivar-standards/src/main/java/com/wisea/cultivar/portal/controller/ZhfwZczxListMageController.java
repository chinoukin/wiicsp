package com.wisea.cultivar.portal.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.portal.po.ZhfwZczxListMageBatDeletePo;
import com.wisea.cultivar.portal.po.ZhfwZczxListMageGetPo;
import com.wisea.cultivar.portal.po.ZhfwZczxListMageInsertPo;
import com.wisea.cultivar.portal.po.ZhfwZczxListMageListPo;
import com.wisea.cultivar.portal.po.ZhfwZczxListMagePagePo;
import com.wisea.cultivar.portal.po.ZhfwZczxListMageUpdatePo;
import com.wisea.cultivar.portal.service.ZhfwZczxListMageService;
import com.wisea.cultivar.portal.vo.ZhfwZczxListMageGetVo;
import com.wisea.cultivar.portal.vo.ZhfwZczxListMageListVo;
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
 * ZhfwZczxListMageController
 * 种植服务政策咨询管理 Controller
 * 2020/08/24 20:28:13
 */
@Api(tags = "种植服务政策咨询管理相关接口")
@RequestMapping(value = "/w/ZhfwZczxListMage")
@PreAuthorize("hasAuthority('pt:pla')")
@RestController
public class ZhfwZczxListMageController {
    @Autowired
    protected ZhfwZczxListMageService zhfwZczxListMageService;

    @ApiOperation(value = "获取种植服务政策咨询管理分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<ZhfwZczxListMageListVo>> findPage(@RequestBody ZhfwZczxListMagePagePo zhfwZczxListMagePagePo) {
        return zhfwZczxListMageService.findPage(zhfwZczxListMagePagePo);
    }

    @ApiOperation(value = "获取种植服务政策咨询管理列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<ZhfwZczxListMageListVo>> list(@RequestBody ZhfwZczxListMageListPo zhfwZczxListMageListPo) {
        return zhfwZczxListMageService.findList(zhfwZczxListMageListPo);
    }

    @ApiOperation(value = "查询种植服务政策咨询管理")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<ZhfwZczxListMageGetVo> get(@RequestBody ZhfwZczxListMageGetPo zhfwZczxListMageGetPo) {
        return zhfwZczxListMageService.get(zhfwZczxListMageGetPo);
    }

    @ApiOperation(value = "新增种植服务政策咨询管理")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody ZhfwZczxListMageInsertPo zhfwZczxListMageInsertPo) {
        return zhfwZczxListMageService.insert(zhfwZczxListMageInsertPo);
    }

    @ApiOperation(value = "修改种植服务政策咨询管理")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody ZhfwZczxListMageUpdatePo zhfwZczxListMageUpdatePo) {
        return zhfwZczxListMageService.update(zhfwZczxListMageUpdatePo);
    }

    @ApiOperation(value = "批量删除种植服务政策咨询管理")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody ZhfwZczxListMageBatDeletePo zhfwZczxListMageBatDeletePo) {
        return zhfwZczxListMageService.batDelete(zhfwZczxListMageBatDeletePo);
    }
    /**
    * 此方法暂时不用，如需使用请自行修改
    * Author: xiehy
    * Date: 2020/8/27 10:28
    */
    @ApiOperation(value = "政策资讯列表（未启用，可删除该方法）")
    @RequestMapping(value = "getlevelList", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<ZhfwZczxListMageListVo>> getlevelList(@RequestBody ZhfwZczxListMagePagePo po){
        return zhfwZczxListMageService.getlevelList(po);
    }
}
