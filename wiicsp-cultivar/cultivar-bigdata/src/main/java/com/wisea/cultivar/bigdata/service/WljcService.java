package com.wisea.cultivar.bigdata.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.dao.bigdata.WljcMapper;
import com.wisea.cultivar.common.entity.bigdata.Wljc;
import com.wisea.cultivar.common.po.bigdata.WljcBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.WljcGetPo;
import com.wisea.cultivar.common.po.bigdata.WljcInsertPo;
import com.wisea.cultivar.common.po.bigdata.WljcListPo;
import com.wisea.cultivar.common.po.bigdata.WljcPagePo;
import com.wisea.cultivar.common.po.bigdata.WljcUpdatePo;
import com.wisea.cultivar.common.vo.bigdata.WljcGetVo;
import com.wisea.cultivar.common.vo.bigdata.WljcListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * WljcService
 * 物流监测 Service
 * 2019/12/02 11:02:15
 */
@Service
public class WljcService extends BaseService {
    @Autowired
    protected WljcMapper wljcMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<WljcListVo>> findPage(WljcPagePo wljcPagePo) {
        ResultPoJo<Page<WljcListVo>> result = new ResultPoJo<>();
        Page<WljcListVo> page = wljcPagePo.getPage();
        List<WljcListVo> list = wljcMapper.findPage(wljcPagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<WljcListVo>> findList(WljcListPo wljcListPo) {
        ResultPoJo<List<WljcListVo>> result = new ResultPoJo<>();
        result.setResult(wljcMapper.findList(wljcListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<WljcGetVo> get(WljcGetPo wljcGetPo) {
        ResultPoJo<WljcGetVo> result = new ResultPoJo<>();
        Wljc entity = wljcMapper.selectByPrimaryKey(wljcGetPo.getId());
        WljcGetVo vo = new WljcGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(WljcInsertPo wljcInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        Wljc wljc = new Wljc();
        ConverterUtil.copyProperties(wljcInsertPo, wljc);
        wljc.preInsert();
        wljcMapper.insert(wljc);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(WljcUpdatePo wljcUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        Wljc wljc = new Wljc();
        ConverterUtil.copyProperties(wljcUpdatePo, wljc);
        wljc.preUpdate();
        wljcMapper.updateByPrimaryKeySelective(wljc);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(WljcBatDeletePo wljcBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : wljcBatDeletePo.getDelList()) {
            Wljc wljc = new Wljc();
            wljc.setId(delId);
            wljc.preUpdate();
            wljcMapper.deleteLogic(wljc);
        }
        return result;
    }
}
