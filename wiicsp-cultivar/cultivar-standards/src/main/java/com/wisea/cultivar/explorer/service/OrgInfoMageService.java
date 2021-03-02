package com.wisea.cultivar.explorer.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.explorer.entity.OrgInfoMage;
import com.wisea.cultivar.explorer.mapper.OrgInfoMageMapper;
import com.wisea.cultivar.explorer.po.*;
import com.wisea.cultivar.explorer.vo.OrgInfoMageGetVo;
import com.wisea.cultivar.explorer.vo.OrgInfoMageListVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * OrgInfoMageService
 * 机构信息维护 Service
 * 2020/07/24 11:21:45
 */
@Service
public class OrgInfoMageService extends BaseService {
    @Autowired
    protected OrgInfoMageMapper orgInfoMageMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<OrgInfoMageListVo>> findPage(OrgInfoMagePagePo orgInfoMagePagePo) {
        ResultPoJo<Page<OrgInfoMageListVo>> result = new ResultPoJo<>();
        Page<OrgInfoMageListVo> page = orgInfoMagePagePo.getPage();
        List<OrgInfoMageListVo> list = orgInfoMageMapper.findPage(orgInfoMagePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<OrgInfoMageListVo>> findList(OrgInfoMageListPo orgInfoMageListPo) {
        ResultPoJo<List<OrgInfoMageListVo>> result = new ResultPoJo<>();
        result.setResult(orgInfoMageMapper.findList(orgInfoMageListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<OrgInfoMageGetVo> get(OrgInfoMageGetPo orgInfoMageGetPo) {
        ResultPoJo<OrgInfoMageGetVo> result = new ResultPoJo<>();
        OrgInfoMage entity = orgInfoMageMapper.selectByPrimaryKey(orgInfoMageGetPo.getId());
        if(null == entity){
            return new ResultPoJo<>(ConstantError.ERR_004,ConstantError.MSG_004);
        }
        OrgInfoMageGetVo vo = new OrgInfoMageGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(OrgInfoMageInsertPo orgInfoMageInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        OrgInfoMage orgInfoMage = new OrgInfoMage();
        ConverterUtil.copyProperties(orgInfoMageInsertPo, orgInfoMage);
        if(StringUtils.isNotBlank(orgInfoMageInsertPo.getJdWd())){
            orgInfoMage.setJd(orgInfoMageInsertPo.getJd());
            orgInfoMage.setWd(orgInfoMageInsertPo.getWd());
        }
        orgInfoMage.preInsert();
        orgInfoMageMapper.insert(orgInfoMage);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(OrgInfoMageUpdatePo orgInfoMageUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        OrgInfoMage entity = orgInfoMageMapper.selectByPrimaryKey(orgInfoMageUpdatePo.getId());
        if(null == entity){
            return new ResultPoJo<>(ConstantError.ERR_004,ConstantError.MSG_004);
        }
        OrgInfoMage orgInfoMage = new OrgInfoMage();
        ConverterUtil.copyProperties(orgInfoMageUpdatePo, orgInfoMage);
        if(StringUtils.isNotBlank(orgInfoMageUpdatePo.getJdWd())){
            orgInfoMage.setJd(orgInfoMageUpdatePo.getJd());
            orgInfoMage.setWd(orgInfoMageUpdatePo.getWd());
        }else {
            orgInfoMage.setJd(Double.valueOf("0"));
            orgInfoMage.setWd(Double.valueOf("0"));
        }
        orgInfoMage.preUpdate();
        orgInfoMageMapper.updateByPrimaryKeySelective(orgInfoMage);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(OrgInfoMageBatDeletePo orgInfoMageBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : orgInfoMageBatDeletePo.getDelList()) {
            OrgInfoMage orgInfoMage = new OrgInfoMage();
            orgInfoMage.setId(delId);
            orgInfoMage.preUpdate();
            orgInfoMageMapper.deleteLogic(orgInfoMage);
        }
        return result;
    }

    /**
     * 导入
     */
    public ResultPoJo<Object> excelImport(List<OrgInfoMageImportPo> dataList, String orgType) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        dataList.forEach(importPo ->{
            OrgInfoMage orgInfoMage = new OrgInfoMage();
            ConverterUtil.copyProperties(importPo, orgInfoMage);
            orgInfoMage.setJd(importPo.getJd());
            orgInfoMage.setWd(importPo.getWd());
            orgInfoMage.setOrgType(orgType);
            orgInfoMage.preInsert();
            orgInfoMageMapper.insert(orgInfoMage);
        });
        return result;
    }
}
