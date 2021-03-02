package com.wisea.cultivar.infomanage.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.po.*;
import com.wisea.cultivar.common.dao.SearchTagsMageMapper;
import com.wisea.cultivar.common.entity.SearchTagsMage;
import com.wisea.cultivar.common.vo.SearchTagsMageGetVo;
import com.wisea.cultivar.common.vo.SearchTagsMageListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * SearchTagsMageService
 * 搜索标签设置 Service
 * 2020/08/04 09:36:59
 */
@Service
public class SearchTagsMageService extends BaseService {
    @Autowired
    protected SearchTagsMageMapper searchTagsMageMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<SearchTagsMageListVo>> findPage(SearchTagsMagePagePo searchTagsMagePagePo) {
        ResultPoJo<Page<SearchTagsMageListVo>> result = new ResultPoJo<>();
        Page<SearchTagsMageListVo> page = searchTagsMagePagePo.getPage();
        List<SearchTagsMageListVo> list = searchTagsMageMapper.findPage(searchTagsMagePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<SearchTagsMageListVo>> findList(SearchTagsMageListPo searchTagsMageListPo) {
        ResultPoJo<List<SearchTagsMageListVo>> result = new ResultPoJo<>();
        result.setResult(searchTagsMageMapper.findList(searchTagsMageListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<SearchTagsMageGetVo> get(SearchTagsMageGetPo searchTagsMageGetPo) {
        ResultPoJo<SearchTagsMageGetVo> result = new ResultPoJo<>();
        SearchTagsMage entity = searchTagsMageMapper.selectByPrimaryKey(searchTagsMageGetPo.getId());
        SearchTagsMageGetVo vo = new SearchTagsMageGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(SearchTagsMageInsertPo searchTagsMageInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        SearchTagsMage searchTagsMage = new SearchTagsMage();
        ConverterUtil.copyProperties(searchTagsMageInsertPo, searchTagsMage);
        searchTagsMage.preInsert();
        searchTagsMageMapper.insert(searchTagsMage);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(SearchTagsMageUpdatePo searchTagsMageUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        SearchTagsMage searchTagsMage = new SearchTagsMage();
        ConverterUtil.copyProperties(searchTagsMageUpdatePo, searchTagsMage);
        searchTagsMage.preUpdate();
        searchTagsMageMapper.updateByPrimaryKeySelective(searchTagsMage);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object>
    batDelete(SearchTagsMageBatDeletePo searchTagsMageBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : searchTagsMageBatDeletePo.getDelList()) {
            SearchTagsMage searchTagsMage = new SearchTagsMage();
            searchTagsMage.setId(delId);
            searchTagsMage.preUpdate();
            searchTagsMageMapper.deleteLogic(searchTagsMage);
        }
        return result;
    }
}
