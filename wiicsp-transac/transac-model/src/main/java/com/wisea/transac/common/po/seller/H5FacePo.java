package com.wisea.transac.common.po.seller;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("人脸核身Po")
public class H5FacePo {

    @ApiModelProperty(value="姓名")
    @Check(test = {"required"})
    private String name;

    @ApiModelProperty(value="身份证号")
    @Check(test = {"required"})
    private String idNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }
}
