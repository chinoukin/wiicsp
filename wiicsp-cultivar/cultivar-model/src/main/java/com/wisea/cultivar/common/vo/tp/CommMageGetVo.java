package com.wisea.cultivar.common.vo.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * CommMageGetVo
 * 2018/09/18 14:36:47
 */
public class CommMageGetVo {
    /**
     * 商品id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品id")
    private Long id;

    /**
     * pid
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "pid")
    private Long pid;

    /**
     * pids
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "pids")
    private Long pids;

    /**
     * 商品编号
     */
    @ApiModelProperty(value = "商品编号")
    private String commNum;

    /**
     * 商品分类名称
     */
    @ApiModelProperty(value = "商品分类名称")
    private String commCatgName;

    /**
     * 商品状态（有效、无效）
     */
    @ApiModelProperty(value = "商品状态（有效、无效）")
    private String effeInvalState;

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
     * 获取商品id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置商品id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取pid
     */
    public Long getPid() {
        return pid;
    }

    /**
     * 设置pid
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * 获取pids
     */
    public Long getPids() {
        return pids;
    }

    /**
     * 设置pids
     */
    public void setPids(Long pids) {
        this.pids = pids;
    }

    /**
     * 获取商品编号
     */
    public String getCommNum() {
        return commNum;
    }

    /**
     * 设置商品编号
     */
    public void setCommNum(String commNum) {
        this.commNum = commNum == null ? null : commNum.trim();
    }

    /**
     * 获取商品分类名称
     */
    public String getCommCatgName() {
        return commCatgName;
    }

    /**
     * 设置商品分类名称
     */
    public void setCommCatgName(String commCatgName) {
        this.commCatgName = commCatgName == null ? null : commCatgName.trim();
    }

    /**
     * 获取商品状态（有效、无效）
     */
    public String getEffeInvalState() {
        return effeInvalState;
    }

    /**
     * 设置商品状态（有效、无效）
     */
    public void setEffeInvalState(String effeInvalState) {
        this.effeInvalState = effeInvalState == null ? null : effeInvalState.trim();
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
