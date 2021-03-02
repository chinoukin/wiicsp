package com.wisea.cultivar.supply.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * 服务单列表
 * @author chengq
 * @date 2020/8/12 10:18
 */
public class SerListVo {

    /**
     * 服务单id
     */
    @ApiModelProperty("服务单id")
    private String id;

    /**
     * 商品标题
     */
    @ApiModelProperty("商品标题")
    private String commTitle;

    /**
     * 服务单编号
     */
    @ApiModelProperty("服务单编号")
    private String serListNo;

    /**
     * 商品图片
     */
    @ApiModelProperty("商品图片")
    private String pictureUrl;

    /**
     * 图片类型
     */
    @ApiModelProperty("图片类型 0-图片 1-视频")
    private String pictureType;

    /**
     * 服务单金额
     */
    @ApiModelProperty(value = "服务单金额", example = "¥3.00")
    private String totalPrice;

    /**
     * 数量
     */
    @ApiModelProperty(value = "数量", example = "500株")
    private String num;

    /**
     * 预约时间
     */
    @ApiModelProperty(value = "预约时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime subscribeDate;

    /**
     * 服务单状态
     */
    @ApiModelProperty(value = "服务单状态 0-待确认 1-待服务 2-服务中 3-已取消 4-已完成")
    private String stateType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommTitle() {
        return commTitle;
    }

    public void setCommTitle(String commTitle) {
        this.commTitle = commTitle;
    }

    public String getSerListNo() {
        return serListNo;
    }

    public void setSerListNo(String serListNo) {
        this.serListNo = serListNo;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getPictureType() {
        return pictureType;
    }

    public void setPictureType(String pictureType) {
        this.pictureType = pictureType;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public OffsetDateTime getSubscribeDate() {
        return subscribeDate;
    }

    public void setSubscribeDate(OffsetDateTime subscribeDate) {
        this.subscribeDate = subscribeDate;
    }

    public String getStateType() {
        return stateType;
    }

    public void setStateType(String stateType) {
        this.stateType = stateType;
    }
}
