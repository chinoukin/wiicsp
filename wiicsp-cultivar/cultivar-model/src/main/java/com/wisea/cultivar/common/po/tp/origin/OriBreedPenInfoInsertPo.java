package com.wisea.cultivar.common.po.tp.origin;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cultivar.common.vo.tp.origin.ImgVo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author jirg
 * @Date 2019/3/22 15:42
 * @Description 养殖栏信息
 **/
public class OriBreedPenInfoInsertPo {
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
	@Check(test = "required")
	private Long breedTungId;

	/**
	 * 会员id
	 */
	@ApiModelProperty(value = "会员id")
	private Long membId;

	/**
	 * 养殖栏名称
	 */
	@ApiModelProperty(value = "养殖栏名称")
	@Check(test = "required")
	private String breedPenName;

	/**
	 * 养殖场id
	 */
	@ApiModelProperty(value = "养殖场id")
	@Check(test = "required")
	private Long farmId;

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
