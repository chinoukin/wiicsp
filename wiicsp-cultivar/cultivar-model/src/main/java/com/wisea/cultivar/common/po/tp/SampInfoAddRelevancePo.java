package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 检测报告添加关联
 * @author: wangs
 * @date :2018/9/28
 */
@ApiModel("检测报告添加关联")
public class SampInfoAddRelevancePo {

    /**
     * 会员id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty("会员id")
    private Long membId;

    /**
     * 发布商品id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty("发布商品id")
    private Long commPubId;

    /**
     * 检测报告id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty("检测报告id 或者是 品鉴报告id 或者是 检疫合格证id")
    private Long id;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty("样品id")
    private Long sampId;

    /**
     * ,3品鉴,4检疫合格证
     */
    @ApiModelProperty("relaType关系类型0检测")
    private String relaType;

    public Long getCommPubId() {
        return commPubId;
    }

    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
    }

    public Long getSampId() {
        return sampId;
    }

    public void setSampId(Long sampId) {
        this.sampId = sampId;
    }

    public String getRelaType() {
        return relaType;
    }

    public void setRelaType(String relaType) {
        this.relaType = relaType;
    }

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
}
