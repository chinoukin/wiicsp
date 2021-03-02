package com.wisea.cultivar.common.po.tp.lta;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description:
 * @author: wangs
 * @date :2019/5/7
 */
public class LtaCommPackPo {

    /**
     * 长协商品信息id
     */
    @ApiModelProperty("长协商品信息id")
    private Long ltaCommRelaId;

    /**
     * 计量单位(计量单位管理表id)
     */
    @ApiModelProperty("计量单位")
    @Check(test = "required", requiredMsg = "计量单位不能为空")
    private Long measUnitId;

    @ApiModelProperty("计量单位名称")
    private String measUnitName;

    /**
     * 规格重量
     */
    @ApiModelProperty("规格重量")
    @Check(test = "required", requiredMsg = "规格重量不能为空")
    private Double spec;

    /**
     * 包装说明
     */
    @ApiModelProperty("包装说明")
    @Check(test = "required", requiredMsg = "包装说明不能为空")
    private String packInstr;

    public Long getLtaCommRelaId() {
        return ltaCommRelaId;
    }

    public void setLtaCommRelaId(Long ltaCommRelaId) {
        this.ltaCommRelaId = ltaCommRelaId;
    }

    public Long getMeasUnitId() {
        return measUnitId;
    }

    public void setMeasUnitId(Long measUnitId) {
        this.measUnitId = measUnitId;
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

    public String getPackInstr() {
        return packInstr;
    }

    public void setPackInstr(String packInstr) {
        this.packInstr = packInstr;
    }
}
