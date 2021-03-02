package com.wisea.transac.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.transac.common.entity.IncomeDetail;
import com.wisea.transac.common.po.trade.IncomeListPo;
import com.wisea.transac.common.vo.trade.IncomeListVo;

@Mapper
@Repository
public interface IncomeDetailMapper extends CrudDao<IncomeDetail> {

    /**
     * 查询收支明细列表
     * @return
     */
    List<IncomeListVo> findIncomeList (IncomeListPo po);
}
