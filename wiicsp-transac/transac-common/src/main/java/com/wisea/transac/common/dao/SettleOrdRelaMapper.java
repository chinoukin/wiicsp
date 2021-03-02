package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.transac.common.entity.SettleOrdRela;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SettleOrdRelaMapper extends CrudDao<SettleOrdRela> {
    /**
     * @Author jirg
     * @Date 2020/5/15 15:25
     * @Description 根据结算单ID查询订单Id列表
     **/
    List<Long> selectOrdIdsBySettleId(@Param("settleBillId") Long id);

    /**
     * @Author jirg
     * @Date 2020/5/15 15:25
     * @Description 根据结算单ID删除数据
     **/
    void delBySettleId(Long id);
}
