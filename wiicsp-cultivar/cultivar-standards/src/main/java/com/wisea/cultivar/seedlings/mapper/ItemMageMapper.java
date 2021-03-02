package com.wisea.cultivar.seedlings.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.seedlings.entity.ItemMage;
import com.wisea.cultivar.seedlings.po.ItemMageListPo;
import com.wisea.cultivar.seedlings.po.ItemMagePagePo;
import com.wisea.cultivar.seedlings.vo.ApplMessageVo;
import com.wisea.cultivar.seedlings.vo.ItemMageListVo;

import java.util.List;

/**
 * item_mage 表DAO
 * 项目管理
 * 2020/08/06 14:19:24
 */
public interface ItemMageMapper extends CrudDao<ItemMage> {
    /**
     * 分页查询
     */
    List<ItemMageListVo> findPage(ItemMagePagePo itemMagePagePo);

    /**
     * 列表查询
     */
    List<ItemMageListVo> findList(ItemMageListPo itemMageListPo);

    List<ItemMageListVo> subsidyList(ItemMageListPo itemMageListPo);

    List<ItemMageListVo> findSubsidyPage(ItemMagePagePo itemMagePagePo);

    void checkItemStateType(ItemMage itemMage);

    List<ApplMessageVo> selectApplMessage();

    List<ApplMessageVo> selectItemApplMessage();
}
