package com.wisea.cultivar.standards.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.standards.entity.StagePicture;
import com.wisea.cultivar.standards.mapper.StagePictureMapper;
import com.wisea.cultivar.standards.po.StagePictureBatDeletePo;
import com.wisea.cultivar.standards.po.StagePictureGetPo;
import com.wisea.cultivar.standards.po.StagePictureInsertPo;
import com.wisea.cultivar.standards.po.StagePictureListPo;
import com.wisea.cultivar.standards.po.StagePicturePagePo;
import com.wisea.cultivar.standards.po.StagePictureUpdatePo;
import com.wisea.cultivar.standards.vo.StagePictureGetVo;
import com.wisea.cultivar.standards.vo.StagePictureListVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * StagePictureService
 * 阶段参考图片 Service
 * 2020/07/24 11:21:45
 */
@Service
public class StagePictureService extends BaseService {
    @Autowired
    protected StagePictureMapper stagePictureMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<StagePictureListVo>> findPage(StagePicturePagePo stagePicturePagePo) {
        ResultPoJo<Page<StagePictureListVo>> result = new ResultPoJo<>();
        Page<StagePictureListVo> page = stagePicturePagePo.getPage();
        List<StagePictureListVo> list = stagePictureMapper.findPage(stagePicturePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<StagePictureListVo>> findList(StagePictureListPo stagePictureListPo) {
        ResultPoJo<List<StagePictureListVo>> result = new ResultPoJo<>();
        result.setResult(stagePictureMapper.findList(stagePictureListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<StagePictureGetVo> get(StagePictureGetPo stagePictureGetPo) {
        ResultPoJo<StagePictureGetVo> result = new ResultPoJo<>();
        StagePicture entity = stagePictureMapper.selectByPrimaryKey(stagePictureGetPo.getId());
        StagePictureGetVo vo = new StagePictureGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(StagePictureInsertPo stagePictureInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        StagePicture stagePicture = new StagePicture();
        ConverterUtil.copyProperties(stagePictureInsertPo, stagePicture);
        stagePicture.preInsert();
        stagePictureMapper.insert(stagePicture);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(StagePictureUpdatePo stagePictureUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        StagePicture stagePicture = new StagePicture();
        ConverterUtil.copyProperties(stagePictureUpdatePo, stagePicture);
        stagePicture.preUpdate();
        stagePictureMapper.updateByPrimaryKeySelective(stagePicture);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(StagePictureBatDeletePo stagePictureBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : stagePictureBatDeletePo.getDelList()) {
            StagePicture stagePicture = new StagePicture();
            stagePicture.setId(delId);
            stagePicture.preUpdate();
            stagePictureMapper.deleteLogic(stagePicture);
        }
        return result;
    }
}
