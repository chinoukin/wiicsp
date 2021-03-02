package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

/**
 * fruits_price 表实体
 * 水果价格
 * 2019/05/28 16:20:20
 */
public class FruitsPrice extends DataLongEntity<FruitsPrice> {
    private static final long serialVersionUID = 1L;

    /**
     * 日期
     */
    private OffsetDateTime fpDate;

    /**
     * 商品分类
     */
    private Long commId;

    /**
     * 商品品种
     */
    private Long commVarietId;

    /**
     * 地区-省
     */
    private String areaProv;

    /**
     * 地区-市
     */
    private String areaCity;

    /**
     * 地区-区县
     */
    private String areaCou;

    /**
     * 单价
     */
    private Double price;

    /**
     * 品类父节点
     */
    private Long commPid;

    /**
     * 地区中文名称
     */
    private String areaDetail;

    /**
     * 品类名称
     */
    private String commName;

    /**
     * 品种名称
     */
    private String commVarietName;

    /**
     * 对比升降标识
     */
    private String compUdType;

    /**
     * 比较的数值
     */
    private Double compValue;


    /**
     * 获取日期
     */
    public OffsetDateTime getFpDate() {
        return fpDate;
    }

    /**
     * 设置日期
     */
    public void setFpDate(OffsetDateTime fpDate) {
        this.fpDate = fpDate;
    }

    /**
     * 获取商品分类
     */
    public Long getCommId() {
        return commId;
    }

    /**
     * 设置商品分类
     */
    public void setCommId(Long commId) {
        this.commId = commId;
    }

    /**
     * 获取商品品种
     */
    public Long getCommVarietId() {
        return commVarietId;
    }

    /**
     * 设置商品品种
     */
    public void setCommVarietId(Long commVarietId) {
        this.commVarietId = commVarietId;
    }

    /**
     * 获取地区-省
     */
    public String getAreaProv() {
        return areaProv;
    }

    /**
     * 设置地区-省
     */
    public void setAreaProv(String areaProv) {
        this.areaProv = areaProv == null ? null : areaProv.trim();
    }

    /**
     * 获取地区-市
     */
    public String getAreaCity() {
        return areaCity;
    }

    /**
     * 设置地区-市
     */
    public void setAreaCity(String areaCity) {
        this.areaCity = areaCity == null ? null : areaCity.trim();
    }

    /**
     * 获取地区-区县
     */
    public String getAreaCou() {
        return areaCou;
    }

    /**
     * 设置地区-区县
     */
    public void setAreaCou(String areaCou) {
        this.areaCou = areaCou == null ? null : areaCou.trim();
    }

    /**
     * 获取单价
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置单价
     */
    public void setPrice(Double price) {
        this.price = price;
    }

	public Long getCommPid() {
		return commPid;
	}

	public void setCommPid(Long commPid) {
		this.commPid = commPid;
	}

	public String getAreaDetail() {
		return areaDetail;
	}

	public void setAreaDetail(String areaDetail) {
		this.areaDetail = areaDetail;
	}

	public String getCommName() {
		return commName;
	}

	public void setCommName(String commName) {
		this.commName = commName;
	}

	public String getCommVarietName() {
		return commVarietName;
	}

	public void setCommVarietName(String commVarietName) {
		this.commVarietName = commVarietName;
	}

	public String getCompUdType() {
		return compUdType;
	}

	public void setCompUdType(String compUdType) {
		this.compUdType = compUdType;
	}

	public Double getCompValue() {
		return compValue;
	}

	public void setCompValue(Double compValue) {
		this.compValue = compValue;
	}
}
