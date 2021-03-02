package com.wisea.cultivar.explorer.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.explorer.entity.IndustryLayerInfo;
import com.wisea.cultivar.explorer.mapper.IndustryLayerInfoMapper;
import com.wisea.cultivar.explorer.po.IndustryLayerInfoBatDeletePo;
import com.wisea.cultivar.explorer.po.IndustryLayerInfoGetPo;
import com.wisea.cultivar.explorer.po.IndustryLayerInfoInsertPo;
import com.wisea.cultivar.explorer.po.IndustryLayerInfoListPo;
import com.wisea.cultivar.explorer.po.IndustryLayerInfoPagePo;
import com.wisea.cultivar.explorer.po.IndustryLayerInfoUpdatePo;
import com.wisea.cultivar.explorer.vo.IndustryLayerInfoGetVo;
import com.wisea.cultivar.explorer.vo.IndustryLayerInfoListVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * IndustryLayerInfoService
 * 产业图层信息 Service
 * 2020/08/11 13:21:46
 */
@Service
public class IndustryLayerInfoService extends BaseService {
    @Autowired
    protected IndustryLayerInfoMapper industryLayerInfoMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<IndustryLayerInfoListVo>> findPage(IndustryLayerInfoPagePo industryLayerInfoPagePo) {
        ResultPoJo<Page<IndustryLayerInfoListVo>> result = new ResultPoJo<>();
        Page<IndustryLayerInfoListVo> page = industryLayerInfoPagePo.getPage();
        List<IndustryLayerInfoListVo> list = industryLayerInfoMapper.findPage(industryLayerInfoPagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<IndustryLayerInfoListVo>> findList(IndustryLayerInfoListPo industryLayerInfoListPo) {
        ResultPoJo<List<IndustryLayerInfoListVo>> result = new ResultPoJo<>();
        result.setResult(industryLayerInfoMapper.findList(industryLayerInfoListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<IndustryLayerInfoGetVo> get(IndustryLayerInfoGetPo industryLayerInfoGetPo) {
        ResultPoJo<IndustryLayerInfoGetVo> result = new ResultPoJo<>();
        IndustryLayerInfo entity = industryLayerInfoMapper.selectByPrimaryKey(industryLayerInfoGetPo.getId());
        IndustryLayerInfoGetVo vo = new IndustryLayerInfoGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(IndustryLayerInfoInsertPo industryLayerInfoInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        IndustryLayerInfo industryLayerInfo = new IndustryLayerInfo();
        ConverterUtil.copyProperties(industryLayerInfoInsertPo, industryLayerInfo);
        industryLayerInfo.preInsert();
        industryLayerInfoMapper.insert(industryLayerInfo);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(IndustryLayerInfoUpdatePo industryLayerInfoUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        IndustryLayerInfo industryLayerInfo = new IndustryLayerInfo();
        ConverterUtil.copyProperties(industryLayerInfoUpdatePo, industryLayerInfo);
        industryLayerInfo.preUpdate();
        industryLayerInfoMapper.updateByPrimaryKeySelective(industryLayerInfo);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(IndustryLayerInfoBatDeletePo industryLayerInfoBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : industryLayerInfoBatDeletePo.getDelList()) {
            IndustryLayerInfo industryLayerInfo = new IndustryLayerInfo();
            industryLayerInfo.setId(delId);
            industryLayerInfo.preUpdate();
            industryLayerInfoMapper.deleteLogic(industryLayerInfo);
        }
        return result;
    }
}
