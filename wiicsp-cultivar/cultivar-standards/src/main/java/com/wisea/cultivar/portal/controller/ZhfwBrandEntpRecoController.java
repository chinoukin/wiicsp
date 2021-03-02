package com.wisea.cultivar.portal.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.portal.po.ZhfwBrandEntpRecoBatDeletePo;
import com.wisea.cultivar.portal.po.ZhfwBrandEntpRecoGetPo;
import com.wisea.cultivar.portal.po.ZhfwBrandEntpRecoInsertPo;
import com.wisea.cultivar.portal.po.ZhfwBrandEntpRecoListPo;
import com.wisea.cultivar.portal.po.ZhfwBrandEntpRecoPagePo;
import com.wisea.cultivar.portal.po.ZhfwBrandEntpRecoUpdatePo;
import com.wisea.cultivar.portal.service.ZhfwBrandEntpRecoService;
import com.wisea.cultivar.portal.vo.ZhfwBrandEntpRecoGetVo;
import com.wisea.cultivar.portal.vo.ZhfwBrandEntpRecoListVo;
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
 * ZhfwBrandEntpRecoController
 * 种植服务品牌企业推荐 Controller
 * 2020/08/24 20:28:13
 */
@Api(tags = "种植服务品牌企业推荐相关接口")
@RequestMapping(value = "/w/ZhfwBrandEntpReco")
@PreAuthorize("hasAuthority('pt:bep')")
@RestController
public class ZhfwBrandEntpRecoController {
    @Autowired
    protected ZhfwBrandEntpRecoService zhfwBrandEntpRecoService;

    @ApiOperation(value = "获取种植服务品牌企业推荐分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<ZhfwBrandEntpRecoListVo>> findPage(@RequestBody ZhfwBrandEntpRecoPagePo zhfwBrandEntpRecoPagePo) {
        return zhfwBrandEntpRecoService.findPage(zhfwBrandEntpRecoPagePo);
    }

    @ApiOperation(value = "获取种植服务品牌企业推荐列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<ZhfwBrandEntpRecoListVo>> list(@RequestBody ZhfwBrandEntpRecoListPo zhfwBrandEntpRecoListPo) {
        return zhfwBrandEntpRecoService.findList(zhfwBrandEntpRecoListPo);
    }

    @ApiOperation(value = "查询种植服务品牌企业推荐")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<ZhfwBrandEntpRecoGetVo> get(@RequestBody ZhfwBrandEntpRecoGetPo zhfwBrandEntpRecoGetPo) {
        return zhfwBrandEntpRecoService.get(zhfwBrandEntpRecoGetPo);
    }

    @ApiOperation(value = "新增种植服务品牌企业推荐")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody ZhfwBrandEntpRecoInsertPo zhfwBrandEntpRecoInsertPo) {
        return zhfwBrandEntpRecoService.insert(zhfwBrandEntpRecoInsertPo);
    }

    @ApiOperation(value = "修改种植服务品牌企业推荐")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody ZhfwBrandEntpRecoUpdatePo zhfwBrandEntpRecoUpdatePo) {
        return zhfwBrandEntpRecoService.update(zhfwBrandEntpRecoUpdatePo);
    }

    @ApiOperation(value = "批量删除种植服务品牌企业推荐")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody ZhfwBrandEntpRecoBatDeletePo zhfwBrandEntpRecoBatDeletePo) {
        return zhfwBrandEntpRecoService.batDelete(zhfwBrandEntpRecoBatDeletePo);
    }
}
