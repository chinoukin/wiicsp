package com.wisea.cultivar.origin.service;

import java.util.List;

import com.wisea.cultivar.origin.constants.ConstantCodeMsg;
import com.wisea.cultivar.origin.constants.DictConstants;
import com.wisea.cultivar.origin.dao.OrmDetectionMechMageMapper;
import com.wisea.cultivar.origin.vo.DetectionMechMageListVo;
import com.wisea.cultivar.origin.vo.DetectionMechMageListWebVo;
import com.wisea.cultivar.origin.entity.DetectionMechMage;
import com.wisea.cultivar.origin.po.CheckOrgNumPo;
import com.wisea.cultivar.origin.po.DetectionMechMageListPo;
import com.wisea.cultivar.origin.po.DetectionMechMageListWebPo;
import com.wisea.cultivar.origin.po.LongIdPo;
import com.wisea.cultivar.origin.po.SaveOrUpdDetectionMechMagePo;
import com.wisea.cultivar.origin.util.OffsetDateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;

/**
 *
 * @author wzx
 *
 *         检测机构app service
 */
@Service
public class DetectionMechMageService extends BaseService {

	@Autowired
	private OrmDetectionMechMageMapper mapper;

	/**
	 * 分页查询检测机构列表
	 * @param po
	 * @return
	 */
	public ResultPoJo<Page<DetectionMechMageListVo>> findDetectionMechList(DetectionMechMageListPo po) {
		ResultPoJo<Page<DetectionMechMageListVo>> result = new ResultPoJo<Page<DetectionMechMageListVo>>(ConstantCodeMsg.NOMAL);

		Page<DetectionMechMageListVo> page = po.getPage();
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		page.setList(mapper.findDetectionMechList(po));
		result.setResult(page);
		return result;
	}

	/**
	 * 分页查询检测机构列表web
	 * @param po
	 * @return
	 */
	public ResultPoJo<Page<DetectionMechMageListWebVo>> findDetectionMechListWeb(DetectionMechMageListWebPo po) {
		ResultPoJo<Page<DetectionMechMageListWebVo>> result = new ResultPoJo<Page<DetectionMechMageListWebVo>>(ConstantCodeMsg.NOMAL);

		Page<DetectionMechMageListWebVo> page = po.getPage();
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		po.setStaDate(OffsetDateTimeUtils.getDayMinTime(po.getStaDate()));
		po.setEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getEndDate()));
		page.setList(mapper.findDetectionMechListWeb(po));
		result.setResult(page);
		return result;
	}
   /**
    * 查询机构信息详情
    * @param po
    * @return
    */
	public ResultPoJo<DetectionMechMage> getFindDetectionMechByid(LongIdPo po) {
		ResultPoJo<DetectionMechMage> result = new ResultPoJo<>(ConstantError.NOMAL);
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		DetectionMechMage data = mapper.selectByPrimaryKey(po.getId());
		//校验数据是否存在
		if(ConverterUtil.isEmpty(data)) {
			result.setCode(ConstantError.ERR_004);
			result.setMsg(ConstantError.MSG_004);
			return result;
		}
		result.setResult(data);
		return result;
	}

	/**
	 * 删除检测机构
	 * @param po
	 * @return
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<?> delDetectionMech(LongIdPo po) {
		ResultPoJo<?> result = new ResultPoJo<>(ConstantError.NOMAL);
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		DetectionMechMage data  = mapper.selectByPrimaryKey(po.getId());
		//校验数据是否存在
		if(ConverterUtil.isEmpty(data)) {
			result.setCode(ConstantError.ERR_004);
			result.setMsg(ConstantError.MSG_004);
			return result;
		}
		data.preUpdate();
		data.setOperator(data.getUpdateBy());
		data.setOperatDate(data.getUpdateDate());
		data.setDelFlag(DictConstants.DEL_FLAG_1);
		mapper.updateByPrimaryKey(data);
		return result;
	}

	/**
	 * 检测机构保存/修改操作
	 * @param po
	 * @return
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<?> saveOrUpdDetectionMech(SaveOrUpdDetectionMechMagePo po) {
		ResultPoJo<?> result = new ResultPoJo<>(ConstantError.NOMAL);
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		//校验传参
		if(ConverterUtil.isEmpty(po)) {
			result.setCode(ConstantError.ERR_001);
			result.setMsg(ConstantError.MSG_001);
			return result;
		}
		DetectionMechMage detectionMechMage = new DetectionMechMage();
		//判断新增修改
		if(ConverterUtil.isEmpty(po.getId())) {
			//新增
			ConverterUtil.copyProperties(po, detectionMechMage);
			detectionMechMage.preInsert();
			detectionMechMage.setOperator(detectionMechMage.getUpdateBy());
			detectionMechMage.setOperatDate(detectionMechMage.getUpdateDate());
			mapper.insertSelective(detectionMechMage);
		}else {
			detectionMechMage = mapper.selectByPrimaryKey(po.getId());
			//校验数据是否存在
			if(ConverterUtil.isEmpty(detectionMechMage)) {
				result.setCode(ConstantError.ERR_004);
				result.setMsg(ConstantError.MSG_004);
				return result;
			}
			// 排他校验
		/*	if (!po.getUpdateDate().equals(detectionMechMage.getUpdateDate())) {
				result.setCode(ConstantError.ERR_009);
				result.setMsg(ConstantError.MSG_009);
				return result;
			}*/
			ConverterUtil.copyProperties(po, detectionMechMage);
			detectionMechMage.preUpdate();
			detectionMechMage.setOperator(detectionMechMage.getCreateBy());
			detectionMechMage.setOperatDate(detectionMechMage.getUpdateDate());
			mapper.updateByPrimaryKeySelective(detectionMechMage);
		}
		return result;
	}

	/**
	 * 校验机构编号
	 * @param po
	 * @return
	 */
	public ResultPoJo<?> checkOrgNum(CheckOrgNumPo po) {
		ResultPoJo<?> result = new ResultPoJo<>(ConstantError.NOMAL);
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		List<DetectionMechMage> detectionMechMage = mapper.checkOrgNum(po);
		if (ConverterUtil.isNotEmpty(detectionMechMage)) {
			result.setCode(ConstantCodeMsg.ERR_700);
			result.setMsg(ConstantCodeMsg.MSG_700);
		}
		return result;
	}

}
