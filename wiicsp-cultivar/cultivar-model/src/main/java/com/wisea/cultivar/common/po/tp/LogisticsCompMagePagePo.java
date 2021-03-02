package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cultivar.common.vo.tp.LogisticsCompMageListVo;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import io.swagger.annotations.ApiModelProperty;

/**
 * LogisticsCompMagePagePo
 * 2018/09/18 14:36:47
 */
public class LogisticsCompMagePagePo extends PagePo<LogisticsCompMageListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 物流公司名称
     */
    @ApiModelProperty(value = "物流公司名称")
    private String logisticsCompName;

    /**
     * 代码
     */
    @ApiModelProperty(value = "代码")
    private String logisticsCompCode;

    @ApiModelProperty(value = "联系方式")
    private String tel;

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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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
     * 获取物流公司名称
     */
    public String getLogisticsCompName() {
        return logisticsCompName;
    }

    /**
     * 设置物流公司名称
     */
    public void setLogisticsCompName(String logisticsCompName) {
        this.logisticsCompName = logisticsCompName == null ? null : logisticsCompName.trim();
    }

    /**
     * 获取代码
     */
    public String getLogisticsCompCode() {
        return logisticsCompCode;
    }

    /**
     * 设置代码
     */
    public void setLogisticsCompCode(String logisticsCompCode) {
        this.logisticsCompCode = logisticsCompCode == null ? null : logisticsCompCode.trim();
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
