package com.wisea.cultivar.infomanage.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.infomanage.po.*;
import com.wisea.cultivar.infomanage.service.KnowledgeBaseMageService;
import com.wisea.cultivar.infomanage.vo.KnowledgeBaseMageGetVo;
import com.wisea.cultivar.infomanage.vo.KnowledgeBaseMageListVo;
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
 * KnowledgeBaseMageController
 * 知识库管理 Controller
 * 2020/08/05 09:31:34
 */
@Api(tags = "知识库管理相关接口")
@RequestMapping(value = "/w/KnowledgeBaseMage")
@PreAuthorize("hasAuthority('im:knw')")
@RestController
public class KnowledgeBaseMageController {
    @Autowired
    protected KnowledgeBaseMageService knowledgeBaseMageService;

    @ApiOperation(value = "获取知识库管理分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<KnowledgeBaseMageListVo>> findPage(@RequestBody KnowledgeBaseMagePagePo knowledgeBaseMagePagePo) {
        return knowledgeBaseMageService.findPage(knowledgeBaseMagePagePo);
    }

    @ApiOperation(value = "获取知识库管理列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<KnowledgeBaseMageListVo>> list(@RequestBody KnowledgeBaseMageListPo knowledgeBaseMageListPo) {
        return knowledgeBaseMageService.findList(knowledgeBaseMageListPo);
    }

    @ApiOperation(value = "查询知识库管理")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<KnowledgeBaseMageGetVo> get(@RequestBody KnowledgeBaseMageGetPo knowledgeBaseMageGetPo) {
        return knowledgeBaseMageService.get(knowledgeBaseMageGetPo);
    }

    @ApiOperation(value = "新增知识库管理")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody KnowledgeBaseMageInsertPo knowledgeBaseMageInsertPo) {
        return knowledgeBaseMageService.insert(knowledgeBaseMageInsertPo);
    }

    @ApiOperation(value = "修改知识库管理")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody KnowledgeBaseMageUpdatePo knowledgeBaseMageUpdatePo) {
        return knowledgeBaseMageService.update(knowledgeBaseMageUpdatePo);
    }

    @ApiOperation(value = "批量删除知识库管理")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody KnowledgeBaseMageBatDeletePo knowledgeBaseMageBatDeletePo) {
        return knowledgeBaseMageService.batDelete(knowledgeBaseMageBatDeletePo);
    }

    @ApiOperation(value = "是否显示")
    @RequestMapping(value = "status", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> status(@RequestBody KnowledgeBaseMageStatus po) {

        return knowledgeBaseMageService.status(po);
    }
}
