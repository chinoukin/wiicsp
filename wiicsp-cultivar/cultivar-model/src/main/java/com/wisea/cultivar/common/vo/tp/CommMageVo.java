package com.wisea.cultivar.common.vo.tp;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;

/**
 * @Description: 商品, 品种信息
 * @author: wangs
 * @date :2017/12/16
 */
@ApiModel("商品,品种信息")
public class CommMageVo {

    /** (品类)id */
    @JsonSerialize(using = IdSerializer.class)
    private Long id;
    /** pid 父id */
    @JsonSerialize(using = IdSerializer.class)
    private Long pid;
    /** 商品(品类)编号 */
    private String commNum;
    /** 商品(品类)名称 */
    private String commName;
    /** 助记码 */
    private String zjm;
    /** 商品(品类)状态:有效、无效: */
    private String effeInvalState;
    /** 商品(品类)标志 */
    private String delFlag;
    /** 创建者 */
    private String createBy;
    /** 创建日期 */
    // @JsonSerialize(using = OffsetDateTimeSerializer.class)
    // @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime createDate;
    /** 更新者 */
    private String updateBy;
    /** 更新日期 */
    // @JsonSerialize(using = OffsetDateTimeSerializer.class)
    // @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime updateDate;
    /** 备注 */
    private String remarks;
    /** 返回商品(品类)各级名称 */
    private String commNameAndPName;

    public String getCommNameAndPName() {
        return commNameAndPName;
    }

    public void setCommNameAndPName(String commNameAndPName) {
        this.commNameAndPName = commNameAndPName;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

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

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public String getZjm() {
        return zjm;
    }

    public void setZjm(String zjm) {
        this.zjm = zjm;
    }

    public String getEffeInvalState() {
        return effeInvalState;
    }

    public void setEffeInvalState(String effeInvalState) {
        this.effeInvalState = effeInvalState;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public OffsetDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(OffsetDateTime createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public OffsetDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(OffsetDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
