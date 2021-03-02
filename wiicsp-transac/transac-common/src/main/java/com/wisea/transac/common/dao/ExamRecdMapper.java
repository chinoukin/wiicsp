package com.wisea.transac.common.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.transac.common.entity.ExamRecd;

@Mapper
@Repository
public interface ExamRecdMapper extends CrudDao<ExamRecd> {

}
