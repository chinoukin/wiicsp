package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.CategoryMage;
import com.wisea.cultivar.common.po.bigdata.CategoryMageListPo;
import com.wisea.cultivar.common.po.bigdata.CategoryMagePagePo;
import com.wisea.cultivar.common.vo.bigdata.CategoryAndVarietiesListVo;
import com.wisea.cultivar.common.vo.bigdata.CategoryMageListVo;

import java.util.List;

/**
 * category_mage 表DAO
 * 品类管理
 * 2019/12/03 14:35:19
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface CategoryMageMapper extends CrudDao<CategoryMage> {
    List<CategoryMageListVo> findPage(CategoryMagePagePo categoryMagePagePo);

    List<CategoryMageListVo> findList(CategoryMageListPo categoryMageListPo);

    /**
     * @Author jirg
     * @Date 2019/12/4 16:14
     * @Description 查询所有物料列表
     **/
    List<CategoryAndVarietiesListVo> findCategoryAndVarietiesList();

	CategoryMage cheakRepetition(CategoryMage categoryMage);
}
