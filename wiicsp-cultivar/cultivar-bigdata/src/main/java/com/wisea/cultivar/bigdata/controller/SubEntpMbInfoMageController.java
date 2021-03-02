package com.wisea.cultivar.bigdata.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.bigdata.service.SubEntpMbInfoMageService;
import com.wisea.cultivar.common.po.bigdata.SubEntpMbInfoMageBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.SubEntpMbInfoMageGetPo;
import com.wisea.cultivar.common.po.bigdata.SubEntpMbInfoMageInsertPo;
import com.wisea.cultivar.common.po.bigdata.SubEntpMbInfoMageListPo;
import com.wisea.cultivar.common.po.bigdata.SubEntpMbInfoMagePagePo;
import com.wisea.cultivar.common.po.bigdata.SubEntpMbInfoMageUpdatePo;
import com.wisea.cultivar.common.vo.bigdata.SubEntpMbInfoMageGetVo;
import com.wisea.cultivar.common.vo.bigdata.SubEntpMbInfoMageListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * SubEntpMbInfoMageController
 * 分公司目标信息维护 Controller
 * 2019/12/02 11:02:15
 */
@Api(tags = "分公司目标信息维护相关接口")
@RequestMapping(value = "/w/subEntpMbInfoMage")
@RestController
public class SubEntpMbInfoMageController {
    @Autowired
    protected SubEntpMbInfoMageService subEntpMbInfoMageService;

    @ApiOperation(value = "获取分公司目标信息维护分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<SubEntpMbInfoMageListVo>> findPage(@RequestBody SubEntpMbInfoMagePagePo subEntpMbInfoMagePagePo) {
        return subEntpMbInfoMageService.findPage(subEntpMbInfoMagePagePo);
    }

    @ApiOperation(value = "获取分公司目标信息维护列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<SubEntpMbInfoMageListVo>> list(@RequestBody SubEntpMbInfoMageListPo subEntpMbInfoMageListPo) {
        return subEntpMbInfoMageService.findList(subEntpMbInfoMageListPo);
    }

    @ApiOperation(value = "查询分公司目标信息维护")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<SubEntpMbInfoMageGetVo> get(@RequestBody SubEntpMbInfoMageGetPo subEntpMbInfoMageGetPo) {
        return subEntpMbInfoMageService.get(subEntpMbInfoMageGetPo);
    }

    @ApiOperation(value = "查询分公司目标信息维护根据分公司id or 年份")
    @RequestMapping(value = "getById", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<SubEntpMbInfoMageGetVo> getById(@RequestBody SubEntpMbInfoMageGetPo subEntpMbInfoMageGetPo) {
    	return subEntpMbInfoMageService.getById(subEntpMbInfoMageGetPo);
    }

    @ApiOperation(value = "新增分公司目标信息维护")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody SubEntpMbInfoMageInsertPo subEntpMbInfoMageInsertPo) {
        return subEntpMbInfoMageService.insert(subEntpMbInfoMageInsertPo);
    }

    @ApiOperation(value = "修改分公司目标信息维护")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody SubEntpMbInfoMageUpdatePo subEntpMbInfoMageUpdatePo) {
        return subEntpMbInfoMageService.update(subEntpMbInfoMageUpdatePo);
    }

    @ApiOperation(value = "添加修改分公司目标信息维护")
    @RequestMapping(value = "saveOrupd", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> saveOrUpdate(@RequestBody SubEntpMbInfoMageUpdatePo subEntpMbInfoMageUpdatePo) {
    	return subEntpMbInfoMageService.saveOrupd(subEntpMbInfoMageUpdatePo);
    }

    @ApiOperation(value = "批量删除分公司目标信息维护")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody SubEntpMbInfoMageBatDeletePo subEntpMbInfoMageBatDeletePo) {
        return subEntpMbInfoMageService.batDelete(subEntpMbInfoMageBatDeletePo);
    }
}
