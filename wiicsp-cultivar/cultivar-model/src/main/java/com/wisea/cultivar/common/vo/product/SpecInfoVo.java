package com.wisea.cultivar.common.vo.product;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cultivar.common.vo.CommAttriInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @ClassName: SpecInfoVo
 * @Author: tgz
 * @Date: 2020/8/6 18:27
 */
@ApiModel("规格参数Vo")
public class SpecInfoVo {
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "分类")
    private String commCatgName;

    @ApiModelProperty(value = "商品描述")
    private String commSignature;

    @ApiModelProperty(value = "省")
    private String commSendProv;
    @ApiModelProperty(value = "市")
    private String commSendCity;
    @ApiModelProperty(value = "区")
    private String commSendCou;
    @ApiModelProperty(value = "发货详细地址")
    private String commSendAddress;

    @ApiModelProperty(value = "属性")
    private List<CommAttriInfoVo> commAttriInfoVos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommCatgName() {
        return commCatgName;
    }

    public void setCommCatgName(String commCatgName) {
        this.commCatgName = commCatgName;
    }

    public String getCommSignature() {
        return commSignature;
    }

    public void setCommSignature(String commSignature) {
        this.commSignature = commSignature;
    }

    public String getCommSendProv() {
        return commSendProv;
    }

    public void setCommSendProv(String commSendProv) {
        this.commSendProv = commSendProv;
    }

    public String getCommSendCity() {
        return commSendCity;
    }

    public void setCommSendCity(String commSendCity) {
        this.commSendCity = commSendCity;
    }

    public String getCommSendCou() {
        return commSendCou;
    }

    public void setCommSendCou(String commSendCou) {
        this.commSendCou = commSendCou;
    }

    public String getCommSendAddress() {
        return commSendAddress;
    }

    public void setCommSendAddress(String commSendAddress) {
        this.commSendAddress = commSendAddress;
    }

    public List<CommAttriInfoVo> getCommAttriInfoVos() {
        return commAttriInfoVos;
    }

    public void setCommAttriInfoVos(List<CommAttriInfoVo> commAttriInfoVos) {
        this.commAttriInfoVos = commAttriInfoVos;
    }
}
