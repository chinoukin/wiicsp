package com.wisea.transac.operation.controller.user;

import javax.servlet.http.HttpServletRequest;

import com.wisea.transac.operation.user.po.CheckMobileIsBdPo;
import com.wisea.transac.operation.user.po.MembBdThirdInfoPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cloud.common.entity.AuthInfo;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.transac.operation.service.user.ThirdLoginService;
import com.wisea.transac.operation.user.po.MembThirdUnBindPo;
import com.wisea.transac.operation.user.po.RegMembByThirdInfoPo;
import com.wisea.transac.operation.user.po.ValiUnionExistPo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 第三方登录的Controller
 *
 * @author wangh(wisea)
 *
 * @date 2020年8月20日
 * @version 1.0
 */
@Api(tags = "第三方登录处理接口")
@RestController
@Lazy
public class ThirdLoginController {

	@Autowired
	private ThirdLoginService thirdLoginService;

	/**
	 * 验证获取的第三方帐号是否已经绑定已有帐号
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年8月21日
	 * @version 1.0
	 */
	@ApiOperation(nickname = "验证获取的第三方帐号是否已经绑定已有帐号)",value = "验证获取的第三方帐号是否已经绑定已有帐号")
	@PostMapping(value = { "/thirdLogin/valiUnionExist" })
	public ResultPoJo<AuthInfo> valiUnionExist(HttpServletRequest request,@RequestBody ValiUnionExistPo po){
		// 处理并且返回
		po.setRelType("0");//0:微信
		return thirdLoginService.valiUnionExist(request, po);
	}
	/**
	 * 验证该手机号的用户已经绑定了其他的微信
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年8月21日
	 * @version 1.0
	 */
	@ApiOperation(nickname = "验证该手机号的用户已经绑定了其他的微信)",value = "验证该手机号的用户已经绑定了其他的微信")
	@PostMapping(value = { "/thirdLogin/checkMobileIfBd" })
	public ResultPoJo<String> checkMobileIfBd(@RequestBody CheckMobileIsBdPo po){
		// 处理并且返回
		po.setRelType("0");//0:微信
		return thirdLoginService.checkMobileIfBd(po);
	}
	/**
	 * 根据第三方信息和手机号注册绑定并且登录处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年8月20日
	 * @version 1.0
	 */
	@ApiOperation(nickname = "根据第三方信息和手机号注册绑定并且登录处理)",value = "根据第三方信息和手机号注册绑定并且登录处理")
	@PostMapping(value = { "/thirdLogin/regMmebByThird" })
	public ResultPoJo<AuthInfo> regMmebByThirdMembInfo(HttpServletRequest request,@RequestBody RegMembByThirdInfoPo po){
		// 处理并且返回
		po.setRelType("0");//0:微信
		return thirdLoginService.regMmebByThirdMembInfo(request, po);
	}
	/**
	 * 第三方微信登录绑定处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年8月24日
	 * @version 1.0
	 */
	@ApiOperation(nickname = "第三方微信登录绑定处理",value = "第三方微信登录绑定处理")
	@PostMapping(value = { "/w/thirdLogin/membBdThird" })
	public ResultPoJo<String> membBdThird(@RequestBody MembBdThirdInfoPo po){
		// 处理并且返回
		po.setRelType("0");//0:微信
		return thirdLoginService.membBdThird(po);
	}
	/**
	 * 第三方微信解绑处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年8月24日
	 * @version 1.0
	 */
	@ApiOperation(nickname = "第三方微信解绑处理",value = "第三方微信解绑处理")
	@PostMapping(value = { "/w/thirdLogin/membUnbind" })
	public ResultPoJo<String> membThirdUnBindPo(@RequestBody MembThirdUnBindPo po){
		// 处理并且返回
		return thirdLoginService.membThirdUnBindPo(po);
	}
}
