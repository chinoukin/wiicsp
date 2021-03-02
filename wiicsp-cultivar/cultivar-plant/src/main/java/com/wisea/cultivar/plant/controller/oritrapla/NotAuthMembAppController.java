package com.wisea.cultivar.plant.controller.oritrapla;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.plant.po.oritrapla.CheckStringPo;
import com.wisea.cultivar.plant.po.oritrapla.RegisterBaseInfoPo;
import com.wisea.cultivar.plant.po.oritrapla.SaveForgetPwdPo;
import com.wisea.cultivar.plant.service.oritrapla.NotAuthMembAppService;
import com.wisea.cultivar.plant.service.oritrapla.SystemBulletinService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * app端会员信息中不需要登录的接口
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月5日
 * @version 1.0
 */
@Api(value = "APP端会员相关的接口(不需要登录)", description = "供App端调用", tags = "APP端会员相关的接口(不需要登录)")
@RestController
@RequestMapping("/n")
public class NotAuthMembAppController {

	@Autowired
	private NotAuthMembAppService notAuthMembAppService;
    @Autowired
	SystemBulletinService systemBulletinService;
	/**
	 * oritrapla_001_【会员】注册时用户名的不重复的验证
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月5日
	 * @version 1.0
	 */
	@ApiOperation(nickname="注册时用户名的不重复的验证",value="注册时手机号不重复的验证",notes="注册时手机号不重复的验证")
	@RequestMapping(value="/app/memb/checkUsername",method= RequestMethod.POST)
	@DataCheck
	public ResultPoJo<String> checkUsername(@RequestBody CheckStringPo po){
		// 返回参数
		return notAuthMembAppService.checkUsername(po);
	}
	/**
	 * oritrapla_001_【会员】注册时手机号不重复的验证
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月5日
	 * @version 1.0
	 */
	@ApiOperation(nickname="注册时手机号不重复的验证",value="注册时手机号不重复的验证",notes="注册时手机号不重复的验证")
	@RequestMapping(value="/app/memb/checkMobile",method= RequestMethod.POST)
	@DataCheck
	public ResultPoJo<String> checkMobile(@RequestBody CheckStringPo po){
		// 返回参数
		return notAuthMembAppService.checkMobile(po);
	}
	/**
	 * oritrapla_003_【会员】注册基本信息保存操作
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月5日
	 * @version 1.0
	 */
	@ApiOperation(nickname="注册基本信息保存操作",value="oritrapla_003_【会员】注册基本信息保存操作",notes="注册基本信息保存操作")
	@RequestMapping(value="/app/memb/saveBaseMembInfo",method= RequestMethod.POST)
	@DataCheck
	public ResultPoJo<String> saveBaseMembInfo(@RequestBody RegisterBaseInfoPo po){
		// 返回参数
		return notAuthMembAppService.saveBaseMembInfo(po);
	}
	/**
	 * oritrapla_006_【会员】修改密码时验证用户名是否存在(忘记密码)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月5日
	 * @version 1.0
	 */
	@ApiOperation(nickname="修改密码时验证用户名是否存在(忘记密码)",value="oritrapla_006_【会员】修改密码时验证用户名是否存在(忘记密码)",notes="修改密码时验证用户名是否存在(忘记密码)")
	@RequestMapping(value="/app/memb/checkLogNameForPwd",method= RequestMethod.POST)
	@DataCheck
	public ResultPoJo<String> checkLogNameForPwd(@RequestBody CheckStringPo po){
		// 返回参数
		return notAuthMembAppService.checkLogNameForPwd(po);
	}

	/**
	 * oritrapla_007_【会员】修改密码保存操作(忘记密码)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月5日
	 * @version 1.0
	 */
	@ApiOperation(nickname="修改密码保存操作(忘记密码)",value="oritrapla_007_【会员】修改密码保存操作(忘记密码)",notes="修改密码保存操作(忘记密码)")
	@RequestMapping(value="/app/memb/saveForgtPwd",method= RequestMethod.POST)
	@DataCheck
	public ResultPoJo<String> saveForgtPwd(@RequestBody SaveForgetPwdPo po){
		// 返回参数
		return notAuthMembAppService.saveForgtPwd(po);
	}

	/**
	 * oritrapla_006_【会员】修改密码时验证用户名是否存在(忘记密码)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月5日
	 * @version 1.0
	 */
	@ApiOperation(nickname="修改密码时验证手机号是否存在(忘记密码)",value="oritrapla_006_【会员】修改密码时验证手机号是否存在(忘记密码)",notes="修改密码时验证手机号是否存在(忘记密码)")
	@RequestMapping(value="/app/memb/checkContTelForPwd",method= RequestMethod.POST)
	@DataCheck
	public ResultPoJo<String> checkContTelForPwd(@RequestBody CheckStringPo po){
		// 返回参数
		return notAuthMembAppService.checkContTelForPwd(po);
	}
}
