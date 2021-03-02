package com.wisea.cultivar.common.po.tp.product;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 中小零批楼层传递参数
 * @author: wangs
 * @date :2019/5/29
 */
@ApiModel("中小零批楼层传递参数")
public class SambFloorPo {

    /**
     * 楼层名称
     */
    @ApiModelProperty("编辑传递id")
    private Long id;

    @ApiModelProperty("楼层名称")
    @Check(test = "required", requiredMsg = "楼层名称不能为空")
    private String floorName;

    @ApiModelProperty("楼层副标题")
    private String sambFloorTitle;
    /**
     * 排序
     */
    @ApiModelProperty("排序")
    @Check(test = "required", requiredMsg = "排序不能为空")
    private Integer sort;

    /**
     * 状态（启用、停用）
     */
    @ApiModelProperty("状态信息")
    @Check(test = "required", requiredMsg = "状态不能为空")
    private String enableFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag;
    }

	public String getSambFloorTitle() {
		return sambFloorTitle;
	}

	public void setSambFloorTitle(String sambFloorTitle) {
		this.sambFloorTitle = sambFloorTitle;
	}
}
