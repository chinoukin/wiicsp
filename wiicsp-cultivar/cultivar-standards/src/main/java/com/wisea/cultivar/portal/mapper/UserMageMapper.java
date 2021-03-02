package com.wisea.cultivar.portal.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.common.sys.entity.Org;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cultivar.portal.entity.UserMage;
import com.wisea.cultivar.portal.po.UserMageActiveFlagPo;
import com.wisea.cultivar.portal.po.UserMageListPo;
import com.wisea.cultivar.portal.po.UserMagePagePo;
import com.wisea.cultivar.portal.vo.UserMageListVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * user_mage 表DAO
 * 成员管理
 * 2020/08/24 20:28:13
 */
public interface UserMageMapper extends CrudDao<UserMage> {
    /**
     * 分页查询
     */
    List<UserMageListVo> findPage(UserMagePagePo userMagePagePo);

    /**
     * 列表查询
     */
    List<UserMageListVo> findList(UserMageListPo userMageListPo);

    @Insert("insert into sys_user_role(user_id,role_id) values (#{userId},#{roleId})")
    void addUserRole(@Param("userId") Long userId, @Param("roleId") Long roleId);

    List<User> getByLoginName(@Param("loginName") String loginName,@Param("id")Long id);
    @Update("update sys_user set del_flag=1 where id=#{sysUserId} and del_flag=0")
    void deleteSysUser(Long sysUserId);
    @Insert("insert into sys_org_user(org_id,user_id) values (#{orgId},#{userId})")
    void addOrgUser(@Param("userId")Long userId,@Param("orgId") Long orgId);
    @Delete("delete from sys_user_role where user_id=#{id}")
    void deleteUserRole(Long id);
    @Delete("delete from sys_org_user where user_id=#{id}")
    void deleteOrgUser(Long id);

    @Select("select org_id from sys_org_user where user_id=#{id}")
    Long getOrgUser(Long id);
    @Select("select role_id from sys_user_role where user_id=#{id}")
    List<Long> getUserRole(Long id);
    @Select("select id,login_name loginName,password,active_flag activeFlag,login_flag loginFlag from sys_user where id=#{sysUserId} and del_flag=0")
    User getSysUserId(Long sysUserId);

    @Update("update sys_user set login_name=#{loginName},password=#{password},mobile=#{tel} where id=#{sysUserId} and del_flag=0")
    void updateUser(@Param("sysUserId") Long sysUserId, @Param("loginName")String loginName,  @Param("password")String password,@Param("tel") String tel);

    @Update("update sys_user set active_flag=#{activeFlag} where id=#{sysUserId} and del_flag=0")
    void status(UserMageActiveFlagPo po);

    @Select("select * from sys_org where id=#{orgId} and del_flag=0")
    Org getByIdSysOrg(Long orgId);

    List<UserMageListVo> selectPage(UserMagePagePo userMagePagePo);
}
