package com.wisea.cultivar.explorer.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.explorer.entity.DemonsBaseIntroduce;
import com.wisea.cultivar.explorer.mapper.DemonsBaseIntroduceMapper;
import com.wisea.cultivar.explorer.po.DemonsBaseIntroduceBatDeletePo;
import com.wisea.cultivar.explorer.po.DemonsBaseIntroduceGetPo;
import com.wisea.cultivar.explorer.po.DemonsBaseIntroduceInsertPo;
import com.wisea.cultivar.explorer.po.DemonsBaseIntroduceListPo;
import com.wisea.cultivar.explorer.po.DemonsBaseIntroducePagePo;
import com.wisea.cultivar.explorer.po.DemonsBaseIntroduceUpdatePo;
import com.wisea.cultivar.explorer.vo.DemonsBaseIntroduceGetVo;
import com.wisea.cultivar.explorer.vo.DemonsBaseIntroduceListVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * DemonsBaseIntroduceService
 * 示范基地详细介绍 Service
 * 2020/08/11 13:21:46
 */
@Service
public class DemonsBaseIntroduceService extends BaseService {
    @Autowired
    protected DemonsBaseIntroduceMapper demonsBaseIntroduceMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<DemonsBaseIntroduceListVo>> findPage(DemonsBaseIntroducePagePo demonsBaseIntroducePagePo) {
        ResultPoJo<Page<DemonsBaseIntroduceListVo>> result = new ResultPoJo<>();
        Page<DemonsBaseIntroduceListVo> page = demonsBaseIntroducePagePo.getPage();
        List<DemonsBaseIntroduceListVo> list = demonsBaseIntroduceMapper.findPage(demonsBaseIntroducePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<DemonsBaseIntroduceListVo>> findList(DemonsBaseIntroduceListPo demonsBaseIntroduceListPo) {
        ResultPoJo<List<DemonsBaseIntroduceListVo>> result = new ResultPoJo<>();
        result.setResult(demonsBaseIntroduceMapper.findList(demonsBaseIntroduceListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<DemonsBaseIntroduceGetVo> get(DemonsBaseIntroduceGetPo demonsBaseIntroduceGetPo) {
        ResultPoJo<DemonsBaseIntroduceGetVo> result = new ResultPoJo<>();
        DemonsBaseIntroduce entity = demonsBaseIntroduceMapper.selectByPrimaryKey(demonsBaseIntroduceGetPo.getId());
        DemonsBaseIntroduceGetVo vo = new DemonsBaseIntroduceGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public ResultPoJo<Object> insert(DemonsBaseIntroduceInsertPo demonsBaseIntroduceInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        DemonsBaseIntroduce demonsBaseIntroduce = new DemonsBaseIntroduce();
        ConverterUtil.copyProperties(demonsBaseIntroduceInsertPo, demonsBaseIntroduce);
        demonsBaseIntroduce.preInsert();
        demonsBaseIntroduceMapper.insert(demonsBaseIntroduce);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(DemonsBaseIntroduceUpdatePo demonsBaseIntroduceUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        DemonsBaseIntroduce demonsBaseIntroduce = new DemonsBaseIntroduce();
        ConverterUtil.copyProperties(demonsBaseIntroduceUpdatePo, demonsBaseIntroduce);
        demonsBaseIntroduce.preUpdate();
        demonsBaseIntroduceMapper.updateByPrimaryKeySelective(demonsBaseIntroduce);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(DemonsBaseIntroduceBatDeletePo demonsBaseIntroduceBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : demonsBaseIntroduceBatDeletePo.getDelList()) {
            DemonsBaseIntroduce demonsBaseIntroduce = new DemonsBaseIntroduce();
            demonsBaseIntroduce.setId(delId);
            demonsBaseIntroduce.preUpdate();
            demonsBaseIntroduceMapper.deleteLogic(demonsBaseIntroduce);
        }
        return result;
    }

    /**
     * 通过示范基地主表ID删除详细信息介绍
     *
     * @param  demonsBaseId 示范基地主表ID
     */
    public void delIntroduce(Long demonsBaseId) {
        demonsBaseIntroduceMapper.delIntroduce(demonsBaseId);
    }

}
