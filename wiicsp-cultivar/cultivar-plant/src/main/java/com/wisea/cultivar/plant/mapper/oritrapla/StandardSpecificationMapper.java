package com.wisea.cultivar.plant.mapper.oritrapla;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.oritrapla.StandardSpecification;
import com.wisea.cultivar.plant.vo.oritrapla.StandardSpecificationListVo;
import com.wisea.cultivar.plant.po.oritrapla.StandardSpecificationListPo;
import com.wisea.cultivar.plant.po.oritrapla.StandardSpecificationOptionPo;
import com.wisea.cultivar.plant.po.oritrapla.StandardSpecificationPagePo;

import java.util.List;

/**
 * standard_specification 表DAO
 * 标准规范
 * 2019/05/27 13:59:47
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface StandardSpecificationMapper extends CrudDao<StandardSpecification> {
    List<StandardSpecificationListVo> findPage(StandardSpecificationPagePo standardSpecificationPagePo);

    List<StandardSpecificationListVo> findList(StandardSpecificationListPo standardSpecificationListPo);

    /**
     * 分页查询
     * @param standardSpecificationPagePo
     * @return
     */
    List<StandardSpecificationListVo> findForPages(StandardSpecificationPagePo standardSpecificationPagePo);

    /**
     * 按条件查询所有标准规范
     * @param po
     * @return
     */
    List<StandardSpecificationListVo> findForOptions(StandardSpecificationOptionPo po);
}
