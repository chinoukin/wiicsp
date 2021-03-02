package com.wisea.cultivar.supply.mapper;

import com.wisea.cloud.common.sys.entity.Role;
import com.wisea.cloud.common.sys.entity.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 2020/08/24 20:28:13
 */
public interface CuMageMapper {

    /**
     * 通过手机号查询用户
     * @param mobile 手机号
     */
    @Select("select * from sys_user where mobile = #{mobile} and del_flag=0")
    List<User> getByMobile(String mobile);

    /**
     * 通过用户名查询用户
     * @param loginName 用户名
     */
    @Select("select * from sys_user where login_name = #{loginName} and del_flag=0")
    User getByLoginName(String loginName);

    /**
     * 查询用户角色
     * @param userId 用户id
     */
    @Select({"select a.* from sys_role a,sys_user_role b where a.id = b.role_id and a.del_flag = '0' and a.rtype = '0' and b.user_id = #{userId}  order by create_date asc"})
    List<Role> findByUserId(Long userId);

    /**
     * 修改密码
     */
    @Update("update sys_user set password = #{password}, update_date = #{updateDate} where id = #{id}")
    void updatePwd(User user);

}
