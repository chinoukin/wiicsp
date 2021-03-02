package com.wisea.transac.tp.system.service.wechat;

import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.dao.WholeSaleMarketMageMapper;
import com.wisea.transac.common.entity.MembBaseInfo;
import com.wisea.transac.common.po.seller.SelMarketSavePo;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.WholeSaleMarketMageInfoVo;
import com.wisea.transac.common.vo.memb.WechatLoginInitVo;
import com.wisea.transac.tp.system.utils.TpSystemMembUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 微信小程序登录后的操作
 *
 * @author wangh(wisea)
 *
 * @date 2018年11月15日
 * @version 1.0
 */
@Service
public class MembWeChatService extends BaseService{

	@Autowired
	private JedisDao jedisDao;
	@Autowired
	private WholeSaleMarketMageMapper wholeSaleMarketMageMapper;
	/**
	 * 登录后初期化处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月29日
	 * @version 1.0
	 */
	public ResultPoJo<WechatLoginInitVo> wechatLoginInit(){
		// 返回值初期化处理
		ResultPoJo<WechatLoginInitVo> result = new ResultPoJo<WechatLoginInitVo>();
		WechatLoginInitVo wechatVo = new WechatLoginInitVo();
		// 验证登录用户的信息
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user)){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}
		// 查询会员基本信息
		MembBaseInfo membBaseInfo = MembUtils.getMembInfoByUserId(user.getId());
		if(membBaseInfo != null){
			wechatVo.setId(membBaseInfo.getId());
			wechatVo.setMembId(membBaseInfo.getMembId());
			wechatVo.setLogoUrl(membBaseInfo.getLogoUrl());
			wechatVo.setContName(membBaseInfo.getContName());
			wechatVo.setPurchaseName(membBaseInfo.getPurchaseName());
			wechatVo.setSaleName(membBaseInfo.getSaleName());
			wechatVo.setAuthType(membBaseInfo.getAuthType());
			wechatVo.setAuthName(membBaseInfo.getAuthName());
			// 市场信息
			SelMarketSavePo selMarketSavePo = jedisDao.getSerialize(TpSystemMembUtils.getSelMarketKey(user.getId()), SelMarketSavePo.class);
			if(selMarketSavePo != null){
				wechatVo.setMarketId(selMarketSavePo.getMarketId());
				wechatVo.setMarketName(selMarketSavePo.getMarketName());
				wechatVo.setCoordinatePoint(selMarketSavePo.getCoordinatePoint());
				wechatVo.setMarketProv(selMarketSavePo.getMarketProv());
				wechatVo.setMarketProvCode(selMarketSavePo.getMarketProvCode());
				wechatVo.setMarketCity(selMarketSavePo.getMarketCity());
				wechatVo.setMarketCityCode(selMarketSavePo.getMarketCityCode());
				wechatVo.setMarketCou(selMarketSavePo.getMarketCou());
				wechatVo.setMarketCouCode(selMarketSavePo.getMarketCouCode());
				wechatVo.setMarketAdress(selMarketSavePo.getMarketAdress());
			}
			result.setResult(wechatVo);
		}

		return result;
	}
	/**
	 * 登录选择市场后保存的处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月29日
	 * @version 1.0
	 */
	public ResultPoJo<String> selMarketInfoSave(SelMarketSavePo po){
		// 返回值初期化处理
		ResultPoJo<String> result = new ResultPoJo<String>();
		// 验证登录用户的信息
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user)){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}
		// 查询市场信息
		LongIdPo idPo = new LongIdPo();
		idPo.setId(po.getMarketId());
		WholeSaleMarketMageInfoVo entity = wholeSaleMarketMageMapper.findInfo(idPo);
		if(entity == null){
			result.setCode(ConstantError.ERR_004);
			result.setMsg(ConstantError.MSG_004);
		}else{
			po.setCoordinatePoint(entity.getCoordinatePoint());
			po.setMarketName(entity.getWholeSaleMarketName());
			po.setMarketProv(entity.getAreaProv());
			po.setMarketProvCode(entity.getAreaProvCode());
			po.setMarketCity(entity.getAreaCity());
			po.setMarketCityCode(entity.getAreaCityCode());
			po.setMarketCou(entity.getAreaCou());
			po.setMarketCouCode(entity.getAreaCouCode());
			po.setMarketAdress(entity.getAddress());
			jedisDao.setSerialize(TpSystemMembUtils.getSelMarketKey(user.getId()), po);
		}
		return result;
	}
}
