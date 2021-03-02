package com.wisea.cultivar.common.vo.tp.origin;

import java.util.List;

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
public class OriBreedPenInfoVo {
	/**
	 * id
	 */
	@JsonSerialize(using = IdSerializer.class)
	@ApiModelProperty(value = "id")
	private Long id;
	/**
	 * 养殖栋id
	 */
	private Long breedTungId;
	/**
	 * 养殖栋id
	 */
	private String breedTungName;

	/**
	 * 会员id
	 */
	private Long membId;

	/**
	 * 养殖栏名称
	 */
	private String breedPenName;

	/**
	 * 养殖场id
	 */
	private Long farmId;
	/**
	 * 养殖场id
	 */
	private String farmName;

	/**
	 * 联系人姓名
	 */
	private String contactName;

	/**
	 * 电话
	 */
	private String tel;

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

	public List<ImgVo> getImgVo() {
		return imgVo;
	}

	public void setImgVo(List<ImgVo> imgVo) {
		this.imgVo = imgVo;
	}

}
