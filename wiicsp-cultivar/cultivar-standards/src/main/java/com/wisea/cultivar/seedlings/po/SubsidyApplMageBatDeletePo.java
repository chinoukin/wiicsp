package com.wisea.cultivar.seedlings.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * SubsidyApplMageBatDeletePo
 * 2020/08/06 14:19:24
 */
public class SubsidyApplMageBatDeletePo {
    /**
     * 批量删除列表
     */
    @Check(test = "required")
    @ApiModelProperty(value = "批量删除/批量审核/批量标记为已拨付列表")
    private List<Long> delList;
    /**
     * 补贴申请状态
     */
    @Check(test = "required")
    @ApiModelProperty(value = "补贴申请状态")
    private String subsidyApplStateType;

    /**
     * 审核意见
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "审核意见", allowableValues = "mixLength:(,255]")
    private String examFailReason;

    /**
     * 获取批量删除列表
     */
    public List<Long> getDelList() {
        return delList;
    }

    /**
     * 设置批量删除列表
     */
    public void setDelList(List<Long> delList) {
        this.delList = delList;
    }

    public String getSubsidyApplStateType() {
        return subsidyApplStateType;
    }

    public void setSubsidyApplStateType(String subsidyApplStateType) {
        this.subsidyApplStateType = subsidyApplStateType;
    }

    public String getExamFailReason() {
        return examFailReason;
    }

    public void setExamFailReason(String examFailReason) {
        this.examFailReason = examFailReason;
    }
}
