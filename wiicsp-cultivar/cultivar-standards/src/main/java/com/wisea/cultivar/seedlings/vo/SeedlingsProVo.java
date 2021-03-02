package com.wisea.cultivar.seedlings.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName: seedlingsProVo
 * @Author: tgz
 * @Date: 2020/11/4 11:31
 */
public class SeedlingsProVo {

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 商品发布Id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品发布Id")
    private Long commPubId;

    /**
     * 品种Id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "品种Id")
    private Long commVarietId;

    @ApiModelProperty(value = "品种名称")
    private String commVarietName;

    @ApiModelProperty("销售数量")
    private Integer num;

    @ApiModelProperty("销售金额")
    private Double totalPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommPubId() {
        return commPubId;
    }

    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
    }

    public Long getCommVarietId() {
        return commVarietId;
    }

    public void setCommVarietId(Long commVarietId) {
        this.commVarietId = commVarietId;
    }

    public String getCommVarietName() {
        return commVarietName;
    }

    public void setCommVarietName(String commVarietName) {
        this.commVarietName = commVarietName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
