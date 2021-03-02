package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.HpCatgMapping;
import com.wisea.cultivar.common.po.tp.product.HpCatgMappingGetPo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.tp.product.HpCatgMappingGetVo;
import org.springframework.stereotype.Repository;

/**
 * hp_catg_mapping 表DAO
 * 首页分类映射
 * 2019/05/28 16:20:20
 */
@Repository
public interface HpCatgMappingMapper extends CrudDao<HpCatgMapping> {

    /**
     * 验证首页分类映射是否重复
     * @param
     * @return
     */
    HpCatgMapping insertCheckHpCatgMapper(HpCatgMapping hpCatgMapping);

    HpCatgMappingGetVo findById(HpCatgMappingGetPo hpCatgMappingGetPo);
}
