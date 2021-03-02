package com.wisea.transac.common.vo.memb;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 运营平台获取会员企业详细信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月22日
 * @version 1.0
 */
@ApiModel("运营平台获取会员企业详细信息VO")
public class MembEntpDetailBackVo {

	@ApiModelProperty(value="会员Id")
	private Long membId;

	@ApiModelProperty(value="企业Id")
	private Long entpId;

	@ApiModelProperty(value="用户注册的基本信息")
	private UserRegisterInfoVo regInfoVo;

	@ApiModelProperty(value="企业基本信息")
	private EntpAuthInfoInitVo  entpAuthVo;

	@ApiModelProperty(value="银行卡信息")
	private EntpBankInfoInitVo entpBankVo;

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

	public EntpBankInfoInitVo getEntpBankVo() {
		return entpBankVo;
	}

	public void setEntpBankVo(EntpBankInfoInitVo entpBankVo) {
		this.entpBankVo = entpBankVo;
	}

	public List<ExamRecdListVo> getExamRecdList() {
		return examRecdList;
	}

	public void setExamRecdList(List<ExamRecdListVo> examRecdList) {
		this.examRecdList = examRecdList;
	}

	public EntpAuthInfoInitVo getEntpAuthVo() {
		return entpAuthVo;
	}

	public void setEntpAuthVo(EntpAuthInfoInitVo entpAuthVo) {
		this.entpAuthVo = entpAuthVo;
	}

	public Long getEntpId() {
		return entpId;
	}

	public void setEntpId(Long entpId) {
		this.entpId = entpId;
	}
}
