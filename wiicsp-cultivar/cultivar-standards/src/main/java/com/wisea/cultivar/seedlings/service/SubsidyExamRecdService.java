package com.wisea.cultivar.seedlings.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.seedlings.entity.SubsidyExamRecd;
import com.wisea.cultivar.seedlings.mapper.SubsidyExamRecdMapper;
import com.wisea.cultivar.seedlings.po.SubsidyExamRecdBatDeletePo;
import com.wisea.cultivar.seedlings.po.SubsidyExamRecdGetPo;
import com.wisea.cultivar.seedlings.po.SubsidyExamRecdInsertPo;
import com.wisea.cultivar.seedlings.po.SubsidyExamRecdListPo;
import com.wisea.cultivar.seedlings.po.SubsidyExamRecdPagePo;
import com.wisea.cultivar.seedlings.po.SubsidyExamRecdUpdatePo;
import com.wisea.cultivar.seedlings.vo.SubsidyExamRecdGetVo;
import com.wisea.cultivar.seedlings.vo.SubsidyExamRecdListVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * SubsidyExamRecdService
 * 补贴审核记录 Service
 * 2020/08/06 14:19:24
 */
@Service
public class SubsidyExamRecdService extends BaseService {
    @Autowired
    protected SubsidyExamRecdMapper subsidyExamRecdMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<SubsidyExamRecdListVo>> findPage(SubsidyExamRecdPagePo subsidyExamRecdPagePo) {
        ResultPoJo<Page<SubsidyExamRecdListVo>> result = new ResultPoJo<>();
        Page<SubsidyExamRecdListVo> page = subsidyExamRecdPagePo.getPage();
        List<SubsidyExamRecdListVo> list = subsidyExamRecdMapper.findPage(subsidyExamRecdPagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<SubsidyExamRecdListVo>> findList(SubsidyExamRecdListPo subsidyExamRecdListPo) {
        ResultPoJo<List<SubsidyExamRecdListVo>> result = new ResultPoJo<>();
        result.setResult(subsidyExamRecdMapper.findList(subsidyExamRecdListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<SubsidyExamRecdGetVo> get(SubsidyExamRecdGetPo subsidyExamRecdGetPo) {
        ResultPoJo<SubsidyExamRecdGetVo> result = new ResultPoJo<>();
        SubsidyExamRecd entity = subsidyExamRecdMapper.selectByPrimaryKey(subsidyExamRecdGetPo.getId());
        SubsidyExamRecdGetVo vo = new SubsidyExamRecdGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(SubsidyExamRecdInsertPo subsidyExamRecdInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        SubsidyExamRecd subsidyExamRecd = new SubsidyExamRecd();
        ConverterUtil.copyProperties(subsidyExamRecdInsertPo, subsidyExamRecd);
        subsidyExamRecd.preInsert();
        subsidyExamRecdMapper.insert(subsidyExamRecd);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(SubsidyExamRecdUpdatePo subsidyExamRecdUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        SubsidyExamRecd subsidyExamRecd = new SubsidyExamRecd();
        ConverterUtil.copyProperties(subsidyExamRecdUpdatePo, subsidyExamRecd);
        subsidyExamRecd.preUpdate();
        subsidyExamRecdMapper.updateByPrimaryKeySelective(subsidyExamRecd);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(SubsidyExamRecdBatDeletePo subsidyExamRecdBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : subsidyExamRecdBatDeletePo.getDelList()) {
            SubsidyExamRecd subsidyExamRecd = new SubsidyExamRecd();
            subsidyExamRecd.setId(delId);
            subsidyExamRecd.preUpdate();
            subsidyExamRecdMapper.deleteLogic(subsidyExamRecd);
        }
        return result;
    }
}
