package com.wisea.cultivar.common.vo.tp.origin;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author jirg
 * @Date 2019/3/22 15:42
 * @Description 养殖栏信息
 **/
@ApiModel("养殖栏信息vo")
public class OriBreedPenInfoPageVo {
	/**
	 * id
	 */
	@JsonSerialize(using = IdSerializer.class)
	@ApiModelProperty(value = "id")
	private Long id;
	/**
	 * 养殖栋id
	 */
	@ApiModelProperty(value = "养殖栋id")
	private Long breedTungId;
	/**
	 * 养殖栋id
	 */
	@ApiModelProperty(value = "养殖栋名称")
	private String breedTungName;

	/**
	 * 会员id
	 */
	@ApiModelProperty(value = "会员id")
	private Long membId;

	/**
	 * 养殖栏名称
	 */
	@ApiModelProperty(value = "养殖栏名称")
	private String breedPenName;

	/**
	 * 养殖场id
	 */
	@ApiModelProperty(value = "养殖场id")
	private Long farmId;
	/**
	 * 养殖场id
	 */
	@ApiModelProperty(value = "养殖场名称")
	private String farmName;

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
	 * logo
	 */
	@ApiModelProperty(value = "logo")
	private String logo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBreedTungId() {
		return breedTungId;
	}

	public void setBreedTungId(Long breedTungId) {
		this.breedTungId = breedTungId;
	}

	public String getBreedTungName() {
		return breedTungName;
	}

	public void setBreedTungName(String breedTungName) {
		this.breedTungName = breedTungName;
	}

	public Long getMembId() {
		return membId;
	}

	public void setMembId(Long membId) {
		this.membId = membId;
	}

	public String getBreedPenName() {
		return breedPenName;
	}

	public void setBreedPenName(String breedPenName) {
		this.breedPenName = breedPenName;
	}

	public Long getFarmId() {
		return farmId;
	}

	public void setFarmId(Long farmId) {
		this.farmId = farmId;
	}

	public String getFarmName() {
		return farmName;
	}

	public void setFarmName(String farmName) {
		this.farmName = farmName;
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

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

}
