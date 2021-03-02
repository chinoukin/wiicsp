package com.wisea.transac.tp.system.controller.memb;

import java.util.List;

import com.wisea.transac.tp.system.service.memb.MembBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.po.memb.EntpInfoForAllListPo;
import com.wisea.transac.common.po.memb.FreezeMembUpdPo;
import com.wisea.transac.common.po.memb.MembMobileUpdPo;
import com.wisea.transac.common.po.memb.MembPwdUpdPo;
import com.wisea.transac.common.vo.memb.EntpInfoForAllListVo;
import com.wisea.transac.common.vo.memb.MembEntpDetailBackVo;
import com.wisea.transac.common.vo.memb.MembInfoDetailBackVo;
import com.wisea.transac.common.vo.memb.MembPersonDetailBackVo;
import com.wisea.transac.common.vo.memb.MembProveBaseInfoVo;
import com.wisea.transac.common.vo.memb.PlatOrMarketLoginInfoVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 会员后台管理的相关接口Controller
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月25日
 * @version 1.0
 */
@Api(tags = "会员后台管理的相关接口")
@RestController
@RequestMapping("/w/admin/memb/")
public class MembInfoBackController {

	@Autowired
	private MembBackService membBackService ;


	/**
	 * 查询当前用户是市场用户还是运营平台用户
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月28日
	 * @version 1.0
	 */
	@ApiOperation(nickname="查询当前用户是市场用户还是运营平台用户", value = "查询当前用户是市场用户还是运营平台用户")
	@PostMapping(value="/platLoginInit")
	@DataCheck
	public ResultPoJo<PlatOrMarketLoginInfoVo> platLoginInit(){
		// 查询返回处理
		return membBackService.platLoginInit();
	}
	/**
	 * 管理员冻结/解冻会员
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月25日
	 * @version 1.0
	 */
	@ApiOperation(nickname="管理员冻结/解冻会员", value = "管理员冻结/解冻会员")
	@PostMapping(value="/membBatFrozen")
	@DataCheck
	public ResultPoJo<String> membBatFrozen(@RequestBody FreezeMembUpdPo po){
		// 返回参数
		return membBackService.freezeMemb(po);
	}
	/**
	 * 后台重置密码的操作
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月25日
	 * @version 1.0
	 */
	@ApiOperation(nickname="后台重置密码的操作", value = "后台重置密码的操作")
	@PostMapping(value="/membPwdReset")
	@DataCheck
	public ResultPoJo<String> membPwdReset(@RequestBody MembPwdUpdPo membPwdUpdPo){
		// 返回参数
		return membBackService.membPwdReset(membPwdUpdPo);
	}

	/**
	 * 后台会员注册手机号的修改
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月25日
	 * @version 1.0
	 */
	@ApiOperation(nickname="后台会员注册手机号的修改", value = "后台会员注册手机号的修改")
	@PostMapping(value="/updRegMobile")
	@DataCheck
	public ResultPoJo<String> updMembMobile(@RequestBody MembMobileUpdPo membMobileUpdPo){
		// 返回参数
		return membBackService.updMembMobile(membMobileUpdPo);
	}
	/**
	 * 根据企业ID查询会员详细信息（查看会员信息、审核初期化）
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月25日
	 * @version 1.0
	 */
	@ApiOperation(value = "根据企业ID查询会员详细信息(传入企业ID)",notes = "根据企业ID查询会员详细信息(传入企业ID)")
	@PostMapping(value = "/getEntpMembDetail")
	@DataCheck
	public ResultPoJo<MembEntpDetailBackVo> getEntpMembDetail(@RequestBody LongIdPo po){
		// 返回处理
		return membBackService.getEntpMembDetail(po);
	}
	/**
	 * 根据个人认证ID查询会员详细信息(传入个人认证ID)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月25日
	 * @version 1.0
	 */
	@ApiOperation(value = "根据个人认证ID查询会员详细信息(传入个人认证ID)",notes = "根据个人认证ID查询会员详细信息(传入个人认证ID)")
	@PostMapping(value = "/getPersonMembDetail")
	@DataCheck
	public ResultPoJo<MembPersonDetailBackVo> getPersonMembDetail(@RequestBody LongIdPo po){
		// 返回处理
		return membBackService.getPersonMembDetail(po);
	}
	/**
	 * 根据会员ID查询会员的详细信息（传入会员ID）
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月19日
	 * @version 1.0
	 */
	@ApiOperation(value = "根据会员ID查询会员的详细信息（传入会员ID）",notes = "根据会员ID查询会员的详细信息（传入会员ID）")
	@PostMapping(value = "/getMembInfoDetail")
	@DataCheck
	public ResultPoJo<MembInfoDetailBackVo> getMembInfoDetail(@RequestBody LongIdPo po){
		// 返回处理
		return membBackService.getMembInfoDetail(po);
	}
	/**
	 * 冻结/修改手机号/重置密码时初期化会员基本信息(参数是会员ID)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月28日
	 * @version 1.0
	 */
	@ApiOperation(value = "冻结/修改手机号/重置密码时初期化会员基本信息(参数是会员ID)",notes = "冻结/修改手机号/重置密码时初期化会员基本信息(参数是会员ID)")
	@PostMapping(value = "/membProveInit")
	@DataCheck
	public ResultPoJo<MembProveBaseInfoVo> membProveInit(@RequestBody LongIdPo po){
		// 返回处理
		return membBackService.membProveInit(po);
	}
	/**
	 * 根据登录用户名称模糊查询用户列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年01月16日
	 * @version 1.0
	 */
	@ApiOperation(nickname="根据登录用户名称模糊查询用户列表", value = "根据登录用户名称模糊查询用户列表",notes = "根据登录用户名称模糊查询用户列表")
	@PostMapping(value = "/entp/findMembInfoAll")
	@DataCheck
	public ResultPoJo<List<EntpInfoForAllListVo>> findMembInfoAll(@RequestBody EntpInfoForAllListPo entpInfoForAllListPo){
		// 返回参数
		return membBackService.findMembInfoAll(entpInfoForAllListPo);
	}
}
