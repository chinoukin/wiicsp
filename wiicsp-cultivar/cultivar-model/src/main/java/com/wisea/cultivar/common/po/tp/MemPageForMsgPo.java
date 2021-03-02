package com.wisea.cultivar.common.po.tp;

import java.util.List;

import com.wisea.cultivar.common.vo.tp.MembInfoListVo;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.po.PagePo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 查询要发送消息的会员列表
 *
 * @author wangh(wisea)
 *
 * @date 2018年10月20日
 * @version 1.0
 */
@ApiModel("查询要发送消息的会员列表Po")
public class MemPageForMsgPo extends PagePo<MembInfoListVo> {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户名/会员名称")
    private String key;
    @Check(test = {"required", "liveable"}, liveable = {"0","1","2","4"}, liveableMsg = "状态为0,1,2,4")
    @ApiModelProperty(value = "状态(0:全部会员1:个人会员2:企业会员4:指定会员)")
    public String  states;
    @ApiModelProperty(value = "指定会员的 查询条件列表",hidden=true)
    public List<String> membKeys;

	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getStates() {
		return states;
	}
	public void setStates(String states) {
		this.states = states;
	}
	public List<String> getMembKeys() {
		return membKeys;
	}
	public void setMembKeys(List<String> membKeys) {
		this.membKeys = membKeys;
	}

}
