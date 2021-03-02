package com.wisea.cultivar.explorer.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.explorer.entity.ProceEntpVideo;
import com.wisea.cultivar.explorer.mapper.ProceEntpVideoMapper;
import com.wisea.cultivar.explorer.po.*;
import com.wisea.cultivar.explorer.vo.EntpInfoMageGetVo;
import com.wisea.cultivar.explorer.vo.ProceEntpVideoGetVo;
import com.wisea.cultivar.explorer.vo.ProceEntpVideoListVo;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ProceEntpVideoService
 * 加工企业视频 Service
 * 2020/08/27 13:47:43
 */
@Service
public class ProceEntpVideoService extends BaseService {
    @Autowired
    protected ProceEntpVideoMapper proceEntpVideoMapper;
    @Autowired
    protected EntpInfoMageService entpInfoMageService;
    /**
     * 查询分页列表
     */
    public ResultPoJo<HashMap<String,Object>> findPage(ProceEntpVideoPagePo proceEntpVideoPagePo) {
        ResultPoJo<HashMap<String,Object>> result = new ResultPoJo<>();
        Page<ProceEntpVideoListVo> page = proceEntpVideoPagePo.getPage();
        List<ProceEntpVideoListVo> list = proceEntpVideoMapper.findPage(proceEntpVideoPagePo);
        page.setList(list);
        HashMap<String,Object> maps = new HashMap<>(2);
        maps.put("page",page);
        EntpInfoMageGetPo infoMageGetPo = new EntpInfoMageGetPo();
        infoMageGetPo.setId(proceEntpVideoPagePo.getEntpInfoMageId());
        final ResultPoJo<EntpInfoMageGetVo> mageGetVoResultPoJo = entpInfoMageService.get(infoMageGetPo);
        final EntpInfoMageGetVo entpInfoMage = mageGetVoResultPoJo.getResult();
        maps.put("enterprise",entpInfoMage);
        result.setResult(maps);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<ProceEntpVideoListVo>> findList(ProceEntpVideoListPo proceEntpVideoListPo) {
        ResultPoJo<List<ProceEntpVideoListVo>> result = new ResultPoJo<>();
        result.setResult(proceEntpVideoMapper.findList(proceEntpVideoListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<ProceEntpVideoGetVo> get(ProceEntpVideoGetPo proceEntpVideoGetPo) {
        ResultPoJo<ProceEntpVideoGetVo> result = new ResultPoJo<>();
        ProceEntpVideo entity = proceEntpVideoMapper.selectByPrimaryKey(proceEntpVideoGetPo.getId());
        ProceEntpVideoGetVo vo = new ProceEntpVideoGetVo();
        ConverterUtil.copyProperties(entity, vo);
        vo.setVideoUrl(entity.getUrl());
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(ProceEntpVideoInsertPo proceEntpVideoInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        ProceEntpVideo proceEntpVideo = new ProceEntpVideo();
        ConverterUtil.copyProperties(proceEntpVideoInsertPo, proceEntpVideo);
        proceEntpVideo.preInsert();
        proceEntpVideo.setUrl(proceEntpVideoInsertPo.getVideoUrl());
        proceEntpVideoMapper.insert(proceEntpVideo);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(ProceEntpVideoUpdatePo proceEntpVideoUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        ProceEntpVideo proceEntpVideo = new ProceEntpVideo();
        ConverterUtil.copyProperties(proceEntpVideoUpdatePo, proceEntpVideo);
        proceEntpVideo.preUpdate();
        proceEntpVideo.setUrl(proceEntpVideoUpdatePo.getVideoUrl());
        proceEntpVideoMapper.updateByPrimaryKeySelective(proceEntpVideo);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(ProceEntpVideoBatDeletePo proceEntpVideoBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : proceEntpVideoBatDeletePo.getDelList()) {
            ProceEntpVideo proceEntpVideo = new ProceEntpVideo();
            proceEntpVideo.setId(delId);
            proceEntpVideo.preUpdate();
            proceEntpVideoMapper.deleteLogic(proceEntpVideo);
        }
        return result;
    }

    public List<String> findVideoList(Long entpInfoMageId) {
        return proceEntpVideoMapper.findVideoList(entpInfoMageId);
    }


}
