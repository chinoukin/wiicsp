package com.wisea.transac.common.po.seller;

import com.wisea.cloud.model.annotation.Check;
import com.wisea.transac.common.po.FilePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className SupPieceInfoPo
 * @date 2020/7/1 13:27
 * @Description 新增或修改优势单品PO
 */
@ApiModel("新增或修改优势单品PO")
public class SupPieceInfoPo {
    @ApiModelProperty("数据ID，修改时非空")
    private Long id;
    @ApiModelProperty("基地id")
    @Check(test = {"required"})
    private Long baseId;
    @ApiModelProperty("优势单品品种id(销售商品分类id)")
    @Check(test = {"required"})
    private Long supPieceId;
    @ApiModelProperty("单品名称")
    @Check(test = {"required"})
    private String supPieceName;
    @ApiModelProperty("上市时间")
    @Check(test = {"required"})
    private String marketDate;
    @ApiModelProperty("年产量")
    @Check(test = {"required"})
    private Double ncl;
    @ApiModelProperty("单品亮点介绍")
    private String supPieceContent;
    @ApiModelProperty("优势单品图片列表")
    private List<FilePo> files;

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

    public List<FilePo> getFiles() {
        return files;
    }

    public void setFiles(List<FilePo> files) {
        this.files = files;
    }
}
