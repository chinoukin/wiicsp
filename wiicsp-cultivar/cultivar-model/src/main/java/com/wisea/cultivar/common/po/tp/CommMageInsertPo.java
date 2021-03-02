package com.wisea.cultivar.common.po.tp;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * CommMageInsertPo
 * 2018/09/18 14:36:47
 */
@ApiModel("商品分类添加PO")
public class CommMageInsertPo {
    @ApiModelProperty("商品ID-修改时使用")
    private Long id;
    @Check(test = "required", requiredMsg = "商品分类pid不能为空")
    @ApiModelProperty(value = "商品分类pid")
    private Long pid;
    @ApiModelProperty(value = "商品分类编码")
    private String commNum;
    @Check(test = "required", requiredMsg = "商品分类名称不能为空")
    @ApiModelProperty(value = "商品分类名称")
    private String commCatgName;
    @Check(test = "required", requiredMsg = "分类排序不能为空")
    @ApiModelProperty("分类排序")
    private Integer sort;
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "商品状态（有效、无效）")
    private String effeInvalState;
    @ApiModelProperty("分类图标")
    private String catgIconUrl;
    @ApiModelProperty("关键词")
    private String keyWord;
    @ApiModelProperty("分类描述")
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getEffeInvalState() {
        return effeInvalState;
    }

    public void setEffeInvalState(String effeInvalState) {
        this.effeInvalState = effeInvalState;
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
