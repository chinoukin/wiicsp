package com.wisea.cultivar.supply.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import com.wisea.cloud.common.util.ConverterUtil;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 商品发布
 * @author chengq
 * @date 2020/8/13 15:03
 */
public class CommoditySavePo {

    @ApiModelProperty("id")
    private Long id;

    /**
     * 商品主图片
     */
    @ApiModelProperty("商品主图片")
    @Size(max = 5, message = "商品主图最多上传5张")
    private List<PicturePo> mainPicture = Lists.newArrayList();

    @ApiModelProperty("商品标题")
    @NotBlank(message = "商品标题不能为空")
    @Length(max = 30, message = "商品标题不能超过30字")
    private String commTitle;

    /**
     * 分类
     */
    @ApiModelProperty("分类id")
    @NotNull(message = "分类不能为空")
    private Long commId;

    /**
     * 品种
     */
    @ApiModelProperty("品种id")
    private Long commVarietId;

    /**
     * 属性id集合
     */
    @ApiModelProperty("属性")
    @NotNull(message = "属性不能为空")
    @Size(min = 1, message = "必须选择一个属性")
    private List<CommAttriPo> attris;

    /**
     * 价格
     */
    @ApiModelProperty("价格")
    @NotNull(message = "价格不能为空")
    private CommPriceUnitPo priceUnit;

    /**
     * 发货省
     */
    @ApiModelProperty("发货省")
    private String commSendProvId;

    /**
     * 发货市
     */
    @ApiModelProperty("发货市")
    private String commSendCityId;

    /**
     * 发货县
     */
    @ApiModelProperty("发货县")
    private String commSendCouId;

    /**
     * 发货省
     */
    @ApiModelProperty("发货省")
    private String commSendProv;

    /**
     * 发货市
     */
    @ApiModelProperty("发货市")
    private String commSendCity;

    /**
     * 发货县
     */
    @ApiModelProperty("发货县")
    private String commSendCou;

    /**
     * 描述
     */
    @ApiModelProperty("描述")
    @Length(max = 1000, message = "描述最多1000字")
    private String commSignature;

    /**
     * 细节图片
     */
    @ApiModelProperty("细节图片")
    @Size(max = 9, message = "细节图片最多上传9张")
    private List<PicturePo> detailsPrices = Lists.newArrayList();

    /**
     * 服务须知
     */
    @ApiModelProperty("服务须知")
    @Length(max = 1000, message = "服务须知最多1000字")
    private String notesToBuy;

    /**
     * 商品发布状态
     */
    @Pattern(regexp = "[012]", message = "商品发布状态只能为0,1,2")
    @ApiModelProperty("商品发布状态（新增不用传） 0-保持原状态、1-草稿、2-上架/审核")
    private String commStateType;

    /**
     * 会员id（服务商）
     */
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Long membId;

    /**
     * 发货详细地址
     */
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private String commSendAddress;

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

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public Long getCommVarietId() {
        return commVarietId;
    }

    public void setCommVarietId(Long commVarietId) {
        this.commVarietId = commVarietId;
    }

    public CommPriceUnitPo getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(CommPriceUnitPo priceUnit) {
        this.priceUnit = priceUnit;
    }

    public String getCommSendProvId() {
        return commSendProvId;
    }

    public void setCommSendProvId(String commSendProvId) {
        this.commSendProvId = commSendProvId;
    }

    public String getCommSendCityId() {
        return commSendCityId;
    }

    public void setCommSendCityId(String commSendCityId) {
        this.commSendCityId = commSendCityId;
    }

    public String getCommSendCouId() {
        return commSendCouId;
    }

    public void setCommSendCouId(String commSendCouId) {
        this.commSendCouId = commSendCouId;
    }

    public String getCommSignature() {
        return commSignature;
    }

    public void setCommSignature(String commSignature) {
        this.commSignature = commSignature;
    }

    public String getNotesToBuy() {
        return notesToBuy;
    }

    public void setNotesToBuy(String notesToBuy) {
        this.notesToBuy = notesToBuy;
    }

    public String getCommStateType() {
        return commStateType;
    }

    public void setCommStateType(String commStateType) {
        this.commStateType = commStateType;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public List<PicturePo> getMainPicture() {
        return mainPicture;
    }

    public void setMainPicture(List<PicturePo> mainPicture) {
        this.mainPicture = mainPicture;
    }

    public List<PicturePo> getDetailsPrices() {
        return detailsPrices;
    }

    public void setDetailsPrices(List<PicturePo> detailsPrices) {
        this.detailsPrices = detailsPrices;
    }

    public List<CommAttriPo> getAttris() {
        return attris;
    }

    public void setAttris(List<CommAttriPo> attris) {
        this.attris = attris;
    }

    public String getCommSendProv() {
        return commSendProv;
    }

    public void setCommSendProv(String commSendProv) {
        this.commSendProv = commSendProv;
    }

    public String getCommSendCity() {
        return commSendCity;
    }

    public void setCommSendCity(String commSendCity) {
        this.commSendCity = commSendCity;
    }

    public String getCommSendCou() {
        return commSendCou;
    }

    public void setCommSendCou(String commSendCou) {
        this.commSendCou = commSendCou;
    }

    public String getCommSendAddress() {
        return commSendAddress;
    }

    public void setCommSendAddress(String commSendAddress) {
        this.commSendAddress = commSendAddress;
    }

    /**
     * 设置详细地址
     */
    public void initCommSendAddr() {
        if (ConverterUtil.isOrEmpty(commSendProv, commSendCity, commSendCou)) {
            return;
        }
        this.commSendAddress = commSendProv + commSendCity + commSendCou;
    }
}
