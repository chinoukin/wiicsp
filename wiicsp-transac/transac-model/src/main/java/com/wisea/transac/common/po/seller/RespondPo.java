package com.wisea.transac.common.po.seller;

import io.swagger.annotations.ApiModelProperty;

public class RespondPo {

    @ApiModelProperty(value = "人脸核身结果的返回码\n" +
            "0：人脸核身成功\n" +
            "其他错误码：失败")
    private String code;

    @ApiModelProperty(value = "订单号，由合作方上送，每次唯一，此信息为本次人脸核身上送的信息")
    private String orderNo;

    @ApiModelProperty(value="人脸采集图片")
    private String faceCollection;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

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
