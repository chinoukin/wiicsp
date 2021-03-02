package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cultivar.common.vo.tp.SettleBillOpreateInfoListVo;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * SettleBillOpreateInfoPagePo
 * 2018/10/13 17:14:52
 */
public class SettleBillOpreateInfoPagePo extends PagePo<SettleBillOpreateInfoListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 结算单id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "结算单id")
    private Long settleId;

    /**
     * 操作者
     */
    @ApiModelProperty(value = "操作者")
    private String operator;

    /**
     * 操作时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "操作时间")
    private OffsetDateTime opreatDate;

    /**
     * 操作内容
     */
    @ApiModelProperty(value = "操作内容")
    private String operatorContent;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取结算单id
     */
    public Long getSettleId() {
        return settleId;
    }

    /**
     * 设置结算单id
     */
    public void setSettleId(Long settleId) {
        this.settleId = settleId;
    }

    /**
     * 获取操作者
     */
    public String getOperator() {
        return operator;
    }

    /**
     * 设置操作者
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * 获取操作时间
     */
    public OffsetDateTime getOpreatDate() {
        return opreatDate;
    }

    /**
     * 设置操作时间
     */
    public void setOpreatDate(OffsetDateTime opreatDate) {
        this.opreatDate = opreatDate;
    }

    /**
     * 获取操作内容
     */
    public String getOperatorContent() {
        return operatorContent;
    }

    /**
     * 设置操作内容
     */
    public void setOperatorContent(String operatorContent) {
        this.operatorContent = operatorContent == null ? null : operatorContent.trim();
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

    /**
     * 获取删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}
