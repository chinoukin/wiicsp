package com.wisea.cultivar.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.ZhfwExamRecd;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ZhfwExamRecdMapper extends CrudDao<ZhfwExamRecd> {

    List<ZhfwExamRecd> findByConditions(ZhfwExamRecd zhfwExamRecd);

}
