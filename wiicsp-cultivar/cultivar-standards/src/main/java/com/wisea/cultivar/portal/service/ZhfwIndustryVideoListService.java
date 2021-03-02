package com.wisea.cultivar.portal.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.portal.entity.ZhfwIndustryVideoList;
import com.wisea.cultivar.portal.mapper.ZhfwIndustryVideoListMapper;
import com.wisea.cultivar.portal.po.ZhfwIndustryVideoListBatDeletePo;
import com.wisea.cultivar.portal.po.ZhfwIndustryVideoListGetPo;
import com.wisea.cultivar.portal.po.ZhfwIndustryVideoListInsertPo;
import com.wisea.cultivar.portal.po.ZhfwIndustryVideoListListPo;
import com.wisea.cultivar.portal.po.ZhfwIndustryVideoListPagePo;
import com.wisea.cultivar.portal.po.ZhfwIndustryVideoListUpdatePo;
import com.wisea.cultivar.portal.vo.ZhfwIndustryVideoListGetVo;
import com.wisea.cultivar.portal.vo.ZhfwIndustryVideoListListVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ZhfwIndustryVideoListService
 * 种植服务产业视频列表 Service
 * 2020/08/24 20:28:13
 */
@Service
public class ZhfwIndustryVideoListService extends BaseService {
    @Autowired
    protected ZhfwIndustryVideoListMapper zhfwIndustryVideoListMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<ZhfwIndustryVideoListListVo>> findPage(ZhfwIndustryVideoListPagePo zhfwIndustryVideoListPagePo) {
        ResultPoJo<Page<ZhfwIndustryVideoListListVo>> result = new ResultPoJo<>();
        Page<ZhfwIndustryVideoListListVo> page = zhfwIndustryVideoListPagePo.getPage();
        List<ZhfwIndustryVideoListListVo> list = zhfwIndustryVideoListMapper.findPage(zhfwIndustryVideoListPagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<ZhfwIndustryVideoListListVo>> findList(ZhfwIndustryVideoListListPo zhfwIndustryVideoListListPo) {
        ResultPoJo<List<ZhfwIndustryVideoListListVo>> result = new ResultPoJo<>();
        result.setResult(zhfwIndustryVideoListMapper.findList(zhfwIndustryVideoListListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<ZhfwIndustryVideoListGetVo> get(ZhfwIndustryVideoListGetPo zhfwIndustryVideoListGetPo) {
        ResultPoJo<ZhfwIndustryVideoListGetVo> result = new ResultPoJo<>();
        ZhfwIndustryVideoList entity = zhfwIndustryVideoListMapper.selectByPrimaryKey(zhfwIndustryVideoListGetPo.getId());
        ZhfwIndustryVideoListGetVo vo = new ZhfwIndustryVideoListGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(ZhfwIndustryVideoListInsertPo zhfwIndustryVideoListInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        ZhfwIndustryVideoList zhfwIndustryVideoList = new ZhfwIndustryVideoList();
        ConverterUtil.copyProperties(zhfwIndustryVideoListInsertPo, zhfwIndustryVideoList);
        zhfwIndustryVideoList.preInsert();
        zhfwIndustryVideoListMapper.insert(zhfwIndustryVideoList);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(ZhfwIndustryVideoListUpdatePo zhfwIndustryVideoListUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        ZhfwIndustryVideoList zhfwIndustryVideoList = new ZhfwIndustryVideoList();
        ConverterUtil.copyProperties(zhfwIndustryVideoListUpdatePo, zhfwIndustryVideoList);
        zhfwIndustryVideoList.preUpdate();
        zhfwIndustryVideoListMapper.updateByPrimaryKeySelective(zhfwIndustryVideoList);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(ZhfwIndustryVideoListBatDeletePo zhfwIndustryVideoListBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : zhfwIndustryVideoListBatDeletePo.getDelList()) {
            ZhfwIndustryVideoList zhfwIndustryVideoList = new ZhfwIndustryVideoList();
            zhfwIndustryVideoList.setId(delId);
            zhfwIndustryVideoList.preUpdate();
            zhfwIndustryVideoListMapper.deleteLogic(zhfwIndustryVideoList);
        }
        return result;
    }
}
