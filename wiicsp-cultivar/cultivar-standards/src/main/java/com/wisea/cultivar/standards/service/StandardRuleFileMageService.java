package com.wisea.cultivar.standards.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.standards.entity.StandardRuleFileMage;
import com.wisea.cultivar.standards.mapper.StandardRuleFileMageMapper;
import com.wisea.cultivar.standards.po.StandardRuleFileMageBatDeletePo;
import com.wisea.cultivar.standards.po.StandardRuleFileMageGetPo;
import com.wisea.cultivar.standards.po.StandardRuleFileMageInsertPo;
import com.wisea.cultivar.standards.po.StandardRuleFileMageListPo;
import com.wisea.cultivar.standards.po.StandardRuleFileMagePagePo;
import com.wisea.cultivar.standards.po.StandardRuleFileMageUpdatePo;
import com.wisea.cultivar.standards.vo.StandardRuleFileMageGetVo;
import com.wisea.cultivar.standards.vo.StandardRuleFileMageListVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * StandardRuleFileMageService
 * 标准规范附件管理 Service
 * 2020/07/24 11:21:45
 */
@Service
public class StandardRuleFileMageService extends BaseService {
    @Autowired
    protected StandardRuleFileMageMapper standardRuleFileMageMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<StandardRuleFileMageListVo>> findPage(StandardRuleFileMagePagePo standardRuleFileMagePagePo) {
        ResultPoJo<Page<StandardRuleFileMageListVo>> result = new ResultPoJo<>();
        Page<StandardRuleFileMageListVo> page = standardRuleFileMagePagePo.getPage();
        List<StandardRuleFileMageListVo> list = standardRuleFileMageMapper.findPage(standardRuleFileMagePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<StandardRuleFileMageListVo>> findList(StandardRuleFileMageListPo standardRuleFileMageListPo) {
        ResultPoJo<List<StandardRuleFileMageListVo>> result = new ResultPoJo<>();
        result.setResult(standardRuleFileMageMapper.findList(standardRuleFileMageListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<StandardRuleFileMageGetVo> get(StandardRuleFileMageGetPo standardRuleFileMageGetPo) {
        ResultPoJo<StandardRuleFileMageGetVo> result = new ResultPoJo<>();
        StandardRuleFileMage entity = standardRuleFileMageMapper.selectByPrimaryKey(standardRuleFileMageGetPo.getId());
        StandardRuleFileMageGetVo vo = new StandardRuleFileMageGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(List<StandardRuleFileMageInsertPo> standardRuleFileMageInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for (StandardRuleFileMageInsertPo ruleFileMageInsertPo : standardRuleFileMageInsertPo) {
            StandardRuleFileMage standardRuleFileMage = new StandardRuleFileMage();
            ConverterUtil.copyProperties(ruleFileMageInsertPo, standardRuleFileMage);
            standardRuleFileMage.preInsert();
            standardRuleFileMageMapper.insert(standardRuleFileMage);
        }
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(List<StandardRuleFileMageUpdatePo> standardRuleFileMageUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for (StandardRuleFileMageUpdatePo ruleFileMageUpdatePo : standardRuleFileMageUpdatePo) {
            StandardRuleFileMage standardRuleFileMage = new StandardRuleFileMage();
            ConverterUtil.copyProperties(ruleFileMageUpdatePo, standardRuleFileMage);
            standardRuleFileMage.preUpdate();
            standardRuleFileMageMapper.updateByPrimaryKeySelective(standardRuleFileMage);
        }
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(StandardRuleFileMageBatDeletePo standardRuleFileMageBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : standardRuleFileMageBatDeletePo.getDelList()) {
            StandardRuleFileMage standardRuleFileMage = new StandardRuleFileMage();
            standardRuleFileMage.setId(delId);
            standardRuleFileMage.preUpdate();
            standardRuleFileMageMapper.deleteLogic(standardRuleFileMage);
        }
        return result;
    }

    public ResultPoJo<List<StandardRuleFileMageListVo>> getById(long id) {
        ResultPoJo<List<StandardRuleFileMageListVo>> result = new ResultPoJo<>();
        result.setResult(standardRuleFileMageMapper.getById(id));
        return result;
    }
}
