package com.wisea.cultivar.portal.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.portal.po.ZhfwFinSerApplRecordBatDeletePo;
import com.wisea.cultivar.portal.po.ZhfwFinSerApplRecordGetPo;
import com.wisea.cultivar.portal.po.ZhfwFinSerApplRecordInsertPo;
import com.wisea.cultivar.portal.po.ZhfwFinSerApplRecordListPo;
import com.wisea.cultivar.portal.po.ZhfwFinSerApplRecordPagePo;
import com.wisea.cultivar.portal.po.ZhfwFinSerApplRecordUpdatePo;
import com.wisea.cultivar.portal.service.ZhfwFinSerApplRecordService;
import com.wisea.cultivar.portal.vo.ZhfwFinSerApplRecordGetVo;
import com.wisea.cultivar.portal.vo.ZhfwFinSerApplRecordListVo;
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
 * ZhfwFinSerApplRecordController
 * 种植服务金融服务申请记录 Controller
 * 2020/08/24 20:28:13
 */
@Api(tags = "种植服务金融服务申请记录相关接口")
@RequestMapping(value = "/w/ZhfwFinSerApplRecord")
@RestController
@PreAuthorize("hasAuthority('pt:fls')")
public class ZhfwFinSerApplRecordController {
    @Autowired
    protected ZhfwFinSerApplRecordService zhfwFinSerApplRecordService;

    @ApiOperation(value = "获取种植服务金融服务申请记录分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<ZhfwFinSerApplRecordListVo>> findPage(@RequestBody ZhfwFinSerApplRecordPagePo zhfwFinSerApplRecordPagePo) {
        return zhfwFinSerApplRecordService.findPage(zhfwFinSerApplRecordPagePo);
    }

    @ApiOperation(value = "获取种植服务金融服务申请记录列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<ZhfwFinSerApplRecordListVo>> list(@RequestBody ZhfwFinSerApplRecordListPo zhfwFinSerApplRecordListPo) {
        return zhfwFinSerApplRecordService.findList(zhfwFinSerApplRecordListPo);
    }

    @ApiOperation(value = "查询种植服务金融服务申请记录")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<ZhfwFinSerApplRecordGetVo> get(@RequestBody ZhfwFinSerApplRecordGetPo zhfwFinSerApplRecordGetPo) {
        return zhfwFinSerApplRecordService.get(zhfwFinSerApplRecordGetPo);
    }

    @ApiOperation(value = "新增种植服务金融服务申请记录")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody ZhfwFinSerApplRecordInsertPo zhfwFinSerApplRecordInsertPo) {
        return zhfwFinSerApplRecordService.insert(zhfwFinSerApplRecordInsertPo);
    }

    @ApiOperation(value = "修改种植服务金融服务申请记录")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody ZhfwFinSerApplRecordUpdatePo zhfwFinSerApplRecordUpdatePo) {
        return zhfwFinSerApplRecordService.update(zhfwFinSerApplRecordUpdatePo);
    }

    @ApiOperation(value = "批量删除种植服务金融服务申请记录")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody ZhfwFinSerApplRecordBatDeletePo zhfwFinSerApplRecordBatDeletePo) {
        return zhfwFinSerApplRecordService.batDelete(zhfwFinSerApplRecordBatDeletePo);
    }
}
