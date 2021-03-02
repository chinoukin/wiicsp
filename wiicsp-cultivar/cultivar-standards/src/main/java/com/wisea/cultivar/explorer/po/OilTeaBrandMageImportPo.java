package com.wisea.cultivar.explorer.po;


import com.wisea.cloud.common.util.excel.annotation.ExcelField;
import com.wisea.cloud.model.annotation.Check;


import java.io.Serializable;
import java.time.OffsetDateTime;

public class OilTeaBrandMageImportPo implements Serializable{

    /**
     * 品牌名称
     */
    @Check(test = {"required", "minLength", "maxLength" }, lengthRange = { 2, 100 })
    @ExcelField(title = "品牌名称")
    private String brandName;

    /**
     * 品牌编号
     */
    @ExcelField(title = "品牌编号")
    private String brandNo;


    /**
     * 品牌介绍
     */
    @ExcelField(title = "品牌介绍")
    private String brandIntroduce;
    /**
     * 申请时间
     */
    @ExcelField(title = "申请时间")
    private String applDateStr;

    /**
     * 申请时间
     */
    private OffsetDateTime applDate;

    /**
     * 联系人
     */
    @ExcelField(title = "联系人")
    private String conter;

    /**
     * 联系方式
     */
    @ExcelField(title = "联系方式")
    private String contTel;


    /**
     * 获取品牌名称
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * 设置品牌名称
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    /**
     * 获取品牌编号
     */
    public String getBrandNo() {
        return brandNo;
    }

    /**
     * 设置品牌编号
     */
    public void setBrandNo(String brandNo) {
        this.brandNo = brandNo == null ? null : brandNo.trim();
    }

    /**
     * 获取品牌介绍
     */
    public String getBrandIntroduce() {
        return brandIntroduce;
    }

    /**
     * 设置品牌介绍
     */
    public void setBrandIntroduce(String brandIntroduce) {
        this.brandIntroduce = brandIntroduce == null ? null : brandIntroduce.trim();
    }

    public OffsetDateTime getApplDate() {
        return applDate;
    }

    public void setApplDate(OffsetDateTime applDate) {
        this.applDate = applDate;
    }

    public String getApplDateStr() {
        return applDateStr;
    }

    public void setApplDateStr(String applDateStr) {
        this.applDateStr = applDateStr;
    }

    /**
     * 获取联系人
     */
    public String getConter() {
        return conter;
    }

    /**
     * 设置联系人
     */
    public void setConter(String conter) {
        this.conter = conter == null ? null : conter.trim();
    }

    /**
     * 获取联系方式
     */
    public String getContTel() {
        return contTel;
    }

    /**
     * 设置联系方式
     */
    public void setContTel(String contTel) {
        this.contTel = contTel == null ? null : contTel.trim();
    }

}
