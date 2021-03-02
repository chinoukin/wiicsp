package com.wisea.transac.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel("优势单品分页查询Vo")
public class FindSupPieceListVo {

    @ApiModelProperty("数据ID")
    private Long id;
    /**
     * 基地id
     */
    @ApiModelProperty(value = "基地id")
    private Long baseId;

    /**
     * 优势单品品种id(销售商品分类id)
     */
    @ApiModelProperty(value = "优势单品品种id(销售商品分类id)")
    private Long supPieceId;

    /**
     * 单品名称
     */
    @ApiModelProperty(value = "单品名称")
    private String supPieceName;

    /**
     * 上市时间
     */
    @ApiModelProperty(value = "上市时间")
    private String marketDate;

    /**
     * 年产量
     */
    @ApiModelProperty(value = "年产量")
    private Double ncl;

    /**
     * 单品亮点介绍
     */
    @ApiModelProperty(value = "单品亮点介绍")
    private String supPieceContent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBaseId() {
        return baseId;
    }

    public void setBaseId(Long baseId) {
        this.baseId = baseId;
    }

    public Long getSupPieceId() {
        return supPieceId;
    }

    public void setSupPieceId(Long supPieceId) {
        this.supPieceId = supPieceId;
    }

    public String getSupPieceName() {
        return supPieceName;
    }

    public void setSupPieceName(String supPieceName) {
        this.supPieceName = supPieceName;
    }

    public String getMarketDate() {
        return marketDate;
    }

    public void setMarketDate(String marketDate) {
        this.marketDate = marketDate;
    }

    public Double getNcl() {
        return ncl;
    }

    public void setNcl(Double ncl) {
        this.ncl = ncl;
    }

    public String getSupPieceContent() {
        return supPieceContent;
    }

    public void setSupPieceContent(String supPieceContent) {
        this.supPieceContent = supPieceContent;
    }
}
