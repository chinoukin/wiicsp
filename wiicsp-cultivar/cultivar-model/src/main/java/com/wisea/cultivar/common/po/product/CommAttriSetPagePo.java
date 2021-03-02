package com.wisea.cultivar.common.po.product;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.product.CommAttriSetListVo;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * CommAttriSetPagePo
 * 2018/09/18 14:36:47
 */
public class CommAttriSetPagePo extends PagePo<CommAttriSetListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 商品id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品id")
    private Long commId;

    /**
     * 属性ID
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "属性ID")
    private Long attriId;

    /**
     * 属性名称
     */
    @ApiModelProperty(value = "属性名称")
    private String commAttriName;

    /**
     * 属性名称
     */
    @ApiModelProperty(value = "属性名称")
    private Long attriName;

    /**
     * 是否必填
     */
    @ApiModelProperty(value = "是否必填")
    private String ifRequ;

    /**
     * 搜索条件
     */
    @ApiModelProperty(value = "搜索条件")
    private String ifSearch;

    /**
     * 显示顺序
     */
    @ApiModelProperty(value = "显示顺序")
    private Integer sort;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "分类ID")
    private Long classifyId;

    /**
     * 分类父id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "分类父id")
    private Long pid;

    @ApiModelProperty("id集合")
    private List<Long> commIds;
    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Long classifyId) {
        this.classifyId = classifyId;
    }

    public String getCommAttriName() {
        return commAttriName;
    }

    public void setCommAttriName(String commAttriName) {
        this.commAttriName = commAttriName;
    }

    public Long getAttriName() {
        return attriName;
    }

    public void setAttriName(Long attriName) {
        this.attriName = attriName;
    }

    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取商品id
     */
    public Long getCommId() {
        return commId;
    }

    /**
     * 设置商品id
     */
    public void setCommId(Long commId) {
        this.commId = commId;
    }

    /**
     * 获取属性ID
     */
    public Long getAttriId() {
        return attriId;
    }

    /**
     * 设置属性ID
     */
    public void setAttriId(Long attriId) {
        this.attriId = attriId;
    }

    /**
     * 获取是否必填
     */
    public String getIfRequ() {
        return ifRequ;
    }

    /**
     * 设置是否必填
     */
    public void setIfRequ(String ifRequ) {
        this.ifRequ = ifRequ == null ? null : ifRequ.trim();
    }

    /**
     * 获取搜索条件
     */
    public String getIfSearch() {
        return ifSearch;
    }

    /**
     * 设置搜索条件
     */
    public void setIfSearch(String ifSearch) {
        this.ifSearch = ifSearch == null ? null : ifSearch.trim();
    }

    /**
     * 获取显示顺序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置显示顺序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 获取删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public List<Long> getCommIds() {
        return commIds;
    }

    public void setCommIds(List<Long> commIds) {
        this.commIds = commIds;
    }
}
