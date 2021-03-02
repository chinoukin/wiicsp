package com.wisea.cultivar.common.po.tp.product;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @Description: 查询品种个数时传入参数
 * @author: wangs
 * @date :2019/5/29
 */
@ApiModel("查询品种个数时传入参数")
public class AvailableQuantityPo {

    @ApiModelProperty("品类id")
    private Long commId;

    @ApiModelProperty("品种id")
    private Long commVarietId;

    @ApiModelProperty("搜索时间的类型")
    private String searchTimeType;

    /**
     * 按可售时间自定义时间搜索
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty("按可售时间自定义时间搜索")
    private OffsetDateTime startTime;

    /**
     * 按可售时间自定义时间搜索
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty("按可售时间自定义时间搜索")
    private OffsetDateTime endTime;

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public Long getCommVarietId() {
        return commVarietId;
    }

    public void setCommVarietId(Long commVarietId) {
        this.commVarietId = commVarietId;
    }

    public String getSearchTimeType() {
        return searchTimeType;
    }

    public void setSearchTimeType(String searchTimeType) {
        this.searchTimeType = searchTimeType;
    }

    public OffsetDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
    }

    public OffsetDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(OffsetDateTime endTime) {
        this.endTime = endTime;
    }
}
