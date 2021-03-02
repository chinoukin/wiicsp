package com.wisea.cultivar.portal.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.portal.entity.ZhfwCultureZxList;
import com.wisea.cultivar.portal.mapper.ZhfwCultureZxListMapper;
import com.wisea.cultivar.portal.po.ZhfwCultureZxListBatDeletePo;
import com.wisea.cultivar.portal.po.ZhfwCultureZxListGetPo;
import com.wisea.cultivar.portal.po.ZhfwCultureZxListInsertPo;
import com.wisea.cultivar.portal.po.ZhfwCultureZxListListPo;
import com.wisea.cultivar.portal.po.ZhfwCultureZxListPagePo;
import com.wisea.cultivar.portal.po.ZhfwCultureZxListUpdatePo;
import com.wisea.cultivar.portal.vo.ZhfwCultureZxListGetVo;
import com.wisea.cultivar.portal.vo.ZhfwCultureZxListListVo;

import java.time.OffsetDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ZhfwCultureZxListService
 * 种植服文化资讯列表 Service
 * 2020/08/24 20:28:13
 */
@Service
public class ZhfwCultureZxListService extends BaseService {
    @Autowired
    protected ZhfwCultureZxListMapper zhfwCultureZxListMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<ZhfwCultureZxListListVo>> findPage(ZhfwCultureZxListPagePo zhfwCultureZxListPagePo) {
        ResultPoJo<Page<ZhfwCultureZxListListVo>> result = new ResultPoJo<>();
        Page<ZhfwCultureZxListListVo> page = zhfwCultureZxListPagePo.getPage();
        List<ZhfwCultureZxListListVo> list = zhfwCultureZxListMapper.findPage(zhfwCultureZxListPagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<ZhfwCultureZxListListVo>> findList(ZhfwCultureZxListListPo zhfwCultureZxListListPo) {
        ResultPoJo<List<ZhfwCultureZxListListVo>> result = new ResultPoJo<>();
        result.setResult(zhfwCultureZxListMapper.findList(zhfwCultureZxListListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<ZhfwCultureZxListGetVo> get(ZhfwCultureZxListGetPo zhfwCultureZxListGetPo) {
        ResultPoJo<ZhfwCultureZxListGetVo> result = new ResultPoJo<>();
        ZhfwCultureZxList entity = zhfwCultureZxListMapper.selectByPrimaryKey(zhfwCultureZxListGetPo.getId());
        ZhfwCultureZxListGetVo vo = new ZhfwCultureZxListGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(ZhfwCultureZxListInsertPo zhfwCultureZxListInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        ZhfwCultureZxList zhfwCultureZxList = new ZhfwCultureZxList();
        ConverterUtil.copyProperties(zhfwCultureZxListInsertPo, zhfwCultureZxList);
        zhfwCultureZxList.preInsert();
        zhfwCultureZxList.setPubDate(OffsetDateTime.now());
        zhfwCultureZxListMapper.insert(zhfwCultureZxList);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(ZhfwCultureZxListUpdatePo zhfwCultureZxListUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        ZhfwCultureZxList zhfwCultureZxList = new ZhfwCultureZxList();
        ConverterUtil.copyProperties(zhfwCultureZxListUpdatePo, zhfwCultureZxList);
        zhfwCultureZxList.preUpdate();
        zhfwCultureZxListMapper.updateByPrimaryKeySelective(zhfwCultureZxList);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(ZhfwCultureZxListBatDeletePo zhfwCultureZxListBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : zhfwCultureZxListBatDeletePo.getDelList()) {
            ZhfwCultureZxList zhfwCultureZxList = new ZhfwCultureZxList();
            zhfwCultureZxList.setId(delId);
            zhfwCultureZxList.preUpdate();
            zhfwCultureZxListMapper.deleteLogic(zhfwCultureZxList);
        }
        return result;
    }
}
