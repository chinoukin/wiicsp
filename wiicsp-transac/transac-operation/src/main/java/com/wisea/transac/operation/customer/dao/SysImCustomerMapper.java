package com.wisea.transac.operation.customer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.transac.operation.customer.entity.SysImCustomer;

/**
 * sys_im_customer 表DAO
 * 客服管理表
 * 2018/09/29 13:46:47
 */
/**
 * 列表查询
 */
public interface SysImCustomerMapper extends CrudDao<SysImCustomer> {

    /**
     * 查询某分组的客服
     *
     * @param groupId
     * @return
     */
    @Select("select su.* from sys_user su left join sys_im_customer sic on sic.user_id = su.id where sic.del_flag = '0' and sic.group_id = #{0}")
    List<User> findCustomUserList(String groupId);

    /**
     * 分配客服
     * <p/>
     * status = 1 查询的是在线客服,否则查询的是全部客服(在线和离线)
     * isAdmin = 0 查询的是非员管理的客服, 否则查询的是全部客服(普通和管理员)
     *
     * @param groupId
     * @param maxSerCount
     * @return
     */
    @Select("<script>" +
            "SELECT " +
            "    tc.* " +
            "FROM " +
            "    sys_im_customer tc " +
            "JOIN sys_im_customer_config tcc ON tcc.group_id = tc.group_id " +
            "WHERE tc.del_flag = '0' " +
            "<if test=\"isAdmin != null and isAdmin != ''\">" +
            "AND tc.is_admin = #{isAdmin} " +
            "</if> " +
            "AND tc.group_id = #{groupId} " +
            "ORDER BY " +
            "  tc.`status` desc, " + // 在线状态优先级大于离线
            "  tc.ser_count ASC, " +  // 当前服务数量约小越优先
            "  tc.update_date ASC " +  // 更新时间越历史前越优先
            "LIMIT 1"
            + "</script>")
    SysImCustomer dispatch(SysImCustomer groupId);

    /**
     * 使用user_id查询
     *
     * @param userId
     * @return
     */
    @Select("select * from sys_im_customer where del_flag = '0' and user_id = #{1}")
    List<SysImCustomer> selectByUser(Long userId);

    /**
     * 使用groupId和user_id查询
     *
     * @param groupId
     * @param userId
     * @return
     */
    @Select("select * from sys_im_customer where del_flag = '0' and group_id = #{0} and user_id = #{1}")
    SysImCustomer selectByGroupAndUser(String groupId, Long userId);

    /**
     * 删除某分组下全部客服
     *
     * @param groupId
     * @return
     */
    @Delete("delete from sys_im_customer where group_id = #{0}")
    int deleteGroupAll(String groupId);

    /**
     * 删除某分组下某个客服
     *
     * @param groupId
     * @param userId
     * @return
     */
    int deleteGroupWithUserId(SysImCustomer entity);
}
