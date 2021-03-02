package com.wisea.cultivar.common.vo.memb;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

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

    @ApiModelProperty(value="Id")
    private Long id;
    @ApiModelProperty(value="会员Id")
    private Long membId;

    @ApiModelProperty("认证类型")
    private String authType;

    @ApiModelProperty("认证状态")
    private String entpAuthStateType;

    @ApiModelProperty("会员类型")
    private String membType;


	@ApiModelProperty(value="注册信息")
	private UserRegisterInfoVo regInfoVo;

	@ApiModelProperty(value="认证详情")
	private EntpAuthInfoInitVo  entpAuthVo;

    @ApiModelProperty(value = "操作记录")
    private List<ExamRecdListVo> examRecdList;

    public String getMembType() {
        return membType;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public void setMembType(String membType) {
        this.membType = membType;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getEntpAuthStateType() {
        return entpAuthStateType;
    }

    public void setEntpAuthStateType(String entpAuthStateType) {
        this.entpAuthStateType = entpAuthStateType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

	public EntpAuthInfoInitVo getEntpAuthVo() {
		return entpAuthVo;
	}

	public void setEntpAuthVo(EntpAuthInfoInitVo entpAuthVo) {
		this.entpAuthVo = entpAuthVo;
	}
}
