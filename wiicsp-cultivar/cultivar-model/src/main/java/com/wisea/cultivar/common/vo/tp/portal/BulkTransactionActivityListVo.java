package com.wisea.cultivar.common.vo.tp.portal;

import java.io.Serializable;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 大宗交易列表显示信息Vo
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月29日
 * @version 1.0
 */
@ApiModel("大宗交易列表显示信息Vo")
public class BulkTransactionActivityListVo implements Serializable{

	private static final long serialVersionUID = -8015558092585511833L;

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

	@ApiModelProperty(value = "图片地址")
	private String imgUrl;

    public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@ApiModelProperty(value = "商品名称")
    private String commName;

    @ApiModelProperty(value = "交易额")
    private Double transPrice;

    @ApiModelProperty(value = "交易内容")
    private String transSubject;

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "交易日期")
    private OffsetDateTime transDate;

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
     * 获取商品名称
     */
    public String getCommName() {
        return commName;
    }

    /**
     * 设置商品名称
     */
    public void setCommName(String commName) {
        this.commName = commName == null ? null : commName.trim();
    }

    /**
     * 获取交易额
     */
    public Double getTransPrice() {
        return transPrice;
    }

    /**
     * 设置交易额
     */
    public void setTransPrice(Double transPrice) {
        this.transPrice = transPrice;
    }

    /**
     * 获取交易内容
     */
    public String getTransSubject() {
        return transSubject;
    }

    /**
     * 设置交易内容
     */
    public void setTransSubject(String transSubject) {
        this.transSubject = transSubject == null ? null : transSubject.trim();
    }

    /**
     * 获取交易日期
     */
    public OffsetDateTime getTransDate() {
        return transDate;
    }

    /**
     * 设置交易日期
     */
    public void setTransDate(OffsetDateTime transDate) {
        this.transDate = transDate;
    }

}
