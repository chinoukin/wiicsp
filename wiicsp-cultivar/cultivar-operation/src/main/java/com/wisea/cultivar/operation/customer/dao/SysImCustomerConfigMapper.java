package com.wisea.cultivar.operation.customer.dao;

import org.apache.ibatis.annotations.Select;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.po.customer.SysImCustomerConfigGetVo;
import com.wisea.cultivar.operation.customer.entity.SysImCustomerConfig;

/**
 * sys_im_customer_config 表DAO 客服管理配置表 2018/09/29 13:46:47
 */
public interface SysImCustomerConfigMapper extends CrudDao<SysImCustomerConfig> {
    /**
     * 使用groupId获取
     *
     * @param groupId
     * @return
     */
    @Select("select * from sys_im_customer_config where del_flag = '0' and group_id = #{0}")
    public SysImCustomerConfigGetVo selectByGroupId(String groupId);
}
