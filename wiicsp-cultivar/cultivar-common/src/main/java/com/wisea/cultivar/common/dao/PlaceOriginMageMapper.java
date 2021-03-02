package com.wisea.cultivar.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.PlaceOriginMage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface PlaceOriginMageMapper extends CrudDao<PlaceOriginMage> {


}
