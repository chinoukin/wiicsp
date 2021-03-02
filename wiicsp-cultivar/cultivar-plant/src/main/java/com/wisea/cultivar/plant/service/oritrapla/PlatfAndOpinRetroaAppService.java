package com.wisea.cultivar.plant.service.oritrapla;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cultivar.plant.constants.ConstantCodeMsg;
import com.wisea.cultivar.plant.constants.DictConstants;
import com.wisea.cultivar.plant.entity.oritrapla.OpinRetroaMage;
import com.wisea.cultivar.plant.entity.oritrapla.PlatfInfoMage;
import com.wisea.cultivar.plant.mapper.oritrapla.OpinRetroaMageMapper;
import com.wisea.cultivar.plant.mapper.oritrapla.PlatfInfoMageMapper;
import com.wisea.cultivar.plant.po.oritrapla.OpinRetroaMageAddPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 意见反馈和关于我们Service
 *
 * @author wzx
 *
 */
@Service
public class PlatfAndOpinRetroaAppService {

	@Autowired
	private OpinRetroaMageMapper opinRetroaMageMapper;

	@Autowired
	private PlatfInfoMageMapper platfInfoMageMapper;

	/**
	 * 查询关于我们
	 *
	 * @return
	 */
	public ResultPoJo<PlatfInfoMage> findPlatfInfo() {
		ResultPoJo<PlatfInfoMage> result = new ResultPoJo<>(ConstantError.NOMAL);
		PlatfInfoMage platfInfoMages = platfInfoMageMapper.findPlatfInfo();
		result.setResult(platfInfoMages);
		return result;
	}

	/**
	 * 意见反馈(未用)
	 *
	 * @param po
	 * @return
	 */
	public ResultPoJo<?> addPlatfInfo(OpinRetroaMageAddPo po) {
		ResultPoJo<?> result = new ResultPoJo<>(ConstantError.NOMAL);
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		OpinRetroaMage opinRetroa = new OpinRetroaMage();
		opinRetroa.preInsert();
		opinRetroa.setMembId(user.getId());//会员id
		opinRetroa.setHandleStatus(DictConstants.HANDLE_STATUS_1);//未处理
		opinRetroa.setRetroaCont(po.getRetroaCont());// 反馈内容
		opinRetroaMageMapper.insertSelective(opinRetroa);
		return result;
	}

}
