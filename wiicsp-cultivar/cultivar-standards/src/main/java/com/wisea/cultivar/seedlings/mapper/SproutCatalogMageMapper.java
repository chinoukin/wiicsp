package com.wisea.cultivar.seedlings.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.po.trade.EntpInfoMagePo;
import com.wisea.cultivar.common.vo.trade.EntpAuthInfoVo;
import com.wisea.cultivar.explorer.vo.EntpInfoMageGetVo;
import com.wisea.cultivar.explorer.vo.OilTeaVarietMageGetVo;
import com.wisea.cultivar.seedlings.entity.SproutCatalogMage;
import com.wisea.cultivar.seedlings.po.SproutBuyGetPo;
import com.wisea.cultivar.seedlings.po.SproutCatalogMageGetPo;
import com.wisea.cultivar.seedlings.po.SproutCatalogMageListPo;
import com.wisea.cultivar.seedlings.po.SproutCatalogMagePagePo;
import com.wisea.cultivar.seedlings.vo.BuySproutIndividualInfoListVo;
import com.wisea.cultivar.seedlings.vo.SproutCatalogMageGetVo;
import com.wisea.cultivar.seedlings.vo.SproutCatalogMageListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * sprout_catalog_mage 表DAO
 * 种苗目录管理
 * 2020/08/06 14:19:24
 */
public interface SproutCatalogMageMapper extends CrudDao<SproutCatalogMage> {
    /**
     * 分页查询
     */
    List<SproutCatalogMageListVo> findPage(SproutCatalogMagePagePo sproutCatalogMagePagePo);

    /**
     * 列表查询
     */
    List<SproutCatalogMageListVo> findList(SproutCatalogMageListPo sproutCatalogMageListPo);

    SproutCatalogMageGetVo detalis(SproutCatalogMageGetPo sproutCatalogMageGetPo);

    List<EntpInfoMageGetVo> findEntpInfoList(EntpInfoMagePo entpInfoMagePo);

    SproutCatalogMage findBySproutYear(@Param("sproutYear") Integer sproutYear);

    List<OilTeaVarietMageGetVo> sproutCataLogDetails(SproutCatalogMageGetPo sproutCatalogMageGetPo);

    List<EntpAuthInfoVo> selectEntpDetails(SproutCatalogMageGetPo sproutCatalogMageGetPo);

    /**
     * 查询种植企业
     */
    List<EntpAuthInfoVo> selectPlantEntp(Long id);

    /**
     * 种植户坐标
     * @param id
     * @return
     */
    List<BuySproutIndividualInfoListVo> selectBuyCoordinates(Long id);

    /**
     * 查询种植户种植详情
     */
    List<BuySproutIndividualInfoListVo> selectBuyDetails(SproutBuyGetPo sproutBuyGetPo);
}
