package com.wisea.transac.common.vo.seller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("关注的商品分页查询Vo")
public class FollowCommMiniPageListVo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="会员id")
    private Long membId;

    @ApiModelProperty(value="商品发布id")
    private Long commPubId;

    @ApiModelProperty(value="商品标题")
    private String commTitle;

    @ApiModelProperty(value="商品图片")
    private String url;

    @ApiModelProperty("价格区间")
    private String priceRang;

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

    public Long getCommPubId() {
        return commPubId;
    }

    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
    }

    public String getCommTitle() {
        return commTitle;
    }

    public void setCommTitle(String commTitle) {
        this.commTitle = commTitle;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPriceRang() {
        return priceRang;
    }

    public void setPriceRang(String priceRang) {
        this.priceRang = priceRang;
    }
}
