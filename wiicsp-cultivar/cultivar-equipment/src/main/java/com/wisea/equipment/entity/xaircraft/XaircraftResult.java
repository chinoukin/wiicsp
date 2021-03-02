package com.wisea.equipment.entity.xaircraft;

import java.time.OffsetDateTime;

/**
 * @author jirg
 * @version 1.0
 * @className DataPoint
 * @date 2019/2/25 13:54
 * @Description 极飞设备数据点
 */
public class XaircraftResult {
    private Long equId; //设备ID
    private OffsetDateTime created_at; //数据采集时间
    private Integer type; //数据存储类型
    private XaircraftData data; //数据内容
    private XaircraftLocation location; //定位信息

    public Long getEquId() {
        return equId;
    }

    public void setEquId(Long equId) {
        this.equId = equId;
    }

    public OffsetDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(OffsetDateTime created_at) {
        this.created_at = created_at;
    }

    public OffsetDateTime getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.created_at = createdAt;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public XaircraftData getData() {
        return data;
    }

    public void setData(XaircraftData data) {
        this.data = data;
    }

    public XaircraftLocation getLocation() {
        return location;
    }

    public void setLocation(XaircraftLocation location) {
        this.location = location;
    }
}
