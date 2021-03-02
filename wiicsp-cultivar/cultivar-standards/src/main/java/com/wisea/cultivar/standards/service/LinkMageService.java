package com.wisea.cultivar.standards.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.constants.QdcyStandardsError;
import com.wisea.cultivar.standards.entity.LinkMage;
import com.wisea.cultivar.standards.mapper.LinkMageMapper;
import com.wisea.cultivar.standards.mapper.StandardRuleMageMapper;
import com.wisea.cultivar.standards.po.*;
import com.wisea.cultivar.standards.vo.LinkMageGetVo;
import com.wisea.cultivar.standards.vo.LinkMageListVo;
import java.util.List;
import java.util.stream.Collectors;

import com.wisea.cultivar.standards.vo.StandardRuleMageListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * LinkMageService
 * 环节管理 Service
 * 2020/07/24 11:21:45
 */
@Service
public class LinkMageService extends BaseService {
    @Autowired
    protected LinkMageMapper linkMageMapper;
    @Autowired
    protected StandardRuleMageMapper standardRuleMageMapper;
    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<LinkMageListVo>> findPage(LinkMagePagePo linkMagePagePo) {
        ResultPoJo<Page<LinkMageListVo>> result = new ResultPoJo<>();
        Page<LinkMageListVo> page = linkMagePagePo.getPage();
        List<LinkMageListVo> list = linkMageMapper.findPage(linkMagePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<LinkMageListVo>> findList(LinkMageListPo linkMageListPo) {
        ResultPoJo<List<LinkMageListVo>> result = new ResultPoJo<>();
        result.setResult(linkMageMapper.findList(linkMageListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<LinkMageGetVo> get(LinkMageGetPo linkMageGetPo) {
        ResultPoJo<LinkMageGetVo> result = new ResultPoJo<>();
        LinkMage entity = linkMageMapper.selectByPrimaryKey(linkMageGetPo.getId());
        LinkMageGetVo vo = new LinkMageGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(LinkMageInsertPo linkMageInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        LinkMage linkMage = new LinkMage();
        ConverterUtil.copyProperties(linkMageInsertPo, linkMage);
        linkMage.preInsert();
        linkMageMapper.insert(linkMage);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(LinkMageUpdatePo linkMageUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        LinkMage linkMage = new LinkMage();
        ConverterUtil.copyProperties(linkMageUpdatePo, linkMage);
        linkMage.preUpdate();
        linkMageMapper.updateByPrimaryKeySelective(linkMage);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(LinkMageBatDeletePo linkMageBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        List<Long> delList = linkMageBatDeletePo.getDelList();
        StandardRuleMageListPo standardRuleMageListPo=new StandardRuleMageListPo();
        List<StandardRuleMageListVo> list = standardRuleMageMapper.findList(standardRuleMageListPo);
        List<Long> collect = list.stream().map(o -> o.getLinkMageId()).collect(Collectors.toList());
       if ( collect.contains( linkMageBatDeletePo.getDelList().get(0))){
           result.setCode(QdcyStandardsError.ERR_80004);
           result.setMsg(QdcyStandardsError.MSG_80004);
           return result;
       }
        for(Long delId : linkMageBatDeletePo.getDelList()) {
            LinkMage linkMage = new LinkMage();
            linkMage.setId(delId);
            linkMage.preUpdate();
            linkMageMapper.deleteLogic(linkMage);
        }
        return result;
    }
}
