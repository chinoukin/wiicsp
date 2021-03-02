package com.wisea.cultivar.common.vo.tp.origin;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author jirg
 * @Date 2019/3/22 15:41
 * @Description 养殖栋信息
 **/
/**
 * @author Administrator
 *
 */
@ApiModel("养殖栋信息vo")
public class OriBreedTungInfoVo {
	/**
	 * id
	 */
	@JsonSerialize(using = IdSerializer.class)
	@ApiModelProperty(value = "id")
	private Long id;

	/**
	 * 会员id
	 */
	@ApiModelProperty(value = "会员id")
	private Long membId;

	/**
	 * 养殖场id
	 */
	@ApiModelProperty(value = "养殖场id")
	private Long farmId;

	/**
	 * 养殖场
	 */
	@ApiModelProperty(value = "养殖场")
	private String farmName;

	/**
	 * 养殖栋名称
	 */
	@ApiModelProperty(value = "养殖栋名称")
	private String breedTungName;

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

	public String getBreedTungName() {
		return breedTungName;
	}

	public void setBreedTungName(String breedTungName) {
		this.breedTungName = breedTungName;
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
