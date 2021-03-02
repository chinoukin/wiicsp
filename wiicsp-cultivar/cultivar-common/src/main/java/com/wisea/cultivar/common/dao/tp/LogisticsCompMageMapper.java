package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.LogisticsCompMage;
import com.wisea.cultivar.common.po.tp.LogisticsCompMageListPo;
import com.wisea.cultivar.common.po.tp.LogisticsCompMagePagePo;
import com.wisea.cultivar.common.vo.tp.LogisticsCompMageListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * logistics_comp_mage 表DAO
 * 物流公司管理
 * 2018/09/18 14:36:47
 * <p>
 * 分页查询
 * <p>
 * 分页查询
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
@Repository
public interface LogisticsCompMageMapper extends CrudDao<LogisticsCompMage> {
  List<LogisticsCompMageListVo> findPage(LogisticsCompMagePagePo logisticsCompMagePagePo);

  List<LogisticsCompMageListVo> findList(LogisticsCompMageListPo logisticsCompMageListPo);

  /**
   * 查询所有记录
   * @return
   */
  List<LogisticsCompMageListVo> findForList();

  /**
   * 分页查询
   * @param logisticsCompMagePagePo
   * @return
   */
  List<LogisticsCompMageListVo> findForPage(LogisticsCompMagePagePo logisticsCompMagePagePo);

  /**
   * 按名称查询--模糊查询
   * @param name
   * @return
   */
  List<LogisticsCompMageListVo> findByName(@Param("name") String name);

  /**
   * 按ID查询
   * @param id
   * @return
   */
  LogisticsCompMageListVo findById(@Param("id") Long id);

  List<LogisticsCompMage> getComponyList();
}
