package com.wisea.cultivar.bigdata.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.dao.bigdata.JtgjdyfxMapper;
import com.wisea.cultivar.common.entity.bigdata.Jtgjdyfx;
import com.wisea.cultivar.common.po.bigdata.JtgjdyfxBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.JtgjdyfxGetPo;
import com.wisea.cultivar.common.po.bigdata.JtgjdyfxInsertPo;
import com.wisea.cultivar.common.po.bigdata.JtgjdyfxListPo;
import com.wisea.cultivar.common.po.bigdata.JtgjdyfxPagePo;
import com.wisea.cultivar.common.po.bigdata.JtgjdyfxUpdatePo;
import com.wisea.cultivar.common.vo.bigdata.JtgjdyfxGetVo;
import com.wisea.cultivar.common.vo.bigdata.JtgjdyfxListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * JtgjdyfxService
 * 交通工具调用分析 Service
 * 2019/12/02 11:02:14
 */
@Service
public class JtgjdyfxService extends BaseService {
    @Autowired
    protected JtgjdyfxMapper jtgjdyfxMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<JtgjdyfxListVo>> findPage(JtgjdyfxPagePo jtgjdyfxPagePo) {
        ResultPoJo<Page<JtgjdyfxListVo>> result = new ResultPoJo<>();
        Page<JtgjdyfxListVo> page = jtgjdyfxPagePo.getPage();
        List<JtgjdyfxListVo> list = jtgjdyfxMapper.findPage(jtgjdyfxPagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<JtgjdyfxListVo>> findList(JtgjdyfxListPo jtgjdyfxListPo) {
        ResultPoJo<List<JtgjdyfxListVo>> result = new ResultPoJo<>();
        result.setResult(jtgjdyfxMapper.findList(jtgjdyfxListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<JtgjdyfxGetVo> get(JtgjdyfxGetPo jtgjdyfxGetPo) {
        ResultPoJo<JtgjdyfxGetVo> result = new ResultPoJo<>();
        Jtgjdyfx entity = jtgjdyfxMapper.selectByPrimaryKey(jtgjdyfxGetPo.getId());
        JtgjdyfxGetVo vo = new JtgjdyfxGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(JtgjdyfxInsertPo jtgjdyfxInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        Jtgjdyfx jtgjdyfx = new Jtgjdyfx();
        ConverterUtil.copyProperties(jtgjdyfxInsertPo, jtgjdyfx);
        jtgjdyfx.preInsert();
        jtgjdyfxMapper.insert(jtgjdyfx);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(JtgjdyfxUpdatePo jtgjdyfxUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        Jtgjdyfx jtgjdyfx = new Jtgjdyfx();
        ConverterUtil.copyProperties(jtgjdyfxUpdatePo, jtgjdyfx);
        jtgjdyfx.preUpdate();
        jtgjdyfxMapper.updateByPrimaryKeySelective(jtgjdyfx);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(JtgjdyfxBatDeletePo jtgjdyfxBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : jtgjdyfxBatDeletePo.getDelList()) {
            Jtgjdyfx jtgjdyfx = new Jtgjdyfx();
            jtgjdyfx.setId(delId);
            jtgjdyfx.preUpdate();
            jtgjdyfxMapper.deleteLogic(jtgjdyfx);
        }
        return result;
    }
}
