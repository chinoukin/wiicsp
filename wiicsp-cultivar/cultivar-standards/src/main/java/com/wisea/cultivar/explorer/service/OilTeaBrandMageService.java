package com.wisea.cultivar.explorer.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.explorer.entity.OilTeaBrandMage;
import com.wisea.cultivar.explorer.mapper.OilTeaBrandMageMapper;
import com.wisea.cultivar.explorer.po.*;
import com.wisea.cultivar.explorer.vo.OilTeaBrandMageGetVo;
import com.wisea.cultivar.explorer.vo.OilTeaBrandMageListVo;

import java.time.OffsetDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * OilTeaBrandMageService
 * 茶油品牌信息维护 Service
 * 2020/07/24 11:21:45
 */
@Service
public class OilTeaBrandMageService extends BaseService {
    @Autowired
    protected OilTeaBrandMageMapper oilTeaBrandMageMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<OilTeaBrandMageListVo>> findPage(OilTeaBrandMagePagePo oilTeaBrandMagePagePo) {
        ResultPoJo<Page<OilTeaBrandMageListVo>> result = new ResultPoJo<>();
        Page<OilTeaBrandMageListVo> page = oilTeaBrandMagePagePo.getPage();
        List<OilTeaBrandMageListVo> list = oilTeaBrandMageMapper.findPage(oilTeaBrandMagePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<OilTeaBrandMageListVo>> findList(OilTeaBrandMageListPo oilTeaBrandMageListPo) {
        ResultPoJo<List<OilTeaBrandMageListVo>> result = new ResultPoJo<>();
        result.setResult(oilTeaBrandMageMapper.findList(oilTeaBrandMageListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<OilTeaBrandMageGetVo> get(OilTeaBrandMageGetPo oilTeaBrandMageGetPo) {
        ResultPoJo<OilTeaBrandMageGetVo> result = new ResultPoJo<>();
        OilTeaBrandMage entity = oilTeaBrandMageMapper.selectByPrimaryKey(oilTeaBrandMageGetPo.getId());
        OilTeaBrandMageGetVo vo = new OilTeaBrandMageGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(OilTeaBrandMageInsertPo oilTeaBrandMageInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        OilTeaBrandMage oilTeaBrandMage = new OilTeaBrandMage();
        ConverterUtil.copyProperties(oilTeaBrandMageInsertPo, oilTeaBrandMage);
        oilTeaBrandMage.setUpdateDate(OffsetDateTime.now());
        oilTeaBrandMage.preInsert();
        oilTeaBrandMageMapper.insert(oilTeaBrandMage);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(OilTeaBrandMageUpdatePo oilTeaBrandMageUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        OilTeaBrandMage oilTeaBrandMage = new OilTeaBrandMage();
        ConverterUtil.copyProperties(oilTeaBrandMageUpdatePo, oilTeaBrandMage);
        oilTeaBrandMage.preUpdate();
        oilTeaBrandMageMapper.updateByPrimaryKeySelective(oilTeaBrandMage);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(OilTeaBrandMageBatDeletePo oilTeaBrandMageBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : oilTeaBrandMageBatDeletePo.getDelList()) {
            OilTeaBrandMage oilTeaBrandMage = new OilTeaBrandMage();
            oilTeaBrandMage.setId(delId);
            oilTeaBrandMage.preUpdate();
            oilTeaBrandMageMapper.deleteLogic(oilTeaBrandMage);
        }
        return result;
    }

    /**
     * 导入
     */
    public ResultPoJo<Object> excelImport(List<OilTeaBrandMageImportPo> dataList) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        dataList.forEach(importPo -> {
            OilTeaBrandMage oilTeaBrandMage = new OilTeaBrandMage();
            ConverterUtil.copyProperties(importPo, oilTeaBrandMage);
            oilTeaBrandMage.setApplDate(ConverterUtil.stringToOffsetDateTime(importPo.getApplDateStr()));
            oilTeaBrandMage.preInsert();
            oilTeaBrandMageMapper.insert(oilTeaBrandMage);
        });
        return result;
    }
}
