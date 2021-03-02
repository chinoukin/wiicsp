package com.wisea.transac.common.vo.memb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 查询所有企业信息列表VO
 *
 * @author wangh(wisea)
 *
 * @date 2020年7月1日
 * @version 1.0
 */
@ApiModel("查询所有企业信息列表VO")
public class EntpInfoForAllListVo {

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "注册手机号")
    private String registTel;

    @ApiModelProperty(value = "企业名称")
    private String entpName;

    @ApiModelProperty(value = "显示=用户名(手机号)")
    private String nameAddtel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getRegistTel() {
		return registTel;
	}

	public void setRegistTel(String registTel) {
		this.registTel = registTel;
	}

	public String getEntpName() {
		return entpName;
	}

	public void setEntpName(String entpName) {
		this.entpName = entpName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNameAddtel() {
		return nameAddtel;
	}

	public void setNameAddtel(String nameAddtel) {
		this.nameAddtel = nameAddtel;
	}

}
