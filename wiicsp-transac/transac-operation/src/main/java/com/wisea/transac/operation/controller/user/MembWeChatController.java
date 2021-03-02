package com.wisea.transac.operation.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.transac.operation.service.user.MembWeChatService;
import com.wisea.transac.operation.user.po.MembReleUnBdPo;
import com.wisea.transac.operation.user.po.WechatBdPo;
import com.wisea.transac.operation.user.vo.WachatBdInfoVo;

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

	/**
	 * 获取unionId并且绑定处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年3月4日
	 * @version 1.0
	 */
	@DataCheck
	@PostMapping("/bdUnionId")
	@ApiOperation(nickname = "获取unionId并且绑定处理",value = "获取unionId并且绑定处理",notes = "获取unionId并且绑定处理")
	public ResultPoJo<WachatBdInfoVo> bdUnionId(@RequestBody WechatBdPo wechatBdPo){
		return membWeChatService.bdUnionId(wechatBdPo);
	}
	/**
	 * 微信解绑
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年11月15日
	 * @version 1.0
	 */
	@DataCheck
	@PostMapping("/weChatUnbind")
	@ApiOperation(nickname = "微信解绑",value = "微信解绑",notes = "微信解绑")
	public ResultPoJo<String> weChatUnbind(@RequestBody MembReleUnBdPo membReleUnBdPo){
		// 返回处理
		return membWeChatService.weChatUnbind(membReleUnBdPo);
	}
}
