package com.wisea.cultivar.supply.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.entity.AuthInfo;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.supply.po.PwdBackPo;
import com.wisea.cultivar.supply.po.ValCodeLoginPo;
import com.wisea.cultivar.supply.service.SupplyAuthService;
import com.wisea.cultivar.supply.util.CustomUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 拓展用户相关
 * @author chengq
 * @date 2020/8/27 14:48
 */
@RestController
@RequestMapping("/auth")
@Api(tags = "拓展用户相关")
public class SupplyAuthController {

    @Resource
    private SupplyAuthService supplyAuthService;

    /**
     * 手机验证码登录
     */
    @PostMapping("valCodeLogin")
    @ApiOperation(value = "手机验证码登录")
    public ResultPoJo<AuthInfo> valCodeLogin(@RequestBody ValCodeLoginPo valCodeLoginPo, HttpServletRequest request) {
        return supplyAuthService.valCodeLogin(valCodeLoginPo, request);
    }

    /**
     * 找回用户密码
     */
    @DataCheck
    @ApiOperation(value = "找回用户密码")
    @PostMapping(value = "pwdBack/confirm")
    public ResultPoJo<Object> pwdBackConfirm(@RequestBody PwdBackPo pwdBackPo) {
        return supplyAuthService.pwdBackConfirm(pwdBackPo);
    }

    /**
     * 通过手机号查询用户手否存在
     */
    @ApiOperation(value = "通过手机号查询用户手否存在")
    @GetMapping(value = "get/user")
    public ResultPoJo<Object> pwdBackConfirm(String mobile) {
        supplyAuthService.checkUser(mobile);
        return CustomUtils.result();
    }

    /**
     * 验证手机号和用户名是否已经存在
     */
    @ApiOperation(value = "验证手机号否已经存在")
    @GetMapping(value = "check/mobile")
    public ResultPoJo<Object> checkMobile(String mobile) {
        supplyAuthService.checkMobile(mobile);
        return CustomUtils.result();
    }

    /**
     * 验证用户名否已经存在
     */
    @ApiOperation(value = "验证用户名否已经存在")
    @GetMapping(value = "check/name")
    public ResultPoJo<Object> checkLoginName(String loginName) {
        supplyAuthService.checkLoginName(loginName);
        return CustomUtils.result();
    }
}
