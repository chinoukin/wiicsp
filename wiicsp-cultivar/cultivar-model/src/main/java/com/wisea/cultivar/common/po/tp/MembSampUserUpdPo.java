package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 冻结解冻会采样人员的PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年10月13日
 * @version 1.0
 */
@ApiModel("冻结解冻会采样人员的PO")
public class MembSampUserUpdPo {
	/**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value="id")
    @Check(test = "required")
    private Long id;
    @ApiModelProperty(value="账户状态(0:正常1:冻结)")
    @Check(test = {"required", "liveable"}, liveable = {"0", "1"}, liveableMsg = "登录状态只能为0或1")
    private String acctState;
    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
    }
	public String getAcctState() {
		return acctState;
	}

	public void setAcctState(String acctState) {
		this.acctState = acctState;
	}

}
