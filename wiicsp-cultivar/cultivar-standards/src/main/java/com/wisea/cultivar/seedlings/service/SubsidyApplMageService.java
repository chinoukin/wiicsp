package com.wisea.cultivar.seedlings.service;

import com.google.common.collect.Maps;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.constants.ConstantCodeMsg;
import com.wisea.cultivar.common.constants.DictConstants;
import com.wisea.cultivar.seedlings.entity.SubsidyApplMage;
import com.wisea.cultivar.seedlings.entity.SubsidyExamRecd;
import com.wisea.cultivar.seedlings.mapper.ItemMageMapper;
import com.wisea.cultivar.seedlings.mapper.SubsidyApplMageMapper;
import com.wisea.cultivar.seedlings.mapper.SubsidyExamRecdMapper;
import com.wisea.cultivar.seedlings.po.*;
import com.wisea.cultivar.seedlings.vo.*;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * SubsidyApplMageService
 * 补贴申请管理 Service
 * 2020/08/06 14:19:24
 */
@Service
public class SubsidyApplMageService extends BaseService {
    @Autowired
    protected SubsidyApplMageMapper subsidyApplMageMapper;

    @Autowired
    protected SubsidyExamRecdMapper subsidyExamRecdMapper;
    @Autowired
    protected ItemMageMapper itemMageMapper;
    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<SubsidyApplMageListVo>> findPage(SubsidyApplMagePagePo subsidyApplMagePagePo) {
        ResultPoJo<Page<SubsidyApplMageListVo>> result = new ResultPoJo<>();
        Page<SubsidyApplMageListVo> page = subsidyApplMagePagePo.getPage();
        List<SubsidyApplMageListVo> list = subsidyApplMageMapper.findPage(subsidyApplMagePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<SubsidyApplMageListVo>> findList(SubsidyApplMageListPo subsidyApplMageListPo) {
        ResultPoJo<List<SubsidyApplMageListVo>> result = new ResultPoJo<>();
        result.setResult(subsidyApplMageMapper.findList(subsidyApplMageListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<SubsidyApplMageGetVo> get(SubsidyApplMageGetPo subsidyApplMageGetPo) {
        ResultPoJo<SubsidyApplMageGetVo> result = new ResultPoJo<>();
        SubsidyApplMage entity = subsidyApplMageMapper.selectByPrimaryKey(subsidyApplMageGetPo.getId());
        SubsidyApplMageGetVo vo = new SubsidyApplMageGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(SubsidyApplMageInsertPo subsidyApplMageInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        SubsidyApplMage subsidyApplMage = new SubsidyApplMage();
        ConverterUtil.copyProperties(subsidyApplMageInsertPo, subsidyApplMage);
        subsidyApplMage.setApplDate(subsidyApplMage.getCreateDate());
        subsidyApplMage.preInsert();
        subsidyApplMageMapper.insert(subsidyApplMage);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(SubsidyApplMageUpdatePo subsidyApplMageUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        SubsidyApplMage subsidyApplMage = new SubsidyApplMage();
        ConverterUtil.copyProperties(subsidyApplMageUpdatePo, subsidyApplMage);
        subsidyApplMage.preUpdate();
        subsidyApplMageMapper.updateByPrimaryKeySelective(subsidyApplMage);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(SubsidyApplMageBatDeletePo subsidyApplMageBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : subsidyApplMageBatDeletePo.getDelList()) {
            SubsidyApplMage subsidyApplMage = new SubsidyApplMage();
            subsidyApplMage.setId(delId);
            subsidyApplMage.preUpdate();
            subsidyApplMageMapper.deleteLogic(subsidyApplMage);
        }
        return result;
    }

    /**
     * 批量审核/批量标记为已拨付
     * @param subsidyApplMageBatDeletePo
     * @return
     */
    public ResultPoJo<Object> batchEdit(SubsidyApplMageBatDeletePo subsidyApplMageBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        String examFailReason = subsidyApplMageBatDeletePo.getExamFailReason();
        User user = SystemUtils.getUser();
        if(ConverterUtil.isEmpty(user)){
            result.setCode(ConstantCodeMsg.ERR_912);
            result.setMsg(ConstantCodeMsg.MSG_912);
            return result;
        }
        SubsidyApplMage subsidyApplMage = new SubsidyApplMage();
        subsidyApplMage.setSubsidyApplStateType(subsidyApplMageBatDeletePo.getSubsidyApplStateType());
        subsidyApplMage.setExamFailReason(subsidyApplMageBatDeletePo.getExamFailReason());
        subsidyApplMage.preUpdate();
        Map<String, Object> maps = Maps.newHashMap();
        maps.put("subsidyApplMage", subsidyApplMage);
        maps.put("ids", subsidyApplMageBatDeletePo.getDelList());
            //待审核的情况下进行审核或者审核不通过操作
            if(subsidyApplMageBatDeletePo.getSubsidyApplStateType().equals(DictConstants.SUBSIDY_APPL_STATE_TYPE_1)
            || subsidyApplMageBatDeletePo.getSubsidyApplStateType().equals(DictConstants.SUBSIDY_APPL_STATE_TYPE_3)) {
                maps.put("stateType", DictConstants.SUBSIDY_APPL_STATE_TYPE_0);
                List<SubsidyApplMage> subsidyApplMages = subsidyApplMageMapper.findListByStateType(maps);
                if (CollectionUtils.isNotEmpty(subsidyApplMages)){
                    List<Long> ids = subsidyApplMages.stream().map(SubsidyApplMage::getId).collect(Collectors.toList());
                    maps.put("ids",ids);
                    subsidyApplMageMapper.updateState(maps);
                    for (SubsidyApplMage subsidy: subsidyApplMages) {
                        SubsidyExamRecd subsidyExamRecd = new SubsidyExamRecd();
                        subsidyExamRecd.setOperator(user.getLoginName());
                        subsidyExamRecd.setOperatDate(OffsetDateTime.now());
                        subsidyExamRecd.setSubsidyApplMageId(subsidy.getId());
                        subsidyExamRecd.setOperatorContent(examFailReason);
                        subsidyExamRecd.preInsert();
                        subsidyExamRecdMapper.insert(subsidyExamRecd);
                    }
                }
            }
            if(subsidyApplMageBatDeletePo.getSubsidyApplStateType().equals(DictConstants.SUBSIDY_APPL_STATE_TYPE_2)) {
                maps.put("stateType", DictConstants.SUBSIDY_APPL_STATE_TYPE_1);
                List<SubsidyApplMage> subsidyApplMages = subsidyApplMageMapper.findListByStateType(maps);
                if (CollectionUtils.isNotEmpty(subsidyApplMages)){
                    List<Long> ids = subsidyApplMages.stream().map(SubsidyApplMage::getId).collect(Collectors.toList());
                    maps.put("ids",ids);
                    subsidyApplMageMapper.updateState(maps);
                }
            }
           return result;
    }

    /**
     * 种苗补助情况
     * @param
     * @return
     */
    public ResultPoJo<SubsidyApplCountVo> getAllowances() {
        ResultPoJo<SubsidyApplCountVo> resultPoJo = new ResultPoJo<>();
        SubsidyApplCountVo subsidyApplCountVo = subsidyApplMageMapper.getapplCount();
        ItemMageListPo itemMageListPo = new ItemMageListPo();
        List<ItemMageListVo> list = itemMageMapper.subsidyList(itemMageListPo); //种苗补助申请记录
        List<ApplMessageVo> applMessageVoList = itemMageMapper.selectApplMessage(); //申请补助用户占比
        List<ApplMessageVo> applMessageVos = itemMageMapper.selectItemApplMessage(); //种苗补助走势分析
        subsidyApplCountVo.setItemMageListVos(list);
        subsidyApplCountVo.setApplMessageVos(applMessageVos);
        subsidyApplCountVo.setApplMessageVoList(applMessageVoList);
        resultPoJo.setResult(subsidyApplCountVo);
        return resultPoJo;
    }
}
