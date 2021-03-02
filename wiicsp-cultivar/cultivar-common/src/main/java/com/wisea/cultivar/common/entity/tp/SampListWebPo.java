package com.wisea.cultivar.common.entity.tp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * 检测信息管理PO
 *
 * @author wzx
 */
@ApiModel("检测信息管理PO")
public class SampListWebPo extends PagePo<SampListWebVo> {

    private static final long serialVersionUID = -1651839854872974081L;
    @ApiModelProperty(value = "(0:样品名称 1:企业名称)")
    private String key;
    @ApiModelProperty(value = "选择查询条件后输入的参数")
    private String value;
    @ApiModelProperty(value = "样品状态")
    private String sampStateType;
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "开始时间")
    private OffsetDateTime staDate;
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "结束时间")
    private OffsetDateTime endDate;
    @ApiModelProperty(value = "品鉴会ID")
    private String judgeMeetId;
    @ApiModelProperty(value = "修改时传递 发布商品id,新增时不传")
    private Long commPubInfoId;
    @ApiModelProperty(value = "企业id")
    private Long compId;

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public Long getCommPubInfoId() {
        return commPubInfoId;
    }

    public void setCommPubInfoId(Long commPubInfoId) {
        this.commPubInfoId = commPubInfoId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSampStateType() {
        return sampStateType;
    }

    public void setSampStateType(String sampStateType) {
        this.sampStateType = sampStateType;
    }

    public OffsetDateTime getStaDate() {
        return staDate;
    }

    public void setStaDate(OffsetDateTime staDate) {
        this.staDate = staDate;
    }

    public OffsetDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
    }

    public String getJudgeMeetId() {
        return judgeMeetId;
    }

    public void setJudgeMeetId(String judgeMeetId) {
        this.judgeMeetId = judgeMeetId;
    }


}
