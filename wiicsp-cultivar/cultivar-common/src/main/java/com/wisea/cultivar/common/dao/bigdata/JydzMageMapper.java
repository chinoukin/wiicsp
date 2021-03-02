package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.JydzMage;
import com.wisea.cultivar.common.po.bigdata.JydzMageListPo;
import com.wisea.cultivar.common.po.bigdata.JydzMagePagePo;
import com.wisea.cultivar.common.vo.bigdata.JydzMageListVo;

import java.util.List;

/**
 * jydz_mage 表DAO
 * 交易递增配置
 * 2019/12/02 14:39:38
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface JydzMageMapper extends CrudDao<JydzMage> {
    List<JydzMageListVo> findPage(JydzMagePagePo jydzMagePagePo);

    List<JydzMageListVo> findList(JydzMageListPo jydzMageListPo);
}
