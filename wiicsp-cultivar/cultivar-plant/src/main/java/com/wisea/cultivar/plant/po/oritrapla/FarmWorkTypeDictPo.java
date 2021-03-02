package com.wisea.cultivar.plant.po.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.plant.entity.oritrapla.FarmWorkTypeDictVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @Description: 农事类型字典值传入po
 * @author: wangs
 * @date :2018/6/21
 */
@ApiModel("农事类型字典值传入po")
public class FarmWorkTypeDictPo extends PagePo<FarmWorkTypeDictVo> {

    /**
     * 分类查询
     */
    @ApiModelProperty(value="分类查询(0:一级分类1:)")
    private String farmWorkType;
    /**
     * 搜索输入的内容
     */
    @ApiModelProperty(value="搜索输入的内容")
    private String searchValue;

    /**
     * 更新时间开始
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value="更新开始时间")
    private OffsetDateTime updStaDate;

    /**
     * 更新时间结束
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value="更新结束时间")
    private OffsetDateTime updEndDate;

    /**
     * 是否常用
     */
    @ApiModelProperty(value="是否常用(0:是1:否)")
    private String comUsedFlag;

    public String getFarmWorkType() {
        return farmWorkType;
    }

    public void setFarmWorkType(String farmWorkType) {
        this.farmWorkType = farmWorkType;
    }

    public OffsetDateTime getUpdStaDate() {
        return updStaDate;
    }

    public void setUpdStaDate(OffsetDateTime updStaDate) {
        this.updStaDate = updStaDate;
    }

    public OffsetDateTime getUpdEndDate() {
        return updEndDate;
    }

    public void setUpdEndDate(OffsetDateTime updEndDate) {
        this.updEndDate = updEndDate;
    }

    public String getComUsedFlag() {
        return comUsedFlag;
    }

    public void setComUsedFlag(String comUsedFlag) {
        this.comUsedFlag = comUsedFlag;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }
}
