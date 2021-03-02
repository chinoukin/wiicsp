package com.wisea.cultivar.common.entity.tp;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

/**
 * import_bill 表实体
 * 进货单
 * 2018/09/19 16:06:10
 */
public class ImportBill extends DataLongEntity<ImportBill> {
	private static final long serialVersionUID = 4277584266793525793L;

	/**
     * 商品发布id
     */
    private Long commPubId;

    /**
     * 会员id
     */
    private Long membId;

    /**
     * 卖方ID
     */
    private Long sellerId;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 批发价
     */
    private Double price;

    /**
     * 代理价
     */
    private Double agentPrice;

    /**
     * 商品加入的时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    protected OffsetDateTime joinTime; // 鍒涘缓鏃ユ湡

    /**
     * 商品发布类型（大宗批发、中小零批）
     */
    private String commPubType;

    /**
     * 商品规格
     */
    private Double commSpec;

    /**
     * 商品等级
     */
    private String commLevelType;

    /**
     * 获取商品发布id
     */
    public Long getCommPubId() {
        return commPubId;
    }

    /**
     * 设置商品发布id
     */
    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
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
     * 获取卖方ID
     */
    public Long getSellerId() {
        return sellerId;
    }

    /**
     * 设置卖方ID
     */
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    /**
     * 获取数量
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置数量
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 获取批发价
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置批发价
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取代理价
     */
    public Double getAgentPrice() {
        return agentPrice;
    }

    /**
     * 设置代理价
     */
    public void setAgentPrice(Double agentPrice) {
        this.agentPrice = agentPrice;
    }

	public OffsetDateTime getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(OffsetDateTime joinTime) {
		this.joinTime = joinTime;
	}

    public String getCommPubType() {
        return commPubType;
    }

    public void setCommPubType(String commPubType) {
        this.commPubType = commPubType;
    }

	public Double getCommSpec() {
		return commSpec;
	}

	public void setCommSpec(Double commSpec) {
		this.commSpec = commSpec;
	}

	public String getCommLevelType() {
		return commLevelType;
	}

	public void setCommLevelType(String commLevelType) {
		this.commLevelType = commLevelType;
	}
}
