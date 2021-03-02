package com.wisea.cultivar.common.vo.tp.lta;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 商品规格列表
 * @author: wangs
 * @date :2019/5/8
 */
@ApiModel("包装规格列表返回值")
public class LtaCommPackListVo {

    @ApiModelProperty("包装规格id")
    @JsonSerialize(using = IdSerializer.class)
    private Long id;
    /**
     * 长协商品信息id
     */
    @ApiModelProperty("长协商品信息id")
    @JsonSerialize(using = IdSerializer.class)
    private Long ltaCommRelaId;

    /**
     * 计量单位(计量单位管理表id)
     */
    @ApiModelProperty("计量单位")
    @JsonSerialize(using = IdSerializer.class)
    private Long measUnitId;

    @ApiModelProperty("计量单位名称")
    private String measUnitName;

    /**
     * 规格重量
     */
    @ApiModelProperty("规格装量")
    private Double spec;

    /**
     * 包装说明
     */
    @ApiModelProperty("包装说明")
    private String packInstr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
