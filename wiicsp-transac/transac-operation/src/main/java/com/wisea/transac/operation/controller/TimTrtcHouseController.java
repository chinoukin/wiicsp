package com.wisea.transac.operation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.transac.operation.po.TimTrtcHouseUpdatePo;
import com.wisea.transac.operation.service.TimTrtcHouseService;
import com.wisea.transac.operation.vo.TimTrtcHouseGetVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * TimTrtcHouseController 实时音视频房间表 Controller 2020/08/07 17:16:38
 */
@Api(tags = "实时音视频房间表相关接口")
@RequestMapping(value = "/w/TimTrtcHouse")
@RestController
public class TimTrtcHouseController {
    @Autowired
    protected TimTrtcHouseService timTrtcHouseService;
//
//    @ApiOperation(value = "获取实时音视频房间表分页列表")
//    @RequestMapping(value = "page", method = RequestMethod.POST)
//    @DataCheck
//    public ResultPoJo<Page<TimTrtcHouseListVo>> findPage(@RequestBody TimTrtcHousePagePo timTrtcHousePagePo) {
//        return timTrtcHouseService.findPage(timTrtcHousePagePo);
//    }
//
//    @ApiOperation(value = "获取实时音视频房间表列表")
//    @RequestMapping(value = "list", method = RequestMethod.POST)
//    @DataCheck
//    public ResultPoJo<List<TimTrtcHouseListVo>> list(@RequestBody TimTrtcHouseListPo timTrtcHouseListPo) {
//        return timTrtcHouseService.findList(timTrtcHouseListPo);
//    }
//
//    @ApiOperation(value = "查询实时音视频房间表")
//    @RequestMapping(value = "get", method = RequestMethod.POST)
//    @DataCheck
//    public ResultPoJo<TimTrtcHouseGetVo> get(@RequestBody TimTrtcHouseGetPo timTrtcHouseGetPo) {
//        return timTrtcHouseService.get(timTrtcHouseGetPo);
//    }

    @ApiOperation(value = "分配实时音视频房间", notes = "为当前登录用户自动分配一个音视频房间并进入(创建房间者不用手动进入房间)")
    @RequestMapping(value = "dispath", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<TimTrtcHouseGetVo> dispath() {
        return timTrtcHouseService.dispath();
    }

    @ApiOperation(value = "进入实时音视频房间", notes = "当前登录用户进入某个实时音视频房间")
    @RequestMapping(value = "join", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> join(@RequestBody TimTrtcHouseUpdatePo timTrtcHouseUpdatePo) {
        return timTrtcHouseService.join(timTrtcHouseUpdatePo);
    }

    @ApiOperation(value = "离开实时音视频房间", notes = "当前登录用户离开某个实时音视频房间")
    @RequestMapping(value = "leave", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> leave(@RequestBody TimTrtcHouseUpdatePo timTrtcHouseUpdatePo) {
        return timTrtcHouseService.leave(timTrtcHouseUpdatePo);
    }
}
