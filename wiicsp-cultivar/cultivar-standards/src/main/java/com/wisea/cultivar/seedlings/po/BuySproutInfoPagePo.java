package com.wisea.cultivar.seedlings.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.seedlings.vo.BuySproutInfoListVo;
import io.swagger.annotations.ApiModelProperty;

/**
 * BuySproutInfoPagePo
 * 2020/08/06 14:19:24
 */
public class BuySproutInfoPagePo extends PagePo<BuySproutInfoListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 补贴申请管理id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "补贴申请管理id")
    private Long subsidyApplMageId;

    /**
     * 服务单id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "服务单id")
    private Long serListId;

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
     * 获取补贴申请管理id
     */
    public Long getSubsidyApplMageId() {
        return subsidyApplMageId;
    }

    /**
     * 设置补贴申请管理id
     */
    public void setSubsidyApplMageId(Long subsidyApplMageId) {
        this.subsidyApplMageId = subsidyApplMageId;
    }

    /**
     * 获取服务单id
     */
    public Long getSerListId() {
        return serListId;
    }

    /**
     * 设置服务单id
     */
    public void setSerListId(Long serListId) {
        this.serListId = serListId;
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
