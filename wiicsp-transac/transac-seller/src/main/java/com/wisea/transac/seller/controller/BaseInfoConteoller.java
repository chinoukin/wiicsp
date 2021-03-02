package com.wisea.transac.seller.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.transac.common.po.seller.BaseInfoPo;
import com.wisea.transac.common.po.seller.BaseVrPo;
import com.wisea.transac.common.vo.seller.BaseInfoHomeVo;
import com.wisea.transac.common.vo.seller.BaseInfoVo;
import com.wisea.transac.seller.service.BaseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jirg
 * @version 1.0
 * @className BaseInfoConteoller
 * @date 2020/6/30 10:59
 * @Description 数字基地管理
 */
@RestController
@RequestMapping("/w/seller/base")
@Api(tags = "【数字基地】基地管理")
public class BaseInfoConteoller {

    @Autowired
    private BaseInfoService service;

    /**
     * @author jirg
     * @date 2020/7/3 14:21
     * @Description 查询基地首页信息
     */
    @DataCheck
    @RequestMapping(value = "/baseHome", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询基地首页信息", value = "查询基地首页信息", notes = "查询基地首页信息", httpMethod = "POST")
    public ResultPoJo<BaseInfoHomeVo> baseHome() {
        return service.baseHome();
    }

    /**
     * @author jirg
     * @date 2020/6/30 11:30
     * @Description 查询当前登录卖家基地信息
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询当前登录卖家基地信息", value = "查询当前登录卖家基地信息", notes = "查询当前登录卖家基地信息", httpMethod = "POST")
    public ResultPoJo<BaseInfoVo> findInfo() {
        return service.findInfo();
    }

    /**
     * @author jirg
     * @date 2020/6/30 14:28
     * @Description 修改基地信息
     */
    @DataCheck
    @RequestMapping(value = "/updateBase", method = RequestMethod.POST)
    @ApiOperation(nickname = "修改基地信息", value = "修改基地信息", notes = "修改基地信息", httpMethod = "POST")
    public ResultPoJo<?> updateBase(@RequestBody BaseInfoPo po) {
        return service.updateBase(po);
    }

    /**
     * @author jirg
     * @date 2020/6/30 14:28
     * @Description 设置基地720VR
     */
    @DataCheck
    @RequestMapping(value = "/setBaseVR", method = RequestMethod.POST)
    @ApiOperation(nickname = "设置基地720VR", value = "设置基地720VR", notes = "设置基地720VR", httpMethod = "POST")
    public ResultPoJo<?> setBaseVR(@RequestBody BaseVrPo po) {
        return service.setBaseVR(po);
    }

}
