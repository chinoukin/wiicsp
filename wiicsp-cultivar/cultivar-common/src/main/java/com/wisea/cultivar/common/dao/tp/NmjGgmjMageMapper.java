package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.NmjGgmjMage;
import com.wisea.cultivar.common.po.tp.system.NmjGgmjMagePagePo;
import com.wisea.cultivar.common.vo.tp.system.NmjGgmjMageListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

import java.util.List;

/**
 * nmj_ggmj_mage 表DAO
 * 糯米蕉挂果面积管理
 * 2019/08/29 17:45:19
 */
public interface NmjGgmjMageMapper extends CrudDao<NmjGgmjMage> {

    List<NmjGgmjMageListVo> findForPages(NmjGgmjMagePagePo po);

    List<NmjGgmjMageListVo> findYearAndMoneth(NmjGgmjMage po);

}
