package com.wisea.cultivar.plant.po.oritrapla;

import java.io.Serializable;

/**
 * 发送系统消息扩展字段(极光推送)
 *
 * @author wangh(wisea)
 *
 * @date 2019年9月4日
 * @version 1.0
 */
public class InsctWarningSendPo implements Serializable{

	/**
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年9月4日
	 * @version 1.0
	 */
	private static final long serialVersionUID = -5428586894995782238L;
	private Long equId;//设备id
	private Long archId;//档案id
	public Long getEquId() {
		return equId;
	}
	public void setEquId(Long equId) {
		this.equId = equId;
	}
	public Long getArchId() {
		return archId;
	}
	public void setArchId(Long archId) {
		this.archId = archId;
	}
}
