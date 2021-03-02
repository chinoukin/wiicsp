package com.wisea.cultivar.common.po.tp.statistics;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.statistics.BuyerAndSellerConsumeVo;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @Description: 买卖双方消费信息
 * @author: wangs
 * @date :2018/11/30
 */
public class BuyerAndSellerConsumePo extends PagePo<BuyerAndSellerConsumeVo> {

    @ApiModelProperty(value = "会员认证状态,字典值,1表示,未认证;0表示,已认证")
    @Check(test = "required", requiredMsg = "会员的认证状态不能为空")
    private String entpAuthStateType;
    @ApiModelProperty(value = "开始时间")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime searchTimeStart;
    @ApiModelProperty(value = "结束时间")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime searchTimeEnd;

    public String getEntpAuthStateType() {
        return entpAuthStateType;
    }

    public void setEntpAuthStateType(String entpAuthStateType) {
        this.entpAuthStateType = entpAuthStateType;
    }

    public OffsetDateTime getSearchTimeStart() {
        return searchTimeStart;
    }

    public void setSearchTimeStart(OffsetDateTime searchTimeStart) {
        this.searchTimeStart = searchTimeStart;
    }

    public OffsetDateTime getSearchTimeEnd() {
        return searchTimeEnd;
    }

    public void setSearchTimeEnd(OffsetDateTime searchTimeEnd) {
        this.searchTimeEnd = searchTimeEnd;
    }
}
