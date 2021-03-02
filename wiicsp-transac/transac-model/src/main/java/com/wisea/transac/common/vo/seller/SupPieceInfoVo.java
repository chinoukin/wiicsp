package com.wisea.transac.common.vo.seller;

import com.wisea.transac.common.vo.FileVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className SupPieceInfoVo
 * @date 2020/7/1 13:16
 * @Description 优势单品详情Vo
 */
@ApiModel("优势单品详情Vo")
public class SupPieceInfoVo {
    private Long id;
    @ApiModelProperty("基地id")
    private Long baseId;
    @ApiModelProperty("优势单品品种id(销售商品分类id)")
    private Long supPieceId;
    @ApiModelProperty("单品名称")
    private String supPieceName;
    @ApiModelProperty("上市时间")
    private String marketDate;
    @ApiModelProperty("年产量")
    private Double ncl;
    @ApiModelProperty("单品亮点介绍")
    private String supPieceContent;
    @ApiModelProperty("优势单品图片列表")
    private List<FileVo> files;

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

    public List<FileVo> getFiles() {
        return files;
    }

    public void setFiles(List<FileVo> files) {
        this.files = files;
    }
}
