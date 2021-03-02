package com.wisea.cultivar.common.vo.tp.retro;

import com.wisea.cultivar.common.po.tp.LongIdPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className RetrospFlagApplListVo
 * @date 2019/12/20 10:23
 * @Description 追溯标签申请记录Vo
 */
@ApiModel("追溯标签申请记录Vo")
public class RetrospFlagApplListVo extends LongIdPo {
    @ApiModelProperty("批次号")
    private String retrospPcNum;
    @ApiModelProperty("产品名称")
    private String prdutName;
    @ApiModelProperty("申请数量")
    private Integer applSl;
    @ApiModelProperty("申请日期")
    private OffsetDateTime applDate;
    @ApiModelProperty("申请类型")
    private String retroLabelType;
    @ApiModelProperty("申请方式类型")
    private String applModeType;
    @ApiModelProperty("申请状态")
    private String retroLabelState;
    @ApiModelProperty("追溯标签文件url")
    private String fileUrl;
    @ApiModelProperty("追溯标签excel文件url")
    private String excelFileUrl;
    @ApiModelProperty("追溯标签申请记录属性列表")
    private List<RetrospFlagApplAttributeVo> applAttributeVos;

    public String getRetrospPcNum() {
        return retrospPcNum;
    }

    public void setRetrospPcNum(String retrospPcNum) {
        this.retrospPcNum = retrospPcNum;
    }

    public String getPrdutName() {
        return prdutName;
    }

    public void setPrdutName(String prdutName) {
        this.prdutName = prdutName;
    }

    public Integer getApplSl() {
        return applSl;
    }

    public void setApplSl(Integer applSl) {
        this.applSl = applSl;
    }

    public OffsetDateTime getApplDate() {
        return applDate;
    }

    public void setApplDate(OffsetDateTime applDate) {
        this.applDate = applDate;
    }

    public String getRetroLabelType() {
        return retroLabelType;
    }

    public void setRetroLabelType(String retroLabelType) {
        this.retroLabelType = retroLabelType;
    }

    public String getApplModeType() {
        return applModeType;
    }

    public void setApplModeType(String applModeType) {
        this.applModeType = applModeType;
    }

    public String getRetroLabelState() {
        return retroLabelState;
    }

    public void setRetroLabelState(String retroLabelState) {
        this.retroLabelState = retroLabelState;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getExcelFileUrl() {
        return excelFileUrl;
    }

    public void setExcelFileUrl(String excelFileUrl) {
        this.excelFileUrl = excelFileUrl;
    }

    public List<RetrospFlagApplAttributeVo> getApplAttributeVos() {
        return applAttributeVos;
    }

    public void setApplAttributeVos(List<RetrospFlagApplAttributeVo> applAttributeVos) {
        this.applAttributeVos = applAttributeVos;
    }
}
