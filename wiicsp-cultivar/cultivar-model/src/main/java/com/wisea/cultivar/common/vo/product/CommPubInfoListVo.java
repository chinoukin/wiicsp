package com.wisea.cultivar.common.vo.product;

import com.wisea.cultivar.common.vo.CommPictureInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Author wangs
 * CommPubInfoListVo
 * 2018/09/18 14:36:47
 */
@ApiModel("发布商品列表返回值")
public class CommPubInfoListVo {

    @ApiModelProperty("商品发布的id")
    private Long id;

    @ApiModelProperty("会员id")
    private Long membId;

    @ApiModelProperty("商品编号")
    private String commNum;

    @ApiModelProperty("商品标题")
    private String commTitle;

    @ApiModelProperty("销售品类设置id")
    private Long commSaleSetId;

    @ApiModelProperty("品类设置名称")
    private String commSalesSetName;

    @ApiModelProperty("销售设置排序信息")
    private Integer sort;

    @ApiModelProperty("销售品类id")
    private Long commSaleId;

    @ApiModelProperty("销售品类名称")
    private String commSaleName;

    @ApiModelProperty("销售排序信息")
    private Integer commSort;

    @ApiModelProperty("档口id")
    private Long stallsMageId;

    @ApiModelProperty("商品状态")
    private String commStateType;

    @ApiModelProperty("成交金额")
    private Double transactionAmount;

    @ApiModelProperty("价格区间")
    private String priceRang;

    @ApiModelProperty("价格最小")
    private String minPrice;


    @ApiModelProperty("图片信息")
    private List<CommPictureInfoVo> commPicture;

    private String catgName;

    public String getCatgName() {
        return catgName;
    }

    public void setCatgName(String catgName) {
        this.catgName = catgName;
    }

    public String getCommStateType() {
        return commStateType;
    }

    public void setCommStateType(String commStateType) {
        this.commStateType = commStateType;
    }

    public Long getCommSaleSetId() {
        return commSaleSetId;
    }

    public void setCommSaleSetId(Long commSaleSetId) {
        this.commSaleSetId = commSaleSetId;
    }

    public String getCommSalesSetName() {
        return commSalesSetName;
    }

    public void setCommSalesSetName(String commSalesSetName) {
        this.commSalesSetName = commSalesSetName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getCommSaleId() {
        return commSaleId;
    }

    public void setCommSaleId(Long commSaleId) {
        this.commSaleId = commSaleId;
    }

    public String getCommSaleName() {
        return commSaleName;
    }

    public void setCommSaleName(String commSaleName) {
        this.commSaleName = commSaleName;
    }

    public Integer getCommSort() {
        return commSort;
    }

    public void setCommSort(Integer commSort) {
        this.commSort = commSort;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getCommNum() {
        return commNum;
    }

    public void setCommNum(String commNum) {
        this.commNum = commNum;
    }

    public String getCommTitle() {
        return commTitle;
    }

    public void setCommTitle(String commTitle) {
        this.commTitle = commTitle;
    }

    public Long getStallsMageId() {
        return stallsMageId;
    }

    public void setStallsMageId(Long stallsMageId) {
        this.stallsMageId = stallsMageId;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getPriceRang() {
        return priceRang;
    }

    public void setPriceRang(String priceRang) {
        this.priceRang = priceRang;
    }


    public List<CommPictureInfoVo> getCommPicture() {
        return commPicture;
    }

    public void setCommPicture(List<CommPictureInfoVo> commPicture) {
        this.commPicture = commPicture;
    }
}
