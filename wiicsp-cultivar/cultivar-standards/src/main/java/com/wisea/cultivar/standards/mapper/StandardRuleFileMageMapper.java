package com.wisea.cultivar.standards.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.standards.entity.StandardRuleFileMage;
import com.wisea.cultivar.standards.po.StandardRuleFileMageListPo;
import com.wisea.cultivar.standards.po.StandardRuleFileMagePagePo;
import com.wisea.cultivar.standards.vo.StandardRuleFileMageListVo;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * standard_rule_file_mage 表DAO
 * 标准规范附件管理
 * 2020/07/24 11:21:45
 */
public interface StandardRuleFileMageMapper extends CrudDao<StandardRuleFileMage> {
    /**
     * 分页查询
     */
    List<StandardRuleFileMageListVo> findPage(StandardRuleFileMagePagePo standardRuleFileMagePagePo);

    /**
     * 列表查询
     */
    List<StandardRuleFileMageListVo> findList(StandardRuleFileMageListPo standardRuleFileMageListPo);

    List<StandardRuleFileMageListVo> getById(long id);
    @Update({"update standard_rule_file_mage set del_flag = '1' where standard_rule_mage_id = #{delId}"})
    void deleteStandardRuleMageId(Long delId);
}
