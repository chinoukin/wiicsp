package com.wisea.cultivar.portal.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.portal.entity.ZhfwCultureVideoList;
import com.wisea.cultivar.portal.mapper.ZhfwCultureVideoListMapper;
import com.wisea.cultivar.portal.po.ZhfwCultureVideoListBatDeletePo;
import com.wisea.cultivar.portal.po.ZhfwCultureVideoListGetPo;
import com.wisea.cultivar.portal.po.ZhfwCultureVideoListInsertPo;
import com.wisea.cultivar.portal.po.ZhfwCultureVideoListListPo;
import com.wisea.cultivar.portal.po.ZhfwCultureVideoListPagePo;
import com.wisea.cultivar.portal.po.ZhfwCultureVideoListUpdatePo;
import com.wisea.cultivar.portal.vo.ZhfwCultureVideoListGetVo;
import com.wisea.cultivar.portal.vo.ZhfwCultureVideoListListVo;

import java.time.OffsetDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ZhfwCultureVideoListService
 * 种植服文化视频列表 Service
 * 2020/08/24 20:28:13
 */
@Service
public class ZhfwCultureVideoListService extends BaseService {
    @Autowired
    protected ZhfwCultureVideoListMapper zhfwCultureVideoListMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<ZhfwCultureVideoListListVo>> findPage(ZhfwCultureVideoListPagePo zhfwCultureVideoListPagePo) {
        ResultPoJo<Page<ZhfwCultureVideoListListVo>> result = new ResultPoJo<>();
        Page<ZhfwCultureVideoListListVo> page = zhfwCultureVideoListPagePo.getPage();
        List<ZhfwCultureVideoListListVo> list = zhfwCultureVideoListMapper.findPage(zhfwCultureVideoListPagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<ZhfwCultureVideoListListVo>> findList(ZhfwCultureVideoListListPo zhfwCultureVideoListListPo) {
        ResultPoJo<List<ZhfwCultureVideoListListVo>> result = new ResultPoJo<>();
        result.setResult(zhfwCultureVideoListMapper.findList(zhfwCultureVideoListListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<ZhfwCultureVideoListGetVo> get(ZhfwCultureVideoListGetPo zhfwCultureVideoListGetPo) {
        ResultPoJo<ZhfwCultureVideoListGetVo> result = new ResultPoJo<>();
        ZhfwCultureVideoList entity = zhfwCultureVideoListMapper.selectByPrimaryKey(zhfwCultureVideoListGetPo.getId());
        ZhfwCultureVideoListGetVo vo = new ZhfwCultureVideoListGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(ZhfwCultureVideoListInsertPo zhfwCultureVideoListInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        ZhfwCultureVideoList zhfwCultureVideoList = new ZhfwCultureVideoList();
        ConverterUtil.copyProperties(zhfwCultureVideoListInsertPo, zhfwCultureVideoList);
        zhfwCultureVideoList.preInsert();
        zhfwCultureVideoList.setPubDate(OffsetDateTime.now());
        zhfwCultureVideoListMapper.insert(zhfwCultureVideoList);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(ZhfwCultureVideoListUpdatePo zhfwCultureVideoListUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        ZhfwCultureVideoList zhfwCultureVideoList = new ZhfwCultureVideoList();
        ConverterUtil.copyProperties(zhfwCultureVideoListUpdatePo, zhfwCultureVideoList);
        zhfwCultureVideoList.preUpdate();
        zhfwCultureVideoListMapper.updateByPrimaryKeySelective(zhfwCultureVideoList);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(ZhfwCultureVideoListBatDeletePo zhfwCultureVideoListBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : zhfwCultureVideoListBatDeletePo.getDelList()) {
            ZhfwCultureVideoList zhfwCultureVideoList = new ZhfwCultureVideoList();
            zhfwCultureVideoList.setId(delId);
            zhfwCultureVideoList.preUpdate();
            zhfwCultureVideoListMapper.deleteLogic(zhfwCultureVideoList);
        }
        return result;
    }
}
