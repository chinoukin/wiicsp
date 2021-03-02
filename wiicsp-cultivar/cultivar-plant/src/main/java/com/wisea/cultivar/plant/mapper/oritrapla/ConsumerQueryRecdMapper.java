package com.wisea.cultivar.plant.mapper.oritrapla;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.oritrapla.ConsumerQueryRecd;
import com.wisea.cultivar.plant.po.oritrapla.ConsumerQueryRecdPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ConsumerQueryRecdMapper extends CrudDao<ConsumerQueryRecd> {
    /**
     * 查询消费者查询列表
     * @param po
     * @return
     */
    List<ConsumerQueryRecd> findQueryRecdList(ConsumerQueryRecdPo po);
}
