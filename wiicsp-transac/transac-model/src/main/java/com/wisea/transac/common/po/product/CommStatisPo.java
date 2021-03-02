package com.wisea.transac.common.po.product;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.product.CommStaticsVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * 商品销售情况po
 *
 * @author yangtao
 */
@ApiModel("商品销售情况po")
public class CommStatisPo extends PagePo<CommStaticsVo> {

    /**
     * 批发市场id
     */
    @ApiModelProperty("批发市场id")
    private Long marketId;

    @ApiModelProperty(value = "档口ID，如果当前登录用户关联了档口，传关联的档口ID，如果当前登录用户没有关联档口，默认不传，用户选择时再传", hidden = true)
    private List<Long> stallsMageIds;

    @ApiModelProperty(value = "开始时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime timeStart;

    @ApiModelProperty(value = "结束时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime timeEnd;

    @ApiModelProperty(value = "热卖商品统计的时候必填（下单金额：0，下单量：1）")
    private String seleckey;

    public String getSeleckey() {
        return seleckey;
    }

    public void setSeleckey(String seleckey) {
        this.seleckey = seleckey;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public List<Long> getStallsMageIds() {
        return stallsMageIds;
    }

    public void setStallsMageIds(List<Long> stallsMageIds) {
        this.stallsMageIds = stallsMageIds;
    }

    public OffsetDateTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(OffsetDateTime timeStart) {
        this.timeStart = timeStart;
    }

    public OffsetDateTime getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(OffsetDateTime timeEnd) {
        this.timeEnd = timeEnd;
    }
}
