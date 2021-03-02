package com.wisea.transac.operation.customer.dao;

import com.wisea.transac.operation.customer.entity.SysImCustomerCnt;
import org.apache.ibatis.annotations.Select;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;

/**
 * sys_im_customer_cnt 表DAO
 * 客服接待关系表
 * 2018/09/29 13:46:47
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface SysImCustomerCntMapper extends CrudDao<SysImCustomerCnt> {

    /**
     * 按分组id和用户id查询
     *
     * @param sysImCustomerCnt
     * @return
     */
    @Select("SELECT tc.* FROM sys_im_customer_cnt scic " +
            "JOIN sys_im_customer sic ON sic.id = scic.customer_id " +
            "WHERE scic.group_id = #{groupId} and scic.user_id = #{userId}" +
            "AND sic.del_flag = '0' " +
            "ORDER BY scic.create_date DESC " +
            "LIMIT 1")
    public SysImCustomerCnt selectByGroupIdAndUserId(SysImCustomerCnt sysImCustomerCnt);
}
