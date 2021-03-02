package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.NhgtzzMsMage;
import com.wisea.cultivar.common.po.tp.system.NhgtzzMsMagePagePo;
import com.wisea.cultivar.common.vo.tp.system.NhgtzzMsMageListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

import java.util.List;

/**
 * nhgtzz_ms_mage 表DAO
 * 农户个体种植亩数管理
 * 2019/08/29 17:45:19
 */
public interface NhgtzzMsMageMapper extends CrudDao<NhgtzzMsMage> {

    List<NhgtzzMsMageListVo> findForPages(NhgtzzMsMagePagePo po);

    List<NhgtzzMsMageListVo> findZzhNameAndTel(NhgtzzMsMage po);

}
