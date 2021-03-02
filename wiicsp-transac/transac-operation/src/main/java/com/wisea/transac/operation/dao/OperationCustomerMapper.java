package com.wisea.transac.operation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.wisea.transac.common.vo.MarketAcctNumMageInfoVo;

public interface OperationCustomerMapper {

    /**
     * 查询运营平台客服人员列表
     *
     * @param groupId
     * @param userId
     * @return
     */
    @Select("select DISTINCT manm.* from sys_im_customer sic "
            + "join market_acct_num_mage manm on manm.id = sic.user_id "
            + "where sic.group_id = '1' and manm.del_flag = '0' and sic.del_flag = '0'")
    public List<MarketAcctNumMageInfoVo> getCustomerList();
}
