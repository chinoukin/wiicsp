package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.BrandMage;
import com.wisea.cultivar.common.entity.tp.CommPubInfo;
import com.wisea.cultivar.common.po.tp.BrandMageListPo;
import com.wisea.cultivar.common.po.tp.BrandMagePagePo;
import com.wisea.cultivar.common.vo.tp.BrandMageListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

import java.util.List;

/**
 * brand_mage 表DAO
 * 品牌管理
 * 2018/09/18 14:36:47
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface BrandMageMapper extends CrudDao<BrandMage> {
    List<BrandMageListVo> findPage(BrandMagePagePo brandMagePagePo);

    List<BrandMageListVo> findList(BrandMageListPo brandMageListPo);

    List<BrandMageListVo> selectBrandList(BrandMagePagePo po);

    List<BrandMageListVo> brandInterface();

    /**
     * 查询名称是否重复
     * */
    BrandMageListVo selectbyName(BrandMage insert);

    /**
     * 查询是否有商品关联信息
     * */
    List<CommPubInfo> selectCommByBrandId(Long id);

    /**
     * 查询名称和ID是否重复
     * */
    BrandMageListVo selectbyNameAndId(BrandMage po);

    List<BrandMage> selectSortIsNotNull(BrandMagePagePo po);

    List<BrandMageListVo> noAuthNoPageBrandList(BrandMagePagePo po);
}
