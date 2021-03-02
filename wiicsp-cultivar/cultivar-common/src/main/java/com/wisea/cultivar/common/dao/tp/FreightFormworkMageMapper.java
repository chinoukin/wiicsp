package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.FreightFormworkMage;
import com.wisea.cultivar.common.po.tp.FreightFormworkMageListPo;
import com.wisea.cultivar.common.po.tp.FreightFormworkMagePagePo;
import com.wisea.cultivar.common.vo.tp.FreightFormworkMageListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * freight_formwork_mage 表DAO
 * 运费模板管理
 * 2018/09/18 14:36:47
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface FreightFormworkMageMapper extends CrudDao<FreightFormworkMage> {
    List<FreightFormworkMageListVo> findPage(FreightFormworkMagePagePo freightFormworkMagePagePo);

    List<FreightFormworkMageListVo> findList(FreightFormworkMageListPo freightFormworkMageListPo);

    List<FreightFormworkMageListVo> findForPage(FreightFormworkMagePagePo freightFormworkMagePagePo);

    FreightFormworkMageListVo findById(@Param("id") Long id);

    List<FreightFormworkMageListVo> findByMemId(@Param("membId")Long memId);

    /**
     * 查询所有使用这个模板的商品编码
     * @param id
     * @return
     */
    List<String> listProductCodeByFormworkId(@Param("id")Long id);
}
