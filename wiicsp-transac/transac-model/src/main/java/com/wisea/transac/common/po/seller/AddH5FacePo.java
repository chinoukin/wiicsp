package com.wisea.transac.common.po.seller;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

public class AddH5FacePo {

    @ApiModelProperty("订单号，由合作方上送，每次唯一，此信息为本次人脸核身上送的信息，不能超过32位")
    @Check(test = {"required"})
    private String orderNo;

    @ApiModelProperty(value="人脸采集图片")
    private String faceCollection;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getFaceCollection() {
        return faceCollection;
    }

    public void setFaceCollection(String faceCollection) {
        this.faceCollection = faceCollection;
    }
}
