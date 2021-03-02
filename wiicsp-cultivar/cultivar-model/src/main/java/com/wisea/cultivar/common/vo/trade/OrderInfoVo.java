package com.wisea.cultivar.common.vo.trade;

import com.wisea.cloud.common.util.ConverterUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @ClassName: OrderInfoVo
 * @Author: tgz
 * @Date: 2020/8/5 9:13
 */
@ApiModel("预约信息Vo")
public class OrderInfoVo {

    @ApiModelProperty("联系人")
    private String conter;
    @ApiModelProperty("联系电话")
    private String 	contTel;
    @ApiModelProperty("服务日期")
    private OffsetDateTime serDate;
    @ApiModelProperty("服务日期")
    private String serDateStr;
    @ApiModelProperty("服务地区省")
    private String serAreaProv;
    @ApiModelProperty("服务地区市")
    private String serAreaCity;
    @ApiModelProperty("服务地区区县")
    private String serAreaCou;
    @ApiModelProperty("服务详细地址")
    private String selAddress;

    public String getSerAreaProv() {
        return serAreaProv;
    }

    public void setSerAreaProv(String serAreaProv) {
        this.serAreaProv = serAreaProv;
    }

    public String getSerAreaCity() {
        return serAreaCity;
    }

    public void setSerAreaCity(String serAreaCity) {
        this.serAreaCity = serAreaCity;
    }

    public String getSerAreaCou() {
        return serAreaCou;
    }

    public void setSerAreaCou(String serAreaCou) {
        this.serAreaCou = serAreaCou;
    }

    public String getConter() {
        return conter;
    }

    public void setConter(String conter) {
        this.conter = conter;
    }

    public String getContTel() {
        return contTel;
    }

    public void setContTel(String contTel) {
        this.contTel = contTel;
    }

    public OffsetDateTime getSerDate() {
        return serDate;
    }

    public void setSerDate(OffsetDateTime serDate) {
        this.serDate = serDate;
    }

    public String getSerDateStr() {
        if(null != this.serDate){
            this.serDateStr = ConverterUtil.offsetDateTimeFormat(this.serDate, ConverterUtil.FORMATE_DATE_MLINE);
        }
        return serDateStr;
    }

    public void setSerDateStr(String serDateStr) {
        this.serDateStr = serDateStr;
    }

    public String getSelAddress() {
        return selAddress;
    }

    public void setSelAddress(String selAddress) {
        this.selAddress = selAddress;
    }
}
