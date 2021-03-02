package com.wisea.cultivar.common.vo.product;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @author wangs
 */
public class CommDataListVo {

    /**
     * 商品id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品id")
    private Long id;


    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String commTitle;

    /**
     * 商家名称
     */
    @ApiModelProperty(value = "商家名称")
    private String entpName;

    /**
     * 商品状态类型
     */
    @ApiModelProperty(value = "商品状态类型")
    private String commStateType;
    /**
     * 商品状态类型
     */
    @ApiModelProperty(value = "商品状态类型值")
    private String commStateTypeValue;


    /**
     * 销售分类配置id
     */
    @ApiModelProperty("商品分类id")
    private Long commSaleSetId;


    /**
     * 销售分类名称
     */
    @ApiModelProperty("商品分类名称")
    private String catgName;
    /**
     * 价格区间
     */
    @ApiModelProperty(value = "价格区间")
    private String priceExpres;

    /**
     * 有效期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "操作时间")
    private OffsetDateTime updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommTitle() {
        return commTitle;
    }

    public void setCommTitle(String commTitle) {
        this.commTitle = commTitle;
    }

    public String getEntpName() {
        return entpName;
    }

    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }

    public String getCommStateType() {
        return commStateType;
    }

    public void setCommStateType(String commStateType) {
        this.commStateType = commStateType;
    }

    public String getCommStateTypeValue() {
        return commStateTypeValue;
    }

    public void setCommStateTypeValue(String commStateTypeValue) {
        this.commStateTypeValue = commStateTypeValue;
    }

    public Long getCommSaleSetId() {
        return commSaleSetId;
    }

    public void setCommSaleSetId(Long commSaleSetId) {
        this.commSaleSetId = commSaleSetId;
    }

    public String getCatgName() {
        return catgName;
    }

    public void setCatgName(String catgName) {
        this.catgName = catgName;
    }

    public String getPriceExpres() {
        return priceExpres;
    }

    public void setPriceExpres(String priceExpres) {
        this.priceExpres = priceExpres;
    }

    public OffsetDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(OffsetDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
