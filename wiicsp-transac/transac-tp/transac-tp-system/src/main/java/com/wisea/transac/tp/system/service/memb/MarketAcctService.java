package com.wisea.transac.tp.system.service.memb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.dao.MarketAcctNumMageMapper;
import com.wisea.transac.common.dao.WholeSaleMarketMageMapper;
import com.wisea.transac.common.entity.MarketAcctNumMage;
import com.wisea.transac.common.po.memb.PlatFormUserInfoPo;
import com.wisea.transac.common.vo.memb.MaketInfoListVo;

/**
 * 批发市场运营平台相关接Service
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月7日
 * @version 1.0
 */
@Service
public class MarketAcctService extends BaseService{

	@Autowired
	private PlatformUserService platformUserService;
	@Autowired
	private MarketAcctNumMageMapper marketAcctNumMageMapper;
	@Autowired
    private WholeSaleMarketMageMapper wholeSaleMarketMageMapper;

	/**
	 * 添加市场的时候管理员的操作处理
	 *
	 * @author wangh(wisea)
	 * @param marketId 市场ID
	 * 		  loginName 登录用户名
	 *        password 登录密码
	 * @date 2020年5月8日
	 * @version 1.0
	 */
	public ResultPoJo<String> addMarketAdminForAddMarket(Long marketId,
			String loginName,String password){
		//  返回参数
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 判断参数
		if(ConverterUtil.isEmpty(marketId) || ConverterUtil.isEmpty(loginName)
				|| ConverterUtil.isEmpty(password)){
			result.setCode(ConstantCodeMsg.ERR_005);
			result.setMsg(ConstantCodeMsg.MSG_005);
			return result;
		}
		// 根据市场ID查询市场管理员相关信息
		MarketAcctNumMage marketAcctNumMage = marketAcctNumMageMapper.getMarketAcctByMarketId(marketId);
		PlatFormUserInfoPo platFormUserInfoPo = new PlatFormUserInfoPo();
		platFormUserInfoPo.setLoginName(loginName);// 登录用户名
		platFormUserInfoPo.setPassword(password);// 登录密码
		platFormUserInfoPo.setMarketId(marketId);// 批发市场ID
		// 如果是空表示是新增处理/如果不是空则表示修改操作
		if(marketAcctNumMage == null){
			platFormUserInfoPo.setEffeInvalState(DictConstants.EFFE_INVAL_STATE_0);// 启用
			platFormUserInfoPo.setSfAdminFlag(DictConstants.SF_ADMIN_FLAG_0);
			result = platformUserService.addMarketAcctNumMage(platFormUserInfoPo);
		}else{
			platFormUserInfoPo.setId(marketAcctNumMage.getId());
			platFormUserInfoPo.setSfAdminFlag(DictConstants.SF_ADMIN_FLAG_0);
			result = platformUserService.updMarketAcctNumMage(platFormUserInfoPo);
		}
		return result;
	}
	/**
	 * 查询所有的市场信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月27日
	 * @version 1.0
	 */
	public ResultPoJo<List<MaketInfoListVo>> findMarketAllList(String po){
		//  返回参数
		ResultPoJo<List<MaketInfoListVo>> result = new ResultPoJo<List<MaketInfoListVo>>(ConstantError.NOMAL);
		result.setResult(wholeSaleMarketMageMapper.findMarketAllList(po));
		return result;
	}
}
