package com.wisea.cultivar.common.vo.bigdata;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @ClassNameSampInfoDataVo
 * @Description
 * @Author zhangbo
 * @Date2020/9/3 18:30
 **/
@ApiModel("抽样监测数据分析vo")
public class SampInfoDataVo {

    @ApiModelProperty(value="获取总抽检数")
    private Double totalStatistics;

    @ApiModelProperty(value="合格数")
    private Double qualifiedQuantity;

    @ApiModelProperty(value="不合格数")
    private  Double unqualifiedQuantity;

    @ApiModelProperty(value="合格率")
    private String passRate;

    @ApiModelProperty(value="不合格率")
    private String unqualifiedRate;

    @ApiModelProperty(value="获取抽样监测信息")
    private List<SampInformationVo> sampInformationVo;

    @ApiModelProperty(value="湖南省各个市区合格数")
    private List<CityAndQuantity> cityAndQuantity;

    public Double getTotalStatistics() {
        return totalStatistics;
    }

    public void setTotalStatistics(Double totalStatistics) {
        this.totalStatistics = totalStatistics;
    }

    public Double getQualifiedQuantity() {
        return qualifiedQuantity;
    }

    public void setQualifiedQuantity(Double qualifiedQuantity) {
        this.qualifiedQuantity = qualifiedQuantity;
    }

    public Double getUnqualifiedQuantity() {
        return unqualifiedQuantity;
    }

    public void setUnqualifiedQuantity(Double unqualifiedQuantity) {
        this.unqualifiedQuantity = unqualifiedQuantity;
    }

    public String getPassRate() {
        return passRate;
    }

    public void setPassRate(String passRate) {
        this.passRate = passRate;
    }

    public String getUnqualifiedRate() {
        return unqualifiedRate;
    }

    public void setUnqualifiedRate(String unqualifiedRate) {
        this.unqualifiedRate = unqualifiedRate;
    }

    public List<SampInformationVo> getSampInformationVo() {
        return sampInformationVo;
    }

    public void setSampInformationVo(List<SampInformationVo> sampInformationVo) {
        this.sampInformationVo = sampInformationVo;
    }

    public List<CityAndQuantity> getCityAndQuantity() {
        return cityAndQuantity;
    }

    public void setCityAndQuantity(List<CityAndQuantity> cityAndQuantity) {
        this.cityAndQuantity = cityAndQuantity;
    }
}
