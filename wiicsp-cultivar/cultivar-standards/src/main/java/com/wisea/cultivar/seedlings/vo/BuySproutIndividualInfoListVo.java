package com.wisea.cultivar.seedlings.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * BuySproutInfoListVo
 * 2020/08/06 14:19:24
 */
public class BuySproutIndividualInfoListVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 服务单id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "服务单id")
    private Long serListId;

    @ApiModelProperty(value = "服务单编号")
    private String serListNo;

    @ApiModelProperty(value = "种植户")
    private String plantName;

    @ApiModelProperty(value = "种植地点")
    private String plantLocation;

    @ApiModelProperty(value = "种苗名称")
    private String commTitle;

    @ApiModelProperty(value = "数量（株）")
    private Integer num;

    @ApiModelProperty(value = "经度")
    private String jd;

    @ApiModelProperty(value = "纬度")
    private String wd;

    @ApiModelProperty(value = "下单时间")
    private String startDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSerListId() {
        return serListId;
    }

    public void setSerListId(Long serListId) {
        this.serListId = serListId;
    }

    public String getSerListNo() {
        return serListNo;
    }

    public void setSerListNo(String serListNo) {
        this.serListNo = serListNo;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getPlantLocation() {
        return plantLocation;
    }

    public void setPlantLocation(String plantLocation) {
        this.plantLocation = plantLocation;
    }

    public String getCommTitle() {
        return commTitle;
    }

    public void setCommTitle(String commTitle) {
        this.commTitle = commTitle;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getJd() {
        return jd;
    }

    public void setJd(String jd) {
        this.jd = jd;
    }

    public String getWd() {
        return wd;
    }

    public void setWd(String wd) {
        this.wd = wd;
    }
}
