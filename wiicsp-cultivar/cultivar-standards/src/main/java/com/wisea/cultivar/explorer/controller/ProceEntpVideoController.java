package com.wisea.cultivar.explorer.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.explorer.po.ProceEntpVideoBatDeletePo;
import com.wisea.cultivar.explorer.po.ProceEntpVideoGetPo;
import com.wisea.cultivar.explorer.po.ProceEntpVideoInsertPo;
import com.wisea.cultivar.explorer.po.ProceEntpVideoListPo;
import com.wisea.cultivar.explorer.po.ProceEntpVideoPagePo;
import com.wisea.cultivar.explorer.po.ProceEntpVideoUpdatePo;
import com.wisea.cultivar.explorer.service.ProceEntpVideoService;
import com.wisea.cultivar.explorer.vo.ProceEntpVideoGetVo;
import com.wisea.cultivar.explorer.vo.ProceEntpVideoListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProceEntpVideoController
 * 加工企业视频 Controller
 * 2020/08/27 13:47:43
 */
@Api(tags = "加工企业视频相关接口")
@RequestMapping(value = "/w/ProceEntpVideo")
@RestController
@PreAuthorize("hasAuthority('ep:prc')")
public class ProceEntpVideoController {
    @Autowired
    protected ProceEntpVideoService proceEntpVideoService;

    @ApiOperation(value = "获取加工企业视频分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<HashMap<String,Object>> findPage(@RequestBody ProceEntpVideoPagePo proceEntpVideoPagePo) {
        return proceEntpVideoService.findPage(proceEntpVideoPagePo);
    }

    @ApiOperation(value = "获取加工企业视频列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<ProceEntpVideoListVo>> list(@RequestBody ProceEntpVideoListPo proceEntpVideoListPo) {
        return proceEntpVideoService.findList(proceEntpVideoListPo);
    }

    @ApiOperation(value = "查询加工企业视频")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<ProceEntpVideoGetVo> get(@RequestBody ProceEntpVideoGetPo proceEntpVideoGetPo) {
        return proceEntpVideoService.get(proceEntpVideoGetPo);
    }

    @ApiOperation(value = "新增加工企业视频")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody ProceEntpVideoInsertPo proceEntpVideoInsertPo) {
        return proceEntpVideoService.insert(proceEntpVideoInsertPo);
    }

    @ApiOperation(value = "修改加工企业视频")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody ProceEntpVideoUpdatePo proceEntpVideoUpdatePo) {
        return proceEntpVideoService.update(proceEntpVideoUpdatePo);
    }

    @ApiOperation(value = "批量删除加工企业视频")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody ProceEntpVideoBatDeletePo proceEntpVideoBatDeletePo) {
        return proceEntpVideoService.batDelete(proceEntpVideoBatDeletePo);
    }
}
