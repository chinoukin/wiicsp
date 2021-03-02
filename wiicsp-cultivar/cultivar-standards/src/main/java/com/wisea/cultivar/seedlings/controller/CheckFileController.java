package com.wisea.cultivar.seedlings.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.seedlings.po.CheckFileBatDeletePo;
import com.wisea.cultivar.seedlings.po.CheckFileGetPo;
import com.wisea.cultivar.seedlings.po.CheckFileInsertPo;
import com.wisea.cultivar.seedlings.po.CheckFileListPo;
import com.wisea.cultivar.seedlings.po.CheckFilePagePo;
import com.wisea.cultivar.seedlings.po.CheckFileUpdatePo;
import com.wisea.cultivar.seedlings.service.CheckFileService;
import com.wisea.cultivar.seedlings.vo.CheckFileGetVo;
import com.wisea.cultivar.seedlings.vo.CheckFileListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * CheckFileController
 * 验收材料 Controller
 * 2020/08/06 14:19:24
 */
@Api(tags = "验收材料相关接口")
@RequestMapping(value = "/w/CheckFile")
@RestController
public class CheckFileController {
    @Autowired
    protected CheckFileService checkFileService;

    @ApiOperation(value = "获取验收材料分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<CheckFileListVo>> findPage(@RequestBody CheckFilePagePo checkFilePagePo) {
        return checkFileService.findPage(checkFilePagePo);
    }

    @ApiOperation(value = "获取验收材料列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<CheckFileListVo>> list(@RequestBody CheckFileListPo checkFileListPo) {
        return checkFileService.findList(checkFileListPo);
    }

    @ApiOperation(value = "查询验收材料")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<CheckFileGetVo> get(@RequestBody CheckFileGetPo checkFileGetPo) {
        return checkFileService.get(checkFileGetPo);
    }

    @ApiOperation(value = "新增验收材料")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody CheckFileInsertPo checkFileInsertPo) {
        return checkFileService.insert(checkFileInsertPo);
    }

    @ApiOperation(value = "修改验收材料")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody CheckFileUpdatePo checkFileUpdatePo) {
        return checkFileService.update(checkFileUpdatePo);
    }

    @ApiOperation(value = "批量删除验收材料")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody CheckFileBatDeletePo checkFileBatDeletePo) {
        return checkFileService.batDelete(checkFileBatDeletePo);
    }
}
