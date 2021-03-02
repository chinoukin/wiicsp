package com.wisea.transac.operation.customer.service;

import java.time.OffsetDateTime;

import com.wisea.transac.operation.customer.entity.SysImCustomerCnt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.transac.operation.customer.dao.SysImCustomerCntMapper;

/**
 * SysImCustomerCntService 客服接待关系表 Service 2018/09/29 13:46:47
 */
@Service
public class SysImCustomerCntService extends BaseService {
    @Autowired
    protected SysImCustomerCntMapper sysImCustomerCntMapper;

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(SysImCustomerCnt sysImCustomerCnt) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        if (null == sysImCustomerCnt.getCreateDate()) {
            sysImCustomerCnt.setCreateDate(OffsetDateTime.now());
        }
        sysImCustomerCntMapper.insert(sysImCustomerCnt);
        return result;
    }

    /**
     * 按groupId和userId查询是否某用户在分组中有过接待客服
     *
     * @param groupId
     * @param userId
     * @return
     */
    public SysImCustomerCnt selectByGroupIdAndUserId(String groupId, Long userId) {
        SysImCustomerCnt sysImCustomerCnt = new SysImCustomerCnt();
        sysImCustomerCnt.setGroupId(groupId);
        sysImCustomerCnt.setUserId(userId);
        return sysImCustomerCntMapper.selectByGroupIdAndUserId(sysImCustomerCnt);
    }
}
