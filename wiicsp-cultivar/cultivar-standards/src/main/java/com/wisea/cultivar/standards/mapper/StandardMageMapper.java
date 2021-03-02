package com.wisea.cultivar.standards.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.standards.entity.StandardMage;
import com.wisea.cultivar.standards.po.StandardMageListPo;
import com.wisea.cultivar.standards.po.StandardMagePagePo;
import com.wisea.cultivar.standards.vo.StandardMageListVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * standard_mage 表DAO
 * 标准管理
 * 2020/07/24 11:21:45
 */
@Component
public interface StandardMageMapper extends CrudDao<StandardMage> {
    /**
     * 分页查询
     */
    List<StandardMageListVo> findPage(StandardMagePagePo standardMagePagePo);

    /**
     * 列表查询
     */
    List<StandardMageListVo> findList(StandardMageListPo standardMageListPo);

}
