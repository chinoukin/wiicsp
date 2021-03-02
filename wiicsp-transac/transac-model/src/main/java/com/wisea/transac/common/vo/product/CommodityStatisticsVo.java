package com.wisea.transac.common.vo.product;

import com.wisea.transac.common.vo.CommPictureInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Description: 商家app 商品统计返回参数
 * @author: wangs
 * @date :2020/5/25
 */
@ApiModel("商家app 商品统计返回参数")
public class CommodityStatisticsVo {

    @ApiModelProperty("商品发布的id")
    private Long id;

    @ApiModelProperty("商品标题")
    private String commTitle;

    @ApiModelProperty("累计销售金额")
    private Double transactionAmount;

    @ApiModelProperty("销售数量")
    private Double salesCount;

    @ApiModelProperty("购买人数")
    private Integer purchasesNum;

    @ApiModelProperty("图片信息")
    private List<CommPictureInfoVo> commPicture;

    public Double getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(Double salesCount) {
        this.salesCount = salesCount;
    }

    public Integer getPurchasesNum() {
        if (purchasesNum == 0) {
            purchasesNum = null;
        }
        return purchasesNum;
    }

    public void setPurchasesNum(Integer purchasesNum) {
        this.purchasesNum = purchasesNum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommTitle() {
        return commTitle;
    }

    public void setCommTitle(String commTitle) {
        this.commTitle = commTitle;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public List<CommPictureInfoVo> getCommPicture() {
        return commPicture;
    }

    public void setCommPicture(List<CommPictureInfoVo> commPicture) {
        this.commPicture = commPicture;
    }
}
