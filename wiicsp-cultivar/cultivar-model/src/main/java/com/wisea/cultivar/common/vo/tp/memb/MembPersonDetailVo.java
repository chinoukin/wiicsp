package com.wisea.cultivar.common.vo.tp.memb;

import java.util.List;

import com.wisea.cultivar.common.vo.tp.ExamRecdListVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 后台查询个人会员详细信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年4月24日
 * @version 1.0
 */
@ApiModel("后台查询个人会员详细信息VO")
public class MembPersonDetailVo {

	//
	@ApiModelProperty(value="会员ID")
	private Long id;
	/**
     * 注册信息
     */
	@ApiModelProperty(value = "注册信息")
    private UserRegisterInfoVo userRegisterInfoVo;
	/**
     * 认证
     */
	@ApiModelProperty(value = "认证信息")
	private MembPersonAutoVo membPersonAutoVo;
	/**
     * 企业历史审核记录
     */
    @ApiModelProperty(value = "企业历史审核记录")
    private List<ExamRecdListVo> examRecdList;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UserRegisterInfoVo getUserRegisterInfoVo() {
		return userRegisterInfoVo;
	}
	public void setUserRegisterInfoVo(UserRegisterInfoVo userRegisterInfoVo) {
		this.userRegisterInfoVo = userRegisterInfoVo;
	}
	public List<ExamRecdListVo> getExamRecdList() {
		return examRecdList;
	}
	public void setExamRecdList(List<ExamRecdListVo> examRecdList) {
		this.examRecdList = examRecdList;
	}
	public MembPersonAutoVo getMembPersonAutoVo() {
		return membPersonAutoVo;
	}
	public void setMembPersonAutoVo(MembPersonAutoVo membPersonAutoVo) {
		this.membPersonAutoVo = membPersonAutoVo;
	}

}
