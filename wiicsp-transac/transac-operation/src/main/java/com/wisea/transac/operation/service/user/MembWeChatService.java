package com.wisea.transac.operation.service.user;

import com.wisea.transac.operation.entity.MembReleBaseInfo;
import com.wisea.transac.operation.entity.MembRelevanceInfo;
import com.wisea.transac.operation.mapper.MembRelevanceInfoMapper;
import com.wisea.transac.operation.user.po.MembReleUnBdPo;
import com.wisea.transac.operation.user.po.WechatBdPo;
import com.wisea.transac.operation.user.vo.WachatBdInfoVo;
import com.wisea.transac.operation.user.vo.WeChatDateByCodeVo;
import com.wisea.transac.operation.utils.AesCbcUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.constants.RedisKeyConstants;
import com.wisea.transac.common.utils.MembUtils;

import net.sf.json.JSONObject;

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
	private MembRelevanceInfoMapper membRelevanceInfoMapper;
	@Autowired
	private MembWxinLoginService membWxinLoginService;
	@Autowired
	private JedisDao jedisDao;

	/**
	 * 微信账号的绑定(unionid)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年2月25日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<WachatBdInfoVo> bdUnionId(WechatBdPo wechatBdPo){
		// 返回值初期化处理
		ResultPoJo<WachatBdInfoVo> result = new ResultPoJo<WachatBdInfoVo>(ConstantCodeMsg.NOMAL);
		WachatBdInfoVo vo = new WachatBdInfoVo();
		vo.setOpenId(wechatBdPo.getOpenid());
		String sessionkey = null;
		String redisSessionKey = RedisKeyConstants.WACHAT_SESSION_KEY + wechatBdPo.getOpenid() + wechatBdPo.getWechatType();
		// 需要重新获取sessionkey的情况
		if(ConverterUtil.isNotEmpty(wechatBdPo.getCode())){
			WeChatDateByCodeVo jsonObject = membWxinLoginService.getInfoByCode(wechatBdPo.getCode(),wechatBdPo.getWechatType());
			sessionkey = jsonObject.getSessionkey();
			jedisDao.setSerialize(redisSessionKey,sessionkey);
		}else{
			sessionkey = jedisDao.getSerialize(redisSessionKey, String.class);
		}
		JSONObject userInfo = AesCbcUtil.decryptDataS5(wechatBdPo.getEncryptedData(), sessionkey, wechatBdPo.getIv());
		String unionId = ConverterUtil.toString(userInfo.get("unionId"));
		if(ConverterUtil.isEmpty(unionId)){
			result.setCode(ConstantCodeMsg.ERR_809);
			result.setMsg(ConstantCodeMsg.MSG_809);
			return result;
		}
		// 如果数据库中有openid则保存unionId
		// 根据openid验证是否已经绑定账户
		MembRelevanceInfo membReleVanceInfo = new MembRelevanceInfo();
		membReleVanceInfo.setOpenId(wechatBdPo.getOpenid());
		membReleVanceInfo.setOpenType(ConverterUtil.toString(wechatBdPo.getWechatType()));
		MembReleBaseInfo membReleBaseInfo = membRelevanceInfoMapper.getMembReleInfoByOpenid(membReleVanceInfo);
		if(ConverterUtil.isNotEmpty(membReleBaseInfo) && ConverterUtil.isNotEmpty(membReleBaseInfo.getId())){
			MembRelevanceInfo membRelevanceInfo = new MembRelevanceInfo();
			membRelevanceInfo.setId(membReleBaseInfo.getId());
			membRelevanceInfo.setUnionId(unionId);
			membRelevanceInfoMapper.updateByPrimaryKeySelective(membRelevanceInfo);
		}else{
			result.setCode(ConstantCodeMsg.ERR_810);
			result.setMsg(ConstantCodeMsg.MSG_810);
			return result;
		}
		vo.setUnionId(unionId);
		result.setResult(vo);
		return result;
	}
	/**
	 * 微信小程序解绑
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年11月15日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<String> weChatUnbind(MembReleUnBdPo po){
		// 返回参数
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 验证登录用户的信息
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user)){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}
		MembRelevanceInfo selInfo = new MembRelevanceInfo();
		selInfo.setReleId(po.getId());
		selInfo.setType("0");// 默认是微信小程序
		selInfo.setOpenType(ConverterUtil.toString(po.getWechatType()));
		MembRelevanceInfo entity = membRelevanceInfoMapper.getMembReleInfo(selInfo);
        if(ConverterUtil.isEmpty(entity) || ConverterUtil.isEmpty(entity.getId())){
        	result.setCode(ConstantCodeMsg.ERR_513);
			result.setMsg(ConstantCodeMsg.MSG_513);
			return result;
        }
        entity.preUpdate();
        membRelevanceInfoMapper.deleteLogic(entity);
        // 清空会员相关的缓存信息
 		MembUtils.delMembSelfUser(po.getId());
		return result;
	}
}
