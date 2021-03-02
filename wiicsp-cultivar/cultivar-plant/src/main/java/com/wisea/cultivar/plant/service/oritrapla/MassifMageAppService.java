package com.wisea.cultivar.plant.service.oritrapla;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.plant.constants.ConstantCodeMsg;
import com.wisea.cultivar.plant.constants.DictConstants;
import com.wisea.cultivar.plant.entity.oritrapla.ArchBasicInfo;
import com.wisea.cultivar.plant.entity.oritrapla.MassifMage;
import com.wisea.cultivar.plant.mapper.ZhfwMembInfoMapper;
import com.wisea.cultivar.plant.mapper.oritrapla.ArchBasicInfoMapper;
import com.wisea.cultivar.plant.mapper.oritrapla.MassifMageMapper;
import com.wisea.cultivar.plant.po.oritrapla.MassifMageInfoAddPo;
import com.wisea.cultivar.plant.po.oritrapla.MassifMageInfoListPo;
import com.wisea.cultivar.plant.po.oritrapla.MassifMageInfoPo;
import com.wisea.cultivar.plant.vo.oritrapla.MassifMageInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author wzx
 *
 *         地块管理app service
 */
@Service
public class MassifMageAppService extends BaseService {

	@Autowired
	private MassifMageMapper mapper;
	@Autowired
	private ArchBasicInfoMapper archBasicInfoMapper;
	@Autowired
	private ZhfwMembInfoMapper membInfoMapper;

	/**
	 * 分页查询地块管理列表
	 *
	 * @param po
	 * @return
	 */
	public ResultPoJo<Page<MassifMageInfoVo>> findMassifPageList(MassifMageInfoListPo po) {
		ResultPoJo<Page<MassifMageInfoVo>> result = new ResultPoJo<Page<MassifMageInfoVo>>(ConstantCodeMsg.NOMAL);

		Page<MassifMageInfoVo> page = po.getPage();
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		// 根据当前登录用户查询 主账号下所有子账号和主账号所有信息
		List<String> list = membInfoMapper.findAccountAll(user.getId());
		// 查询人员管理列表
		po.setMembId(list);
		page.setList(mapper.findMassifPageList(po));
		result.setResult(page);
		return result;
	}

	/**
	 * 保存地块
	 *
	 * @param po
	 * @return
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<?> addOrUpdMassif(MassifMageInfoAddPo po) {
		ResultPoJo<?> result = new ResultPoJo<>(ConstantError.NOMAL);
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		if (ConverterUtil.isEmpty(po.getId())) {// 为空是新增
			MassifMage massif = new MassifMage();// 地块管理表
			massif.preInsert();
			massif.setMembId(user.getId());// 会员id
			massif.setMassifName(po.getMassifName());// 地块名称
			massif.setMassifType(po.getMassifType());// 地块类型
			massif.setMassifAcre(po.getMassifAcre());// 地块面积
			massif.setJd(po.getJd());// 地块纬度
			massif.setWd(po.getWd());// 地块纬度
			massif.setLocation(po.getLocation());// 所在位置
			mapper.insertSelective(massif);
		} else {
			// 查询地块信息数据
			MassifMage massifData = mapper.selectByPrimaryKey(po.getId());
			//检验是否删除
			if (DictConstants.DEL_FLAG_1.equals(massifData.getDelFlag())) {
				result.setCode(ConstantCodeMsg.ERR_602);
				result.setMsg(ConstantCodeMsg.MSG_602);
				return result;
			}
			// 排他校验
			if (!po.getUpdateDate().equals(massifData.getUpdateDate())) {
				result.setCode(ConstantError.ERR_009);
				result.setMsg(ConstantError.MSG_009);
				return result;
			}

			MassifMage massif = new MassifMage();// 地块管理表
			massif.preUpdate();
			massif.setId(po.getId());// 地块id
			massif.setMembId(user.getId());// 会员id
			massif.setMassifName(po.getMassifName());// 地块名称
			massif.setMassifType(po.getMassifType());// 地块类型
			massif.setMassifAcre(po.getMassifAcre());// 地块面积
			massif.setJd(po.getJd());// 地块纬度
			massif.setWd(po.getWd());// 地块纬度
			massif.setLocation(po.getLocation());// 所在位置
			mapper.updateByPrimaryKeySelective(massif);
		}
		return result;
	}

	/**
	 * 查询地块详细信息(未用)
	 *
	 * @param po
	 * @return
	 */
	public ResultPoJo<MassifMage> findMassifInfo(MassifMageInfoPo po) {

		ResultPoJo<MassifMage> result = new ResultPoJo<>(ConstantError.NOMAL);
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		MassifMage massif = mapper.selectByPrimaryKey(po.getId());
		result.setResult(massif);
		return result;
	}

	/**
	 * 删除地块信息
	 *
	 * @param po
	 * @return
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<?> delMassifInfo(MassifMageInfoPo po) {
		ResultPoJo<?> result = new ResultPoJo<>(ConstantError.NOMAL);
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		// 根据地块id 查询是否生成档案
		ArchBasicInfo archBasic = new ArchBasicInfo();
		archBasic.setMassifId(po.getId());
		List<ArchBasicInfo> archBasicInfo = archBasicInfoMapper.findMineArchByMassifId(archBasic);

		// 档案如果存在不可以删除
		if (ConverterUtil.isNotEmpty(archBasicInfo)) {
			result.setCode(ConstantCodeMsg.ERR_900);
			result.setMsg(ConstantCodeMsg.MSG_900);
			return result;
		}
		// 更新状态为已删除
		MassifMage massif = new MassifMage();
		massif.preUpdate();
		massif.setId(po.getId());// 地块id
		massif.setDelFlag(DictConstants.DEL_FLAG_1);// 已删除
		mapper.updateByPrimaryKeySelective(massif);
		return result;
	}

}
