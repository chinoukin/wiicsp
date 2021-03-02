package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.PlaceOriginMage;
import com.wisea.cultivar.common.po.bigdata.PlaceOriginMageListPo;
import com.wisea.cultivar.common.po.bigdata.PlaceOriginMagePagePo;
import com.wisea.cultivar.common.vo.bigdata.PlaceOriginMageListVo;
import com.wisea.cultivar.common.vo.bigdata.PlaceOriginMageMembVo;

import java.util.List;

/**
 * place_origin_mage 表DAO
 * 产地管理
 * 2019/12/02 11:02:15
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface BigdataPlaceOriginMageMapper extends CrudDao<PlaceOriginMage> {
    List<PlaceOriginMageListVo> findPage(PlaceOriginMagePagePo placeOriginMagePagePo);

    List<PlaceOriginMageListVo> findList(PlaceOriginMageListPo placeOriginMageListPo);

    List<PlaceOriginMageMembVo> findJbMemb(PlaceOriginMagePagePo placeOriginMageListPo);
}
