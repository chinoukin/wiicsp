package com.wisea.cultivar.plant.service.oritrapla;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cultivar.plant.constants.ConstantCodeMsg;
import com.wisea.cultivar.plant.constants.DictConstants;
import com.wisea.cultivar.plant.entity.oritrapla.ArchBasicInfo;
import com.wisea.cultivar.plant.entity.oritrapla.YjMage;
import com.wisea.cultivar.plant.mapper.oritrapla.ArchBasicInfoMapper;
import com.wisea.cultivar.plant.mapper.oritrapla.YjMageMapper;
import com.wisea.cultivar.plant.po.oritrapla.LongIdPo;
import com.wisea.cultivar.plant.vo.oritrapla.YjMageGetVo;
import com.wisea.cultivar.plant.po.oritrapla.YjMageUpdatePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 预警设置Service
 *
 * @author wangh(wisea)
 *
 * @date 2019年8月23日
 * @version 1.0
 */
@Service
public class YjMageService  extends BaseService {

	@Autowired
	private YjMageMapper yjMageMapper;
	@Autowired
	private ArchBasicInfoMapper archBasicInfoMapper;
	/**
	 * 预警设置的更新操作
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年8月23日
	 * @version 1.0
	 */
	@Transactional(readOnly=false)
	public ResultPoJo<String> updYjMage(YjMageUpdatePo po){
		// 返回值初期化
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 通过档案Id查询当前用户是否存在记录
		YjMage yjMageOld = yjMageMapper.selectByPrimaryKey(po.getId());
		if(yjMageOld == null){
			result.setCode(ConstantCodeMsg.ERR_999);
			result.setMsg(ConstantCodeMsg.MSG_999);
			return result;
		}
		YjMage yjMage = new YjMage();
		ConverterUtil.copyProperties(po, yjMage);
		yjMageMapper.updateByPrimaryKeySelective(yjMage);
		return result;
	}
	/**
	 * 通过档案Id获取预警设置信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年8月23日
	 * @version 1.0
	 */
	public ResultPoJo<YjMageGetVo> getInfo(LongIdPo po){
		// 返回值初期化处理
		ResultPoJo<YjMageGetVo> result = new ResultPoJo<YjMageGetVo>(ConstantError.NOMAL);
		// 查询档案Id是否存在
		// 根据档案Id查看档案是否存在
		ArchBasicInfo archBasicInfo = archBasicInfoMapper.selectByPrimaryKey(po.getId());
		if(archBasicInfo == null){
			result.setCode(ConstantCodeMsg.ERR_117);
			result.setMsg(ConstantCodeMsg.MSG_117);
			return result;
		}
		YjMageGetVo vo = new YjMageGetVo();
		// 通过档案Id查询当前用户是否存在记录
		YjMage yjMageOld = yjMageMapper.getInfoByArchId(po.getId());
		if(yjMageOld != null){
			vo.setId(yjMageOld.getId());
			vo.setMassgePushFlag(yjMageOld.getMassgePushFlag());
			vo.setYjTel(yjMageOld.getYjTel());
			vo.setMassgeSysPushFlag(yjMageOld.getMassgeSysPushFlag());
		}else{//保存
			YjMage yjMage = new YjMage();
			yjMage.preInsert();
			yjMage.setArchId(po.getId());
			yjMage.setMassgePushFlag(DictConstants.MASSGE_PUSH_FLAG_1);
			yjMage.setMassgeSysPushFlag(DictConstants.MASSGE_SYS_PUSH_FLAG_1);
			yjMageMapper.insertSelective(yjMage);
			vo.setId(yjMage.getId());
			vo.setMassgePushFlag(DictConstants.MASSGE_PUSH_FLAG_1);
			vo.setMassgeSysPushFlag(DictConstants.MASSGE_SYS_PUSH_FLAG_1);
		}
		result.setResult(vo);
		return result;
	}
}
