package com.wisea.cultivar.supply.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.supply.entity.SerListMage;
import com.wisea.cultivar.supply.po.SerGetPo;
import com.wisea.cultivar.supply.po.SerListPo;
import com.wisea.cultivar.supply.vo.SerDetailsVo;
import com.wisea.cultivar.supply.vo.SerListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SerListMageMapper extends CrudDao<SerListMage> {

    /**
     * 服务单列表
     * @param serListPo 查询条件
     */
    List<SerListVo> findSerList(SerListPo serListPo);

    /**
     * 通过状态查询服务单数量
     * @param userId 用户id
     * @param state 状态
     */
    String selectSerCountByState(@Param("userId") Long userId, @Param("state") String state);

    /**
     * 服务单详情
     * @param serGetPo 服务单id
     * @return 详情
     */
    SerDetailsVo findSerDetails(SerGetPo serGetPo);
}
