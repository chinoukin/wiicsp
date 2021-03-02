package com.wisea.cultivar.portal.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.portal.po.ZhfwCultureZxRecoBatDeletePo;
import com.wisea.cultivar.portal.po.ZhfwCultureZxRecoGetPo;
import com.wisea.cultivar.portal.po.ZhfwCultureZxRecoInsertPo;
import com.wisea.cultivar.portal.po.ZhfwCultureZxRecoListPo;
import com.wisea.cultivar.portal.po.ZhfwCultureZxRecoPagePo;
import com.wisea.cultivar.portal.po.ZhfwCultureZxRecoUpdatePo;
import com.wisea.cultivar.portal.service.ZhfwCultureZxRecoService;
import com.wisea.cultivar.portal.vo.ZhfwCultureZxRecoGetVo;
import com.wisea.cultivar.portal.vo.ZhfwCultureZxRecoListVo;
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
 * ZhfwCultureZxRecoController
 * 种植服务文化资讯推荐 Controller
 * 2020/08/24 20:28:13
 */
@Api(tags = "种植服务文化资讯推荐相关接口")
@RequestMapping(value = "/w/ZhfwCultureZxReco")
@RestController
@PreAuthorize("hasAuthority('pt:clr')")
public class ZhfwCultureZxRecoController {
    @Autowired
    protected ZhfwCultureZxRecoService zhfwCultureZxRecoService;

    @ApiOperation(value = "获取种植服务文化资讯推荐分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<ZhfwCultureZxRecoListVo>> findPage(@RequestBody ZhfwCultureZxRecoPagePo zhfwCultureZxRecoPagePo) {
        return zhfwCultureZxRecoService.findPage(zhfwCultureZxRecoPagePo);
    }

    @ApiOperation(value = "获取种植服务文化资讯推荐列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<ZhfwCultureZxRecoListVo>> list(@RequestBody ZhfwCultureZxRecoListPo zhfwCultureZxRecoListPo) {
        return zhfwCultureZxRecoService.findList(zhfwCultureZxRecoListPo);
    }

    @ApiOperation(value = "查询种植服务文化资讯推荐")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<ZhfwCultureZxRecoGetVo> get(@RequestBody ZhfwCultureZxRecoGetPo zhfwCultureZxRecoGetPo) {
        return zhfwCultureZxRecoService.get(zhfwCultureZxRecoGetPo);
    }

    @ApiOperation(value = "新增种植服务文化资讯推荐")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody ZhfwCultureZxRecoInsertPo zhfwCultureZxRecoInsertPo) {
        return zhfwCultureZxRecoService.insert(zhfwCultureZxRecoInsertPo);
    }

    @ApiOperation(value = "修改种植服务文化资讯推荐")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody ZhfwCultureZxRecoUpdatePo zhfwCultureZxRecoUpdatePo) {
        return zhfwCultureZxRecoService.update(zhfwCultureZxRecoUpdatePo);
    }

    @ApiOperation(value = "批量删除种植服务文化资讯推荐")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody ZhfwCultureZxRecoBatDeletePo zhfwCultureZxRecoBatDeletePo) {
        return zhfwCultureZxRecoService.batDelete(zhfwCultureZxRecoBatDeletePo);
    }
}
