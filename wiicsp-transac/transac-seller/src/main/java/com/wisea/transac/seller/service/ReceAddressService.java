package com.wisea.transac.seller.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;

import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;

import com.wisea.transac.common.dao.ReceAddressMapper;
import com.wisea.transac.common.entity.ReceAddress;
import com.wisea.transac.common.po.ReceAddressPageListPo;
import com.wisea.transac.common.po.ReceAddressPo;
import com.wisea.transac.common.vo.ReceAddressInfoVo;
import com.wisea.transac.common.vo.ReceAddressPageListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className ReceAddressService
 * @date 2020/12/02 13:57:00
 * @Description
 */
@Service
public class ReceAddressService extends BaseService {
    @Autowired
    private ReceAddressMapper mapper;

    /**
     * @author wbf-code-generator
     * @date 2020/12/02 13:57:00
     * @Description 分页查询ReceAddress
     */
    public ResultPoJo<List<ReceAddressPageListVo>> findPageList(ReceAddressPageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
		ResultPoJo<List<ReceAddressPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		List<ReceAddressPageListVo> list = mapper.findPageList(po);
		resultPoJo.setResult(list);
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/12/02 13:57:00
     * @Description 逻辑删除ReceAddress
     */
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		ReceAddress entity = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(entity)){
			entity.setDelFlag(ReceAddress.DEL_FLAG_DELETE);
			entity.preUpdate();
			mapper.updateByPrimaryKey(entity);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/12/02 13:57:00
     * @Description 新增或修改ReceAddress
     */
    public ResultPoJo saveOrUpdate(ReceAddressPo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		if(ConverterUtil.isNotEmpty(po.getId())){
			updateDefault(po);
			//修改
			ReceAddress entity = mapper.selectByPrimaryKey(po.getId());
			if(ConverterUtil.isNotEmpty(entity)){
				BeanUtils.copyProperties(po, entity);
				entity.preUpdate();
				mapper.updateByPrimaryKeySelective(entity);
			}else{
				resultPoJo.setCode(ConstantError.ERR_004);
				resultPoJo.setMsg(ConstantError.MSG_004);
			}
		}else{
			updateDefault(po);
			//新增
			ReceAddress entity = new ReceAddress();
			BeanUtils.copyProperties(po, entity);
			entity.preInsert();
			mapper.insert(entity);
		}
		return resultPoJo;
    }

	private void updateDefault(ReceAddressPo po) {
		//查看是否是默认地址 如果数据中有默认地址则修改原来的默认地址
		if (po.getDefaultFlag().equals("0")) {
			ReceAddress byDefault = mapper.findByDefault();
			if (ConverterUtil.isNotEmpty(byDefault)) {
				byDefault.setDefaultFlag("1");
				byDefault.preUpdate();
				mapper.updateByPrimaryKeySelective(byDefault);
			}
		}
	}

	/**
     * @author wbf-code-generator
     * @date 2020/12/02 13:57:00
     * @Description 查询详细信息ReceAddress
     */
    public ResultPoJo<ReceAddressInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
		ResultPoJo<ReceAddressInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		ReceAddressInfoVo vo = mapper.findInfo(po.getId());
		if(ConverterUtil.isNotEmpty(vo)){
			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }
}
