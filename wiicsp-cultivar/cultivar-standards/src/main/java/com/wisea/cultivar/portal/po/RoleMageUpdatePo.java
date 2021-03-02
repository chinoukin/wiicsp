package com.wisea.cultivar.portal.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * RoleMageUpdatePo
 * 2020/08/24 20:28:13
 */
public class RoleMageUpdatePo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required" })
    @ApiModelProperty(value = "id", required = true)
    private Long id;

    /**
     * sys_role_id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "sys_role_id", allowableValues = "length:(,19]")
    private Long sysRoleId;

    /**
     * 角色编码
     */
    @Check(test = { "maxLength" }, mixLength = 128)
    @ApiModelProperty(value = "角色编码", allowableValues = "mixLength:(,128]")
    private String code;

    /**
     * 角色名称
     */
    @Check(test = { "maxLength" }, mixLength = 256)
    @ApiModelProperty(value = "角色名称", allowableValues = "mixLength:(,256]")
    private String name;

    /**
     * 角色类型
     */
    @Check(test = { "maxLength" }, mixLength = 1)
    @ApiModelProperty(value = "角色类型", allowableValues = "mixLength:(,1]")
    private String rtype;

    /**
     * 显示顺序
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "显示顺序", allowableValues = "length:(,10]")
    private Integer sort;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 删除标记
     */
    @Check(test = { "maxLength" }, mixLength = 1)
    @ApiModelProperty(value = "删除标记", allowableValues = "mixLength:(,1]")
    private String delFlag;

    @Check(test = "required")
    @ApiModelProperty(value = "权限id")
    private List<String> menuIds;
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
     * 获取sys_role_id
     */
    public Long getSysRoleId() {
        return sysRoleId;
    }

    /**
     * 设置sys_role_id
     */
    public void setSysRoleId(Long sysRoleId) {
        this.sysRoleId = sysRoleId;
    }

    /**
     * 获取角色编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置角色编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置角色名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取角色类型
     */
    public String getRtype() {
        return rtype;
    }

    /**
     * 设置角色类型
     */
    public void setRtype(String rtype) {
        this.rtype = rtype == null ? null : rtype.trim();
    }

    /**
     * 获取显示顺序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置显示顺序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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

    public List<String> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<String> menuIds) {
        this.menuIds = menuIds;
    }
}
