package com.wisea.cultivar.explorer.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.explorer.entity.OrgInfoMage;
import com.wisea.cultivar.explorer.po.OrgInfoMageListPo;
import com.wisea.cultivar.explorer.po.OrgInfoMagePagePo;
import com.wisea.cultivar.explorer.vo.OrgInfoMageListVo;
import java.util.List;

/**
 * org_info_mage 表DAO
 * 机构信息维护
 * 2020/07/24 11:21:45
 */
public interface OrgInfoMageMapper extends CrudDao<OrgInfoMage> {
    /**
     * 分页查询
     */
    List<OrgInfoMageListVo> findPage(OrgInfoMagePagePo orgInfoMagePagePo);

    /**
     * 列表查询
     */
    List<OrgInfoMageListVo> findList(OrgInfoMageListPo orgInfoMageListPo);
}
