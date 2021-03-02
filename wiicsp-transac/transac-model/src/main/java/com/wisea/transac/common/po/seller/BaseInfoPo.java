package com.wisea.transac.common.po.seller;

import com.wisea.cloud.model.annotation.Check;
import com.wisea.transac.common.po.FilePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className BaseInfoPo
 * @date 2020/6/30 14:30
 * @Description 保存或修改基地PO
 */
@ApiModel("保存或修改基地PO")
public class BaseInfoPo {
    @ApiModelProperty("基地id")
    @Check(test = {"required"})
    private Long id;
    @ApiModelProperty("基地名称")
    @Check(test = {"required"})
    private String baseName;
    @ApiModelProperty("基地详情")
    private String baseContent;
    @ApiModelProperty("基地类型")
    @Check(test = {"required"})
    private String baseType;
    @ApiModelProperty("省")
    @Check(test = "logic", logic = "'0'.equals(#baseType)?#isNotEmpty(#areaProv):true", logicMsg = "省份不能为空")
    private String areaProv;
    @ApiModelProperty("市")
    @Check(test = "logic", logic = "'0'.equals(#baseType)?#isNotEmpty(#areaCity):true", logicMsg = "市不能为空")
    private String areaCity;
    @ApiModelProperty("区县")
    @Check(test = "logic", logic = "'0'.equals(#baseType)?#isNotEmpty(#areaCou):true", logicMsg = "区县不能为空")
    private String areaCou;
    @ApiModelProperty("详细地址")
    @Check(test = "logic", logic = "'0'.equals(#baseType)?#isNotEmpty(#address):true", logicMsg = "详细地址不能为空")
    private String address;
    @ApiModelProperty("经度")
    @Check(test = "logic", logic = "'0'.equals(#baseType)?#isNotEmpty(#jd):true", logicMsg = "经纬度不能为空")
    private String jd;
    @ApiModelProperty("纬度")
    @Check(test = "logic", logic = "'0'.equals(#baseType)?#isNotEmpty(#wd):true", logicMsg = "经纬度不能为空")
    private String wd;
    @ApiModelProperty("国外产地id")
    @Check(test = "logic", logic = "'1'.equals(#baseType)?#isNotEmpty(#abroadId):true", logicMsg = "国外产地不能为空")
    private Long abroadId;
    @ApiModelProperty("基地图片/视频列表")
    @Check(test = { "required" }, cascade = true)
    private List<FilePo> fileLists;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public String getBaseContent() {
        return baseContent;
    }

    public void setBaseContent(String baseContent) {
        this.baseContent = baseContent;
    }

    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }

    public String getAreaProv() {
        return areaProv;
    }

    public void setAreaProv(String areaProv) {
        this.areaProv = areaProv;
    }

    public String getAreaCity() {
        return areaCity;
    }

    public void setAreaCity(String areaCity) {
        this.areaCity = areaCity;
    }

    public String getAreaCou() {
        return areaCou;
    }

    public void setAreaCou(String areaCou) {
        this.areaCou = areaCou;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getAbroadId() {
        return abroadId;
    }

    public void setAbroadId(Long abroadId) {
        this.abroadId = abroadId;
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

    public List<FilePo> getFileLists() {
        return fileLists;
    }

    public void setFileLists(List<FilePo> fileLists) {
        this.fileLists = fileLists;
    }
}
