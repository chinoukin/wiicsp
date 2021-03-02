package com.wisea.transac.tp.system.controller.memb;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.StringPo;
import com.wisea.transac.common.po.memb.*;
import com.wisea.transac.common.vo.memb.MembInfoForSetVo;
import com.wisea.transac.common.vo.memb.MembInfoListForMsgVo;
import com.wisea.transac.common.vo.memb.SetPwdOrNameInitVo;
import com.wisea.transac.common.vo.seller.MembInfoVo;
import com.wisea.transac.tp.system.service.memb.MembInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 会员相关的基本操作Controller
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月9日
 * @version 1.0
 */
@Api(tags = "会员相关基本操作的接口")
@RestController
@RequestMapping("/w/memb/")
public class MembInfoController {

	@Autowired
	private MembInfoService membInfoService;

	/**
	 * 查询会员的基本信息（小程序端设置的初期话处理）
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月9日
	 * @version 1.0
	 */
	@ApiOperation(value = "查询会员的基本信息（小程序端设置的初期话处理）",notes = "查询会员的基本信息（小程序端设置的初期话处理）")
	@PostMapping(value = "getMembInfo")
	@DataCheck
	public ResultPoJo<MembInfoForSetVo> getMembInfoForSet(@RequestBody LongIdPo po){
		// 查询并且返回处理
		return membInfoService.getMembInfoForSet(po);
	}
	/**
	 * 验证旧的注册手机号是否正确
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月9日
	 * @version 1.0
	 */
	@ApiOperation(value = "验证旧的注册手机号是否正确",notes = "验证旧的注册手机号是否正确")
	@PostMapping(value = "checkOldMobile")
	@DataCheck
	public ResultPoJo<String> checkOldMobile(@RequestBody CheckOldMobilePo po){
		// 验证并且返回处理
		return membInfoService.checkOldMobile(po);
	}
	/**
	 * 验证新绑定的手机号是否已经绑定其他账号
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月9日
	 * @version 1.0
	 */
	@ApiOperation(value = "验证新绑定的手机号是否已经绑定其他账号",notes = "验证新绑定的手机号是否已经绑定其他账号")
	@PostMapping(value = "checkNewMobile")
	@DataCheck
	public ResultPoJo<String> checkNewMobile(@RequestBody StringPo po){
		// 验证并且返回处理
		return membInfoService.checkNewMobile(po);
	}
	/**
	 * 保存新手机号的处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月26日
	 * @version 1.0
	 */
	@ApiOperation(nickname="保存新手机号的处理", value = "保存新手机号的处理")
	@PostMapping(value = "/memb/saveNewMobile")
	@DataCheck
	public ResultPoJo<String> saveNewMobile(@RequestBody MembSaveNewMobilePo po){
		// 返回参数
		return membInfoService.saveNewMobile(po);
	}
	/**
	 * 修改登录密码(修改当前用户的密码)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年9月26日
	 * @version 1.0
	 */
	@ApiOperation(nickname="【修改登录密码(修改当前用户的密码)", value = "修改登录密码(修改当前用户的密码)")
	@PostMapping(value = "/memb/updPwd")
	@DataCheck
	public ResultPoJo<String> userUpdPwd(@RequestBody MembPwdUpdatePo membPwdUpdatePo){
		// 返回参数
		return membInfoService.userUpdPwd(membPwdUpdatePo);
	}
	/**
	 * 发送消息 -指定的时候查询所有的会员接口
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年10月20日
	 * @version 1.0
	 */
	@ApiOperation( value = "发送消息 -指定的时候查询所有的会员接口")
	@PostMapping("/senMsg/findMembList")
	@DataCheck
	public ResultPoJo<List<MembInfoListForMsgVo>> membListForMsg(@RequestBody MembListForMsgPo po){
		// 返回参数
		return membInfoService.membListForMsg(po);
	}

	/**
	 * 第一次设置密码的处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年7月24日
	 * @version 1.0
	 */
	@DataCheck
	@PostMapping("/firstUpdPwd")
	@ApiOperation(nickname = "第一次设置密码的处理",value = "第一次设置密码的处理",notes = "第一次设置密码的处理")
	public ResultPoJo<String> firstSavePwd(@RequestBody MembWechatPwdPo membWechatPwdPo){
		// 返回处理
		return membInfoService.firstSavePwd(membWechatPwdPo);
	}
	/**
	 * 设置用户名密码判断
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年7月24日
	 * @version 1.0
	 */
	@DataCheck
	@PostMapping("/setPwdOrNameInit")
	@ApiOperation(nickname = "设置用户名密码判断",value = "设置用户名密码判断")
	public ResultPoJo<SetPwdOrNameInitVo> setPwdOrNameInit(){
		// 返回处理
		return membInfoService.setPwdOrNameInit();
	}
	/**
	 * 修改会员的基本信息(昵称,姓名,头像)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年8月17日
	 * @version 1.0
	 */
	@DataCheck
	@PostMapping("/updMembBaseInfo")
	@ApiOperation(nickname = " 修改会员的基本信息(昵称,姓名,头像)",value = " 修改会员的基本信息(昵称,姓名,头像)")
	public ResultPoJo<String> updMembBaseInfo(@RequestBody MembBaseInfoUpdPo po){
		// 返回处理
		return membInfoService.updMembBaseInfo(po);
	}


	/**
	 * 查询客服基本信息
	 * @param po
	 * @return
	 */
	@ApiOperation(value = "查询客服基本信息",notes = "查询客服基本信息")
	@PostMapping(value = "getMembInfobyId")
	@DataCheck
	public ResultPoJo<MembInfoVo> getMembInfo(@RequestBody LongIdPo po){
		return membInfoService.getMembInfo(po);
	}
}
