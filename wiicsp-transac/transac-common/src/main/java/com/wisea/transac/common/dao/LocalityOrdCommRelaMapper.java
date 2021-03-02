package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.transac.common.entity.LocalityOrdCommRela;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LocalityOrdCommRelaMapper extends CrudDao<LocalityOrdCommRela> {

    /**
     * 根据订单ID查询主采购
     * @param ordId
     * @return
     */
    String findMainBuyerByOrdId(@Param("ordId")String ordId);
}
