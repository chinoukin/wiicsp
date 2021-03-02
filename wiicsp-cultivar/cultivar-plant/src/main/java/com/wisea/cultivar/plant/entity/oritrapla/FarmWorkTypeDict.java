package com.wisea.cultivar.plant.entity.oritrapla;

import com.wisea.cloud.common.entity.DataLongEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 农事操作类型字典
 */
@ApiModel("农事操作类型字典")
public class FarmWorkTypeDict extends DataLongEntity<FarmWorkTypeDict> {
    /**
     *  父节点id
     */
    @ApiModelProperty("父节点id")
    private Long parentId;
    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String name;
    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer sort;
    /**
     * 类型
     */
    @ApiModelProperty("类型")
    private String farmWorkType;
    /**
     * 是否设为常用
     */
    @ApiModelProperty("是否常用")
    private String comUsedFlag;

    @ApiModelProperty("parentName父名称ong")
    private String parentName;

    @ApiModelProperty("更新人标记信息1458哦哦")
    private String updatBy;

    @ApiModelProperty("创建人")
    private String creatBy;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getFarmWorkType() {
		return farmWorkType;
	}

	public void setFarmWorkType(String farmWorkType) {
		this.farmWorkType = farmWorkType;
	}

	public String getComUsedFlag() {
        return comUsedFlag;
    }

    public void setComUsedFlag(String comUsedFlag) {
        this.comUsedFlag = comUsedFlag;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getUpdatBy() {
        return updatBy;
    }

    public void setUpdatBy(String updatBy) {
        this.updatBy = updatBy;
    }

    public String getCreatBy() {
        return creatBy;
    }

    public void setCreatBy(String creatBy) {
        this.creatBy = creatBy;
    }
}
