package com.wisea.cultivar.common.po.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.bigdata.ClOrdInfoListVo;
import io.swagger.annotations.ApiModelProperty;

/**
 * ClOrdInfoPagePo
 * 2019/12/02 11:02:14
 */
public class ClOrdInfoPagePo extends PagePo<ClOrdInfoListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 待处理
     */
    @ApiModelProperty(value = "待处理")
    private Integer dcl;

    /**
     * 打包中
     */
    @ApiModelProperty(value = "打包中")
    private Integer dbz;

    /**
     * 在途中
     */
    @ApiModelProperty(value = "在途中")
    private Integer ztz;

    /**
     * 已完成
     */
    @ApiModelProperty(value = "已完成")
    private Integer ywc;

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
     * 获取待处理
     */
    public Integer getDcl() {
        return dcl;
    }

    /**
     * 设置待处理
     */
    public void setDcl(Integer dcl) {
        this.dcl = dcl;
    }

    /**
     * 获取打包中
     */
    public Integer getDbz() {
        return dbz;
    }

    /**
     * 设置打包中
     */
    public void setDbz(Integer dbz) {
        this.dbz = dbz;
    }

    /**
     * 获取在途中
     */
    public Integer getZtz() {
        return ztz;
    }

    /**
     * 设置在途中
     */
    public void setZtz(Integer ztz) {
        this.ztz = ztz;
    }

    /**
     * 获取已完成
     */
    public Integer getYwc() {
        return ywc;
    }

    /**
     * 设置已完成
     */
    public void setYwc(Integer ywc) {
        this.ywc = ywc;
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
