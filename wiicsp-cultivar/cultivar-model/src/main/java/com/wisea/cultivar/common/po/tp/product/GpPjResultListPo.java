package com.wisea.cultivar.common.po.tp.product;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.product.GpPjResultListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @Description: 评价结果列表查询传入参数
 * @author: wangs
 * @date :2019/6/6
 */
@ApiModel("评价结果列表查询传入参数")
public class GpPjResultListPo extends PagePo<GpPjResultListVo> {

    /**
     * 商品id
     */
    @ApiModelProperty("品类id")
    private Long commId;

    /**
     * 商品品种id
     */
    @ApiModelProperty("品种id")
    private Long commVarietId;

    /**
     * 开始时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "开始时间")
    private OffsetDateTime stratTime;

    /**
     * 结束时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "开始时间")
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

    public OffsetDateTime getStratTime() {
        return stratTime;
    }

    public void setStratTime(OffsetDateTime stratTime) {
        this.stratTime = stratTime;
    }

    public OffsetDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(OffsetDateTime endTime) {
        this.endTime = endTime;
    }
}
