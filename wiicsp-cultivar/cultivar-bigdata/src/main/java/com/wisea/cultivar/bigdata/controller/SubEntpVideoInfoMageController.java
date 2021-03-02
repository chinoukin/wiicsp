package com.wisea.cultivar.bigdata.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.bigdata.service.SubEntpVideoInfoMageService;
import com.wisea.cultivar.common.po.bigdata.SubEntpVideoInfoMageBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.SubEntpVideoInfoMageGetPo;
import com.wisea.cultivar.common.po.bigdata.SubEntpVideoInfoMageInsertPo;
import com.wisea.cultivar.common.po.bigdata.SubEntpVideoInfoMageListPo;
import com.wisea.cultivar.common.po.bigdata.SubEntpVideoInfoMagePagePo;
import com.wisea.cultivar.common.po.bigdata.SubEntpVideoInfoMageUpdatePo;
import com.wisea.cultivar.common.vo.bigdata.HTSubEntpVideoInfoMageListVo;
import com.wisea.cultivar.common.vo.bigdata.SubEntpVideoInfoMageGetVo;
import com.wisea.cultivar.common.vo.bigdata.SubEntpVideoInfoMageListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * SubEntpVideoInfoMageController
 * 分公司视频信息维护 Controller
 * 2019/12/02 11:02:15
 */
@Api(tags = "分公司视频信息维护相关接口")
@RequestMapping(value = "/w/subEntpVideoInfoMage")
@RestController
public class SubEntpVideoInfoMageController {
    @Autowired
    protected SubEntpVideoInfoMageService subEntpVideoInfoMageService;

    @ApiOperation(value = "获取分公司视频信息维护分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<SubEntpVideoInfoMageListVo>> findPage(@RequestBody SubEntpVideoInfoMagePagePo subEntpVideoInfoMagePagePo) {
        return subEntpVideoInfoMageService.findPage(subEntpVideoInfoMagePagePo);
    }

    @ApiOperation(value = "后台获取分公司视频信息维护列表")
    @RequestMapping(value = "htPage", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<HTSubEntpVideoInfoMageListVo> htPage(@RequestBody SubEntpVideoInfoMagePagePo subEntpVideoInfoMagePagePo) {
    	return subEntpVideoInfoMageService.findHTPage(subEntpVideoInfoMagePagePo);
    }

    @ApiOperation(value = "获取分公司视频信息维护列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<SubEntpVideoInfoMageListVo>> list(@RequestBody SubEntpVideoInfoMageListPo subEntpVideoInfoMageListPo) {
        return subEntpVideoInfoMageService.findList(subEntpVideoInfoMageListPo);
    }

    @ApiOperation(value = "查询分公司视频信息维护")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<SubEntpVideoInfoMageGetVo> get(@RequestBody SubEntpVideoInfoMageGetPo subEntpVideoInfoMageGetPo) {
        return subEntpVideoInfoMageService.get(subEntpVideoInfoMageGetPo);
    }

    @ApiOperation(value = "新增分公司视频信息维护")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody SubEntpVideoInfoMageInsertPo subEntpVideoInfoMageInsertPo) {
        return subEntpVideoInfoMageService.insert(subEntpVideoInfoMageInsertPo);
    }

    @ApiOperation(value = "修改分公司视频信息维护")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody SubEntpVideoInfoMageUpdatePo subEntpVideoInfoMageUpdatePo) {
        return subEntpVideoInfoMageService.update(subEntpVideoInfoMageUpdatePo);
    }

    @ApiOperation(value = "批量删除分公司视频信息维护")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody SubEntpVideoInfoMageBatDeletePo subEntpVideoInfoMageBatDeletePo) {
        return subEntpVideoInfoMageService.batDelete(subEntpVideoInfoMageBatDeletePo);
    }
}
