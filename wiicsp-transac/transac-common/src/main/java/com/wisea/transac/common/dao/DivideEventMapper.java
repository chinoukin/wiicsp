package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.transac.common.entity.DivideEvent;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DivideEventMapper extends CrudDao<DivideEvent> {

    /**
     * 查询所有可以分账的信息
     * @return
     */
    List<DivideEvent> selOutOfDivide ();

    /**
     * 根据支付ID查询分账信息
     * @param ordDateId
     * @return
     */
    DivideEvent selByOrdDateId(@Param("ordDateId") String ordDateId);
}
