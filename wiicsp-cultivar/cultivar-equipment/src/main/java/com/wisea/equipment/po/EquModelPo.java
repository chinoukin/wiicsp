package com.wisea.equipment.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className EquModelPo
 * @date 2020/7/6 16:22
 * @Description
 */
@ApiModel("新增或修改设备型号PO")
public class EquModelPo {
    @ApiModelProperty("数据ID，修改时非空")
    private Long id;
    @ApiModelProperty("设备厂商id")
    @Check(test = { "required" })
    private Long equEntpId;
    @ApiModelProperty("设备型号")
    @Check(test = { "required" })
    private String equModel;
    @ApiModelProperty("设备类型")
    @Check(test = { "liveable" }, liveable = {"0", "1"}, liveableMsg = "设备类型数据无效")
    private String equType;
    @ApiModelProperty("接口访问地址")
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEquEntpId() {
        return equEntpId;
    }

    public void setEquEntpId(Long equEntpId) {
        this.equEntpId = equEntpId;
    }

    public String getEquModel() {
        return equModel;
    }

    public void setEquModel(String equModel) {
        this.equModel = equModel;
    }

    public String getEquType() {
        return equType;
    }

    public void setEquType(String equType) {
        this.equType = equType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
