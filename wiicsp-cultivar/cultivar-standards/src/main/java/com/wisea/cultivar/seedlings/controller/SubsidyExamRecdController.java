package com.wisea.cultivar.seedlings.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.seedlings.po.SubsidyExamRecdBatDeletePo;
import com.wisea.cultivar.seedlings.po.SubsidyExamRecdGetPo;
import com.wisea.cultivar.seedlings.po.SubsidyExamRecdInsertPo;
import com.wisea.cultivar.seedlings.po.SubsidyExamRecdListPo;
import com.wisea.cultivar.seedlings.po.SubsidyExamRecdPagePo;
import com.wisea.cultivar.seedlings.po.SubsidyExamRecdUpdatePo;
import com.wisea.cultivar.seedlings.service.SubsidyExamRecdService;
import com.wisea.cultivar.seedlings.vo.SubsidyExamRecdGetVo;
import com.wisea.cultivar.seedlings.vo.SubsidyExamRecdListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * SubsidyExamRecdController
 * 补贴审核记录 Controller
 * 2020/08/06 14:19:24
 */
@Api(tags = "补贴审核记录相关接口")
@RequestMapping(value = "/w/SubsidyExamRecd")
@RestController
public class SubsidyExamRecdController {
    @Autowired
    protected SubsidyExamRecdService subsidyExamRecdService;

    @ApiOperation(value = "获取补贴审核记录分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<SubsidyExamRecdListVo>> findPage(@RequestBody SubsidyExamRecdPagePo subsidyExamRecdPagePo) {
        return subsidyExamRecdService.findPage(subsidyExamRecdPagePo);
    }

    @ApiOperation(value = "获取补贴审核记录列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<SubsidyExamRecdListVo>> list(@RequestBody SubsidyExamRecdListPo subsidyExamRecdListPo) {
        return subsidyExamRecdService.findList(subsidyExamRecdListPo);
    }

    @ApiOperation(value = "查询补贴审核记录")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<SubsidyExamRecdGetVo> get(@RequestBody SubsidyExamRecdGetPo subsidyExamRecdGetPo) {
        return subsidyExamRecdService.get(subsidyExamRecdGetPo);
    }

    @ApiOperation(value = "新增补贴审核记录")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody SubsidyExamRecdInsertPo subsidyExamRecdInsertPo) {
        return subsidyExamRecdService.insert(subsidyExamRecdInsertPo);
    }

    @ApiOperation(value = "修改补贴审核记录")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody SubsidyExamRecdUpdatePo subsidyExamRecdUpdatePo) {
        return subsidyExamRecdService.update(subsidyExamRecdUpdatePo);
    }

    @ApiOperation(value = "批量删除补贴审核记录")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody SubsidyExamRecdBatDeletePo subsidyExamRecdBatDeletePo) {
        return subsidyExamRecdService.batDelete(subsidyExamRecdBatDeletePo);
    }
}
