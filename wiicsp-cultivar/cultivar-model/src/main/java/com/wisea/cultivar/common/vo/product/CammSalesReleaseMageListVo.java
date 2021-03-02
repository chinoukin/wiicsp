package com.wisea.cultivar.common.vo.product;

import com.wisea.cloud.common.util.ConverterUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 销售分类配置信息
 * @author: wangs
 * @date :2020/4/30
 */
@ApiModel("销售分类配置信息")
public class CammSalesReleaseMageListVo {

    @ApiModelProperty("id")
    private Long id;
    /**
     * 基础品类id
     */
    @ApiModelProperty("基础品类id")
    private Long commId;

    /**
     * 基础品类名称
     */
    @ApiModelProperty("基础品类名称")
    private String cammName;

    /**
     * 所属销售分类名称
     */
    @ApiModelProperty("所属销售分类名称")
    private String salesCatgName;

    /**
     * 所属销售分类id
     */
    @ApiModelProperty("销售分类id")
    private Long commSalesCatgId;

    /**
     * 销售分类配置id
     */
    @ApiModelProperty("销售分类配置id")
    private Long commSalesReleaseId;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private String sort;

    @ApiModelProperty("首字母信息")
    private String keyWord;

    private String label;

    private Long value;

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getLabel() {
        if (ConverterUtil.isNotEmpty(cammName)) {
            label = cammName;
        }
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getValue() {
        if (ConverterUtil.isNotEmpty(id)) {
            value = id;
        }
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public String getCammName() {
        return cammName;
    }

    public void setCammName(String cammName) {
        this.cammName = cammName;
    }

    public String getSalesCatgName() {
        return salesCatgName;
    }

    public void setSalesCatgName(String salesCatgName) {
        this.salesCatgName = salesCatgName;
    }

    public Long getCommSalesCatgId() {
        return commSalesCatgId;
    }

    public void setCommSalesCatgId(Long commSalesCatgId) {
        this.commSalesCatgId = commSalesCatgId;
    }

    public Long getCommSalesReleaseId() {
        return commSalesReleaseId;
    }

    public void setCommSalesReleaseId(Long commSalesReleaseId) {
        this.commSalesReleaseId = commSalesReleaseId;
    }
}
