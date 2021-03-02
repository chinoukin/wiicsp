package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.YxEntp;
import com.wisea.cultivar.common.po.bigdata.YxEntpListPo;
import com.wisea.cultivar.common.po.bigdata.YxEntpPagePo;
import com.wisea.cultivar.common.vo.bigdata.YxEntpListVo;

import java.util.List;

/**
 * yx_entp 表DAO
 * 已选企业
 * 2019/12/02 11:02:15
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface YxEntpMapper extends CrudDao<YxEntp> {
    List<YxEntpListVo> findPage(YxEntpPagePo yxEntpPagePo);

    List<YxEntpListVo> findList(YxEntpListPo yxEntpListPo);

    /**
     *根据ID逻辑删除
     * @param placeOriginId
     */
    void delByPlantId (Long placeOriginId);
}
