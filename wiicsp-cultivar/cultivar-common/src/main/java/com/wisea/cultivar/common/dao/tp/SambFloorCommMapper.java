package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.SambFloorComm;
import com.wisea.cultivar.common.po.tp.product.SambFloorCommGetPo;
import com.wisea.cultivar.common.po.tp.product.SambFloorCommPo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.tp.product.SambFloorCommGetVo;
import com.wisea.cultivar.common.vo.tp.product.SambFloorCommListVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * samb_floor_comm 表DAO
 * 中小零批页楼层商品关系
 * 2019/05/28 16:20:20
 */
@Repository
public interface SambFloorCommMapper extends CrudDao<SambFloorComm> {

    /**
     * 根据楼层id查询品类品种列表
     * @param sambFloorCommPo
     * @return
     */
    List<SambFloorCommListVo> findListComm(SambFloorCommPo sambFloorCommPo);

    /**
     * 根据楼层id删除品种品类
     * @param id
     */
    void delBySambFloorId(Long id);

    /**
     * 根据id查询详情
     * @param sambFloorCommGetPo
     * @return
     */
    SambFloorCommGetVo findById(SambFloorCommGetPo sambFloorCommGetPo);
}
