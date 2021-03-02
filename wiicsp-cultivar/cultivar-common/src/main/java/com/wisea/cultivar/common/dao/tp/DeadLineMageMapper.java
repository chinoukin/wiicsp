package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.DeadLineMage;
import com.wisea.cultivar.common.po.tp.DeadLineMageListPo;
import com.wisea.cultivar.common.po.tp.DeadLineMagePagePo;
import com.wisea.cultivar.common.vo.tp.DeadLineMageListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * dead_line_mage 表DAO
 * 期限类型：买家提交订单后，付款期限商家发货后，买家确认收货期限
 * 2018/09/18 14:36:47
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface DeadLineMageMapper extends CrudDao<DeadLineMage> {
    List<DeadLineMageListVo> findPage(DeadLineMagePagePo deadLineMagePagePo);

    List<DeadLineMageListVo> findList(DeadLineMageListPo deadLineMageListPo);

    /**
     * 根据类型查询当前使用的那条
     * @param type
     * @return
     */
    DeadLineMageListVo findOneByType(@Param("type") String type);

    /**
     * 根据类型修改与这个类型相同的所有数据的delflag
     * @param map
     * @return
     */
    int updateAllDeadlineDelFlagByType(Map<String,Object> map);

    /**
     * 根据类型和删除标记统计个数
     * @param map
     * @return
     */
    Integer countDeadlineByTypeAndDelFlag(Map<String,Object> map);
}
