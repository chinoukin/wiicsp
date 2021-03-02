package com.wisea.transac.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.transac.common.entity.RefundCommOperatorInfo;
import com.wisea.transac.common.vo.trade.OpreateInfoVo;

@Mapper
@Repository
public interface RefundCommOperatorInfoMapper extends CrudDao<RefundCommOperatorInfo> {

    List<OpreateInfoVo> selectRefundOpreateInfos (@Param("id") Long id);
}
