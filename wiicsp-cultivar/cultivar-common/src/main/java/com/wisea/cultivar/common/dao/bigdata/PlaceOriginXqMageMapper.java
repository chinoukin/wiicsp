package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.PlaceOriginXqMage;
import com.wisea.cultivar.common.po.bigdata.PlaceOriginXqMageListPo;
import com.wisea.cultivar.common.po.bigdata.PlaceOriginXqMagePagePo;
import com.wisea.cultivar.common.vo.bigdata.PlaceOriginXqMageListVo;

import java.util.List;

/**
 * place_origin_xq_mage 表DAO
 * 产地详情管理
 * 2019/12/02 11:02:15
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface PlaceOriginXqMageMapper extends CrudDao<PlaceOriginXqMage> {
    List<PlaceOriginXqMageListVo> findPage(PlaceOriginXqMagePagePo placeOriginXqMagePagePo);

    List<PlaceOriginXqMageListVo> findList(PlaceOriginXqMageListPo placeOriginXqMageListPo);
    /**
     *根据ID逻辑删除
     * @param placeOriginId
     */
    void delByPlantId (Long placeOriginId);
}
