package com.wisea.cultivar.standards.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.standards.entity.PlantStandardDetails;
import com.wisea.cultivar.standards.mapper.PlantStandardDetailsMapper;
import com.wisea.cultivar.standards.po.PlantStandardDetailsBatDeletePo;
import com.wisea.cultivar.standards.po.PlantStandardDetailsGetPo;
import com.wisea.cultivar.standards.po.PlantStandardDetailsInsertPo;
import com.wisea.cultivar.standards.po.PlantStandardDetailsListPo;
import com.wisea.cultivar.standards.po.PlantStandardDetailsPagePo;
import com.wisea.cultivar.standards.po.PlantStandardDetailsUpdatePo;
import com.wisea.cultivar.standards.vo.PlantStandardDetailsGetVo;
import com.wisea.cultivar.standards.vo.PlantStandardDetailsListVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * PlantStandardDetailsService
 * 标准详情 Service
 * 2020/07/24 11:21:45
 */
@Service
public class PlantStandardDetailsService extends BaseService {
    @Autowired
    protected PlantStandardDetailsMapper plantStandardDetailsMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<PlantStandardDetailsListVo>> findPage(PlantStandardDetailsPagePo plantStandardDetailsPagePo) {
        ResultPoJo<Page<PlantStandardDetailsListVo>> result = new ResultPoJo<>();
        Page<PlantStandardDetailsListVo> page = plantStandardDetailsPagePo.getPage();
        List<PlantStandardDetailsListVo> list = plantStandardDetailsMapper.findPage(plantStandardDetailsPagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<PlantStandardDetailsListVo>> findList(PlantStandardDetailsListPo plantStandardDetailsListPo) {
        ResultPoJo<List<PlantStandardDetailsListVo>> result = new ResultPoJo<>();
        result.setResult(plantStandardDetailsMapper.findList(plantStandardDetailsListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<PlantStandardDetailsGetVo> get(PlantStandardDetailsGetPo plantStandardDetailsGetPo) {
        ResultPoJo<PlantStandardDetailsGetVo> result = new ResultPoJo<>();
        PlantStandardDetails entity = plantStandardDetailsMapper.selectByPrimaryKey(plantStandardDetailsGetPo.getId());
        PlantStandardDetailsGetVo vo = new PlantStandardDetailsGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(PlantStandardDetailsInsertPo plantStandardDetailsInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        PlantStandardDetails plantStandardDetails = new PlantStandardDetails();
        ConverterUtil.copyProperties(plantStandardDetailsInsertPo, plantStandardDetails);
        plantStandardDetails.preInsert();
        plantStandardDetailsMapper.insert(plantStandardDetails);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(PlantStandardDetailsUpdatePo plantStandardDetailsUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        PlantStandardDetails plantStandardDetails = new PlantStandardDetails();
        ConverterUtil.copyProperties(plantStandardDetailsUpdatePo, plantStandardDetails);
        plantStandardDetails.preUpdate();
        plantStandardDetailsMapper.updateByPrimaryKeySelective(plantStandardDetails);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(PlantStandardDetailsBatDeletePo plantStandardDetailsBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : plantStandardDetailsBatDeletePo.getDelList()) {
            PlantStandardDetails plantStandardDetails = new PlantStandardDetails();
            plantStandardDetails.setId(delId);
            plantStandardDetails.preUpdate();
            plantStandardDetailsMapper.deleteLogic(plantStandardDetails);
        }
        return result;
    }
}
