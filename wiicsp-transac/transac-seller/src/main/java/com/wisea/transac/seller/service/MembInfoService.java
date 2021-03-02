package com.wisea.transac.seller.service;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.common.util.OffsetDateTimeUtils;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.dao.MembInfoMapper;
import com.wisea.transac.common.dao.PurchaseStaffMageMapper;
import com.wisea.transac.common.dao.RealPersonAuthMapper;
import com.wisea.transac.common.dao.SaleStaffInfoMageMapper;
import com.wisea.transac.common.entity.MembBaseInfo;
import com.wisea.transac.common.entity.MembInfo;
import com.wisea.transac.common.mss.RemoteTIMAccountMss;
import com.wisea.transac.common.mss.UserMembInfoMss;
import com.wisea.transac.common.po.MembInfoPageListPo;
import com.wisea.transac.common.po.MembInfoPo;
import com.wisea.transac.common.po.memb.MembCheckLoginNamePo;
import com.wisea.transac.common.po.memb.UpdUserMembInfoPo;
import com.wisea.transac.common.po.trade.StaticOrderPo;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.MembInfoInfoVo;
import com.wisea.transac.common.vo.MembInfoPageListVo;
import com.wisea.transac.common.vo.RealPersonAuthInfoVo;
import com.wisea.transac.common.vo.seller.MembInfoVo;
import com.wisea.transac.common.vo.trade.ChartVo;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className MembInfoService
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Service
public class MembInfoService extends BaseService {
    @Autowired
    private MembInfoMapper membInfoMapper;
	@Autowired
	private SaleStaffInfoMageMapper saleStaffInfoMageMapper;
	@Autowired
	private PurchaseStaffMageMapper purchaseStaffMageMapper;
	@Autowired
	private RemoteTIMAccountMss remoteTIMAccountMss;
//	@Autowired
//	private RemoteUserMss remoteUserMss;

	@Autowired
	private UserMembInfoMss userMembInfoMss;

	@Autowired
	private RealPersonAuthMapper realPersonAuthMapper;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询MembInfo
     */
    public ResultPoJo<Page<MembInfoPageListVo>> findPageList(MembInfoPageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
		ResultPoJo<Page<MembInfoPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		Page<MembInfoPageListVo> page = po.getPage();
		List<MembInfoPageListVo> list = membInfoMapper.findPageList(po);
		page.setList(list);
		resultPoJo.setResult(page);
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 逻辑删除MembInfo
     */
	@Transactional(readOnly = false)
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		MembInfo entity = membInfoMapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(entity)){
			entity.setDelFlag(MembInfo.DEL_FLAG_DELETE);
			entity.preUpdate();
			membInfoMapper.updateByPrimaryKey(entity);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 新增或修改MembInfo
     */
	@Transactional(readOnly = false)
    public ResultPoJo saveOrUpdate(MembInfoPo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		if(ConverterUtil.isNotEmpty(po.getId())){
			//MembBaseInfo info = MembUtils.getMembInfoByUserId(po.getId());
			MembInfo entity = membInfoMapper.selectByPrimaryKey(po.getId());
			if(ConverterUtil.isEmpty(entity)){
				resultPoJo.setCode(ConstantError.ERR_004);
				resultPoJo.setMsg(ConstantError.MSG_004);
				return resultPoJo;
			}
			//获取个人认证信息
			if(ConverterUtil.isNotEmpty(po.getContName())){
				RealPersonAuthInfoVo realPerson = realPersonAuthMapper.findInfoByUserId(po.getId());
				if (ConverterUtil.isNotEmpty(realPerson)) {
					if(DictConstants.ENTP_AUTH_STATE_TYPE_0.equals(realPerson.getEntpAuthStateType())){
						if (!realPerson.getRealName().equals(po.getContName())){
							resultPoJo.setCode("886");
							resultPoJo.setMsg("已通过实人认证姓名不可更改!");
							return resultPoJo;
						}
					}
				}
			}
			//修改
			BeanUtils.copyProperties(po, entity);
			entity.preUpdate();
			membInfoMapper.updateByPrimaryKeySelective(entity);
		}else{
			//新增
			MembInfo entity = new MembInfo();
			BeanUtils.copyProperties(po, entity);
			entity.preInsert();
			membInfoMapper.insert(entity);
		}
		//清楚缓存
		MembUtils.delMembUser(po.getId());
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息MembInfo
     */
    public ResultPoJo<MembInfoInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
		ResultPoJo<MembInfoInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		MembInfoInfoVo vo = membInfoMapper.findInfo(po);
		if(ConverterUtil.isNotEmpty(vo)){
			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }

	/**
	 * 账号信息
	 * @return
	 */
	public ResultPoJo<MembInfoVo> findMembInfo() {
		ResultPoJo<MembInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		MembInfoVo vo = new MembInfoVo();
		User user= SystemUtils.getUser();
		MembBaseInfo info = MembUtils.getMembInfoByUserId(user.getId());
		vo.setId(info.getId());
		vo.setName(ConverterUtil.isNotEmpty(info.getContName())? info.getContName() : ConverterUtil.isNotEmpty(info.getLoginName())?info.getLoginName() : info.getRegistTel());
		vo.setContName(info.getContName());
		vo.setLogoUrl(info.getLogoUrl());
		vo.setEntpName(info.getAuthName());
		vo.setPetName(info.getPetName());
		vo.setLoginNameSetFlag(info.getLoginNameSetFlag());
		if (!DictConstants.LOGIN_NAME_SET_FLAG_1.equals(info.getLoginNameSetFlag())){
			vo.setLoginName(info.getLoginName());
		}
		vo.setRegistTel(info.getRegistTel());
			LongIdPo po = new LongIdPo();
			po.setId(user.getId());
			MembInfoInfoVo membInfoInfoVo = membInfoMapper.findInfo(po);
			if (ConverterUtil.isNotEmpty(membInfoInfoVo)){
				vo.setPosition(membInfoInfoVo.getPosition());
				vo.setSexType(membInfoInfoVo.getSexType());
			}
		if(ConverterUtil.isNotEmpty(vo)){
			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}

		return resultPoJo;
	}

	/**
	 * 修改账号信息
	 * @param po
	 * @return
	 */
	//@TxTransaction(type = Transactions.LCN, propagation = DTXPropagation.REQUIRED)
	@GlobalTransactional
	@Transactional(readOnly = false)
    public ResultPoJo  updAccount(MembInfoPo po) {
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		MembBaseInfo info = MembUtils.getMembInfoByUserId(po.getId());
		MembInfo entity = membInfoMapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isEmpty(entity)){
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
			return resultPoJo;
		}
		if (ConverterUtil.isEmpty(po.getLoginName())){
			po.setLoginName(null);
		}
		// 验证用户名是否重复
		MembCheckLoginNamePo membCheckLoginNamePo = new MembCheckLoginNamePo();
		membCheckLoginNamePo.setLoginName(po.getLoginName());
		membCheckLoginNamePo.setMembId(po.getId());
		int count = membInfoMapper.checkLoginNameExist(membCheckLoginNamePo);
		// 用户名称已经存在的情况
		if(count > 0){
			resultPoJo.setCode(ConstantCodeMsg.ERR_502);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_502);
			return resultPoJo;
		}

		//获取个人认证信息
		RealPersonAuthInfoVo realPerson = realPersonAuthMapper.findInfoByUserId(po.getId());
		if (ConverterUtil.isNotEmpty(realPerson)) {
			if(DictConstants.ENTP_AUTH_STATE_TYPE_0.equals(realPerson.getEntpAuthStateType())){
				if (!realPerson.getRealName().equals(po.getContName())){
					resultPoJo.setCode(ConstantCodeMsg.ERR_996);
					resultPoJo.setMsg(ConstantCodeMsg.MSG_996);
					return resultPoJo;
				}
			}
		}
		//修改登陆用户名
		if (!DictConstants.LOGIN_NAME_SET_FLAG_0.equals(entity.getLoginNameSetFlag())){
			if(!entity.getLoginName().equals(po.getLoginName())&&ConverterUtil.isNotEmpty(po.getLoginName())){
				//UpdateLoginNamePo updateLoginNamePo = new UpdateLoginNamePo();
				UpdUserMembInfoPo updUserMembInfoPo = new UpdUserMembInfoPo();
				updUserMembInfoPo.setId(po.getId());
				updUserMembInfoPo.setLoginName(po.getLoginName());
				ResultPoJo<String> userResult = userMembInfoMss.updUserMembInfo(updUserMembInfoPo);
				if(!userResult.getCode().equals(ConstantError.NOMAL)){
					checkRemoteResult(userResult);
					resultPoJo.setCode(userResult.getCode());
					resultPoJo.setMsg(userResult.getMsg());
					return resultPoJo;
				}
			}
		}

		//修改
		BeanUtils.copyProperties(po, entity);
		entity.preUpdate();
		membInfoMapper.updateByPrimaryKeySelective(entity);
		//清楚缓存
		MembUtils.delMembUser(po.getId());

		return resultPoJo;
    }

	/**
	 * 查询用户数量
	 * @return
	 */
	public ResultPoJo<List<ChartVo>> findUser() {
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		StaticOrderPo moth = new StaticOrderPo();
		moth.setStartDate(OffsetDateTimeUtils.getDayMinTime(OffsetDateTime.now().plusDays(-29)));
		moth.setEndDate(OffsetDateTime.now());
		List<ChartVo> memeber = membInfoMapper.findUser(moth);
		if (memeber.size() == 0) {
			return new ResultPoJo<>();
		}
			//构造30天
			List<String> daysYmd = Lists.newArrayList();
			daysYmd = OffsetDateTimeUtils.getStartAndEndYmd(moth.getStartDate(), moth.getEndDate());
			Map<String, ChartVo> resultMap = memeber.stream().collect(Collectors.toMap(ChartVo::getxPoint, Function.identity()));
			List<ChartVo> chartVos = Lists.newArrayList();
			daysYmd.forEach(e -> {
				if (resultMap.containsKey(e)){
					chartVos.add(resultMap.get(e));
				}else{
					ChartVo chartVo = new ChartVo();
					chartVo.setxPoint(e);
					chartVo.setyValue(0);
					chartVos.add(chartVo);
				}
			});
		resultPoJo.setResult(chartVos);
		return resultPoJo;
	}
}
