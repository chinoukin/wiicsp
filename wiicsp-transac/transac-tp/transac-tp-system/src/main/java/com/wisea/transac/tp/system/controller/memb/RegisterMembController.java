package com.wisea.transac.tp.system.controller.memb;

import com.wisea.transac.tp.system.service.memb.RegisterMembService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.entity.MembInfo;
import com.wisea.transac.common.po.StringPo;
import com.wisea.transac.common.po.memb.MembCheckLoginNamePo;
import com.wisea.transac.common.po.memb.MembCheckMobilePo;
import com.wisea.transac.common.po.memb.MembForgotPwdPo;
import com.wisea.transac.common.po.memb.MembInfoRegisterPo;
import com.wisea.transac.common.vo.memb.MembForgotPwdVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 商家注册会员相关的接口
 *
 * @author wangh(wisea)
 *
 * @date 2020年4月28日
 * @version 1.0
 */
@Api(tags = "商家注册会员相关的接口")
@RestController
public class RegisterMembController {

	@Autowired
	private RegisterMembService registerMembService;

	/**
	 * 商户APP注册会员的处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月22日
	 * @version 1.0
	 */
	@ApiOperation(value = "商户APP注册会员的处理",notes = "商户APP注册会员的处理")
	@PostMapping(value = "/memb/register")
	@DataCheck
	public ResultPoJo<MembInfo> register(@RequestBody MembInfoRegisterPo po){
		// 操作并且返回
		po.setLocalityMembType(DictConstants.LOCALITY_MEMB_TYPE_1);// 非产地会员
		return registerMembService.register(po);
	}
	/**
	 * 产地APP注册会员的处理(place of origin)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月22日
	 * @version 1.0
	 */
	@ApiOperation(value = "产地APP注册会员的处理",notes = "产地APP注册会员的处理")
	@PostMapping(value = "/poo/memb/register")
	@DataCheck
	public ResultPoJo<MembInfo> pooRegister(@RequestBody MembInfoRegisterPo po){
		// 操作并且返回
		po.setLocalityMembType(DictConstants.LOCALITY_MEMB_TYPE_0);// 产地会员
		return registerMembService.register(po);
	}
	/**
	 * 验证用户名是否已经存在
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年4月28日
	 * @version 1.0
	 */
	@ApiOperation(value = "验证用户名是否已经存在",notes = "验证用户名是否已经存在")
	@PostMapping(value = "/memb/checkLoginNameExist")
	@DataCheck
	public ResultPoJo<String> checkLoginNameExist(@RequestBody StringPo po){
		MembCheckLoginNamePo membCheckLoginNamePo = new MembCheckLoginNamePo();
		membCheckLoginNamePo.setLoginName(po.getKeyStr());
		// 返回参数
		return registerMembService.checkLoginNameExist(membCheckLoginNamePo);
	}
	/**
	 * 验证手机号是否已经存在
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年9月25日
	 * @version 1.0
	 */
	@ApiOperation(value = "验证手机号是否已经存在",notes = "验证手机号是否已经存在")
	@PostMapping(value = "/memb/checkMobileExist")
	@DataCheck
	public ResultPoJo<String> checkMobileExist(@RequestBody StringPo po){
		MembCheckMobilePo membCheckMobilePo = new MembCheckMobilePo();
		membCheckMobilePo.setMobile(po.getKeyStr());
		// 返回参数
		return registerMembService.checkMobileExist(membCheckMobilePo);
	}
	/**
	 * 忘记密码-点击发送手机验证码的操作
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年9月29日
	 * @version 1.0
	 */
	@ApiOperation(value = "忘记密码-点击发送手机验证码的操作",notes = "忘记密码-点击发送手机验证码的操作")
	@PostMapping(value = "/memb/getMobile")
	@DataCheck
	public ResultPoJo<MembForgotPwdVo> forgotPwdGetMobile(@RequestBody StringPo stringPo){
		// 返回参数
		return registerMembService.forgotPwdGetMobile(stringPo);
	}
	/**
	 * 忘记密码保存操作
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年9月25日
	 * @version 1.0
	 */
	@ApiOperation( value = "忘记密码保存操作",notes = "忘记密码保存操作")
	@PostMapping(value = "/memb/forgotPassword")
	@DataCheck
	public ResultPoJo<String> forgotPassword(@RequestBody MembForgotPwdPo membForgotPwdPo){
		// 返回参数
		return registerMembService.forgotPassword(membForgotPwdPo);
	}

}
