package com.wisea.cultivar.seedlings.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.OffsetDateTimeUtils;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.constants.DictConstants;
import com.wisea.cultivar.seedlings.entity.ItemMage;
import com.wisea.cultivar.seedlings.mapper.ItemMageMapper;
import com.wisea.cultivar.seedlings.po.*;
import com.wisea.cultivar.seedlings.vo.ItemMageGetVo;
import com.wisea.cultivar.seedlings.vo.ItemMageListVo;

import java.time.OffsetDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ItemMageService
 * 项目管理 Service
 * 2020/08/06 14:19:24
 */
@Service
public class ItemMageService extends BaseService {
    @Autowired
    protected ItemMageMapper itemMageMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<ItemMageListVo>> findPage(ItemMagePagePo itemMagePagePo) {
        ResultPoJo<Page<ItemMageListVo>> result = new ResultPoJo<>();
        Page<ItemMageListVo> page = itemMagePagePo.getPage();
        List<ItemMageListVo> list = itemMageMapper.findPage(itemMagePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<ItemMageListVo>> findList(ItemMageListPo itemMageListPo) {
        ResultPoJo<List<ItemMageListVo>> result = new ResultPoJo<>();
        result.setResult(itemMageMapper.findList(itemMageListPo));
        return result;
    }


    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<ItemMageListVo>> findSubsidyPage(ItemMagePagePo itemMagePagePo) {
        ResultPoJo<Page<ItemMageListVo>> result = new ResultPoJo<>();
        Page<ItemMageListVo> page = itemMagePagePo.getPage();
        List<ItemMageListVo> list = itemMageMapper.findSubsidyPage(itemMagePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<ItemMageListVo>> subsidyList(ItemMageListPo itemMageListPo) {
        ResultPoJo<List<ItemMageListVo>> result = new ResultPoJo<>();
        result.setResult(itemMageMapper.subsidyList(itemMageListPo));
        return result;
    }


    /**
     * 查询
     */
    public ResultPoJo<ItemMageGetVo> get(ItemMageGetPo itemMageGetPo) {
        ResultPoJo<ItemMageGetVo> result = new ResultPoJo<>();
        ItemMage entity = itemMageMapper.selectByPrimaryKey(itemMageGetPo.getId());
        ItemMageGetVo vo = new ItemMageGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(ItemMageInsertPo itemMageInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        ItemMage itemMage = new ItemMage();
        ConverterUtil.copyProperties(itemMageInsertPo, itemMage);
        itemMage.setApplDate(itemMage.getCreateDate());
        itemMage.preInsert();
        itemMageMapper.insert(itemMage);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(ItemMageUpdatePo itemMageUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        ItemMage itemMage = new ItemMage();
        ConverterUtil.copyProperties(itemMageUpdatePo, itemMage);
        itemMage.preUpdate();
        itemMageMapper.updateByPrimaryKeySelective(itemMage);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(ItemMageBatDeletePo itemMageBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : itemMageBatDeletePo.getDelList()) {
            ItemMage itemMage = new ItemMage();
            itemMage.setId(delId);
            itemMage.preUpdate();
            itemMageMapper.deleteLogic(itemMage);
        }
        return result;
    }

    /**
     * 批量结束项目
     * @param itemMageOverPo
     * @return
     */
    public ResultPoJo<Object> itemMageOver(ItemMageOverPo itemMageOverPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        if(itemMageOverPo.getItemStateType().equals(DictConstants.ITEM_STATE_TYPE_1)){
            for(Long delId : itemMageOverPo.getOverList()) {
                ItemMage itemMage = new ItemMage();
                itemMage.setId(delId);
                itemMage.setItemStateType(itemMageOverPo.getItemStateType());
                itemMage.setApplDate(OffsetDateTime.now());
                itemMage.preUpdate();
                itemMageMapper.updateByPrimaryKeySelective(itemMage);
            }
            return result;
        }
        return result;
    }

    /**
     * 定时结束项目
     */
    public void checkItemStateType() {
        ItemMage itemMage = new ItemMage();
        OffsetDateTime nowDate = OffsetDateTimeUtils.getDateTimeNow();
        itemMage.setEndDate(nowDate);
        itemMageMapper.checkItemStateType(itemMage);
    }
}
