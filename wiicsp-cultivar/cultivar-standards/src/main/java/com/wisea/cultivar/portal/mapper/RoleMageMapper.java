package com.wisea.cultivar.portal.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.portal.entity.RoleMage;
import com.wisea.cultivar.portal.po.RoleMageListPo;
import com.wisea.cultivar.portal.po.RoleMagePagePo;
import com.wisea.cultivar.portal.vo.RoleMageListVo;
import com.wisea.cultivar.portal.vo.ViewMenuVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * role_mage 表DAO
 * 角色管理
 * 2020/08/24 20:28:13
 */
public interface RoleMageMapper extends CrudDao<RoleMage> {
    /**
     * 分页查询
     */
    List<RoleMageListVo> findPage(RoleMagePagePo roleMagePagePo);

    /**
     * 列表查询
     */
    List<RoleMageListVo> findList(RoleMageListPo roleMageListPo);

    @Insert("insert into sys_role(id,code,name,rtype,create_date,update_date,remarks,del_flag,update_by,create_by) " +
            "values (#{id},#{code},#{name},#{rtype},#{createDate},#{updateDate},#{remarks},0,#{updateBy},#{createBy})")
    void addSysRole(RoleMage roleMage);
    @Insert("insert into sys_role_menu(role_id,menu_id) values (#{id},#{menuId})")
    void addsysRoleMenu(@Param("id") Long id, @Param("menuId")String menuId);

    @Update("update sys_role set del_flag=1 where id=#{sysRoleId} and del_flag=0")
    void deleteSysRole(String sysRoleId);
    @Delete("delete from sys_role_menu where role_id=#{delId}")
    void deleteSysRoleMenu(Long delId);

    @Select("select menu_id from sys_role_menu where role_id=#{id}")
    List<String> selectByRoleId(Long id);

    @Update("update sys_role set name=#{name},code=#{code},rtype=#{rtype},remarks=#{remarks},update_by=#{updateBy},update_date=#{updateDate} where id=#{sysRoleIdvar} and del_flag=0")
    void updateSysRole(RoleMage roleMage);

    @Select("SELECT count(*) FROM sys_user_role WHERE role_id=#{id}")
    Integer userCount(Long id);

    List<RoleMageListVo> selectByName(@Param("name")String name,@Param("id")String idvar);

    List<RoleMageListVo> selectByCode(@Param("code") String code,@Param("id")String idvar);

    List<ViewMenuVo> tree(@Param("id") Long sysUserId);
}
