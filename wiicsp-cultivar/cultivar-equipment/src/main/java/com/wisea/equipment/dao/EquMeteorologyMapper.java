package com.wisea.equipment.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.equipment.entity.EquMeteorology;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;

@Mapper
@Repository
public interface EquMeteorologyMapper extends CrudDao<EquMeteorology> {

    /**
     * @author jirg
     * @date 2020/7/8 13:34
     * @Description 根据设备ID、数据类型查询最大时间
     */
    OffsetDateTime selectMaxDateByEquId(@Param("equInfoId") Long equInfoId, @Param("equDateType") String equDateType);
}