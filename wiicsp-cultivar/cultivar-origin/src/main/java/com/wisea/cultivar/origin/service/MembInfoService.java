package com.wisea.cultivar.origin.service;

import java.util.List;

import com.wisea.cultivar.origin.po.LongIdPo;
import com.wisea.cultivar.origin.po.MembListPo;
import com.wisea.cultivar.origin.vo.MembListVo;
import com.wisea.cultivar.origin.constants.ConstantCodeMsg;
import com.wisea.cultivar.origin.dao.OrmMembInfoMapper;
import com.wisea.cultivar.origin.entity.MembInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.utils.tp.SystemAreaUtils;

/**
 *
 * @author wzx
 *
 *         采样企业app service
 */
@Service
public class MembInfoService extends BaseService {

	@Autowired
	private OrmMembInfoMapper mapper;


	/**
	 * 分页查询采样企业列表
	 * @param po
	 * @return
	 */
	public ResultPoJo<Page<MembListVo>> findMembInfoList(MembListPo po) {
		ResultPoJo<Page<MembListVo>> result = new ResultPoJo<Page<MembListVo>>(ConstantCodeMsg.NOMAL);

		Page<MembListVo> page = po.getPage();
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		List<MembListVo> data = mapper.findMembInfoList(po);
		for (MembListVo vo : data) {
			if(ConverterUtil.isNotEmpty(vo)) {
				StringBuffer adr = new StringBuffer();
				adr.append(SystemAreaUtils.getNameByCode(vo.getRegistAddressProv()));
				adr.append(SystemAreaUtils.getNameByCode(vo.getRegistAddressCity()));
				adr.append(SystemAreaUtils.getNameByCode(vo.getRegistAddressCou()));
				vo.setAddress(adr.toString());
			}
		}
		page.setList(data);
		result.setResult(page);
		return result;
	}
	/**
	 * 会员信息
	 * @param po
	 * @return
	 */
	public ResultPoJo<MembInfo> findMembInfo(LongIdPo po) {
		ResultPoJo<MembInfo> result = new ResultPoJo<>(ConstantError.NOMAL);
		// 当前登录的用户信息
	  	User user = SystemUtils.getUser();
		if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		result.setResult(mapper.selectByPrimaryKey(po.getId()));
		return result;
	}

}
