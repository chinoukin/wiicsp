package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.JyncgscgjeMage;
import com.wisea.cultivar.common.po.tp.system.JyncgscgjeMageListPo;
import com.wisea.cultivar.common.po.tp.system.JyncgscgjeMagePagePo;
import com.wisea.cultivar.common.vo.tp.system.JyncgscgjeMageListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

import java.util.List;

/**
 * jyncgscgje_mage 表DAO
 * 近一年采购商采购金额管理
 * 2019/09/04 15:07:41
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface JyncgscgjeMageMapper extends CrudDao<JyncgscgjeMage> {
    List<JyncgscgjeMageListVo> findPage(JyncgscgjeMagePagePo jyncgscgjeMagePagePo);

    List<JyncgscgjeMageListVo> findList(JyncgscgjeMageListPo jyncgscgjeMageListPo);

    List<JyncgscgjeMageListVo> findEntpName(JyncgscgjeMage po);
}
