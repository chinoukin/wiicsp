package com.wisea.cultivar.common.vo.tp.origin;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author jirg
 * @Date 2019/3/22 15:42
 * @Description 养殖场信息vo
 **/
@ApiModel("养殖场信息vo")
public class OriFarmInfoVo {
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
	@ApiModelProperty(value = "会员id")
	private Long membId;

	/**
	 * 养殖场名称
	 */
	@ApiModelProperty(value = "养殖场名称")
	private String farmName;

	/**
	 * 规模
	 */
	@ApiModelProperty(value = "规模")
	private Integer scale;

	/**
	 * 联系人姓名
	 */
	@ApiModelProperty(value = "联系人姓名")
	private String contactName;

	/**
	 * 电话
	 */
	@ApiModelProperty(value = "电话")
	private String tel;

	/**
	 * 联系地区省
	 */
	@ApiModelProperty(value = "联系地区省")
	private String areaProv;

	/**
	 * 联系地区市
	 */
	@ApiModelProperty(value = "联系地区市")
	private String areaCity;

	/**
	 * 联系地区区县
	 */
	@ApiModelProperty(value = "联系地区区县")
	private String areaCou;

	/**
	 * 详细地址
	 */
	@ApiModelProperty(value = "详细地址")
	private String address;

	/**
	 * 图片
	 */
	@ApiModelProperty(value = "图片")
	private List<ImgVo> imgVo;
	@ApiModelProperty("联系地区省名称")
	private String areaProvName;
	@ApiModelProperty("联系地区市名称")
	private String areaCityName;
	@ApiModelProperty("联系地区区县名称")
	private String areaCouName;


	public String getAreaProvName() {
		return areaProvName;
	}

	public void setAreaProvName(String areaProvName) {
		this.areaProvName = areaProvName;
	}

	public String getAreaCityName() {
		return areaCityName;
	}

	public void setAreaCityName(String areaCityName) {
		this.areaCityName = areaCityName;
	}

	public String getAreaCouName() {
		return areaCouName;
	}

	public void setAreaCouName(String areaCouName) {
		this.areaCouName = areaCouName;
	}

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
