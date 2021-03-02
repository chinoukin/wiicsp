package com.wisea.cultivar.bigdata.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.dao.bigdata.SubEntpMageMapper;
import com.wisea.cultivar.common.dao.bigdata.SubEntpMbInfoMageMapper;
import com.wisea.cultivar.common.entity.bigdata.SubEntpMage;
import com.wisea.cultivar.common.entity.bigdata.SubEntpMbInfoMage;
import com.wisea.cultivar.common.po.bigdata.SubEntpMbInfoMageBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.SubEntpMbInfoMageGetPo;
import com.wisea.cultivar.common.po.bigdata.SubEntpMbInfoMageInsertPo;
import com.wisea.cultivar.common.po.bigdata.SubEntpMbInfoMageListPo;
import com.wisea.cultivar.common.po.bigdata.SubEntpMbInfoMagePagePo;
import com.wisea.cultivar.common.po.bigdata.SubEntpMbInfoMageUpdatePo;
import com.wisea.cultivar.common.vo.bigdata.SubEntpMbInfoMageGetVo;
import com.wisea.cultivar.common.vo.bigdata.SubEntpMbInfoMageListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * SubEntpMbInfoMageService
 * 分公司目标信息维护 Service
 * 2019/12/02 11:02:15
 */
@Service
public class SubEntpMbInfoMageService extends BaseService {
    @Autowired
    protected SubEntpMbInfoMageMapper subEntpMbInfoMageMapper;
    @Autowired
	protected SubEntpMageMapper subEntpMageMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<SubEntpMbInfoMageListVo>> findPage(SubEntpMbInfoMagePagePo subEntpMbInfoMagePagePo) {
        ResultPoJo<Page<SubEntpMbInfoMageListVo>> result = new ResultPoJo<>();
        Page<SubEntpMbInfoMageListVo> page = subEntpMbInfoMagePagePo.getPage();
        List<SubEntpMbInfoMageListVo> list = subEntpMbInfoMageMapper.findPage(subEntpMbInfoMagePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<SubEntpMbInfoMageListVo>> findList(SubEntpMbInfoMageListPo subEntpMbInfoMageListPo) {
        ResultPoJo<List<SubEntpMbInfoMageListVo>> result = new ResultPoJo<>();
        result.setResult(subEntpMbInfoMageMapper.findList(subEntpMbInfoMageListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<SubEntpMbInfoMageGetVo> get(SubEntpMbInfoMageGetPo subEntpMbInfoMageGetPo) {
        ResultPoJo<SubEntpMbInfoMageGetVo> result = new ResultPoJo<>();
        SubEntpMbInfoMage entity = subEntpMbInfoMageMapper.selectByPrimaryKey(subEntpMbInfoMageGetPo.getId());
        SubEntpMbInfoMageGetVo vo = new SubEntpMbInfoMageGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 查询根据分公司id
     */
    public ResultPoJo<SubEntpMbInfoMageGetVo> getById(SubEntpMbInfoMageGetPo subEntpMbInfoMageGetPo) {
    	ResultPoJo<SubEntpMbInfoMageGetVo> result = new ResultPoJo<>();
    	SubEntpMbInfoMage entity = subEntpMbInfoMageMapper.selectByPrimaryKeyById(subEntpMbInfoMageGetPo);
    	SubEntpMbInfoMageGetVo vo = new SubEntpMbInfoMageGetVo();
    	ConverterUtil.copyProperties(entity, vo);
    	SubEntpMage subEntpMage	= subEntpMageMapper.selectByPrimaryKey(subEntpMbInfoMageGetPo.getId());
    	if (subEntpMage != null) {
    		vo.setSubEntpName(subEntpMage.getSubEntpName());
		}
    	result.setResult(vo);
    	return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(SubEntpMbInfoMageInsertPo subEntpMbInfoMageInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        SubEntpMbInfoMage subEntpMbInfoMage = new SubEntpMbInfoMage();
        ConverterUtil.copyProperties(subEntpMbInfoMageInsertPo, subEntpMbInfoMage);
        subEntpMbInfoMage.preInsert();
        subEntpMbInfoMageMapper.insertSelective(subEntpMbInfoMage);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(SubEntpMbInfoMageUpdatePo subEntpMbInfoMageUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        SubEntpMbInfoMage subEntpMbInfoMage = new SubEntpMbInfoMage();
        ConverterUtil.copyProperties(subEntpMbInfoMageUpdatePo, subEntpMbInfoMage);
        subEntpMbInfoMage.preUpdate();
        subEntpMbInfoMageMapper.updateByPrimaryKeySelective(subEntpMbInfoMage);
        return result;
    }

    /**
     * 添加修改
     * @param subEntpMbInfoMageUpdatePo
     * @return
     */
    public ResultPoJo<Object> saveOrupd(SubEntpMbInfoMageUpdatePo subEntpMbInfoMageUpdatePo) {
    	  ResultPoJo<Object> result = new ResultPoJo<>();
          SubEntpMbInfoMage subEntpMbInfoMage = new SubEntpMbInfoMage();
          if(ConverterUtil.isEmpty(subEntpMbInfoMageUpdatePo.getId())) {
        	  ConverterUtil.copyProperties(subEntpMbInfoMageUpdatePo, subEntpMbInfoMage);
              subEntpMbInfoMage.preInsert();
              subEntpMbInfoMageMapper.insert(subEntpMbInfoMage);
          }else {
        	  ConverterUtil.copyProperties(subEntpMbInfoMageUpdatePo, subEntpMbInfoMage);
              subEntpMbInfoMage.preUpdate();
              subEntpMbInfoMageMapper.updateByPrimaryKeySelective(subEntpMbInfoMage);
          }

          return result;
	}

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(SubEntpMbInfoMageBatDeletePo subEntpMbInfoMageBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : subEntpMbInfoMageBatDeletePo.getDelList()) {
            SubEntpMbInfoMage subEntpMbInfoMage = new SubEntpMbInfoMage();
            subEntpMbInfoMage.setId(delId);
            subEntpMbInfoMage.preUpdate();
            subEntpMbInfoMageMapper.deleteLogic(subEntpMbInfoMage);
        }
        return result;
    }

}
