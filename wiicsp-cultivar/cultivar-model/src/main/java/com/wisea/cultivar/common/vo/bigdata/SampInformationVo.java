package com.wisea.cultivar.common.vo.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cultivar.common.serializer.OffsetDateSerializer;
import com.wisea.cultivar.common.vo.tp.SampPictureGetVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @ClassNameSampInformationVo
 * @Description
 * @Author zhangbo
 * @Date2020/9/3 15:09
 **/
@ApiModel("SampInformationVo抽样检测信息vo")
public class SampInformationVo {

    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="样品名称")
    private String sampName;

    @ApiModelProperty(value="监测结果")
    private String resultType;

    @ApiModelProperty(value="抽样地区")
    private String sampCity;

    @ApiModelProperty(value="抽样日期")
    @JsonSerialize(
            using = OffsetDateSerializer.class
    )
    private OffsetDateTime sampDate;

    private List<SampPictureGetVo> pictures;

    public String getSampName() {
        return sampName;
    }

    public void setSampName(String sampName) {
        this.sampName = sampName;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getSampCity() {
        return sampCity;
    }

    public void setSampCity(String sampCity) {
        this.sampCity = sampCity;
    }

    public OffsetDateTime getSampDate() {
        return sampDate;
    }

    public void setSampDate(OffsetDateTime sampDate) {
        this.sampDate = sampDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<SampPictureGetVo> getPictures() {
        return pictures;
    }

    public void setPictures(List<SampPictureGetVo> pictures) {
        this.pictures = pictures;
    }
}
