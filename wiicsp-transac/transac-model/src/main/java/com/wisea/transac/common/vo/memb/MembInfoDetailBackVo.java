package com.wisea.transac.common.vo.memb;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 运营平台获取会员细信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月22日
 * @version 1.0
 */
@ApiModel("运营平台获取会员细信息VO")
public class MembInfoDetailBackVo {

	@ApiModelProperty(value="会员Id")
	private Long membId;


	@ApiModelProperty(value="用户注册的基本信息")
	private UserRegisterInfoVo regInfoVo;

    @ApiModelProperty(value = "历史审核记录")
    private List<ExamRecdListVo> examRecdList;

	public Long getMembId() {
		return membId;
	}

	public void setMembId(Long membId) {
		this.membId = membId;
	}

	public UserRegisterInfoVo getRegInfoVo() {
		return regInfoVo;
	}

	public void setRegInfoVo(UserRegisterInfoVo regInfoVo) {
		this.regInfoVo = regInfoVo;
	}

	public List<ExamRecdListVo> getExamRecdList() {
		return examRecdList;
	}

	public void setExamRecdList(List<ExamRecdListVo> examRecdList) {
		this.examRecdList = examRecdList;
	}
}
