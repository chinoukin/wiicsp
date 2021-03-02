package com.wisea.cultivar.explorer.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.explorer.entity.DemonsBaseMassif;
import com.wisea.cultivar.explorer.entity.IndustryLayerArea;
import com.wisea.cultivar.explorer.mapper.IndustryLayerAreaMapper;
import com.wisea.cultivar.explorer.po.*;
import com.wisea.cultivar.explorer.vo.IndustryLayerAreaGetVo;
import com.wisea.cultivar.explorer.vo.IndustryLayerAreaListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * IndustryLayerAreaService
 * 图层区域信息 Service
 * 2020/08/11 13:21:46
 */
@Service
public class IndustryLayerAreaService extends BaseService {
    @Autowired
    protected IndustryLayerAreaMapper industryLayerAreaMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<IndustryLayerAreaListVo>> findPage(IndustryLayerAreaPagePo industryLayerAreaPagePo) {
        ResultPoJo<Page<IndustryLayerAreaListVo>> result = new ResultPoJo<>();
        Page<IndustryLayerAreaListVo> page = industryLayerAreaPagePo.getPage();
        List<IndustryLayerAreaListVo> list = industryLayerAreaMapper.findPage(industryLayerAreaPagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<HashMap<String,Object>> findList(IndustryLayerAreaListPo industryLayerAreaListPo) {
        ResultPoJo<HashMap<String,Object>> result = new ResultPoJo<>();
        HashMap<String,Object> maps = new HashMap<>();
        final List<IndustryLayerAreaListVo> layerAreaLists = industryLayerAreaMapper.findList(industryLayerAreaListPo);
        maps.put("areaLists",layerAreaLists);
        maps.put("defaultCoordPointExpres", DemonsBaseMassif.defaultCoordPointExpres);
        result.setResult(maps);
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<IndustryLayerAreaGetVo> get(IndustryLayerAreaGetPo industryLayerAreaGetPo) {
        ResultPoJo<IndustryLayerAreaGetVo> result = new ResultPoJo<>();
        IndustryLayerArea entity = industryLayerAreaMapper.selectByPrimaryKey(industryLayerAreaGetPo.getId());
        IndustryLayerAreaGetVo vo = new IndustryLayerAreaGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(IndustryLayerAreaInsertPo industryLayerAreaInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        IndustryLayerArea industryLayerArea = new IndustryLayerArea();
        ConverterUtil.copyProperties(industryLayerAreaInsertPo, industryLayerArea);
        industryLayerArea.preInsert();
        industryLayerAreaMapper.insert(industryLayerArea);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(IndustryLayerAreaUpdatePo industryLayerAreaUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        IndustryLayerArea industryLayerArea = new IndustryLayerArea();
        ConverterUtil.copyProperties(industryLayerAreaUpdatePo, industryLayerArea);
        industryLayerArea.preUpdate();
        industryLayerAreaMapper.updateByPrimaryKeySelective(industryLayerArea);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(IndustryLayerAreaBatDeletePo industryLayerAreaBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for (Long delId : industryLayerAreaBatDeletePo.getDelList()) {
            IndustryLayerArea industryLayerArea = new IndustryLayerArea();
            industryLayerArea.setId(delId);
            industryLayerArea.preUpdate();
            industryLayerAreaMapper.deleteLogic(industryLayerArea);
        }
        return result;
    }
}
