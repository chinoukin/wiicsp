package com.wisea.transac.tp.system.controller.wechat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.transac.common.po.memb.MembWechatPwdPo;
import com.wisea.transac.common.po.seller.SelMarketSavePo;
import com.wisea.transac.common.vo.memb.WechatLoginInitVo;
import com.wisea.transac.tp.system.service.memb.MembInfoService;
import com.wisea.transac.tp.system.service.wechat.MembWeChatService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 微信小程序登录后相关的操作
 *
 * @author wangh(wisea)
 *
 * @date 2018年11月15日
 * @version 1.0
 */
@Api(tags = "微信小程序登录后相关的操作")
@RestController
@RequestMapping("/w/weChat")
public class MembWeChatController {

	@Autowired
	private MembWeChatService membWeChatService;
	@Autowired
	private MembInfoService membInfoService;

	/**
	 * 微信设定密码
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年11月15日
	 * @version 1.0
	 */
	@DataCheck
	@PostMapping("/setPwd")
	@ApiOperation(nickname = "微信设定密码",value = "微信设定密码",notes = "微信设定密码")
	public ResultPoJo<String> weChatSetPwd(@RequestBody MembWechatPwdPo membWechatPwdPo){
		// 返回处理
		return membInfoService.firstSavePwd(membWechatPwdPo);
	}
	/**
	 *  登录后初期化处理(登录后立即调用)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月29日
	 * @version 1.0
	 */
	@DataCheck
	@PostMapping("/wechatLoginInit")
	@ApiOperation(nickname = " 登录后初期化处理(*仅支持买家端使用)",value = " 登录后初期化处理(*仅支持买家端使用)")
	public ResultPoJo<WechatLoginInitVo> wechatLoginInit(){
		// 返回处理
		return membWeChatService.wechatLoginInit();
	}
	/**
	 *  登录选择市场后保存的处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月29日
	 * @version 1.0
	 */
	@DataCheck
	@PostMapping("/selMarketInfoSave")
	@ApiOperation(nickname = "登录选择市场后保存的处理",value = "登录选择市场后保存的处理")
	public ResultPoJo<String> selMarketInfoSave(@RequestBody SelMarketSavePo po){
		// 返回处理
		return membWeChatService.selMarketInfoSave(po);
	}
}
