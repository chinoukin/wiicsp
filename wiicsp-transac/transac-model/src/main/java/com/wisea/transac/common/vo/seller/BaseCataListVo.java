package com.wisea.transac.common.vo.seller;

/**
 * @author wangjiahao
 * @since 2020/7/2 2:07 下午
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("基地品种分类VO")
public class BaseCataListVo {

    @ApiModelProperty("分类ID")
    private Long catgId;
    @ApiModelProperty("分类名称")
    private String catgName;
    @ApiModelProperty("优势单品ID")
    private Long supPieceId;
    @ApiModelProperty("优势单品名称")
    private String supPieceName;
    @ApiModelProperty("基地数量")
    private Integer count;
    @ApiModelProperty("品种名称")
    private String commName;

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public Long getCatgId() {
        return catgId;
    }

    public void setCatgId(Long catgId) {
        this.catgId = catgId;
    }

    public String getCatgName() {
        return catgName;
    }

    public void setCatgName(String catgName) {
        this.catgName = catgName;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
