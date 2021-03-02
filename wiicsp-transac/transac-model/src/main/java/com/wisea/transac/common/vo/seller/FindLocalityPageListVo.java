package com.wisea.transac.common.vo.seller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("产地交易商家VO")
public class FindLocalityPageListVo {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "会员id")
    private Long membId;

    @ApiModelProperty(value = "基地id")
    private Long baseId;

    @ApiModelProperty(value = "基地名称")
    private String baseName;

    @ApiModelProperty(value = "基地图片")
    private String baseUrl;

    @ApiModelProperty(value = "基地详情")
    private String baseContent;

    @ApiModelProperty(value = "企业认证状态（有值就是已认证）")
    private String entpAuth;

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

    public Long getBaseId() {
        return baseId;
    }

    public void setBaseId(Long baseId) {
        this.baseId = baseId;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseContent() {
        return baseContent;
    }

    public void setBaseContent(String baseContent) {
        this.baseContent = baseContent;
    }

    public String getEntpAuth() {
        return entpAuth;
    }

    public void setEntpAuth(String entpAuth) {
        this.entpAuth = entpAuth;
    }
}
