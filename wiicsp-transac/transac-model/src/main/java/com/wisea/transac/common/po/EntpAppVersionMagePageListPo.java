package com.wisea.transac.common.po;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.EntpAppVersionMagePageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("企业版本分页查询Po")
public class EntpAppVersionMagePageListPo extends PagePo<EntpAppVersionMagePageListVo> {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="来源类型,0.采购app，1.档口app，2.产地app")
    private String sourceType;

    @ApiModelProperty(value="版本类型")
    private String appVersionType;

    @ApiModelProperty(value="版本名称")
    private String appVersionName;

    @ApiModelProperty(value="版本号")
    private String versionNum;

    @ApiModelProperty(value="是否强制更新")
    private String ifDisplayType;

    @ApiModelProperty(value="更新地址")
    private String updateUrl;

    @ApiModelProperty(value="更新内容")
    private String updateContent;

    @ApiModelProperty(value="处理时间_前缀")
    private OffsetDateTime oprdateFront;

    @ApiModelProperty(value="处理时间_后缀")
    private OffsetDateTime oprdateBack;

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public OffsetDateTime getOprdateFront() {
        return oprdateFront;
    }

    public void setOprdateFront(OffsetDateTime oprdateFront) {
        this.oprdateFront = oprdateFront;
    }

    public OffsetDateTime getOprdateBack() {
        return oprdateBack;
    }

    public void setOprdateBack(OffsetDateTime oprdateBack) {
        this.oprdateBack = oprdateBack;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppVersionType() {
        return appVersionType;
    }

    public void setAppVersionType(String appVersionType) {
        this.appVersionType = appVersionType;
    }

    public String getAppVersionName() {
        return appVersionName;
    }

    public void setAppVersionName(String appVersionName) {
        this.appVersionName = appVersionName;
    }

    public String getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(String versionNum) {
        this.versionNum = versionNum;
    }

    public String getIfDisplayType() {
        return ifDisplayType;
    }

    public void setIfDisplayType(String ifDisplayType) {
        this.ifDisplayType = ifDisplayType;
    }

    public String getUpdateUrl() {
        return updateUrl;
    }

    public void setUpdateUrl(String updateUrl) {
        this.updateUrl = updateUrl;
    }

    public String getUpdateContent() {
        return updateContent;
    }

    public void setUpdateContent(String updateContent) {
        this.updateContent = updateContent;
    }
}
