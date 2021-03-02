package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.ZzjdZzmsMage;
import com.wisea.cultivar.common.po.tp.system.ZzjdZzmsMagePagePo;
import com.wisea.cultivar.common.vo.tp.system.ZzjdZzmsMageListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

import java.util.List;

/**
 * zzjd_zzms_mage 表DAO
 * 种植基地种植亩数管理
 * 2019/08/29 17:45:19
 */
public interface ZzjdZzmsMageMapper extends CrudDao<ZzjdZzmsMage> {

    List<ZzjdZzmsMageListVo> findForPages(ZzjdZzmsMagePagePo po);

    List<ZzjdZzmsMageListVo> findZzjdNameAndTel(ZzjdZzmsMage po);

}
