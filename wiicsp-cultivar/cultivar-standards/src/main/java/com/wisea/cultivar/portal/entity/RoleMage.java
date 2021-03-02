package com.wisea.cultivar.portal.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * role_mage 表实体
 * 角色管理
 * 2020/08/24 20:28:13
 */
public class RoleMage extends DataLongEntity<RoleMage> {
    private static final long serialVersionUID = 1L;

    /**
     * sys_role_id
     */
    private Long sysRoleId;

    /**
     * 角色编码
     */
    private String code;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色类型
     */
    private String rtype;

    /**
     * 显示顺序
     */
    private Integer sort;

    /**
     * 临时id
     */
    private Long sid;
    private String sysRoleIdvar;

    /**
     *
     * @mbg.generated
     */
    public RoleMage() {
        super();
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

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getSysRoleIdvar() {
        return sysRoleIdvar;
    }

    public void setSysRoleIdvar(String sysRoleIdvar) {
        this.sysRoleIdvar = sysRoleIdvar;
    }
}
