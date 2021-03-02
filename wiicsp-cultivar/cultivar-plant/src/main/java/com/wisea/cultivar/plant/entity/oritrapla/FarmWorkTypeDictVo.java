package com.wisea.cultivar.plant.entity.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.annotation.LongSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @Description: 农事类型返回参数
 * @author: wangs
 * @date :2018/7/6
 */
@ApiModel("农事类型返回参数vo")
public class FarmWorkTypeDictVo {

    @ApiModelProperty("id")
    @JsonSerialize(using= LongSerializer.class)
    private Long id;
    /**
     *  父节点id
     */
    @ApiModelProperty("父节点id")
    @JsonSerialize(using= LongSerializer.class)
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

    @ApiModelProperty("更新时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime updateDate;
    @ApiModelProperty("更新人标记信息")
    private String updateBy;

    @ApiModelProperty("创建时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime createDate;
    @ApiModelProperty("创建人")
    private String createBy;

    private String remarks;

    private String delFlag;

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

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffsetDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(OffsetDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public OffsetDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(OffsetDateTime createDate) {
        this.createDate = createDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
