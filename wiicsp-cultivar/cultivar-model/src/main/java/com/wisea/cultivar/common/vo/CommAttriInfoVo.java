package com.wisea.cultivar.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("详细信息Vo")
public class CommAttriInfoVo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="商品发布id")
    private Long commPubId;

    @ApiModelProperty(value="属性id")
    private Long commAttriId;

    @ApiModelProperty(value="属性名称")
    private String commAttriName;

    @ApiModelProperty(value="属性字段")
    private String commAttriColumn;

    @ApiModelProperty(value="属性类型")
    private String commAttriType;

    @ApiModelProperty(value="属性值")
    private String commAttriVal;

    @ApiModelProperty(value="长度")
    private Integer length;

    @ApiModelProperty(value="是否必填")
    private String ifRequ;

    @ApiModelProperty(value="显示顺序")
    private Integer sort;

    private String dictVal;

    public String getDictVal() {
        return dictVal;
    }

    public void setDictVal(String dictVal) {
        this.dictVal = dictVal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommPubId() {
        return commPubId;
    }

    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
    }

    public Long getCommAttriId() {
        return commAttriId;
    }

    public void setCommAttriId(Long commAttriId) {
        this.commAttriId = commAttriId;
    }

    public String getCommAttriName() {
        return commAttriName;
    }

    public void setCommAttriName(String commAttriName) {
        this.commAttriName = commAttriName;
    }

    public String getCommAttriColumn() {
        return commAttriColumn;
    }

    public void setCommAttriColumn(String commAttriColumn) {
        this.commAttriColumn = commAttriColumn;
    }

    public String getCommAttriType() {
        return commAttriType;
    }

    public void setCommAttriType(String commAttriType) {
        this.commAttriType = commAttriType;
    }

    public String getCommAttriVal() {
        return commAttriVal;
    }

    public void setCommAttriVal(String commAttriVal) {
        this.commAttriVal = commAttriVal;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getIfRequ() {
        return ifRequ;
    }

    public void setIfRequ(String ifRequ) {
        this.ifRequ = ifRequ;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
