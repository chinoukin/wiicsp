package com.wisea.cultivar.common.po.tp.product;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @Description: 首页查询传入参数
 * @author: wangs
 * @date :2019/5/31
 */
@ApiModel("查询传入参数")
public class AvailableSupplyPo {

    @ApiModelProperty("品类id")
    private Long commId;

    @ApiModelProperty("商品发布品名称")
    private String commPubName;

    @ApiModelProperty("品种id")
    private Long commVarietId;

    @ApiModelProperty("品牌id")
    private Long brandId;

    @ApiModelProperty("属性id")
    private Long commAttriId;

    @ApiModelProperty("计数")
    private Integer countNum;

    @ApiModelProperty("属性id列表")
    private List<String> commAttriIdList;

    @ApiModelProperty("属性值")
    private String commAttriVal;

    @ApiModelProperty("属性值列表")
    private List<String> commAttriValList;

    @ApiModelProperty("注册地省份信息")
    private String registAddressProv;

    @ApiModelProperty("注册地城市信息")
    private String registAddressCity;

    @ApiModelProperty("交易模式")
    private String commPubType;

    @ApiModelProperty("挂单类型")
    private String supplyModeType;

    @ApiModelProperty("搜索时间的类型")
    private String searchTimeType;

    @ApiModelProperty("品类的父id")
    private String remarks;

    /**
     * 按可售时间自定义时间搜索
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty("按可售时间自定义时间搜索")
    private OffsetDateTime startTime;

    /**
     * 按可售时间自定义时间搜索
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty("按可售时间自定义时间搜索")
    private OffsetDateTime endTime;
    @ApiModelProperty("登陆后传递会员id搜索")
    private String membId;
    @ApiModelProperty("登陆后传递会员id搜索")
    private String viewMembId;

    @ApiModelProperty("没有登录传递,任意只要这个字段有值就行")
    private String notDxhyBds;

    public String getNotDxhyBds() {
        return notDxhyBds;
    }

    public void setNotDxhyBds(String notDxhyBds) {
        this.notDxhyBds = notDxhyBds;
    }

    public String getViewMembId() {
        return viewMembId;
    }

    public void setViewMembId(String viewMembId) {
        this.viewMembId = viewMembId;
    }

    public String getMembId() {
        return membId;
    }

    public void setMembId(String membId) {
        this.membId = membId;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public String getCommPubName() {
        return commPubName;
    }

    public void setCommPubName(String commPubName) {
        this.commPubName = commPubName;
    }

    public Long getCommVarietId() {
        return commVarietId;
    }

    public void setCommVarietId(Long commVarietId) {
        this.commVarietId = commVarietId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getCommAttriId() {
        return commAttriId;
    }

    public void setCommAttriId(Long commAttriId) {
        this.commAttriId = commAttriId;
    }

    public String getCommAttriVal() {
        return commAttriVal;
    }

    public void setCommAttriVal(String commAttriVal) {
        this.commAttriVal = commAttriVal;
    }

    public List<String> getCommAttriIdList() {
        return commAttriIdList;
    }

    public void setCommAttriIdList(List<String> commAttriIdList) {
        this.commAttriIdList = commAttriIdList;
    }

    public List<String> getCommAttriValList() {
        return commAttriValList;
    }

    public void setCommAttriValList(List<String> commAttriValList) {
        this.commAttriValList = commAttriValList;
    }

    public Integer getCountNum() {
        return countNum;
    }

    public void setCountNum(Integer countNum) {
        this.countNum = countNum;
    }

    public String getRegistAddressProv() {
        return registAddressProv;
    }

    public void setRegistAddressProv(String registAddressProv) {
        this.registAddressProv = registAddressProv;
    }

    public String getRegistAddressCity() {
        return registAddressCity;
    }

    public void setRegistAddressCity(String registAddressCity) {
        this.registAddressCity = registAddressCity;
    }

    public String getCommPubType() {
        return commPubType;
    }

    public void setCommPubType(String commPubType) {
        this.commPubType = commPubType;
    }

    public String getSupplyModeType() {
        return supplyModeType;
    }

    public void setSupplyModeType(String supplyModeType) {
        this.supplyModeType = supplyModeType;
    }

    public String getSearchTimeType() {
        return searchTimeType;
    }

    public void setSearchTimeType(String searchTimeType) {
        this.searchTimeType = searchTimeType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public OffsetDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
    }

    public OffsetDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(OffsetDateTime endTime) {
        this.endTime = endTime;
    }

}
