package com.wisea.cultivar.infomanage.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.common.po.memb.FreezeMembUpdPo;
import com.wisea.cultivar.common.po.memb.MembMobileUpdPo;
import com.wisea.cultivar.common.vo.memb.MembEntpDetailBackVo;
import com.wisea.cultivar.common.vo.memb.MembProveBaseInfoVo;
import com.wisea.cultivar.infomanage.service.MembBackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
@PreAuthorize("hasAnyAuthority('im:mmg')")
public class MembInfoBackController {

	@Autowired
	private MembBackService membBackService ;

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
	 * 根据会员ID查询会员详细信息（查看会员信息、审核初期化）
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月25日
	 * @version 1.0
	 */
	@ApiOperation(value = "根据会员ID查询会员详细信息(传入会员ID)",notes = "根据会员ID查询会员详细信息(传入会员ID)")
	@PostMapping(value = "/getEntpMembDetail")
	@DataCheck
	public ResultPoJo<MembEntpDetailBackVo> getEntpMembDetail(@RequestBody LongIdPo po){
		// 返回处理
		return membBackService.getEntpMembDetail(po);
	}

    /**
     * 根据企业ID查询会员详细信息（查看会员信息、审核初期化）
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月25日
     * @version 1.0
     */
    @ApiOperation(value = "根据企业ID查询企业详细信息(传入企业ID)",notes = "根据企业ID查询企业详细信息(传入企业ID)")
    @PostMapping(value = "/getEntpDetail")
    @DataCheck
    public ResultPoJo<MembEntpDetailBackVo> getEntpDetail(@RequestBody LongIdPo po){
        // 返回处理
        return membBackService.getEntpDetail(po);
    }




	/**
	 * 冻结/修改手机号/重置密码时初期化会员基本信息(参数是会员ID)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月28日
	 * @version 1.0
	 */
	@ApiOperation(value = "冻结/修改手机号/初期化会员基本信息(参数是会员ID)",notes = "冻结/修改手机号/重置密码时初期化会员基本信息(参数是会员ID)")
	@PostMapping(value = "/membProveInit")
	@DataCheck
	public ResultPoJo<MembProveBaseInfoVo> membProveInit(@RequestBody LongIdPo po){
		// 返回处理
		return membBackService.membProveInit(po);
	}
}
