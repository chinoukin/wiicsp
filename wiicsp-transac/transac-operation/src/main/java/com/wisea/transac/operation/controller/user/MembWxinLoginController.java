package com.wisea.transac.operation.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.transac.common.po.StringPo;
import com.wisea.transac.common.vo.memb.AuthInfoVo;
import com.wisea.transac.operation.service.user.MembWxinLoginService;
import com.wisea.transac.operation.user.po.WeChatUserPo;
import com.wisea.transac.operation.user.po.WechatBdPo;
import com.wisea.transac.operation.user.po.WechatVilLoginPo;
import com.wisea.transac.operation.user.vo.WachatBdInfoVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 *
 * 微信小程序登录的处理
 *
 * @author wangh(wisea)
 *
 * @date 2018年10月29日
 * @version 1.0
 */
@Api(tags = "微信小程序登录的处理")
@RestController
public class MembWxinLoginController {

	@Autowired
	private MembWxinLoginService membWxinLoginService;
	/**
	 * 根据code获取OpenID
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年11月8日
	 * @version 1.0
	 */
	@DataCheck
	@PostMapping("/weChat/getOpenId")
	@ApiOperation(nickname = "后台获取OpenID",value = "后台获取OpenID",notes = "后台获取OpenID")
	public ResultPoJo<AuthInfoVo> getSessionKeyOropenid(HttpServletRequest request, HttpServletResponse response,
			@RequestBody WechatVilLoginPo po){
		// 处理并且返回
		return membWxinLoginService.getSessionKeyOropenid(po, request);
	}
	/**
	 * 验证手机号是否已经存在
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年11月8日
	 * @version 1.0
	 */
	@DataCheck
	@PostMapping("/weChat/checkByMobile")
	@ApiOperation(nickname = "验证手机号是否已经存在",value = "验证手机号是否已经存在",notes = "验证手机号是否已经存在")
	public ResultPoJo<String> checkByMobile(@RequestBody StringPo po){
		// 返回处理
		return membWxinLoginService.checkByMobile(po);
	}
	/**
	 * 微信授权第一次的用户信息完善
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年11月12日
	 * @version 1.0
	 */
	@DataCheck
	@PostMapping("/weChat/weChatUserPer")
	@ApiOperation(nickname = "微信授权第一次的用户信息完善",value = "微信授权第一次的用户信息完善",notes = "微信授权第一次的用户信息完善")
	public ResultPoJo<AuthInfoVo> wechatUserPerfect(HttpServletRequest request, HttpServletResponse response,
			@RequestBody WeChatUserPo weChatUserPo){
		// 返回处理
		return membWxinLoginService.wechatUserPerfect(request,response,weChatUserPo);
	}
	/**
	 * 获取unionId
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年3月4日
	 * @version 1.0
	 */
	@DataCheck
	@PostMapping("/weChat/getWachatUnionId")
	@ApiOperation(nickname = "获取unionId",value = "获取unionId",notes = "获取unionId")
	public ResultPoJo<WachatBdInfoVo> getWachatUnionId(@RequestBody WechatBdPo wechatBdPo){
		return membWxinLoginService.getWachatUnionId(wechatBdPo);
	}
}
