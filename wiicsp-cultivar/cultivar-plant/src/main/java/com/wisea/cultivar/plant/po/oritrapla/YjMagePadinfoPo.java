package com.wisea.cultivar.plant.po.oritrapla;

import java.time.OffsetDateTime;

/**
 * 预警设置的档案信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年8月23日
 * @version 1.0
 */
public class YjMagePadinfoPo {

	private Long id;
	private Long membId;// 档案会员ID
	private Long archId;// 档案ID
	private OffsetDateTime reportTime;//记录时间
	private String padId;//病虫害id
	private String padName;//病虫害名称
	private double cxsjTime;//持续时间
	private String massifName;//地块名称
	private Long massifId;//地块id

	public Long getMembId() {
		return membId;
	}
	public void setMembId(Long membId) {
		this.membId = membId;
	}
	public String getPadId() {
		return padId;
	}
	public void setPadId(String padId) {
		this.padId = padId;
	}
	public String getPadName() {
		return padName;
	}
	public void setPadName(String padName) {
		this.padName = padName;
	}
	public double getCxsjTime() {
		return cxsjTime;
	}
	public void setCxsjTime(double cxsjTime) {
		this.cxsjTime = cxsjTime;
	}
	public String getMassifName() {
		return massifName;
	}
	public void setMassifName(String massifName) {
		this.massifName = massifName;
	}
	public Long getMassifId() {
		return massifId;
	}
	public void setMassifId(Long massifId) {
		this.massifId = massifId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getArchId() {
		return archId;
	}
	public void setArchId(Long archId) {
		this.archId = archId;
	}
	public OffsetDateTime getReportTime() {
		return reportTime;
	}
	public void setReportTime(OffsetDateTime reportTime) {
		this.reportTime = reportTime;
	}
}
