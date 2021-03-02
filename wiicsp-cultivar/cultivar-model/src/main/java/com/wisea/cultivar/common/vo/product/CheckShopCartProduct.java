package com.wisea.cultivar.common.vo.product;

import com.wisea.cultivar.common.po.product.LevelSpecQuoteMagePo;
import com.wisea.cultivar.common.po.CommAttriMagePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Description:
 * @author: wangs
 * @date :2020/4/23
 */
@ApiModel("比较商品发布是否变更关键信息")
public class CheckShopCartProduct {

    @ApiModelProperty("商品发布id")
    private Long id;
    @ApiModelProperty(value = "品类id")
    private Long commId;
    @ApiModelProperty(value = "商品品种id")
    private Long commVarietId;
    @ApiModelProperty(value = "商品标题")
    private String commTitle;
    @ApiModelProperty(value = "档口id")
    private Long stallsMageId;
    @ApiModelProperty(value = "基地id")
    private Long baseId;

    /**
     * 商品属性
     */
    @ApiModelProperty("商品属性集合")
    private List<CommAttriMagePo> commAttris;
    /**
     * 规格信息
     */
    @ApiModelProperty("商品规格信息")
    private List<LevelSpecQuoteMagePo> commLevelPo;

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

    public Long getCommVarietId() {
        return commVarietId;
    }

    public void setCommVarietId(Long commVarietId) {
        this.commVarietId = commVarietId;
    }

    public String getCommTitle() {
        return commTitle;
    }

    public void setCommTitle(String commTitle) {
        this.commTitle = commTitle;
    }

    public Long getStallsMageId() {
        return stallsMageId;
    }

    public void setStallsMageId(Long stallsMageId) {
        this.stallsMageId = stallsMageId;
    }

    public Long getBaseId() {
        return baseId;
    }

    public void setBaseId(Long baseId) {
        this.baseId = baseId;
    }

    public List<CommAttriMagePo> getCommAttris() {
        return commAttris;
    }

    public void setCommAttris(List<CommAttriMagePo> commAttris) {
        this.commAttris = commAttris;
    }

    public List<LevelSpecQuoteMagePo> getCommLevelPo() {
        return commLevelPo;
    }

    public void setCommLevelPo(List<LevelSpecQuoteMagePo> commLevelPo) {
        this.commLevelPo = commLevelPo;
    }
}