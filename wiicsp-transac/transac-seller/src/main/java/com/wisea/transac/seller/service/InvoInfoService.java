package com.wisea.transac.seller.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.dao.InvoInfoMapper;
import com.wisea.transac.common.entity.InvoInfo;
import com.wisea.transac.common.po.InvoInfoPageListPo;
import com.wisea.transac.common.po.InvoInfoPo;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.InvoInfoInfoVo;
import com.wisea.transac.common.vo.InvoInfoPageListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className InvoInfoService
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Service
public class InvoInfoService extends BaseService {
	@Autowired
	private InvoInfoMapper invoInfoMapper;

	/**
	 * @author wbf-code-generator
	 * @date 2020/04/27 17:01:29
	 * @Description 分页查询InvoInfo
	 */
	public ResultPoJo<Page<InvoInfoPageListVo>> findPageList(InvoInfoPageListPo po) {
		LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
		ResultPoJo<Page<InvoInfoPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		Page<InvoInfoPageListVo> page = po.getPage();
		User user = SystemUtils.getUser();
		po.setMembId(MembUtils.getMembInfoByUserId(user.getId()).getMembId());
		List<InvoInfoPageListVo> list = invoInfoMapper.findPageList(po);
		page.setList(list);
		resultPoJo.setResult(page);
		return resultPoJo;
	}

	/**
	 * @author wbf-code-generator
	 * @date 2020/04/27 17:01:29
	 * @Description 逻辑删除InvoInfo
	 */
	@Transactional(readOnly = false)
	public ResultPoJo logicDel(LongIdPo po) {
		LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		InvoInfo entity = invoInfoMapper.selectByPrimaryKey(po.getId());
		if (ConverterUtil.isNotEmpty(entity)) {
			entity.setDelFlag(InvoInfo.DEL_FLAG_DELETE);
			entity.preUpdate();
			invoInfoMapper.updateByPrimaryKey(entity);
		} else {
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
	}

	/**
	 * @author wbf-code-generator
	 * @date 2020/04/27 17:01:29
	 * @Description 新增或修改InvoInfo
	 */
	@Transactional(readOnly = false)
	public ResultPoJo saveOrUpdate(InvoInfoPo po) {
		LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		if (ConverterUtil.isEmpty(po.getDefaultFlag())){
              po.setDefaultFlag(DictConstants.DEFAULT_FLAG_1);
		}
		if (ConverterUtil.isNotEmpty(po.getId())) {
			User user = SystemUtils.getUser();
			Long membId = MembUtils.getMembInfoByUserId(user.getId()).getMembId();

			//判断是否是默认是更改之前的默认发票
			if (po.getDefaultFlag().equals(DictConstants.DEFAULT_FLAG_0)){
				InvoInfoInfoVo invoInfoInfoVo= invoInfoMapper.selDefaultInvoByMembId(membId);
				if (ConverterUtil.isNotEmpty(invoInfoInfoVo)){
					if (!po.getId().equals(invoInfoInfoVo.getId())){
						if (ConverterUtil.isNotEmpty(invoInfoInfoVo)){
							InvoInfo invoInfo = new InvoInfo();
							BeanUtils.copyProperties(invoInfoInfoVo, invoInfo);
							invoInfo.preUpdate();
							invoInfo.setDefaultFlag(DictConstants.DEFAULT_FLAG_1);
							invoInfoMapper.updateByPrimaryKeySelective(invoInfo);
						}
					}
				}
			}

			//修改
			InvoInfo entity = invoInfoMapper.selectByPrimaryKey(po.getId());
			if (ConverterUtil.isNotEmpty(entity)) {
				BeanUtils.copyProperties(po, entity);
				entity.preUpdate();
				invoInfoMapper.updateByPrimaryKeySelective(entity);
				resultPoJo.setResult(entity.getId());
			} else {
				resultPoJo.setCode(ConstantError.ERR_004);
				resultPoJo.setMsg(ConstantError.MSG_004);
			}
		} else {
			User user = SystemUtils.getUser();
			Long membId = MembUtils.getMembInfoByUserId(user.getId()).getMembId();

			//判断是否是默认是更改之前的默认发票
			if (DictConstants.DEFAULT_FLAG_0.equals(po.getDefaultFlag())){
				InvoInfoInfoVo invoInfoInfoVo= invoInfoMapper.selDefaultInvoByMembId(membId);
				if (ConverterUtil.isNotEmpty(invoInfoInfoVo)){
					InvoInfo invoInfo = new InvoInfo();
					BeanUtils.copyProperties(invoInfoInfoVo, invoInfo);
					invoInfo.preUpdate();
					invoInfo.setDefaultFlag(DictConstants.DEFAULT_FLAG_1);
					invoInfoMapper.updateByPrimaryKeySelective(invoInfo);
				}
			}
			//新增
			InvoInfo entity = new InvoInfo();
			BeanUtils.copyProperties(po, entity);
			entity.preInsert();
			entity.setMembId(membId);
			if (ConverterUtil.isEmpty(po.getDefaultFlag())){
				entity.setDefaultFlag(DictConstants.DEFAULT_FLAG_1);
			}
			invoInfoMapper.insert(entity);
			resultPoJo.setResult(entity.getId());
		}
		return resultPoJo;
	}

	/**
	 * @author wbf-code-generator
	 * @date 2020/04/27 17:01:29
	 * @Description 查询详细信息InvoInfo
	 */
	public ResultPoJo<InvoInfoInfoVo> findInfo(LongIdPo po) {
		LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
		ResultPoJo<InvoInfoInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		InvoInfoInfoVo vo = invoInfoMapper.findInfo(po);
		if (ConverterUtil.isNotEmpty(vo)) {
			resultPoJo.setResult(vo);
		} else {
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
	}

	/**
	 * 设置默认发票
	 *
	 * @param po
	 * @return
	 */
	@Transactional(readOnly = false)
	public ResultPoJo setDefault(LongIdPo po) {
		LoggerUtil.infoWithContext("【setDefault】设置默认发票：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);

		//校验订单是否存在
		InvoInfoInfoVo vo = invoInfoMapper.findInfo(po);
		if (ConverterUtil.isEmpty(vo)) {
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
			return resultPoJo;
		}
		//更改之前的默认发票
		InvoInfoInfoVo invoInfoInfoVo= invoInfoMapper.selDefaultInvoByMembId(vo.getMembId());
		if (ConverterUtil.isNotEmpty(invoInfoInfoVo)){
			InvoInfo invoInfo = new InvoInfo();
			BeanUtils.copyProperties(invoInfoInfoVo, invoInfo);
			invoInfo.preUpdate();
			invoInfo.setDefaultFlag(DictConstants.DEFAULT_FLAG_1);
			invoInfoMapper.updateByPrimaryKeySelective(invoInfo);
		}

		//设置为默认发票
		InvoInfo invoInfo1 = new InvoInfo();
		invoInfo1.setDefaultFlag(DictConstants.DEFAULT_FLAG_0);
		invoInfo1.setId(po.getId());
		invoInfo1.preUpdate();
		invoInfoMapper.updateByPrimaryKeySelective(invoInfo1);
		return resultPoJo;
	}
}
