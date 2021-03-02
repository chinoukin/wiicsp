package com.wisea.cultivar.common.vo.tp.product;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @Description: 评价列表返回列表
 * @author: wangs
 * @date :2019/6/6
 */
@ApiModel("评价列表返回列表")
public class GpPjResultListVo {

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty("评价")
    private Long id;
    /**
     * 商品id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty("品类id")
    private Long commId;

    private String commName;

    /**
     * 商品品种id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty("品种id")
    private Long commVarietId;

    /**
     * 商品产地省
     */
    @ApiModelProperty("商品产地省")
    private String commLocalProv;

    /**
     * 商品产地市
     */
    @ApiModelProperty("商品产地市")
    private String commLocalCity;

    /**
     * 商品产地区县
     */
    @ApiModelProperty("商品产地区县")
    private String commLocalCou;

    /**
     * 上市时间
     */
    @ApiModelProperty("上市时间")
    private String ssDate;

    /**
     * 综合评价
     */
    @ApiModelProperty("综合评价")
    private String compEval;

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty("维护时间")
    private OffsetDateTime updateDate;

    /**
     * 标记字段
     */
    @ApiModelProperty("标记字段")
    private String remarks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public Long getCommVarietId() {
        return commVarietId;
    }

    public void setCommVarietId(Long commVarietId) {
        this.commVarietId = commVarietId;
    }

    public String getCommLocalProv() {
        return commLocalProv;
    }

    public void setCommLocalProv(String commLocalProv) {
        this.commLocalProv = commLocalProv;
    }

    public String getCommLocalCity() {
        return commLocalCity;
    }

    public void setCommLocalCity(String commLocalCity) {
        this.commLocalCity = commLocalCity;
    }

    public String getCommLocalCou() {
        return commLocalCou;
    }

    public void setCommLocalCou(String commLocalCou) {
        this.commLocalCou = commLocalCou;
    }

    public String getSsDate() {
        return ssDate;
    }

    public void setSsDate(String ssDate) {
        this.ssDate = ssDate;
    }

    public String getCompEval() {
        return compEval;
    }

    public void setCompEval(String compEval) {
        this.compEval = compEval;
    }

    public OffsetDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(OffsetDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
