package com.wisea.cultivar.explorer.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.constants.QdcyStandardsDict;
import com.wisea.cultivar.explorer.entity.EntpInfoMage;
import com.wisea.cultivar.explorer.mapper.EntpInfoMageMapper;
import com.wisea.cultivar.explorer.po.*;
import com.wisea.cultivar.explorer.vo.EntpInfoMageGetVo;
import com.wisea.cultivar.explorer.vo.EntpInfoMageListVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * EntpInfoMageService
 * 企业信息维护 Service
 * 2020/07/24 11:21:45
 */
@Service
public class EntpInfoMageService extends BaseService {
    @Autowired
    protected EntpInfoMageMapper entpInfoMageMapper;
    @Autowired
    protected ProceEntpVideoService proceEntpVideoService;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<EntpInfoMageListVo>> findPage(EntpInfoMagePagePo entpInfoMagePagePo) {
        ResultPoJo<Page<EntpInfoMageListVo>> result = new ResultPoJo<>();
        Page<EntpInfoMageListVo> page = entpInfoMagePagePo.getPage();
        List<EntpInfoMageListVo> list = entpInfoMageMapper.findPage(entpInfoMagePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<EntpInfoMageListVo>> findList(EntpInfoMageListPo entpInfoMageListPo) {
        ResultPoJo<List<EntpInfoMageListVo>> result = new ResultPoJo<>();
        List<EntpInfoMageListVo> infoMageListVos = entpInfoMageMapper.findList(entpInfoMageListPo);
        if(QdcyStandardsDict.ENTP_MAIN_BUSINESS_TYPE_5.equals(entpInfoMageListPo.getEntpMainBusinessType())){
            infoMageListVos = infoMageListVos.stream().peek(entInfo-> entInfo.setProcessingVideo(proceEntpVideoService.findVideoList(entInfo.getId()))).collect(Collectors.toList());
            if(null != entpInfoMageListPo.getId()){
                final List<EntpInfoMageListVo> entpInfoMageListVos = infoMageListVos.stream().filter(entInfo -> entInfo.getId().equals(entpInfoMageListPo.getId())).collect(Collectors.toList());
                infoMageListVos = infoMageListVos.stream().filter(entInfo -> !entInfo.getId().equals(entpInfoMageListPo.getId())).collect(Collectors.toList());
                infoMageListVos.addAll(0,entpInfoMageListVos);
            }
        }
        result.setResult(infoMageListVos);
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<EntpInfoMageGetVo> get(EntpInfoMageGetPo entpInfoMageGetPo) {
        ResultPoJo<EntpInfoMageGetVo> result = new ResultPoJo<>();
        EntpInfoMage entity = entpInfoMageMapper.selectByPrimaryKey(entpInfoMageGetPo.getId());
        if (ConverterUtil.isEmpty(entity)) {
            result.setCode(ConstantError.ERR_004);
            result.setMsg(ConstantError.MSG_004);
            return result;
        }
        EntpInfoMageGetVo vo = new EntpInfoMageGetVo();
        ConverterUtil.copyProperties(entity, vo);

        if(QdcyStandardsDict.ENTP_MAIN_BUSINESS_TYPE_5.equals(entity.getEntpMainBusinessType())){
            vo.setProcessingVideo(proceEntpVideoService.findVideoList(entity.getId()));
        }

        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(EntpInfoMageInsertPo entpInfoMageInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        EntpInfoMage entpInfoMage = new EntpInfoMage();
        ConverterUtil.copyProperties(entpInfoMageInsertPo, entpInfoMage);
        entpInfoMage.setUpdateDate(OffsetDateTime.now());
        if(StringUtils.isNotBlank(entpInfoMageInsertPo.getJdWd())){
            entpInfoMage.setJd(entpInfoMageInsertPo.getJd());
            entpInfoMage.setWd(entpInfoMageInsertPo.getWd());
        }
        entpInfoMage.preInsert();
        entpInfoMageMapper.insert(entpInfoMage);
        return result;
    }

    /**
     * 新增农技/精深加工
     */
    public ResultPoJo<Object> insert(EntpInfoMageInsertProceAgricPo entpInfoMageInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        EntpInfoMage entpInfoMage = new EntpInfoMage();
        ConverterUtil.copyProperties(entpInfoMageInsertPo, entpInfoMage);
        if(StringUtils.isNotBlank(entpInfoMageInsertPo.getJdWd())){
            entpInfoMage.setJd(entpInfoMageInsertPo.getJd());
            entpInfoMage.setWd(entpInfoMageInsertPo.getWd());
        }
        entpInfoMage.preInsert();
        entpInfoMageMapper.insert(entpInfoMage);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(EntpInfoMageUpdatePo entpInfoMageUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        EntpInfoMage entity = entpInfoMageMapper.selectByPrimaryKey(entpInfoMageUpdatePo.getId());
        if (ConverterUtil.isEmpty(entity)) {
            result.setCode(ConstantError.ERR_004);
            result.setMsg(ConstantError.MSG_004);
            return result;
        }
        EntpInfoMage entpInfoMage = new EntpInfoMage();
        ConverterUtil.copyProperties(entpInfoMageUpdatePo, entpInfoMage);
        if (StringUtils.isNotBlank(entpInfoMageUpdatePo.getJdWd())) {
            entpInfoMage.setJd(entpInfoMageUpdatePo.getJd());
            entpInfoMage.setWd(entpInfoMageUpdatePo.getWd());
        }else {
            entpInfoMage.setJd(Double.valueOf("0"));
            entpInfoMage.setWd(Double.valueOf("0"));
        }
        entpInfoMage.preUpdate();
        entpInfoMageMapper.updateByPrimaryKeySelective(entpInfoMage);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(EntpInfoMageUpdateProceAgricPo entpInfoMageUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        EntpInfoMage entpInfoMage = new EntpInfoMage();
        ConverterUtil.copyProperties(entpInfoMageUpdatePo, entpInfoMage);
        if (StringUtils.isNotBlank(entpInfoMageUpdatePo.getJdWd())) {
            entpInfoMage.setJd(entpInfoMageUpdatePo.getJd());
            entpInfoMage.setWd(entpInfoMageUpdatePo.getWd());
        } else {
            entpInfoMage.setJd(Double.valueOf("0"));
            entpInfoMage.setWd(Double.valueOf("0"));
        }
        entpInfoMage.preUpdate();
        entpInfoMageMapper.updateByPrimaryKeySelective(entpInfoMage);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(EntpInfoMageBatDeletePo entpInfoMageBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for (Long delId : entpInfoMageBatDeletePo.getDelList()) {
            EntpInfoMage entpInfoMage = new EntpInfoMage();
            entpInfoMage.setId(delId);
            entpInfoMage.preUpdate();
            entpInfoMageMapper.deleteLogic(entpInfoMage);
        }
        return result;
    }

    /**
     * 导入
     */
    public ResultPoJo<Object> excelImportProceAgric(List<EntpInfoMageImportProceAgricPo> dataList, String entpMainBusinessType) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        dataList.forEach(importPo -> {
            EntpInfoMage entpInfoMage = new EntpInfoMage();
            ConverterUtil.copyProperties(importPo, entpInfoMage);
            entpInfoMage.setJd(importPo.getJd());
            entpInfoMage.setWd(importPo.getWd());
            entpInfoMage.setEntpMainBusinessType(entpMainBusinessType);
            if(!ConverterUtil.isEmpty(importPo.getEstabDate())){
                entpInfoMage.setEstabDate(ConverterUtil.stringToOffsetDateTime(importPo.getEstabDate()));
            }
            entpInfoMage.preInsert();
            entpInfoMageMapper.insert(entpInfoMage);
        });
        return result;
    }

    /*
     * 导入种苗企业信息
     */

    public ResultPoJo<Object> excelImportSeedCompanies(List<EntpInfoSeedCompaniesImportPo> dataList, String entpMainBusinessType) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        dataList.forEach(importPo -> {
            EntpInfoMage entpInfoMage = new EntpInfoMage();
            ConverterUtil.copyProperties(importPo, entpInfoMage);
            entpInfoMage.setJd(importPo.getJd());
            entpInfoMage.setWd(importPo.getWd());
            entpInfoMage.setEntpMainBusinessType(entpMainBusinessType);
            if(!ConverterUtil.isEmpty(importPo.getEstabDate())){
                entpInfoMage.setEstabDate(ConverterUtil.stringToOffsetDateTime(importPo.getEstabDate()));
            }
            entpInfoMage.preInsert();
            entpInfoMageMapper.insert(entpInfoMage);
        });
        return result;
    }

    /*
     * 导入种植主体信息
     */

    public ResultPoJo<Object> excelImportPlantEnterprise(List<EntpInfoPlantEnterpriseImportPo> dataList, String entpMainBusinessType) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        dataList.forEach(importPo -> {
            EntpInfoMage entpInfoMage = new EntpInfoMage();
            ConverterUtil.copyProperties(importPo, entpInfoMage);
            entpInfoMage.setJd(importPo.getJd());
            entpInfoMage.setWd(importPo.getWd());
            entpInfoMage.setEntpMainBusinessType(entpMainBusinessType);
            if(!ConverterUtil.isEmpty(importPo.getEstabDate())){
                entpInfoMage.setEstabDate(ConverterUtil.stringToOffsetDateTime(importPo.getEstabDate()));
            }
            entpInfoMage.preInsert();
            entpInfoMageMapper.insert(entpInfoMage);
        });
        return result;
    }

}
