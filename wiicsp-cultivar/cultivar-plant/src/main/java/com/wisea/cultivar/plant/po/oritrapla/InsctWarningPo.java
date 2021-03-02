package com.wisea.cultivar.plant.po.oritrapla;

import java.io.Serializable;

/**
 * 发送系统消息相关字段
 *
 * @author wangh(wisea)
 *
 * @date 2019年9月4日
 * @version 1.0
 */
public class InsctWarningPo implements Serializable{

	/**
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年9月4日
	 * @version 1.0
	 */
	private static final long serialVersionUID = -5428586894995782238L;
	/** 病虫害预警信息ID **/
	private Long id;//病虫害预警信息ID
	/** 设备id **/
	private Long equId;//设备id


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEquId() {
		return equId;
	}
	public void setEquId(Long equId) {
		this.equId = equId;
	}
}
