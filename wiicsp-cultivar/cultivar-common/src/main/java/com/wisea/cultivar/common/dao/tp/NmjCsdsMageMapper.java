package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.NmjCsdsMage;
import com.wisea.cultivar.common.po.tp.system.NmjCsdsMagePagePo;
import com.wisea.cultivar.common.vo.tp.system.NmjCsdsMageListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

import java.util.List;

/**
 * nmj_csds_mage 表DAO
 * 糯米蕉成熟吨数管理
 * 2019/08/29 17:45:19
 */
public interface NmjCsdsMageMapper extends CrudDao<NmjCsdsMage> {

    List<NmjCsdsMageListVo> findForPages(NmjCsdsMagePagePo po);

    List<NmjCsdsMageListVo> findYearAndMoneth(NmjCsdsMage po);

}
