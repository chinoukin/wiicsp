package com.wisea.cultivar.explorer.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.explorer.po.MainBusinessMassifBatDeletePo;
import com.wisea.cultivar.explorer.po.MainBusinessMassifGetPo;
import com.wisea.cultivar.explorer.po.MainBusinessMassifInsertPo;
import com.wisea.cultivar.explorer.po.MainBusinessMassifListPo;
import com.wisea.cultivar.explorer.po.MainBusinessMassifPagePo;
import com.wisea.cultivar.explorer.po.MainBusinessMassifUpdatePo;
import com.wisea.cultivar.explorer.service.MainBusinessMassifService;
import com.wisea.cultivar.explorer.vo.MainBusinessMassifGetVo;
import com.wisea.cultivar.explorer.vo.MainBusinessMassifListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * MainBusinessMassifController
 * 主体地块信息 Controller
 * 2020/08/24 20:19:05
 */
@Api(tags = "主体地块信息相关接口")
@RequestMapping(value = "/w/MainBusinessMassif")
@RestController
public class MainBusinessMassifController {
    @Autowired
    protected MainBusinessMassifService mainBusinessMassifService;
    @ApiOperation(value = "获取主体地块信息分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<MainBusinessMassifListVo>> findPage(@RequestBody MainBusinessMassifPagePo mainBusinessMassifPagePo) {
        return mainBusinessMassifService.findPage(mainBusinessMassifPagePo);
    }

    @ApiOperation(value = "获取主体地块信息列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<MainBusinessMassifListVo>> list(@RequestBody MainBusinessMassifListPo mainBusinessMassifListPo) {
        return mainBusinessMassifService.findList(mainBusinessMassifListPo);
    }

    @ApiOperation(value = "查询主体地块信息")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<MainBusinessMassifGetVo> get(@RequestBody MainBusinessMassifGetPo mainBusinessMassifGetPo) {
        return mainBusinessMassifService.get(mainBusinessMassifGetPo);
    }

    @ApiOperation(value = "新增主体地块信息")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody MainBusinessMassifInsertPo mainBusinessMassifInsertPo) {
        return mainBusinessMassifService.insert(mainBusinessMassifInsertPo);
    }

    @ApiOperation(value = "修改主体地块信息")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody MainBusinessMassifUpdatePo mainBusinessMassifUpdatePo) {
        return mainBusinessMassifService.update(mainBusinessMassifUpdatePo);
    }

    @ApiOperation(value = "批量删除主体地块信息")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody MainBusinessMassifBatDeletePo mainBusinessMassifBatDeletePo) {
        return mainBusinessMassifService.batDelete(mainBusinessMassifBatDeletePo);
    }

    @ApiOperation(value = "通过种植主体ID批量删除主体地块信息")
    @RequestMapping(value = "deleteEntpInfoId", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> deleteEntpInfoId(@RequestBody MainBusinessMassifBatDeletePo mainBusinessMassifBatDeletePo) {
        return mainBusinessMassifService.deleteEntpInfoId(mainBusinessMassifBatDeletePo);
    }
}
