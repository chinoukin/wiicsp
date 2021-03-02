package com.wisea.cultivar.common.po.tp.memb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cultivar.common.vo.tp.SubAcctInfoListVo;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;

import io.swagger.annotations.ApiModelProperty;

/**
 * SubAcctInfoPagePo
 * 2018/10/11 10:36:38
 */
public class SubAcctInfoPagePo extends PagePo<SubAcctInfoListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * 会员id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "会员id",hidden=true)
    private Long membId;
    /**
     * 启用标志
     */
    @ApiModelProperty(value = "启用标志",hidden=true)
    private String enableFlag;
    /**
     * 帐号或者员工姓名
     */
    @ApiModelProperty(value = "帐号或者员工姓名")
    private String key;

	public Long getMembId() {
		return membId;
	}
	public void setMembId(Long membId) {
		this.membId = membId;
	}
	public String getEnableFlag() {
		return enableFlag;
	}
	public void setEnableFlag(String enableFlag) {
		this.enableFlag = enableFlag;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}

}
