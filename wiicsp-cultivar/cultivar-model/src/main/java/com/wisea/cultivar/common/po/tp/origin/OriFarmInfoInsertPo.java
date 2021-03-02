package com.wisea.cultivar.common.po.tp.origin;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cultivar.common.vo.tp.origin.ImgVo;

import io.swagger.annotations.ApiModelProperty;

public class OriFarmInfoInsertPo {
	/**
	 * id
	 */
	@JsonSerialize(using = IdSerializer.class)
	@ApiModelProperty(value = "id")
	private Long id;
    /**
     * 会员id
     */
	@JsonSerialize(using = IdSerializer.class)
	@ApiModelProperty(value = "会员id" ,hidden=true)
    private Long membId;

    /**
     * 养殖场名称
     */
	@ApiModelProperty(value = "养殖场名称")
	@Check(test = "required")
    private String farmName;

    /**
     * 规模
     */
	@ApiModelProperty(value = "规模")
	@Check(test = "required")
    private Integer scale;

    /**
     * 联系人姓名
     */
	@ApiModelProperty(value = "联系人姓名")
	@Check(test = "required")
    private String contactName;

    /**
     * 电话
     */
	@ApiModelProperty(value = "电话")
	@Check(test = "required")
    private String tel;

    /**
     * 联系地区省
     */
	@ApiModelProperty(value = "联系地区省")
	@Check(test = "required")
    private String areaProv;

    /**
     * 联系地区市
     */
	@ApiModelProperty(value = "联系地区市")
	@Check(test = "required")
    private String areaCity;

    /**
     * 联系地区区县
     */
	@ApiModelProperty(value = "联系地区区县")
	@Check(test = "required")
    private String areaCou;

    /**
     * 详细地址
     */
	@ApiModelProperty(value = "详细地址")
	@Check(test = "required")
    private String address;

	/**
	 * 图片
	 */
	@ApiModelProperty(value = "图片")
	private List<ImgVo> imgVo;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMembId() {
		return membId;
	}

	public void setMembId(Long membId) {
		this.membId = membId;
	}

	public String getFarmName() {
		return farmName;
	}

	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}

	public Integer getScale() {
		return scale;
	}

	public void setScale(Integer scale) {
		this.scale = scale;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAreaProv() {
		return areaProv;
	}

	public void setAreaProv(String areaProv) {
		this.areaProv = areaProv;
	}

	public String getAreaCity() {
		return areaCity;
	}

	public void setAreaCity(String areaCity) {
		this.areaCity = areaCity;
	}

	public String getAreaCou() {
		return areaCou;
	}

	public void setAreaCou(String areaCou) {
		this.areaCou = areaCou;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<ImgVo> getImgVo() {
		return imgVo;
	}

	public void setImgVo(List<ImgVo> imgVo) {
		this.imgVo = imgVo;
	}
}
