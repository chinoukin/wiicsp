package com.wisea.cultivar.common.po.product;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.product.CommVarietMageListVo;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author wangs
 * CommVarietMagePagePo
 * 2019/04/15 09:49:09
 */
public class CommVarietMagePagePo extends PagePo<CommVarietMageListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 选中一级的父id
     */
    @ApiModelProperty(value = "pid",hidden = true)
    private Long pid;

    /**
     * 商品id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品id")
    private Long commId;

    /**
     * 品种名称
     */
    @ApiModelProperty(value = "品种名称")
    private String commVarietName;

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
    @ApiModelProperty(value = "ids的list")
    private List<Long> commIds;
    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
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
     * 获取品种名称
     */
    public String getCommVarietName() {
        return commVarietName;
    }

    /**
     * 设置品种名称
     */
    public void setCommVarietName(String commVarietName) {
        this.commVarietName = commVarietName == null ? null : commVarietName.trim();
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
