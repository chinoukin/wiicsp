package com.wisea.cultivar.explorer.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.explorer.entity.DemonsBaseMassif;
import com.wisea.cultivar.explorer.entity.RelationIotInfo;
import com.wisea.cultivar.explorer.mapper.DemonsBaseMassifMapper;
import com.wisea.cultivar.explorer.po.DemonsBaseMassifBatDeletePo;
import com.wisea.cultivar.explorer.po.DemonsBaseMassifGetPo;
import com.wisea.cultivar.explorer.po.DemonsBaseMassifInsertPo;
import com.wisea.cultivar.explorer.po.DemonsBaseMassifListPo;
import com.wisea.cultivar.explorer.po.DemonsBaseMassifPagePo;
import com.wisea.cultivar.explorer.po.DemonsBaseMassifUpdatePo;
import com.wisea.cultivar.explorer.vo.DemonsBaseMassifGetVo;
import com.wisea.cultivar.explorer.vo.DemonsBaseMassifListVo;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * DemonsBaseMassifService
 * 示范基地地块信息 Service
 * 2020/08/11 13:21:46
 */
@Service
public class DemonsBaseMassifService extends BaseService {
    @Autowired
    protected DemonsBaseMassifMapper demonsBaseMassifMapper;
    @Autowired
    protected RelationIotInfoService relationIotInfoService;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<DemonsBaseMassifListVo>> findPage(DemonsBaseMassifPagePo demonsBaseMassifPagePo) {
        ResultPoJo<Page<DemonsBaseMassifListVo>> result = new ResultPoJo<>();
        Page<DemonsBaseMassifListVo> page = demonsBaseMassifPagePo.getPage();
        List<DemonsBaseMassifListVo> list = demonsBaseMassifMapper.findPage(demonsBaseMassifPagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<HashMap<String,Object>> findList(DemonsBaseMassifListPo demonsBaseMassifListPo) {
        ResultPoJo<HashMap<String,Object>> result = new ResultPoJo<>();
        HashMap<String,Object> maps = new HashMap<>(2);
        final List<DemonsBaseMassifListVo> massifLists = demonsBaseMassifMapper.findList(demonsBaseMassifListPo);
        maps.put("massifLists",massifLists);
        maps.put("defaultCoordPointExpres", DemonsBaseMassif.defaultCoordPointExpres);
        result.setResult(maps);
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<DemonsBaseMassifGetVo> get(DemonsBaseMassifGetPo demonsBaseMassifGetPo) {
        ResultPoJo<DemonsBaseMassifGetVo> result = new ResultPoJo<>();
        DemonsBaseMassif entity = demonsBaseMassifMapper.selectByPrimaryKey(demonsBaseMassifGetPo.getId());
        DemonsBaseMassifGetVo vo = new DemonsBaseMassifGetVo();
        ConverterUtil.copyProperties(entity, vo);
        final List<Long> equipmentIds = relationIotInfoService.equipmentIds(demonsBaseMassifGetPo);
        if(null != equipmentIds && equipmentIds.size() > 0 ){
            vo.setAreaId(equipmentIds);
            vo.setAreaNum(equipmentIds.size());
        }
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(DemonsBaseMassifInsertPo demonsBaseMassifInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        DemonsBaseMassif demonsBaseMassif = new DemonsBaseMassif();
        ConverterUtil.copyProperties(demonsBaseMassifInsertPo, demonsBaseMassif);
        demonsBaseMassif.preInsert();
        demonsBaseMassifMapper.insert(demonsBaseMassif);
        if(!CollectionUtils.isEmpty(demonsBaseMassifInsertPo.getEquipmentIds())){
            final List<Long> equipmentIds = demonsBaseMassifInsertPo.getEquipmentIds();
            equipmentIds.parallelStream().forEach(equipmentId -> {
                RelationIotInfo relationIotInfo = new RelationIotInfo(demonsBaseMassif.getId(), equipmentId);
                relationIotInfoService.insert(relationIotInfo);
            });
        }
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(DemonsBaseMassifUpdatePo demonsBaseMassifUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        DemonsBaseMassif demonsBaseMassif = new DemonsBaseMassif();
        ConverterUtil.copyProperties(demonsBaseMassifUpdatePo, demonsBaseMassif);
        demonsBaseMassif.preUpdate();
        demonsBaseMassifMapper.updateByPrimaryKeySelective(demonsBaseMassif);
        relationIotInfoService.delete(demonsBaseMassif.getId());
        if(!CollectionUtils.isEmpty(demonsBaseMassifUpdatePo.getEquipmentIds())){
            final List<Long> equipmentIds = demonsBaseMassifUpdatePo.getEquipmentIds();
            equipmentIds.forEach(equipmentId -> {
                RelationIotInfo relationIotInfo = new RelationIotInfo(demonsBaseMassif.getId(), equipmentId);
                relationIotInfoService.insert(relationIotInfo);
            });
        }
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(DemonsBaseMassifBatDeletePo demonsBaseMassifBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : demonsBaseMassifBatDeletePo.getDelList()) {
            DemonsBaseMassif demonsBaseMassif = new DemonsBaseMassif();
            demonsBaseMassif.setId(delId);
            demonsBaseMassif.preUpdate();
            demonsBaseMassifMapper.deleteLogic(demonsBaseMassif);
        }
        return result;
    }
}
