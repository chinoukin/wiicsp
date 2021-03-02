package com.wisea.cultivar.standards.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.standards.entity.FarmingCycle;
import com.wisea.cultivar.standards.mapper.FarmingCycleMapper;
import com.wisea.cultivar.standards.po.FarmingCycleBatDeletePo;
import com.wisea.cultivar.standards.po.FarmingCycleGetPo;
import com.wisea.cultivar.standards.po.FarmingCycleInsertPo;
import com.wisea.cultivar.standards.po.FarmingCycleListPo;
import com.wisea.cultivar.standards.po.FarmingCyclePagePo;
import com.wisea.cultivar.standards.po.FarmingCycleUpdatePo;
import com.wisea.cultivar.standards.vo.FarmingCycleGetVo;
import com.wisea.cultivar.standards.vo.FarmingCycleListVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * FarmingCycleService
 * 农事周期 Service
 * 2020/07/24 11:21:45
 */
@Service
public class FarmingCycleService extends BaseService {
    @Autowired
    protected FarmingCycleMapper farmingCycleMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<FarmingCycleListVo>> findPage(FarmingCyclePagePo farmingCyclePagePo) {
        ResultPoJo<Page<FarmingCycleListVo>> result = new ResultPoJo<>();
        Page<FarmingCycleListVo> page = farmingCyclePagePo.getPage();
        List<FarmingCycleListVo> list = farmingCycleMapper.findPage(farmingCyclePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<FarmingCycleListVo>> findList(FarmingCycleListPo farmingCycleListPo) {
        ResultPoJo<List<FarmingCycleListVo>> result = new ResultPoJo<>();
        result.setResult(farmingCycleMapper.findList(farmingCycleListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<FarmingCycleGetVo> get(FarmingCycleGetPo farmingCycleGetPo) {
        ResultPoJo<FarmingCycleGetVo> result = new ResultPoJo<>();
        FarmingCycle entity = farmingCycleMapper.selectByPrimaryKey(farmingCycleGetPo.getId());
        FarmingCycleGetVo vo = new FarmingCycleGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(FarmingCycleInsertPo farmingCycleInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        FarmingCycle farmingCycle = new FarmingCycle();
        ConverterUtil.copyProperties(farmingCycleInsertPo, farmingCycle);
        farmingCycle.preInsert();
        farmingCycleMapper.insert(farmingCycle);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(FarmingCycleUpdatePo farmingCycleUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        FarmingCycle farmingCycle = new FarmingCycle();
        ConverterUtil.copyProperties(farmingCycleUpdatePo, farmingCycle);
        farmingCycle.preUpdate();
        farmingCycleMapper.updateByPrimaryKeySelective(farmingCycle);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(FarmingCycleBatDeletePo farmingCycleBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : farmingCycleBatDeletePo.getDelList()) {
            FarmingCycle farmingCycle = new FarmingCycle();
            farmingCycle.setId(delId);
            farmingCycle.preUpdate();
            farmingCycleMapper.deleteLogic(farmingCycle);
        }
        return result;
    }
}
