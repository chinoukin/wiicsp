package com.wisea.cultivar.bigdata.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.dao.bigdata.SubEntpMageMapper;
import com.wisea.cultivar.common.dao.bigdata.SubEntpVideoInfoMageMapper;
import com.wisea.cultivar.common.entity.bigdata.SubEntpMage;
import com.wisea.cultivar.common.entity.bigdata.SubEntpVideoInfoMage;
import com.wisea.cultivar.common.po.bigdata.SubEntpVideoInfoMageBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.SubEntpVideoInfoMageGetPo;
import com.wisea.cultivar.common.po.bigdata.SubEntpVideoInfoMageInsertPo;
import com.wisea.cultivar.common.po.bigdata.SubEntpVideoInfoMageListPo;
import com.wisea.cultivar.common.po.bigdata.SubEntpVideoInfoMagePagePo;
import com.wisea.cultivar.common.po.bigdata.SubEntpVideoInfoMageUpdatePo;
import com.wisea.cultivar.common.vo.bigdata.HTSubEntpVideoInfoMageListVo;
import com.wisea.cultivar.common.vo.bigdata.SubEntpVideoInfoMageGetVo;
import com.wisea.cultivar.common.vo.bigdata.SubEntpVideoInfoMageListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * SubEntpVideoInfoMageService
 * 分公司视频信息维护 Service
 * 2019/12/02 11:02:15
 */
@Service
public class SubEntpVideoInfoMageService extends BaseService {
    @Autowired
    protected SubEntpVideoInfoMageMapper subEntpVideoInfoMageMapper;
    @Autowired
	protected SubEntpMageMapper subEntpMageMapper;
    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<SubEntpVideoInfoMageListVo>> findPage(SubEntpVideoInfoMagePagePo subEntpVideoInfoMagePagePo) {
        ResultPoJo<Page<SubEntpVideoInfoMageListVo>> result = new ResultPoJo<>();
        Page<SubEntpVideoInfoMageListVo> page = subEntpVideoInfoMagePagePo.getPage();
        List<SubEntpVideoInfoMageListVo> list = subEntpVideoInfoMageMapper.findPage(subEntpVideoInfoMagePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     *
     * @param subEntpVideoInfoMageListPo
     * @return
     */
    public ResultPoJo<HTSubEntpVideoInfoMageListVo> findHTPage(
    		SubEntpVideoInfoMagePagePo subEntpVideoInfoMagePagePo) {

    	 ResultPoJo<HTSubEntpVideoInfoMageListVo> result = new ResultPoJo<>();
    	 HTSubEntpVideoInfoMageListVo  vo = new HTSubEntpVideoInfoMageListVo();
         Page<SubEntpVideoInfoMageListVo> page = subEntpVideoInfoMagePagePo.getPage();
         List<SubEntpVideoInfoMageListVo> list = subEntpVideoInfoMageMapper.findPage(subEntpVideoInfoMagePagePo);
         if(ConverterUtil.isNotEmpty(subEntpVideoInfoMagePagePo.getSubEntpId())) {
        	 SubEntpMage subEntpMage = subEntpMageMapper.selectByPrimaryKey(subEntpVideoInfoMagePagePo.getSubEntpId());
          	 if (subEntpMage != null) {
          		vo.setSubEntpName(subEntpMage.getSubEntpName());
      		 }
         }
         vo.setSubEntpVideoInfoMageListVo(list);
         page.setList(list);
         result.setResult(vo);
         return result;
	}

    /**
     * 查询列表
     */
    public ResultPoJo<List<SubEntpVideoInfoMageListVo>> findList(SubEntpVideoInfoMageListPo subEntpVideoInfoMageListPo) {
        ResultPoJo<List<SubEntpVideoInfoMageListVo>> result = new ResultPoJo<>();
        result.setResult(subEntpVideoInfoMageMapper.findList(subEntpVideoInfoMageListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<SubEntpVideoInfoMageGetVo> get(SubEntpVideoInfoMageGetPo subEntpVideoInfoMageGetPo) {
        ResultPoJo<SubEntpVideoInfoMageGetVo> result = new ResultPoJo<>();
        SubEntpVideoInfoMage entity = subEntpVideoInfoMageMapper.selectByPrimaryKey(subEntpVideoInfoMageGetPo.getId());
        SubEntpVideoInfoMageGetVo vo = new SubEntpVideoInfoMageGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(SubEntpVideoInfoMageInsertPo subEntpVideoInfoMageInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        SubEntpVideoInfoMage subEntpVideoInfoMage = new SubEntpVideoInfoMage();
        ConverterUtil.copyProperties(subEntpVideoInfoMageInsertPo, subEntpVideoInfoMage);
        subEntpVideoInfoMage.preInsert();
        subEntpVideoInfoMageMapper.insertSelective(subEntpVideoInfoMage);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(SubEntpVideoInfoMageUpdatePo subEntpVideoInfoMageUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        SubEntpVideoInfoMage subEntpVideoInfoMage = new SubEntpVideoInfoMage();
        ConverterUtil.copyProperties(subEntpVideoInfoMageUpdatePo, subEntpVideoInfoMage);
        subEntpVideoInfoMage.preUpdate();
        subEntpVideoInfoMageMapper.updateByPrimaryKeySelective(subEntpVideoInfoMage);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(SubEntpVideoInfoMageBatDeletePo subEntpVideoInfoMageBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : subEntpVideoInfoMageBatDeletePo.getDelList()) {
            SubEntpVideoInfoMage subEntpVideoInfoMage = new SubEntpVideoInfoMage();
            subEntpVideoInfoMage.setId(delId);
            subEntpVideoInfoMage.preUpdate();
            subEntpVideoInfoMageMapper.deleteLogic(subEntpVideoInfoMage);
        }
        return result;
    }

}
