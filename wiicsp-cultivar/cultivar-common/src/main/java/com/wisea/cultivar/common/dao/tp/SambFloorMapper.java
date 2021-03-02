package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.SambFloor;
import com.wisea.cultivar.common.po.tp.product.SambFloorPagePo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.tp.product.SambFloorListVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * samb_floor 表DAO
 * 中小零批页楼层
 * 2019/05/28 16:20:20
 */
@Repository
public interface SambFloorMapper extends CrudDao<SambFloor> {

    /**
     * 查询楼层信息
     * @param sambFloorPagePo
     * @return
     */
    List<SambFloorListVo> findListFloor(SambFloorPagePo sambFloorPagePo);
}
