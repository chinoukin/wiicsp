package com.wisea.cultivar.plant.mapper.oritrapla;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.oritrapla.OriExamRecd;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OriExamRecdMapper extends CrudDao<OriExamRecd> {

	/**
	 * 逻辑删除检测记录
	 * @param id
	 */
	public void delExamRecd(Long id);
}
