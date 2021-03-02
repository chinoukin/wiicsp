package com.wisea.cultivar.infomanage.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.common.entity.DeadLineMage;
import com.wisea.cultivar.common.po.system.DeadLineInsertPo;
import com.wisea.cultivar.infomanage.service.DeadLineMageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author jirg
 * @Date 2020/4/30 15:41
 * @Description
 **/
@Api(tags = "【后台设置】期限时间管理")
@RestController
@PreAuthorize("hasAuthority('im:dla')")
@RequestMapping("/w/set/buyer/dead_line")
public class DeadLineMageController {

    @Autowired
    private DeadLineMageService service;

    @DataCheck
    @PostMapping("/findAll")
    @ApiOperation(nickname = "查询所有期限设置", value = "【后台设置】查询所有期限设置", notes = "查询所有期限设置", httpMethod = "POST")
    public ResultPoJo<List<DeadLineMage>> findAllDeadLine() {
        return service.findAllDeadLine();
    }

    /**
     * @Author jirg
     * @Date 2020/4/30 16:24
     * @Description 保存期限设置
     **/
    @DataCheck
    @PostMapping("/saveDeadLines")
    @ApiOperation(nickname = "保存期限设置", value = "【后台设置】保存期限设置", notes = "保存期限设置", httpMethod = "POST")
    public ResultPoJo saveDeadLines(@RequestBody DeadLineInsertPo po) {
        return service.saveDeadLines(po);
    }
}
