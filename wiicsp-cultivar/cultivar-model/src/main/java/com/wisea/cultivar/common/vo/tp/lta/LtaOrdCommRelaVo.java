package com.wisea.cultivar.common.vo.tp.lta;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className LtaOrdCommRelaVo
 * @date 2019/5/8 13:46
 * @Description 订单商品Vo
 */
@ApiModel("订单商品Vo")
public class LtaOrdCommRelaVo {
    @ApiModelProperty("商品发布ID")
    private Long ltaCommRelaId;
    @ApiModelProperty("商品图片url")
    private String commPicUrl;
    @ApiModelProperty("商品名称")
    private String commName;
    @ApiModelProperty("商品品牌名称")
    private String brandName;
    @ApiModelProperty("等级")
    private String level;
    @ApiModelProperty("包装说明")
    private String packInstr;
    @ApiModelProperty("商品单价")
    private Double price;
    @ApiModelProperty("商品货号")
    private String commHh;
    @ApiModelProperty("商品编号")
    private String commNum;
    @ApiModelProperty("购买数量")
    private Integer slNum;
    @ApiModelProperty("计量单位")
    private String measUnitName;
    @ApiModelProperty("规格重量")
    private Double spec;
    @ApiModelProperty("商品单价小计")
    private Double priceCount;

    /**后台字段**/
    @ApiModelProperty("商品结算价格小计")
    private Double settlePriceCount;
    @ApiModelProperty("平台服务费小计")
    private Double platfCostCount;

    public Long getLtaCommRelaId() {
        return ltaCommRelaId;
    }

    public void setLtaCommRelaId(Long ltaCommRelaId) {
        this.ltaCommRelaId = ltaCommRelaId;
    }

    public String getCommPicUrl() {
        return commPicUrl;
    }

    public void setCommPicUrl(String commPicUrl) {
        this.commPicUrl = commPicUrl;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPackInstr() {
        return packInstr;
    }

    public void setPackInstr(String packInstr) {
        this.packInstr = packInstr;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCommHh() {
        return commHh;
    }

    public void setCommHh(String commHh) {
        this.commHh = commHh;
    }

    public String getCommNum() {
        return commNum;
    }

    public void setCommNum(String commNum) {
        this.commNum = commNum;
    }

    public Integer getSlNum() {
        return slNum;
    }

    public void setSlNum(Integer slNum) {
        this.slNum = slNum;
    }

    public String getMeasUnitName() {
        return measUnitName;
    }

    public void setMeasUnitName(String measUnitName) {
        this.measUnitName = measUnitName;
    }

    public Double getSpec() {
        return spec;
    }

    public void setSpec(Double spec) {
        this.spec = spec;
    }

    public Double getPriceCount() {
        return priceCount;
    }

    public void setPriceCount(Double priceCount) {
        this.priceCount = priceCount;
    }

    public Double getSettlePriceCount() {
        return settlePriceCount;
    }

    public void setSettlePriceCount(Double settlePriceCount) {
        this.settlePriceCount = settlePriceCount;
    }

    public Double getPlatfCostCount() {
        return platfCostCount;
    }

    public void setPlatfCostCount(Double platfCostCount) {
        this.platfCostCount = platfCostCount;
    }
}
