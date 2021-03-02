package com.wisea.cultivar.plant.vo.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.annotation.LongSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * app端获取最新版本信息的Vo
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月27日
 * @version 1.0
 */
@ApiModel("app端获取最新版本信息的Vo")
public class VersionInfoMageVo {

	@ApiModelProperty("ID")
	@JsonSerialize(using= LongSerializer.class)
	private Long id;
	@ApiModelProperty("版本名称")
    private String versionName;
	@ApiModelProperty("版本号")
    private String versionNum;
	@ApiModelProperty("是否强制更新类型(force_update_type[0:是1:否])")
    private String forceUpdateType;
	@ApiModelProperty("更新内容")
    private String updateCont;
	@ApiModelProperty("更新地址")
    private String updateUrl;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the versionName
	 */
	public String getVersionName() {
		return versionName;
	}
	/**
	 * @param versionName the versionName to set
	 */
	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}
	/**
	 * @return the versionNum
	 */
	public String getVersionNum() {
		return versionNum;
	}
	/**
	 * @param versionNum the versionNum to set
	 */
	public void setVersionNum(String versionNum) {
		this.versionNum = versionNum;
	}
	/**
	 * @return the forceUpdateType
	 */
	public String getForceUpdateType() {
		return forceUpdateType;
	}
	/**
	 * @param forceUpdateType the forceUpdateType to set
	 */
	public void setForceUpdateType(String forceUpdateType) {
		this.forceUpdateType = forceUpdateType;
	}
	/**
	 * @return the updateCont
	 */
	public String getUpdateCont() {
		return updateCont;
	}
	/**
	 * @param updateCont the updateCont to set
	 */
	public void setUpdateCont(String updateCont) {
		this.updateCont = updateCont;
	}
	/**
	 * @return the updateUrl
	 */
	public String getUpdateUrl() {
		return updateUrl;
	}
	/**
	 * @param updateUrl the updateUrl to set
	 */
	public void setUpdateUrl(String updateUrl) {
		this.updateUrl = updateUrl;
	}
}
