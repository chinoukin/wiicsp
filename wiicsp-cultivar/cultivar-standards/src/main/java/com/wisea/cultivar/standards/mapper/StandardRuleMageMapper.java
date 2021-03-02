package com.wisea.cultivar.standards.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.standards.entity.StandardRuleMage;
import com.wisea.cultivar.standards.po.StandardRuleMageListPo;
import com.wisea.cultivar.standards.po.StandardRuleMagePagePo;
import com.wisea.cultivar.standards.vo.StandardRuleMageListVo;
import java.util.List;

/**
 * standard_rule_mage 表DAO
 * 标准规范管理
 * 2020/07/24 11:21:45
 */
public interface StandardRuleMageMapper extends CrudDao<StandardRuleMage> {
    /**
     * 分页查询
     */
    List<StandardRuleMageListVo> findPage(StandardRuleMagePagePo standardRuleMagePagePo);

    /**
     * 列表查询
     */
    List<StandardRuleMageListVo> findList(StandardRuleMageListPo standardRuleMageListPo);
}
