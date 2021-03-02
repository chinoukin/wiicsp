package com.wisea.cultivar.operation.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.entity.AuthInfo;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.operation.service.LoginExtendsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录扩展相关的接口
 *
 * @author wangh(wisea)
 * @date 2020/12/17 17:35
 * @version 1.0
 */
@Api(tags = "用户登录扩展相关接口")
@RestController
public class LoginExtendsController {

    @Autowired
    private LoginExtendsService loginExtendsService;

    /**
     * 刷新手机端登录验证的处理
     *
     * @author wangh(wisea)
     *
     * @date 2020年8月11日
     * @version 1.0
     */
    @PostMapping(value = { "/refreshLogin" })
    @DataCheck
    public ResultPoJo<AuthInfo> reFreshTokenForMobile(HttpServletRequest request,
                                                      @RequestBody LongIdPo po){
        // 返回参数初期化
        return loginExtendsService.reFreshTokenForMobile(request, po);
    }







}
