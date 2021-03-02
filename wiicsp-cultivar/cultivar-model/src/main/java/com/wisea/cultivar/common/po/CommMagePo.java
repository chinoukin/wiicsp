package com.wisea.cultivar.common.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("新增或修改Po")
public class CommMagePo {
    @ApiModelProperty(value="商品id")
    private Long id;

    @ApiModelProperty(value="pid")
    private Long pid;

    @ApiModelProperty(value="pids")
    private String pids;

    @ApiModelProperty(value="商品编号")
    private String commNum;

    @ApiModelProperty(value="商品分类名称")
    private String commCatgName;

    @ApiModelProperty(value="商品状态（有效、无效）")
    private String effeInvalState;

    @ApiModelProperty(value="显示顺序")
    private Integer sort;

    @ApiModelProperty(value="分类图标")
    private String catgIconUrl;

    @ApiModelProperty(value="关键词")
    private String keyWord;

    @ApiModelProperty(value="分类描述")
    private String catgRemarks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getPids() {
        return pids;
    }

    public void setPids(String pids) {
        this.pids = pids;
    }

    public String getCommNum() {
        return commNum;
    }

    public void setCommNum(String commNum) {
        this.commNum = commNum;
    }

    public String getCommCatgName() {
        return commCatgName;
    }

    public void setCommCatgName(String commCatgName) {
        this.commCatgName = commCatgName;
    }

    public String getEffeInvalState() {
        return effeInvalState;
    }

    public void setEffeInvalState(String effeInvalState) {
        this.effeInvalState = effeInvalState;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getCatgIconUrl() {
        return catgIconUrl;
    }

    public void setCatgIconUrl(String catgIconUrl) {
        this.catgIconUrl = catgIconUrl;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getCatgRemarks() {
        return catgRemarks;
    }

    public void setCatgRemarks(String catgRemarks) {
        this.catgRemarks = catgRemarks;
    }
}
