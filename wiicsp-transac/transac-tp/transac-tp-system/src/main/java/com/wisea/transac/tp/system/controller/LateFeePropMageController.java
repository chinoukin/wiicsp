package com.wisea.transac.tp.system.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.transac.common.entity.LateFeePropMage;
import com.wisea.transac.tp.system.service.LateFeePropMageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jirg
 * @version 1.0
 * @className LateFeeMageController
 * @date 2019/8/21 11:23
 * @Description 账期滞纳金设置Controller
 */
@Api(tags = "【后台设置】账期滞纳金设置")
@RestController
@RequestMapping("/w/set/lateFeeMage")
public class LateFeePropMageController {
    @Autowired
    private LateFeePropMageService service;

    /**
     * @Author jirg
     * @Date 2019/8/21 14:58
     * @Description 获取滞纳金设置
     **/
    @PostMapping("/getLateFeeMage")
    @ApiOperation(nickname = "获取账期滞纳金设置", value = "获取账期滞纳金设置", notes = "获取账期滞纳金设置")
    public ResultPoJo<LateFeePropMage> getLateFeeMage() {
        return service.getLateFeeMage();
    }

    /**
     * @Author jirg
     * @Date 2019/8/21 14:58
     * @Description 设置滞纳金比例
     **/
    @DataCheck
    @PostMapping("/saveOrUpdate")
    @ApiOperation(nickname = "设置滞纳金比例", value = "设置滞纳金比例", notes = "设置滞纳金比例")
    public ResultPoJo<?> saveOrUpdate(@RequestBody LateFeePropMage po) {
        return service.saveOrUpdate(po);
    }

}
