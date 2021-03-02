package com.wisea.transac.common.po.seller;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("员工新增或修改Po")
public class StaffMagePo {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "注册手机号")
    @Check(
            test = {"required"}
    )
    private String registTel;

    @ApiModelProperty(value = "姓名")
    @Check(
            test = {"required"}
    )
    private String staffName;

    @ApiModelProperty(value = "职位")
    private String position;

    @ApiModelProperty(value = "性别类型")
    private String sexType;

    @ApiModelProperty(value = "是否为管理员 1:否 0:是")
    private String sfAdminFlag;

    @ApiModelProperty(value = "停启用状态")
    @Check(
            test = {"required"}
    )
    private String effeInvalState;

    /**
     * 菜单.id字符串数组(使用逗号分隔)
     */
    @ApiModelProperty(value = "菜单.id字符串数组(使用逗号分隔)")
    private String menuIds;

    public String getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(String menuIds) {
        this.menuIds = menuIds;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistTel() {
        return registTel;
    }

    public void setRegistTel(String registTel) {
        this.registTel = registTel;
    }


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSexType() {
        return sexType;
    }

    public void setSexType(String sexType) {
        this.sexType = sexType;
    }

    public String getSfAdminFlag() {
        return sfAdminFlag;
    }

    public void setSfAdminFlag(String sfAdminFlag) {
        this.sfAdminFlag = sfAdminFlag;
    }

    public String getEffeInvalState() {
        return effeInvalState;
    }

    public void setEffeInvalState(String effeInvalState) {
        this.effeInvalState = effeInvalState;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
}
