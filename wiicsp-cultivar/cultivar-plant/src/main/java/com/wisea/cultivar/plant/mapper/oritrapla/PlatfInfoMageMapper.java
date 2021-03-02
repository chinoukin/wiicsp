package com.wisea.cultivar.plant.mapper.oritrapla;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.oritrapla.PlatfInfoMage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PlatfInfoMageMapper extends CrudDao<PlatfInfoMage> {
	/**
	 * 查询平台信息管理数据
	 * @return
	 */
	PlatfInfoMage findPlatfInfo();

}
