package com.wisea.cultivar.plant.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.plant.po.MembMomentsLimitsMagePageListPo;
import com.wisea.cultivar.plant.po.MembMomentsLimitsMagePo;
import com.wisea.cultivar.plant.vo.MembMomentsLimitsMageInfoVo;
import com.wisea.cultivar.plant.service.MembMomentsLimitsMageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className MembMomentsLimitsMageController
 * @date 2020/08/06 18:28:39
 * @Description
 */
@RestController
@RequestMapping("/w/membMomentsLimitsMage")
@Api(tags = "圈子权限设置")
public class MembMomentsLimitsMageController {
    @Autowired
    private MembMomentsLimitsMageService service;

    @DataCheck
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询圈子权限信息", value = "查询圈子权限信息", notes = "查询圈子权限信息", httpMethod = "POST")
    public ResultPoJo<List<MembMomentsLimitsMageInfoVo>> find(@RequestBody MembMomentsLimitsMagePageListPo po) {
        return service.findMembMomentsLimits(po);
    }

    @DataCheck
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(nickname = "设置圈子权限信息", value = "设置圈子权限信息", notes = "设置圈子权限信息", httpMethod = "POST")
    public ResultPoJo update(@RequestBody MembMomentsLimitsMagePo po) {
        return service.update(po);
    }

}
