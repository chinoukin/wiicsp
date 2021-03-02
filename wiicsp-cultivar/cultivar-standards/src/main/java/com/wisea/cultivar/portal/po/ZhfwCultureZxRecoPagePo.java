package com.wisea.cultivar.portal.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.portal.vo.ZhfwCultureZxRecoListVo;
import io.swagger.annotations.ApiModelProperty;

/**
 * ZhfwCultureZxRecoPagePo
 * 2020/08/24 20:28:13
 */
public class ZhfwCultureZxRecoPagePo extends PagePo<ZhfwCultureZxRecoListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 种植服文化资讯列表id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "种植服文化资讯列表id")
    private Long zhfwCultureZxListId;

    /**
     * 显示顺序
     */
    @ApiModelProperty(value = "显示顺序")
    private Integer sort;

    /**
     * 是否显示
     */
    @ApiModelProperty(value = "是否显示")
    private String showFlag;

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

    public String getShowFlag() {
        return showFlag;
    }

    public void setShowFlag(String showFlag) {
        this.showFlag = showFlag;
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
     * 获取种植服文化资讯列表id
     */
    public Long getZhfwCultureZxListId() {
        return zhfwCultureZxListId;
    }

    /**
     * 设置种植服文化资讯列表id
     */
    public void setZhfwCultureZxListId(Long zhfwCultureZxListId) {
        this.zhfwCultureZxListId = zhfwCultureZxListId;
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
