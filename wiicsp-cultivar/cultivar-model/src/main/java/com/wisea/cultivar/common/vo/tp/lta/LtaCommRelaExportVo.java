package com.wisea.cultivar.common.vo.tp.lta;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description:
 * @author: wangs
 * @date :2019/5/8
 */
public class LtaCommRelaExportVo {

    /**
     * 商品编号
     */
    @ApiModelProperty("商品编号")
    @ExcelField(title = "商品编号",sort = 15)
    private String commNum;

    /**
     * 商品货号
     */
    @ApiModelProperty("商品货号")
    @ExcelField(title = "商品货号",sort = 10)
    private String commHh;

    /**
     * 商品图片url
     */
    @ApiModelProperty("商品图片url")
    private String commPicUrl;

    /**
     * 商品名称
     */
    @ApiModelProperty("商品名称")
    @ExcelField(title = "商品名称",sort = 20)
    private String commName;

    /**
     * 商品品牌(品牌管理表id)
     */
    @ApiModelProperty("品牌id")
    @JsonSerialize(using = IdSerializer.class)
    private Long brandId;

    @ApiModelProperty("品牌名称")
    @ExcelField(title = "品牌名称",sort = 20)
    private String brandName;

    @ApiModelProperty("商品分类+品种的名称")
    @ExcelField(title = "商品分类",sort = 30)
    private String commCatgVariName;

    /**
     * 商品id
     */
    @ApiModelProperty("后台商品树id")
    @JsonSerialize(using = IdSerializer.class)
    private Long commCatgId;

    /**
     * 品种id
     */
    @ApiModelProperty("后台商品品种id")
    @JsonSerialize(using = IdSerializer.class)
    private Long commVariId;

    /**
     * 等级
     */
    @ApiModelProperty("等级")
    @ExcelField(title = "等级",sort = 20)
    private String level;

    /**
     * 计量单位名称
     */
    @ApiModelProperty("计量单位名称")
    @ExcelField(title = "计量单位名称",sort = 30)
    private String measUnitName;

    /**
     * 规格重量
     */
    @ApiModelProperty("规格装量")
    @ExcelField(title = "规格",sort = 50)
    private String spec;

    /**
     * 包装说明
     */
    @ApiModelProperty("包装说明")
    @ExcelField(title = "包装说明",sort = 20)
    private String packInstr;

    @ApiModelProperty("商品状态")
    @ExcelField(title = "商品状态",sort = 10)
    private String ltaCommStateType;

    public String getCommNum() {
        return commNum;
    }

    public void setCommNum(String commNum) {
        this.commNum = commNum;
    }

    public String getCommHh() {
        return commHh;
    }

    public void setCommHh(String commHh) {
        this.commHh = commHh;
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

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCommCatgVariName() {
        return commCatgVariName;
    }

    public void setCommCatgVariName(String commCatgVariName) {
        this.commCatgVariName = commCatgVariName;
    }

    public Long getCommCatgId() {
        return commCatgId;
    }

    public void setCommCatgId(Long commCatgId) {
        this.commCatgId = commCatgId;
    }

    public Long getCommVariId() {
        return commVariId;
    }

    public void setCommVariId(Long commVariId) {
        this.commVariId = commVariId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMeasUnitName() {
        return measUnitName;
    }

    public void setMeasUnitName(String measUnitName) {
        this.measUnitName = measUnitName;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getPackInstr() {
        return packInstr;
    }

    public void setPackInstr(String packInstr) {
        this.packInstr = packInstr;
    }

    public String getLtaCommStateType() {
        return ltaCommStateType;
    }

    public void setLtaCommStateType(String ltaCommStateType) {
        this.ltaCommStateType = ltaCommStateType;
    }
}
