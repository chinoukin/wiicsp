package com.wisea.cultivar.common.po.tp.memb;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cultivar.common.vo.tp.MembInfoListVo;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * MembInfoPagePo
 * 2018/09/18 14:36:47
 */
@ApiModel("MembInfoPagePo")
public class MembInfoPagePo extends PagePo<MembInfoListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * 用户名/注册手机号/会员名称
     */
    @ApiModelProperty(value = "用户名/注册手机号/会员名称")
    private String key;
    /**
     * 注册开始时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "注册开始时间")
    private OffsetDateTime registDateStart;
    /**
     * 注册结束时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "注册结束时间")
    private OffsetDateTime registDateEnd;

    /**
     * 会员状态
     */
    @ApiModelProperty(value = "会员状态(0:正常1:冻结)")
    private String acctState;
    /**
     * 状态选项
     */
    @ApiModelProperty(value = "状态选项(0:全部会员1:个人2:企业3:商家)不填写默认是全部")
    public String  states;

	public OffsetDateTime getRegistDateStart() {
		return registDateStart;
	}

	public void setRegistDateStart(OffsetDateTime registDateStart) {
		this.registDateStart = registDateStart;
	}

	public OffsetDateTime getRegistDateEnd() {
		return registDateEnd;
	}

	public void setRegistDateEnd(OffsetDateTime registDateEnd) {
		this.registDateEnd = registDateEnd;
	}
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getAcctState() {
		return acctState;
	}

	public void setAcctState(String acctState) {
		this.acctState = acctState;
	}

	public String getStates() {
		return states;
	}

	public void setStates(String states) {
		this.states = states;
	}
}
