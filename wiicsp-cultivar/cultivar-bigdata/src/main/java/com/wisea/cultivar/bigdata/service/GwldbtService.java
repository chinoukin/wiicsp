package com.wisea.cultivar.bigdata.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.dao.bigdata.GwldbtMapper;
import com.wisea.cultivar.common.entity.bigdata.Gwldbt;
import com.wisea.cultivar.common.po.bigdata.GwldbtBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.GwldbtGetPo;
import com.wisea.cultivar.common.po.bigdata.GwldbtInsertPo;
import com.wisea.cultivar.common.po.bigdata.GwldbtListPo;
import com.wisea.cultivar.common.po.bigdata.GwldbtPagePo;
import com.wisea.cultivar.common.po.bigdata.GwldbtUpdatePo;
import com.wisea.cultivar.common.vo.bigdata.GwldbtGetVo;
import com.wisea.cultivar.common.vo.bigdata.GwldbtListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * GwldbtService
 * 各物流对比图 Service
 * 2019/12/02 11:02:14
 */
@Service
public class GwldbtService extends BaseService {
    @Autowired
    protected GwldbtMapper gwldbtMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<GwldbtListVo>> findPage(GwldbtPagePo gwldbtPagePo) {
        ResultPoJo<Page<GwldbtListVo>> result = new ResultPoJo<>();
        Page<GwldbtListVo> page = gwldbtPagePo.getPage();
        List<GwldbtListVo> list = gwldbtMapper.findPage(gwldbtPagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<GwldbtListVo>> findList(GwldbtListPo gwldbtListPo) {
        ResultPoJo<List<GwldbtListVo>> result = new ResultPoJo<>();
        result.setResult(gwldbtMapper.findList(gwldbtListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<GwldbtGetVo> get(GwldbtGetPo gwldbtGetPo) {
        ResultPoJo<GwldbtGetVo> result = new ResultPoJo<>();
        Gwldbt entity = gwldbtMapper.selectByPrimaryKey(gwldbtGetPo.getId());
        GwldbtGetVo vo = new GwldbtGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(GwldbtInsertPo gwldbtInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        Gwldbt gwldbt = new Gwldbt();
        ConverterUtil.copyProperties(gwldbtInsertPo, gwldbt);
        gwldbt.preInsert();
        gwldbtMapper.insert(gwldbt);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(GwldbtUpdatePo gwldbtUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        Gwldbt gwldbt = new Gwldbt();
        ConverterUtil.copyProperties(gwldbtUpdatePo, gwldbt);
        gwldbt.preUpdate();
        gwldbtMapper.updateByPrimaryKeySelective(gwldbt);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(GwldbtBatDeletePo gwldbtBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : gwldbtBatDeletePo.getDelList()) {
            Gwldbt gwldbt = new Gwldbt();
            gwldbt.setId(delId);
            gwldbt.preUpdate();
            gwldbtMapper.deleteLogic(gwldbt);
        }
        return result;
    }
}
