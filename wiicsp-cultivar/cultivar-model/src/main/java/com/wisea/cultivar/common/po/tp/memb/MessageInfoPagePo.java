package com.wisea.cultivar.common.po.tp.memb;

import com.wisea.cultivar.common.vo.tp.memb.MessageInfoListVo;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.po.PagePo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 分页查询系统消息PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月13日
 * @version 1.0
 */
@ApiModel("分页查询系统消息PO")
public class MessageInfoPagePo extends PagePo<MessageInfoListVo> {

	private static final long serialVersionUID = 8099897154991308265L;

	@ApiModelProperty(value="标题或者内容")
	private String searchKey;

	@Check(test = {"required", "liveable"}, liveable = {"0", "1"}, liveableMsg = "消息类型只能是0或者1")
	@ApiModelProperty(value="消息类型(message_type0:系统消息1:活动消息)")
	private String messageType;

	@ApiModelProperty(value="消息接受者",hidden=true)
	private Long reciverMembId;

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public Long getReciverMembId() {
		return reciverMembId;
	}

	public void setReciverMembId(Long reciverMembId) {
		this.reciverMembId = reciverMembId;
	}

}
