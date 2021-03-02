package com.wisea.cultivar.bigdata.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.dao.bigdata.DeliveryInfoWhMapper;
import com.wisea.cultivar.common.entity.bigdata.DeliveryInfoWh;
import com.wisea.cultivar.common.po.bigdata.DeliveryInfoWhBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.DeliveryInfoWhGetPo;
import com.wisea.cultivar.common.po.bigdata.DeliveryInfoWhInsertPo;
import com.wisea.cultivar.common.po.bigdata.DeliveryInfoWhListPo;
import com.wisea.cultivar.common.po.bigdata.DeliveryInfoWhPagePo;
import com.wisea.cultivar.common.po.bigdata.DeliveryInfoWhUpdatePo;
import com.wisea.cultivar.common.vo.bigdata.DeliveryInfoWhGetVo;
import com.wisea.cultivar.common.vo.bigdata.DeliveryInfoWhListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * DeliveryInfoWhService
 * 配送信息维护 Service
 * 2019/12/02 11:02:14
 */
@Service
public class DeliveryInfoWhService extends BaseService {
    @Autowired
    protected DeliveryInfoWhMapper deliveryInfoWhMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<DeliveryInfoWhListVo>> findPage(DeliveryInfoWhPagePo deliveryInfoWhPagePo) {
        ResultPoJo<Page<DeliveryInfoWhListVo>> result = new ResultPoJo<>();
        Page<DeliveryInfoWhListVo> page = deliveryInfoWhPagePo.getPage();
        List<DeliveryInfoWhListVo> list = deliveryInfoWhMapper.findPage(deliveryInfoWhPagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<DeliveryInfoWhListVo>> findList(DeliveryInfoWhListPo deliveryInfoWhListPo) {
        ResultPoJo<List<DeliveryInfoWhListVo>> result = new ResultPoJo<>();
        result.setResult(deliveryInfoWhMapper.findList(deliveryInfoWhListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<DeliveryInfoWhGetVo> get(DeliveryInfoWhGetPo deliveryInfoWhGetPo) {
        ResultPoJo<DeliveryInfoWhGetVo> result = new ResultPoJo<>();
        DeliveryInfoWh entity = deliveryInfoWhMapper.selectByPrimaryKey(deliveryInfoWhGetPo.getId());
        DeliveryInfoWhGetVo vo = new DeliveryInfoWhGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 查询根据分公司id
     */
    public ResultPoJo<DeliveryInfoWhGetVo> getByid(DeliveryInfoWhGetPo deliveryInfoWhGetPo) {
    	ResultPoJo<DeliveryInfoWhGetVo> result = new ResultPoJo<>();
    	DeliveryInfoWh entity = deliveryInfoWhMapper.selectByPrimaryKeyByid(deliveryInfoWhGetPo.getId());
    	DeliveryInfoWhGetVo vo = new DeliveryInfoWhGetVo();
    	ConverterUtil.copyProperties(entity, vo);
    	result.setResult(vo);
    	return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(DeliveryInfoWhInsertPo deliveryInfoWhInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        DeliveryInfoWh deliveryInfoWh = new DeliveryInfoWh();
        ConverterUtil.copyProperties(deliveryInfoWhInsertPo, deliveryInfoWh);
        deliveryInfoWh.preInsert();
        deliveryInfoWhMapper.insertSelective(deliveryInfoWh);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(DeliveryInfoWhUpdatePo deliveryInfoWhUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        DeliveryInfoWh deliveryInfoWh = new DeliveryInfoWh();
        if(ConverterUtil.isEmpty(deliveryInfoWhUpdatePo.getId())) {
			   ConverterUtil.copyProperties(deliveryInfoWhUpdatePo, deliveryInfoWh);
		       deliveryInfoWh.preInsert();
		       deliveryInfoWh.setDelFlag("0");
		       deliveryInfoWhMapper.insertSelective(deliveryInfoWh);

        }else {
	        	ConverterUtil.copyProperties(deliveryInfoWhUpdatePo, deliveryInfoWh);
	            deliveryInfoWh.preUpdate();
	            deliveryInfoWhMapper.updateByPrimaryKeySelective(deliveryInfoWh);
        }

        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(DeliveryInfoWhBatDeletePo deliveryInfoWhBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : deliveryInfoWhBatDeletePo.getDelList()) {
            DeliveryInfoWh deliveryInfoWh = new DeliveryInfoWh();
            deliveryInfoWh.setId(delId);
            deliveryInfoWh.preUpdate();
            deliveryInfoWhMapper.deleteLogic(deliveryInfoWh);
        }
        return result;
    }

}
