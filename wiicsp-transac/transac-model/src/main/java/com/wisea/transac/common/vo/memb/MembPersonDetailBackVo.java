package com.wisea.transac.common.vo.memb;

import java.util.List;

import com.wisea.transac.common.vo.RealPersonAuthInfoVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 会员个人信息的查询VO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月29日
 * @version 1.0
 */
@ApiModel("会员个人信息的查询VO")
public class MembPersonDetailBackVo {


	@ApiModelProperty(value="会员Id")
	private Long membId;

	@ApiModelProperty(value="个人Id")
	private Long personId;

	@ApiModelProperty(value="用户注册的基本信息")
	private UserRegisterInfoVo regInfoVo;

	@ApiModelProperty(value="个人认证详细信息")
	private RealPersonAuthInfoVo personInfoVo;

    @ApiModelProperty(value = "历史审核记录")
    private List<ExamRecdListVo> examRecdList;

	public Long getMembId() {
		return membId;
	}

	public void setMembId(Long membId) {
		this.membId = membId;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public UserRegisterInfoVo getRegInfoVo() {
		return regInfoVo;
	}

	public void setRegInfoVo(UserRegisterInfoVo regInfoVo) {
		this.regInfoVo = regInfoVo;
	}

	public RealPersonAuthInfoVo getPersonInfoVo() {
		return personInfoVo;
	}

	public void setPersonInfoVo(RealPersonAuthInfoVo personInfoVo) {
		this.personInfoVo = personInfoVo;
	}

	public List<ExamRecdListVo> getExamRecdList() {
		return examRecdList;
	}

	public void setExamRecdList(List<ExamRecdListVo> examRecdList) {
		this.examRecdList = examRecdList;
	}
}
