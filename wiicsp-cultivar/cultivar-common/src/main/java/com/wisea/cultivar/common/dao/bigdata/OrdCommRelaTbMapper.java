package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.OrdCommRelaTb;
import com.wisea.cultivar.common.vo.product.CommVarietMageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrdCommRelaTbMapper extends CrudDao<OrdCommRelaTb> {

    /**
     *热卖品种
     */
    List<String> findSearchName();
}