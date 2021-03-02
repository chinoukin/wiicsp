package com.wisea.cultivar.standards.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.standards.vo.StandardRuleFileMageListVo;
import io.swagger.annotations.ApiModelProperty;

/**
 * StandardRuleFileMagePagePo
 * 2020/07/24 11:21:45
 */
public class StandardRuleFileMagePagePo extends PagePo<StandardRuleFileMageListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 标准规范管理id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "标准规范管理id")
    private Long standardRuleMageId;

    /**
     * 标准附件url
     */
    @ApiModelProperty(value = "标准附件url")
    private String url;

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
     * 获取标准规范管理id
     */
    public Long getStandardRuleMageId() {
        return standardRuleMageId;
    }

    /**
     * 设置标准规范管理id
     */
    public void setStandardRuleMageId(Long standardRuleMageId) {
        this.standardRuleMageId = standardRuleMageId;
    }

    /**
     * 获取标准附件url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置标准附件url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
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
}
