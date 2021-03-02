package com.wisea.cultivar.explorer.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.explorer.entity.OilTeaVarietMage;
import com.wisea.cultivar.explorer.mapper.OilTeaVarietMageMapper;
import com.wisea.cultivar.explorer.po.*;
import com.wisea.cultivar.explorer.vo.OilTeaVarietMageGetVo;
import com.wisea.cultivar.explorer.vo.OilTeaVarietMageListVo;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * OilTeaVarietMageService
 * 油茶品种信息维护 Service
 * 2020/07/24 11:21:45
 */
@Service
public class OilTeaVarietMageService extends BaseService {
    @Autowired
    protected OilTeaVarietMageMapper oilTeaVarietMageMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<OilTeaVarietMageListVo>> findPage(OilTeaVarietMagePagePo oilTeaVarietMagePagePo) {
        ResultPoJo<Page<OilTeaVarietMageListVo>> result = new ResultPoJo<>();
        Page<OilTeaVarietMageListVo> page = oilTeaVarietMagePagePo.getPage();
        List<OilTeaVarietMageListVo> list = oilTeaVarietMageMapper.findPage(oilTeaVarietMagePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<OilTeaVarietMageListVo>> findList(OilTeaVarietMageListPo oilTeaVarietMageListPo) {
        ResultPoJo<List<OilTeaVarietMageListVo>> result = new ResultPoJo<>();
        result.setResult(oilTeaVarietMageMapper.findList(oilTeaVarietMageListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<OilTeaVarietMageGetVo> get(OilTeaVarietMageGetPo oilTeaVarietMageGetPo) {
        ResultPoJo<OilTeaVarietMageGetVo> result = new ResultPoJo<>();
        OilTeaVarietMage entity = oilTeaVarietMageMapper.selectByPrimaryKey(oilTeaVarietMageGetPo.getId());
        OilTeaVarietMageGetVo vo = new OilTeaVarietMageGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(OilTeaVarietMageInsertPo oilTeaVarietMageInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        OilTeaVarietMage oilTeaVarietMage = new OilTeaVarietMage();
        ConverterUtil.copyProperties(oilTeaVarietMageInsertPo, oilTeaVarietMage);
        oilTeaVarietMage.setUpdateDate(OffsetDateTime.now());
        oilTeaVarietMage.preInsert();
        oilTeaVarietMageMapper.insert(oilTeaVarietMage);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(OilTeaVarietMageUpdatePo oilTeaVarietMageUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        OilTeaVarietMage oilTeaVarietMage = new OilTeaVarietMage();
        ConverterUtil.copyProperties(oilTeaVarietMageUpdatePo, oilTeaVarietMage);
        oilTeaVarietMage.preUpdate();
        oilTeaVarietMageMapper.updateByPrimaryKey(oilTeaVarietMage);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(OilTeaVarietMageBatDeletePo oilTeaVarietMageBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : oilTeaVarietMageBatDeletePo.getDelList()) {
            OilTeaVarietMage oilTeaVarietMage = new OilTeaVarietMage();
            oilTeaVarietMage.setId(delId);
            oilTeaVarietMage.preUpdate();
            oilTeaVarietMageMapper.deleteLogic(oilTeaVarietMage);
        }
        return result;
    }

    /**
     * 导入
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> excelImport(List<OilTeaVarietMageImportPo> dataList) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for (OilTeaVarietMageImportPo importPo: dataList) {
            OilTeaVarietMage oilTea = oilTeaVarietMageMapper.selectByOilNo(importPo.getOilTeaVarietNo());
            if(oilTea!=null){
                OilTeaVarietMage oilTeaVarietMage = checkParam(importPo);
                oilTeaVarietMage.preUpdate();
                oilTeaVarietMageMapper.updateByNo(oilTeaVarietMage);
            }else {
                OilTeaVarietMage oilTeaVarietMage = checkParam(importPo);
                oilTeaVarietMage.preInsert();
                oilTeaVarietMageMapper.insert(oilTeaVarietMage);
            }

        }
        return result;
    }

    /**
     * 字段校验
     * @param importPo
     * @return
     */
    public OilTeaVarietMage checkParam(OilTeaVarietMageImportPo importPo){
        OilTeaVarietMage oilTeaVarietMage = new OilTeaVarietMage();
        if(importPo.getAcrePlantCg() != null){
            BigDecimal bigDecimal   = new   BigDecimal(importPo.getAcrePlantCg());
            importPo.setAcrePlantCg(bigDecimal.setScale(2,bigDecimal.ROUND_FLOOR).doubleValue());
        }if(importPo.getAcrePlantCy() != null){
            BigDecimal bigDecimal1   = new   BigDecimal(importPo.getAcrePlantCy());
            importPo.setAcrePlantCy(bigDecimal1.setScale(2,bigDecimal1.ROUND_FLOOR).doubleValue());
        }if(importPo.getAcrePlantCz() != null){
            BigDecimal bigDecimal2   = new   BigDecimal(importPo.getAcrePlantCy());
            importPo.setAcrePlantCy(bigDecimal2.setScale(2,bigDecimal2.ROUND_FLOOR).doubleValue());
        }if(importPo.getAcrePlantNum() != null){
            importPo.setAcrePlantNum(Math.floor(importPo.getAcrePlantNum()));
        }
        ConverterUtil.copyProperties(importPo, oilTeaVarietMage);
        return oilTeaVarietMage;
    }
}
