package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cultivar.common.vo.tp.QuarantinePictureGetVo;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * QuarantineReportInsertPo
 * 2019/01/14 13:35:42
 */
public class QuarantineReportInsertPo {
    /**
     * 会员id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "会员id")
    private Long membId;

    /**
     * 检疫证编号
     */
    @Check(test = "required",requiredMsg = "检疫证编号不能为空")
    @ApiModelProperty(value = "检疫证编号")
    private String quarantineNum;

    /**
     * 产品名称/动物种类
     */
    @Check(test = "required",requiredMsg = "产品名称/动物种类不能为空")
    @ApiModelProperty(value = "产品名称/动物种类")
    private String productName;

    /**
     * 数量及单位
     */
    @Check(test = "required",requiredMsg = "数量及单位不能为空")
    @ApiModelProperty(value = "数量及单位")
    private String slDw;

    /**
     * 产地
     */
    @ApiModelProperty(value = "产地")
    private String originPlace;

    /**
     * 货主
     */
    @Check(test = "required",requiredMsg = "货主不能为空")
    @ApiModelProperty(value = "货主")
    private String shipper;

    /**
     * 签发日期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @Check(test = "required",requiredMsg = "签发日期不能为空")
    @ApiModelProperty(value = "签发日期")
    private OffsetDateTime issueDate;

    /**
     * 联系电话
     */
    @Check(test = "required",requiredMsg = "联系电话不能为空")
    @ApiModelProperty(value = "联系电话")
    private String tel;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "图片信息")
    private List<QuarantinePictureGetVo> quarantinePicture;

    public List<QuarantinePictureGetVo> getQuarantinePicture() {
        return quarantinePicture;
    }

    public void setQuarantinePicture(List<QuarantinePictureGetVo> quarantinePicture) {
        this.quarantinePicture = quarantinePicture;
    }

    /**
     * 获取会员id
     */
    public Long getMembId() {
        return membId;
    }

    /**
     * 设置会员id
     */
    public void setMembId(Long membId) {
        this.membId = membId;
    }

    /**
     * 获取检疫证编号
     */
    public String getQuarantineNum() {
        return quarantineNum;
    }

    /**
     * 设置检疫证编号
     */
    public void setQuarantineNum(String quarantineNum) {
        this.quarantineNum = quarantineNum == null ? null : quarantineNum.trim();
    }

    /**
     * 获取产品名称/动物种类
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置产品名称/动物种类
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * 获取数量及单位
     */
    public String getSlDw() {
        return slDw;
    }

    /**
     * 设置数量及单位
     */
    public void setSlDw(String slDw) {
        this.slDw = slDw == null ? null : slDw.trim();
    }

    /**
     * 获取产地
     */
    public String getOriginPlace() {
        return originPlace;
    }

    /**
     * 设置产地
     */
    public void setOriginPlace(String originPlace) {
        this.originPlace = originPlace == null ? null : originPlace.trim();
    }

    /**
     * 获取货主
     */
    public String getShipper() {
        return shipper;
    }

    /**
     * 设置货主
     */
    public void setShipper(String shipper) {
        this.shipper = shipper == null ? null : shipper.trim();
    }

    /**
     * 获取签发日期
     */
    public OffsetDateTime getIssueDate() {
        return issueDate;
    }

    /**
     * 设置签发日期
     */
    public void setIssueDate(OffsetDateTime issueDate) {
        this.issueDate = issueDate;
    }

    /**
     * 获取联系电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置联系电话
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}
