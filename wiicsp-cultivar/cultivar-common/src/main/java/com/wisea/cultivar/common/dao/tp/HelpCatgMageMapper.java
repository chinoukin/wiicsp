package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.HelpCatgMage;
import com.wisea.cultivar.common.po.tp.HelpCatgMageListPo;
import com.wisea.cultivar.common.po.tp.HelpCatgMagePagePo;
import com.wisea.cultivar.common.vo.tp.HelpCatgMageListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

import java.util.List;

/**
 * help_catg_mage 表DAO
 * 帮助分类管理
 * 2018/10/29 10:29:10
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface HelpCatgMageMapper extends CrudDao<HelpCatgMage> {
    List<HelpCatgMageListVo> findPage(HelpCatgMagePagePo helpCatgMagePagePo);

    List<HelpCatgMageListVo> findList(HelpCatgMageListPo helpCatgMageListPo);

}
