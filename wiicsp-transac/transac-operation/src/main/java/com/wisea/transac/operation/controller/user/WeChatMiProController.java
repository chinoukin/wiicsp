package com.wisea.transac.operation.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.entity.AuthInfo;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.memb.MobileValiLoginPo;
import com.wisea.transac.operation.service.user.UserLoginExtendsService;

import io.swagger.annotations.ApiOperation;


/**
 * 微信小程序模拟登录的Controller
 *
 * @author wangh(wisea)
 *
 * @date 2018年11月12日
 * @version 1.0
 */
@RestController
public class WeChatMiProController {

	@Autowired
	private UserLoginExtendsService userLoginExtendsService;

	/**
	 * 注册手机号验证码登录的
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年11月12日
	 * @version 1.0
	 */
	@ApiOperation(nickname = "注册手机号验证码登录的(/mobileLogin?ltype=(city_bus:同城交易loc_bus:产地交易   默认是是city_bus))",value = "注册手机号验证码登录的/mobileLogin?ltype=(city_bus:同城交易loc_bus:产地交易   默认是是city_bus)")
	@PostMapping(value = { "/mobileLogin" })
	public ResultPoJo<AuthInfo> mobileLogin(HttpServletRequest request,
			@RequestBody MobileValiLoginPo po){
		// 登录并且返回
		return userLoginExtendsService.mobileValiCodeLogin(request, po);
	}

	/**
	 * 注册手机号验证码登录(如果手机号不存在则注册新的账号)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年11月12日
	 * @version 1.0
	 */
	@ApiOperation(nickname = "注册手机号验证码登录(如果手机号不存在则注册新的账号)",value = "注册手机号验证码登录(如果手机号不存在则注册新的账号)")
	@PostMapping(value = { "/mobileLoginReg" })
	public ResultPoJo<AuthInfo> mobileLoginOrReg(HttpServletRequest request,
			@RequestBody MobileValiLoginPo po){
		// 登录并且返回
		return userLoginExtendsService.mobileLoginOrReg(request, po);
	}
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
		return userLoginExtendsService.reFreshTokenForMobile(request,po);
	}
}
