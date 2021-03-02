package com.wisea.transac.common.vo.seller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className SupPieceInfoListVo
 * @date 2020/7/1 11:26
 * @Description 优势单品列表VO
 */
@ApiModel("优势单品列表VO")
public class SupPieceInfoListVo {
    @ApiModelProperty("数据ID")
    private Long id;
    @ApiModelProperty("单品名称")
    private String supPieceName;
    @ApiModelProperty("上市时间")
    private String marketDate;
    @ApiModelProperty("年产量")
    private Double ncl;
    @ApiModelProperty("图片url")
    private String imgUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
