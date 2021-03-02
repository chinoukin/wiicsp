package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class SupPieceInfo extends DataLongEntity<SupPieceInfo> {
    /**
     * 基地id
     */
    private Long baseId;

    /**
     * 优势单品品种id(销售商品分类id)
     */
    private Long supPieceId;

    /**
     * 单品名称
     */
    private String supPieceName;

    /**
     * 上市时间
     */
    private String marketDate;

    /**
     * 年产量
     */
    private Double ncl;

    /**
     * 单品亮点介绍
     */
    private String supPieceContent;

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
