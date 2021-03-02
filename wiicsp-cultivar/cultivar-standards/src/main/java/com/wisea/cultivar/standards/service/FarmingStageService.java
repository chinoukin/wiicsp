package com.wisea.cultivar.standards.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.standards.entity.FarmingStage;
import com.wisea.cultivar.standards.mapper.FarmingStageMapper;
import com.wisea.cultivar.standards.po.FarmingStageBatDeletePo;
import com.wisea.cultivar.standards.po.FarmingStageGetPo;
import com.wisea.cultivar.standards.po.FarmingStageInsertPo;
import com.wisea.cultivar.standards.po.FarmingStageListPo;
import com.wisea.cultivar.standards.po.FarmingStagePagePo;
import com.wisea.cultivar.standards.po.FarmingStageUpdatePo;
import com.wisea.cultivar.standards.vo.FarmingStageGetVo;
import com.wisea.cultivar.standards.vo.FarmingStageListVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * FarmingStageService
 * 农事阶段 Service
 * 2020/07/24 11:21:45
 */
@Service
public class FarmingStageService extends BaseService {
    @Autowired
    protected FarmingStageMapper farmingStageMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<FarmingStageListVo>> findPage(FarmingStagePagePo farmingStagePagePo) {
        ResultPoJo<Page<FarmingStageListVo>> result = new ResultPoJo<>();
        Page<FarmingStageListVo> page = farmingStagePagePo.getPage();
        List<FarmingStageListVo> list = farmingStageMapper.findPage(farmingStagePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<FarmingStageListVo>> findList(FarmingStageListPo farmingStageListPo) {
        ResultPoJo<List<FarmingStageListVo>> result = new ResultPoJo<>();
        result.setResult(farmingStageMapper.findList(farmingStageListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<FarmingStageGetVo> get(FarmingStageGetPo farmingStageGetPo) {
        ResultPoJo<FarmingStageGetVo> result = new ResultPoJo<>();
        FarmingStage entity = farmingStageMapper.selectByPrimaryKey(farmingStageGetPo.getId());
        FarmingStageGetVo vo = new FarmingStageGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(FarmingStageInsertPo farmingStageInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        FarmingStage farmingStage = new FarmingStage();
        ConverterUtil.copyProperties(farmingStageInsertPo, farmingStage);
        farmingStage.preInsert();
        farmingStageMapper.insert(farmingStage);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(FarmingStageUpdatePo farmingStageUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        FarmingStage farmingStage = new FarmingStage();
        ConverterUtil.copyProperties(farmingStageUpdatePo, farmingStage);
        farmingStage.preUpdate();
        farmingStageMapper.updateByPrimaryKeySelective(farmingStage);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(FarmingStageBatDeletePo farmingStageBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : farmingStageBatDeletePo.getDelList()) {
            FarmingStage farmingStage = new FarmingStage();
            farmingStage.setId(delId);
            farmingStage.preUpdate();
            farmingStageMapper.deleteLogic(farmingStage);
        }
        return result;
    }
}
