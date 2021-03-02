package com.wisea.cultivar.standards.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.standards.entity.LinkMage;
import com.wisea.cultivar.standards.po.LinkMageListPo;
import com.wisea.cultivar.standards.po.LinkMagePagePo;
import com.wisea.cultivar.standards.vo.LinkMageListVo;
import java.util.List;

/**
 * link_mage 表DAO
 * 环节管理
 * 2020/07/24 11:21:45
 */
public interface LinkMageMapper extends CrudDao<LinkMage> {
    /**
     * 分页查询
     */
    List<LinkMageListVo> findPage(LinkMagePagePo linkMagePagePo);

    /**
     * 列表查询
     */
    List<LinkMageListVo> findList(LinkMageListPo linkMageListPo);
}
