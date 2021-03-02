package com.wisea.equipment.entity.xaircraft;

/**
 * @author jirg
 * @version 1.0
 * @className XaircraftDeviceInfo
 * @date 2020/9/18 16:40
 * @Description 极飞设备信息
 */
public class XaircraftDeviceInfo {
    private String id; //设备 id
    private String sn; //设备生产序列
    private String name; //设备名称
    private Integer type; //设备类型
    private String type_name; //类型名称
    private Integer model; //类型型号
    private String model_name; //型号名称
    private Integer status; //0:未激活，1:在线，2:离线

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
