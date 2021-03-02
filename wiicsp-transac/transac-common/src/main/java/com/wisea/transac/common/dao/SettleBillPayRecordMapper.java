package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.transac.common.entity.SettleBillPayRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SettleBillPayRecordMapper extends CrudDao<SettleBillPayRecord> {
    /**
     * @Author jirg
     * @Date 2020/5/20 16:29
     * @Description 根据结算单ID查询支付记录列表
     */
    List<SettleBillPayRecord> findBySettleBillId(@Param("settleId") Long settleId);
}
