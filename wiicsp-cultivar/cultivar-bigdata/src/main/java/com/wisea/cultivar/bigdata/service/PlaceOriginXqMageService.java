package com.wisea.cultivar.bigdata.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.dao.bigdata.PlaceOriginXqMageMapper;
import com.wisea.cultivar.common.entity.bigdata.PlaceOriginXqMage;
import com.wisea.cultivar.common.po.bigdata.PlaceOriginXqMageBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.PlaceOriginXqMageGetPo;
import com.wisea.cultivar.common.po.bigdata.PlaceOriginXqMageInsertPo;
import com.wisea.cultivar.common.po.bigdata.PlaceOriginXqMageListPo;
import com.wisea.cultivar.common.po.bigdata.PlaceOriginXqMagePagePo;
import com.wisea.cultivar.common.po.bigdata.PlaceOriginXqMageUpdatePo;
import com.wisea.cultivar.common.vo.bigdata.PlaceOriginXqMageGetVo;
import com.wisea.cultivar.common.vo.bigdata.PlaceOriginXqMageListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * PlaceOriginXqMageService
 * 产地详情管理 Service
 * 2019/12/02 11:02:15
 */
@Service
public class PlaceOriginXqMageService extends BaseService {
    @Autowired
    protected PlaceOriginXqMageMapper placeOriginXqMageMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<PlaceOriginXqMageListVo>> findPage(PlaceOriginXqMagePagePo placeOriginXqMagePagePo) {
        ResultPoJo<Page<PlaceOriginXqMageListVo>> result = new ResultPoJo<>();
        Page<PlaceOriginXqMageListVo> page = placeOriginXqMagePagePo.getPage();
        List<PlaceOriginXqMageListVo> list = placeOriginXqMageMapper.findPage(placeOriginXqMagePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<PlaceOriginXqMageListVo>> findList(PlaceOriginXqMageListPo placeOriginXqMageListPo) {
        ResultPoJo<List<PlaceOriginXqMageListVo>> result = new ResultPoJo<>();
        result.setResult(placeOriginXqMageMapper.findList(placeOriginXqMageListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<PlaceOriginXqMageGetVo> get(PlaceOriginXqMageGetPo placeOriginXqMageGetPo) {
        ResultPoJo<PlaceOriginXqMageGetVo> result = new ResultPoJo<>();
        PlaceOriginXqMage entity = placeOriginXqMageMapper.selectByPrimaryKey(placeOriginXqMageGetPo.getId());
        PlaceOriginXqMageGetVo vo = new PlaceOriginXqMageGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(PlaceOriginXqMageInsertPo placeOriginXqMageInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        PlaceOriginXqMage placeOriginXqMage = new PlaceOriginXqMage();
        ConverterUtil.copyProperties(placeOriginXqMageInsertPo, placeOriginXqMage);
        placeOriginXqMage.preInsert();
        placeOriginXqMageMapper.insert(placeOriginXqMage);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(PlaceOriginXqMageUpdatePo placeOriginXqMageUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        PlaceOriginXqMage placeOriginXqMage = new PlaceOriginXqMage();
        ConverterUtil.copyProperties(placeOriginXqMageUpdatePo, placeOriginXqMage);
        placeOriginXqMage.preUpdate();
        placeOriginXqMageMapper.updateByPrimaryKeySelective(placeOriginXqMage);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(PlaceOriginXqMageBatDeletePo placeOriginXqMageBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : placeOriginXqMageBatDeletePo.getDelList()) {
            PlaceOriginXqMage placeOriginXqMage = new PlaceOriginXqMage();
            placeOriginXqMage.setId(delId);
            placeOriginXqMage.preUpdate();
            placeOriginXqMageMapper.deleteLogic(placeOriginXqMage);
        }
        return result;
    }
}
