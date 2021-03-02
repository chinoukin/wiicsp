package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.PlatfSerCostMage;
import com.wisea.cultivar.common.po.tp.PlatfSerCostMageListPo;
import com.wisea.cultivar.common.po.tp.PlatfSerCostMagePagePo;
import com.wisea.cultivar.common.vo.tp.PlatfSerCostMageListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * platf_ser_cost_mage 表DAO
 * 包含：平台服务费，平台代理服务费
 * 2018/09/18 14:36:47
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface PlatfSerCostMageMapper extends CrudDao<PlatfSerCostMage> {
    List<PlatfSerCostMageListVo> findPage(PlatfSerCostMagePagePo platfSerCostMagePagePo);

    List<PlatfSerCostMageListVo> findList(PlatfSerCostMageListPo platfSerCostMageListPo);

    /**
     * 通过类型查询当前使用的记录
     * @param type
     * @return
     */
    PlatfSerCostMageListVo findOneByType(@Param("type") String type);

    /**
     * 按类型更新所有记录的delflag
     * @param map
     * @return
     */
    int updateAllSerCostDelFlagByType(Map<String,Object> map);

    /**
     * 根据类型统计可用记录总数
     * @param map
     * @return
     */
    Integer countSerCostByTypeAndDelFlag(Map<String,Object> map);
}
