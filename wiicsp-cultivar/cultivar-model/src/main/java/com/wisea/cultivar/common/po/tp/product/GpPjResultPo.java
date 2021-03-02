package com.wisea.cultivar.common.po.tp.product;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Description: 果品评价结果传入参数
 * @author: wangs
 * @date :2019/6/6
 */
@ApiModel("果品评价结果传入参数")
public class GpPjResultPo {

    @ApiModelProperty("编辑的时候传递")
    private Long id;
    /**
     * 商品id
     */
    @ApiModelProperty("品类id")
    @Check(test = "required",requiredMsg = "品类id不能为空")
    private Long commId;

    /**
     * 商品品种id
     */
    @ApiModelProperty("品种id")
    @Check(test = "required",requiredMsg = "品种id不能为空")
    private Long commVarietId;

    /**
     * 商品产地省
     */
    @ApiModelProperty("商品产地省")
    private String commLocalProv;

    /**
     * 商品产地市
     */
    @ApiModelProperty("商品产地市")
    private String commLocalCity;

    /**
     * 商品产地区县
     */
    @ApiModelProperty("商品产地区县")
    private String commLocalCou;

    /**
     * 上市时间
     */
    @ApiModelProperty("上市时间")
    @Check(test = "required",requiredMsg = "上市时间不能为空")
    private String ssDate;

    /**
     * 综合评价
     */
    @ApiModelProperty("综合评价")
    @Check(test = "required",requiredMsg = "综合评价不能为空")
    private String compEval;

    @ApiModelProperty("标记字段用于存储品类,品种信息")
    private String remarks;

    @ApiModelProperty("传递评价指标")
    private List<PjZbList> pjZbList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCommLocalProv() {
        return commLocalProv;
    }

    public void setCommLocalProv(String commLocalProv) {
        this.commLocalProv = commLocalProv;
    }

    public String getCommLocalCity() {
        return commLocalCity;
    }

    public void setCommLocalCity(String commLocalCity) {
        this.commLocalCity = commLocalCity;
    }

    public String getCommLocalCou() {
        return commLocalCou;
    }

    public void setCommLocalCou(String commLocalCou) {
        this.commLocalCou = commLocalCou;
    }

    public String getSsDate() {
        return ssDate;
    }

    public void setSsDate(String ssDate) {
        this.ssDate = ssDate;
    }

    public String getCompEval() {
        return compEval;
    }

    public void setCompEval(String compEval) {
        this.compEval = compEval;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<PjZbList> getPjZbList() {
        return pjZbList;
    }

    public void setPjZbList(List<PjZbList> pjZbList) {
        this.pjZbList = pjZbList;
    }
}
