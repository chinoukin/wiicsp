package com.wisea.cultivar.plant.service.oritrapla;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cultivar.plant.constants.ConstantCodeMsg;
import com.wisea.cultivar.plant.entity.oritrapla.PlatfInfoMage;
import com.wisea.cultivar.plant.mapper.oritrapla.PlatfInfoMageMapper;
import com.wisea.cultivar.plant.po.oritrapla.WebPlatfInfoMageAddPo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * web平台信息管理Service
 *
 * @author wzx
 *
 */
@Service
public class PlatfInfoMageService {

	@Autowired
	private PlatfInfoMageMapper mapper;

	/**
	 * 关于我们信息的保存 关于我们or注册协议
	 *
	 * @param po
	 * @return
	 */
	public ResultPoJo<?> addPlatfInfo(WebPlatfInfoMageAddPo po) {
		ResultPoJo<?> result = new ResultPoJo<>(ConstantError.NOMAL);
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		// 查询平台信息管理数据
		PlatfInfoMage dataInfo = mapper.findPlatfInfo();
		// 判断是否为空 (因为表数据只能有一条)
		if (dataInfo != null) {
			PlatfInfoMage data = new PlatfInfoMage();
			BeanUtils.copyProperties(po, data);
			mapper.updateByPrimaryKeySelective(data);
		} else {
			PlatfInfoMage data = new PlatfInfoMage();
			BeanUtils.copyProperties(po, data);
			mapper.insertSelective(data);
		}
		return result;
	}

	/**
	 * 查询其它信息配置详情
	 *
	 * @param
	 * @return
	 */
	public ResultPoJo<PlatfInfoMage> findPlatfInfo() {
		ResultPoJo<PlatfInfoMage> result = new ResultPoJo<>(ConstantError.NOMAL);
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		PlatfInfoMage platfInfoMages = mapper.findPlatfInfo();
		result.setResult(platfInfoMages);
		return result;
	}

}
