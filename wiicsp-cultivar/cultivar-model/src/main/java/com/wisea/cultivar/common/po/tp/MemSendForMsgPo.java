package com.wisea.cultivar.common.po.tp;

import java.util.List;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 发送消息
 *
 * @author wangh(wisea)
 *
 * @date 2018年10月20日
 * @version 1.0
 */
@ApiModel("平台发送系统消息Po")
public class MemSendForMsgPo{

    @ApiModelProperty(value = "用户名/会员名称")
    private String key;
    @Check(test = {"required", "liveable"}, liveable = {"0","1","2","3","4"}, liveableMsg = "状态为1-4")
    @ApiModelProperty(value = "状态(0:全部会员1:个人2:企业3:代理商4:指定)")
    public String  states;
    @ApiModelProperty(value = "指定会员的 查询条件列表",hidden=true)
    public List<String> membKeys;
    @Check(test = {"required"})
    @ApiModelProperty(value = "发送标题")
    private String title;
    @ApiModelProperty(value = "发送摘要")
    private String summary;
    @Check(test = {"required"})
    @ApiModelProperty(value = "发送详细内容")
    private String content;

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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<String> getMembKeys() {
		return membKeys;
	}
	public void setMembKeys(List<String> membKeys) {
		this.membKeys = membKeys;
	}

}
