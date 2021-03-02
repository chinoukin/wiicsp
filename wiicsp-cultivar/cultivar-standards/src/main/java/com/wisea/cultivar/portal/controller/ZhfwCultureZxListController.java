package com.wisea.cultivar.portal.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.portal.po.ZhfwCultureZxListBatDeletePo;
import com.wisea.cultivar.portal.po.ZhfwCultureZxListGetPo;
import com.wisea.cultivar.portal.po.ZhfwCultureZxListInsertPo;
import com.wisea.cultivar.portal.po.ZhfwCultureZxListListPo;
import com.wisea.cultivar.portal.po.ZhfwCultureZxListPagePo;
import com.wisea.cultivar.portal.po.ZhfwCultureZxListUpdatePo;
import com.wisea.cultivar.portal.service.ZhfwCultureZxListService;
import com.wisea.cultivar.portal.vo.ZhfwCultureZxListGetVo;
import com.wisea.cultivar.portal.vo.ZhfwCultureZxListListVo;
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
 * ZhfwCultureZxListController
 * 种植服文化资讯列表 Controller
 * 2020/08/24 20:28:13
 */
@Api(tags = "种植服文化资讯列表相关接口")
@RequestMapping(value = "/w/ZhfwCultureZxList")
@RestController
@PreAuthorize("hasAuthority('pt:cli')")
public class ZhfwCultureZxListController {
    @Autowired
    protected ZhfwCultureZxListService zhfwCultureZxListService;

    @ApiOperation(value = "获取种植服文化资讯列表分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<ZhfwCultureZxListListVo>> findPage(@RequestBody ZhfwCultureZxListPagePo zhfwCultureZxListPagePo) {
        return zhfwCultureZxListService.findPage(zhfwCultureZxListPagePo);
    }

    @ApiOperation(value = "获取种植服文化资讯列表列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<ZhfwCultureZxListListVo>> list(@RequestBody ZhfwCultureZxListListPo zhfwCultureZxListListPo) {
        return zhfwCultureZxListService.findList(zhfwCultureZxListListPo);
    }

    @ApiOperation(value = "查询种植服文化资讯列表")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<ZhfwCultureZxListGetVo> get(@RequestBody ZhfwCultureZxListGetPo zhfwCultureZxListGetPo) {
        return zhfwCultureZxListService.get(zhfwCultureZxListGetPo);
    }

    @ApiOperation(value = "新增种植服文化资讯列表")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody ZhfwCultureZxListInsertPo zhfwCultureZxListInsertPo) {
        return zhfwCultureZxListService.insert(zhfwCultureZxListInsertPo);
    }

    @ApiOperation(value = "修改种植服文化资讯列表")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody ZhfwCultureZxListUpdatePo zhfwCultureZxListUpdatePo) {
        return zhfwCultureZxListService.update(zhfwCultureZxListUpdatePo);
    }

    @ApiOperation(value = "批量删除种植服文化资讯列表")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody ZhfwCultureZxListBatDeletePo zhfwCultureZxListBatDeletePo) {
        return zhfwCultureZxListService.batDelete(zhfwCultureZxListBatDeletePo);
    }
}
