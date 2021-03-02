package com.wisea.transac.common.po.product;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 改变商品状态传入参数
 * @author: wangs
 * @date :2020/5/13
 */
@ApiModel("改变商品状态传入参数")
public class CommPubInfoStatePo {

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    @Check(test = "required")
    private Long id;

    @ApiModelProperty("传 状态标识 0,销售中 即上架操作; 1, 驳回操作 ; 传3,下架操作; 2 ,后台审核操作; 5 , 删除操作  ")
    @Check(test = "required")
    private String stateType;

    /**
     * 驳回原因（审核意见）
     */
    @ApiModelProperty("驳回原因")
    private String rejectReason;

    @ApiModelProperty("审核人id")
    private Long examId;

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

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

    public String getStateType() {
        return stateType;
    }

    public void setStateType(String stateType) {
        this.stateType = stateType;
    }
}
