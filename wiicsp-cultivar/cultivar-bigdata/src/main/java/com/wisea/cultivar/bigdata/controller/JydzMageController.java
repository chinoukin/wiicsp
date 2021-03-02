package com.wisea.cultivar.bigdata.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.common.po.bigdata.JydzMageUpdatePo;
import com.wisea.cultivar.common.po.bigdata.JydzReloadAccumulatePo;
import com.wisea.cultivar.bigdata.service.JydzMageService;
import com.wisea.cultivar.common.vo.bigdata.JydzMageListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * JydzMageController
 * 交易递增配置 Controller
 * 2019/12/02 14:39:38
 */
@Api(tags = "交易递增配置相关接口")
@RequestMapping(value = "/w/jydzMage")
@RestController
public class JydzMageController {
   /* @Autowired
    protected JydzMageService jydzMageService;

    @ApiOperation(value = "获取交易递增配置")
    @RequestMapping(value = "getJydzMage", method = RequestMethod.POST)
    public ResultPoJo<JydzMageListVo> getJydzMage() {
        return jydzMageService.getJydzMage();
    }

    @ApiOperation(value ="新增/修改交易递增配置")
    @RequestMapping(value = "saveOrUpdate", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> saveOrUpdate(@RequestBody JydzMageUpdatePo jydzMageUpdatePo) {
        return jydzMageService.saveOrUpdate(jydzMageUpdatePo);
    }

    @ApiOperation(value ="重新累计")
    @RequestMapping(value = "reloadAccumulate", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> reloadAccumulate(@RequestBody JydzReloadAccumulatePo po) {
        return jydzMageService.reloadAccumulate(po);
    }*/
}
