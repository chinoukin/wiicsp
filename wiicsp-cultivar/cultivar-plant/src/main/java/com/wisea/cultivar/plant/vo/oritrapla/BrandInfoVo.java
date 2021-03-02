package com.wisea.cultivar.plant.vo.oritrapla;

import com.wisea.cultivar.plant.entity.oritrapla.BrandPicture;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 品牌信息
 */
@ApiModel("品牌信息vo")
public class BrandInfoVo {
    @ApiModelProperty(value="品牌信息id")
	private Long id;
	@ApiModelProperty(value="会员id")
    private Long membId; //会员id
	@ApiModelProperty(value="品牌名称")
    private String brandName; //品牌名称
	@ApiModelProperty(value="品牌介绍")
    private String brandIntr; //品牌介绍
	@ApiModelProperty(value="品牌照片")
    private List<BrandPicture> brandPicture;

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

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandIntr() {
        return brandIntr;
    }

    public void setBrandIntr(String brandIntr) {
        this.brandIntr = brandIntr;
    }

	public List<BrandPicture> getBrandPicture() {
		return brandPicture;
	}

	public void setBrandPicture(List<BrandPicture> brandPicture) {
		this.brandPicture = brandPicture;
	}
}
