package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.VarietiesMage;
import com.wisea.cultivar.common.po.bigdata.VarietiesMageInsertPo;
import com.wisea.cultivar.common.po.bigdata.VarietiesMageListPo;
import com.wisea.cultivar.common.po.bigdata.VarietiesMagePagePo;
import com.wisea.cultivar.common.vo.bigdata.VarietiesMageListVo;

import java.util.List;

/**
 * varieties_mage 表DAO
 * 物料管理
 * 2019/12/03 14:35:19
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface VarietiesMageMapper extends CrudDao<VarietiesMage> {
    List<VarietiesMageListVo> findPage(VarietiesMagePagePo varietiesMagePagePo);

    List<VarietiesMageListVo> findList(VarietiesMageListPo varietiesMageListPo);

	VarietiesMage check(VarietiesMageInsertPo varietiesMageInsertPo);

	VarietiesMage cheakRepetition(VarietiesMage varietiesMage);
}
