package com.wisea.cultivar.infomanage.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.IdGen;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.infomanage.entity.KnowledgeBaseMage;
import com.wisea.cultivar.infomanage.entity.KnowledgeBasePicture;
import com.wisea.cultivar.infomanage.mapper.KnowledgeBaseMageMapper;
import com.wisea.cultivar.infomanage.po.*;
import com.wisea.cultivar.infomanage.vo.KnowledgeBaseMageGetVo;
import com.wisea.cultivar.infomanage.vo.KnowledgeBaseMageListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * KnowledgeBaseMageService
 * 知识库管理 Service
 * 2020/08/05 09:31:34
 */
@Service
public class KnowledgeBaseMageService extends BaseService {
    @Autowired
    protected KnowledgeBaseMageMapper knowledgeBaseMageMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<KnowledgeBaseMageListVo>> findPage(KnowledgeBaseMagePagePo knowledgeBaseMagePagePo) {
        ResultPoJo<Page<KnowledgeBaseMageListVo>> result = new ResultPoJo<>();
        Page<KnowledgeBaseMageListVo> page = knowledgeBaseMagePagePo.getPage();
        List<KnowledgeBaseMageListVo> list = knowledgeBaseMageMapper.findPage(knowledgeBaseMagePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<KnowledgeBaseMageListVo>> findList(KnowledgeBaseMageListPo knowledgeBaseMageListPo) {
        ResultPoJo<List<KnowledgeBaseMageListVo>> result = new ResultPoJo<>();
        result.setResult(knowledgeBaseMageMapper.findList(knowledgeBaseMageListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<KnowledgeBaseMageGetVo> get(KnowledgeBaseMageGetPo knowledgeBaseMageGetPo) {
        ResultPoJo<KnowledgeBaseMageGetVo> result = new ResultPoJo<>();
        KnowledgeBaseMage entity = knowledgeBaseMageMapper.selectByPrimaryKey(knowledgeBaseMageGetPo.getId());
        KnowledgeBaseMageGetVo vo = new KnowledgeBaseMageGetVo();
        ConverterUtil.copyProperties(entity, vo);
        if (entity.getId()!=null){
           List<KnowledgeBasePicture> imgList=knowledgeBaseMageMapper.queryImgList(entity.getId());
            vo.setKnowledgeBasePictures(imgList);
        }
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(KnowledgeBaseMageInsertPo knowledgeBaseMageInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        KnowledgeBaseMage knowledgeBaseMage = new KnowledgeBaseMage();
        ConverterUtil.copyProperties(knowledgeBaseMageInsertPo, knowledgeBaseMage);
        knowledgeBaseMage.setReleDate(OffsetDateTime.now());
        knowledgeBaseMage.preInsert();
        knowledgeBaseMageMapper.insert(knowledgeBaseMage);
        List<KnowledgeBasePicture> knowledgeBasePictures = knowledgeBaseMageInsertPo.getKnowledgeBasePictures();
        if (ConverterUtil.isNotEmpty(knowledgeBasePictures)){
            Long id = knowledgeBaseMage.getId();
            for (KnowledgeBasePicture knowledgeBasePicture : knowledgeBasePictures) {
                knowledgeBasePicture.setKnowledgeBaseMageId(id);
                knowledgeBasePicture.setCreateDate(OffsetDateTime.now());
                knowledgeBasePicture.setId(IdGen.randomLong());
                knowledgeBaseMageMapper.addImg(knowledgeBasePicture);
            }

        }
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(KnowledgeBaseMageUpdatePo knowledgeBaseMageUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        KnowledgeBaseMage knowledgeBaseMage = new KnowledgeBaseMage();
        ConverterUtil.copyProperties(knowledgeBaseMageUpdatePo, knowledgeBaseMage);
        knowledgeBaseMage.preUpdate();
        knowledgeBaseMageMapper.updateByPrimaryKeySelective(knowledgeBaseMage);

        Long id = knowledgeBaseMage.getId();
        KnowledgeBasePicture knowledgeBasePicture = new KnowledgeBasePicture();
        knowledgeBasePicture.setUpdateDate(OffsetDateTime.now());
        knowledgeBasePicture.setKnowledgeBaseMageId(id);
        knowledgeBaseMageMapper.deleteImg(knowledgeBasePicture);
        List<KnowledgeBasePicture> knowledgeBasePictures = knowledgeBaseMageUpdatePo.getKnowledgeBasePictures();
        if (ConverterUtil.isNotEmpty(knowledgeBasePictures)){
            for (KnowledgeBasePicture knowledge : knowledgeBasePictures) {
                knowledge.setKnowledgeBaseMageId(id);
                knowledge.setCreateDate(OffsetDateTime.now());
                knowledge.setId(IdGen.randomLong());
                knowledgeBaseMageMapper.addImg(knowledge);
            }

        }
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(KnowledgeBaseMageBatDeletePo knowledgeBaseMageBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : knowledgeBaseMageBatDeletePo.getDelList()) {
            KnowledgeBaseMage knowledgeBaseMage = new KnowledgeBaseMage();
            knowledgeBaseMage.setId(delId);
            knowledgeBaseMage.preUpdate();
            knowledgeBaseMageMapper.deleteLogic(knowledgeBaseMage);
            Long id = knowledgeBaseMage.getId();
            KnowledgeBasePicture knowledgeBasePicture = new KnowledgeBasePicture();
            knowledgeBasePicture.setUpdateDate(OffsetDateTime.now());
            knowledgeBasePicture.setKnowledgeBaseMageId(id);
            knowledgeBaseMageMapper.deleteImg(knowledgeBasePicture);
        }
        return result;
    }

    public ResultPoJo<Object> status(KnowledgeBaseMageStatus po) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        po.preUpdate();
        po.setUpdateDate(OffsetDateTime.now());
        knowledgeBaseMageMapper.status(po);
        return result;
    }
}
