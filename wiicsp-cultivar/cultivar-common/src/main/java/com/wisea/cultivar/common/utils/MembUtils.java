package com.wisea.cultivar.common.utils;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.entity.AreaTree;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.SystemCacheService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.IdGen;
import com.wisea.cultivar.common.constants.ConstantCodeMsg;
import com.wisea.cultivar.common.constants.DictConstants;
import com.wisea.cultivar.common.constants.tp.RedisKeyConstants;
import com.wisea.cultivar.common.dao.MarketAcctNumMageMapper;
import com.wisea.cultivar.common.dao.MembInfoMapper;
import com.wisea.cultivar.common.entity.MarketAcctNumMage;
import com.wisea.cultivar.common.entity.MembBaseInfo;
import com.wisea.cultivar.common.entity.MembInfo;
import com.wisea.cultivar.common.po.memb.LoginNameOrMobilePo;
import com.wisea.cultivar.common.po.memb.MembCheckLoginNamePo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 会员相关工具类
 *
 * @author wangh(wisea)
 *
 * @date 2020年4月28日
 * @version 1.0
 */
public class MembUtils {

	/* 会员基础信息 */
    public static final String MEMB_USERID = "MEMB_USERID_";

	private static JedisDao jedisdao = SpringBootContext.getBean(JedisDao.class);
	private static MembInfoMapper membInfoMapper = SpringBootContext.getBean(MembInfoMapper.class);
	private static MarketAcctNumMageMapper marketAcctNumMageMapper = SpringBootContext.getBean(MarketAcctNumMageMapper.class);
	private static SystemCacheService systemCacheService = SpringBootContext.getBean(SystemCacheService.class);

	public static String government = "北京市,上海市,重庆市,天津市";
	/**
	 * 通过用户信息获取会员id
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年10月8日
	 * @version 1.0
	 */
	public static Long getMembIdFromUser(User user){
		Long membId= null;
		if(user != null){
			MembBaseInfo membBaseInfo = getMembInfoByUserId(user.getId());
			if(membBaseInfo != null && ConverterUtil.isNotEmpty(membBaseInfo.getMembId())){
				membId = membBaseInfo.getMembId();
			}else{
				membId = user.getId();
            }
		}
		return membId;
	}
	/**
	 * 根据用户id（用户id和会员id相同）获取会员的相关信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年10月10日
	 * @version 1.0
	 */
	public static MembBaseInfo getMembInfoByUserId(Long id){
		if(ConverterUtil.isEmpty(id)){
			return null;
		}
		String key = getMembUserId(id);
		MembBaseInfo membBaseInfo = jedisdao.getSerialize(key, MembBaseInfo.class);
		if(membBaseInfo == null){
			membBaseInfo = membInfoMapper.getMembBaseInfo(id);
			if(membBaseInfo == null){
				return null;
			}else{
				if(ConverterUtil.isNotEmpty(membBaseInfo.getNfkfpType())
						&& ConverterUtil.isNotEmpty(membBaseInfo.getInvoType())){
					membBaseInfo.setInvoList(Arrays.asList(membBaseInfo.getInvoType().split(",")));
				}
			}
			jedisdao.setSerialize(key, membBaseInfo);
		}
		return membBaseInfo;
	}


	/**
     * 通过手机号或者用户名查询登录用户名--会员用户不包含运营用户
     *
     * @author wangh(wisea)
     *
     * @date 2019年5月7日
     * @version 1.0
     */
    public static MembInfo getLoginNameByUserName(String userName){
    	return membInfoMapper.getLoginNameByUserNameOrMobile(userName);
    }
    /**
     * 查询总运营平台或者市场的超级管理员用户ID
     *
     * @author wangh(wisea)
     *
     * @date 2020年6月18日
     * @version 1.0
     */
    public static Long getPlatOrMarketAdminId(Long marketId){
    	return membInfoMapper.getAdminId(marketId);
    }
    /**
     * 通过注册手机号查询用户信息
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月11日
     * @version 1.0
     */
    public static MembInfo getMembInfoByRegTel(String regTel){
    	return membInfoMapper.getMembInfoByRegTel(regTel);
    }
    /**
     * 商户APP登录的验证处理
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月12日
     * @version 1.0
     */
    public static MembBaseInfo sellerAppLoginCheck(LoginNameOrMobilePo po){
    	return membInfoMapper.sellerAppLoginCheck(po);
    }
    /**
     * 通过用户名称查询市场或者运营平台人员信息
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月11日
     * @version 1.0
     */
    public static MarketAcctNumMage getMarketAcctInfo(String loginName){
    	return marketAcctNumMageMapper.getMarketAcctInfo(loginName);
    }
	/**
     * 获取会员基础信息的缓存key
     *
     * @param userId
     * @return
     */
    public static String getMembUserId(Long userId) {
        if (ConverterUtil.isEmpty(userId)) {
            return null;
        }
        return MEMB_USERID + String.valueOf(userId);
    }
    /**
     * 根据用户id清楚会员基础信息缓存
     *
     * @author wangh(wisea)
     *
     * @date 2018年1月29日
     * @version 1.0
     */
    public static void delMembSelfUser(Long userId){
    	if (ConverterUtil.isEmpty(userId)) {
            return;
        }
    	String key = getMembUserId(userId);
    	jedisdao.delSerialize(key);
    }
    /**
     * 根据用户id清楚会员基础信息缓存
     *
     * @author wangh(wisea)
     *
     * @date 2018年1月29日
     * @version 1.0
     */
    public static void delMembUser(Long userId){
    	if (ConverterUtil.isEmpty(userId)) {
            return;
        }
    	String key = getMembUserId(userId);
    	jedisdao.delSerialize(key);
    	// 删除子类的缓存
    	List<Long> list = membInfoMapper.getPruAndSaleList(userId);
    	if(list != null && list.size() > 0){
    		for(Long membId : list){
    			String subKey = getMembUserId(membId);
    	    	jedisdao.delSerialize(subKey);
    		}
    	}
    }
    /**
     * 11位手机号中间四位加密的处理
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月9日
     * @version 1.0
     */
    public static String telEncrypt(String tel){
    	if(ConverterUtil.isNotEmpty(tel) && tel.length() == 11){
    		tel = tel.substring(0,3) + "****" + tel.substring(7, 11);
    	}
    	return tel;
    }
    public static void main(String[] args) {
    	System.out.println(telEncrypt("18515192817"));
	}

	/**
	 * @Author jirg
	 * @Date 2020/5/12 9:51
	 * @Description 企业用户开通账期支付
	 **/
	public static ResultPoJo<?> openApPay(Long id) {
		ResultPoJo<?> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		MembBaseInfo membBaseInfo = getMembInfoByUserId(id);
		//判断是否为企业，并且通过平台企业认证
		if(membBaseInfo.getAuthType().equals("0")){
			if(DictConstants.AP_FLAG_1.equals(membBaseInfo.getApFlag()) || ConverterUtil.isEmpty(membBaseInfo.getApFlag())){
				MembInfo membInfo = new MembInfo();
				membInfo.setId(membBaseInfo.getMembId());
				membInfo.setApFlag(DictConstants.AP_FLAG_0);
				//删除当前登录用户缓存
				membInfoMapper.updateByPrimaryKeySelective(membInfo);
				delMembUser(membBaseInfo.getId());
				if(!membBaseInfo.getId().equals(membBaseInfo.getMembId())){
					//清楚父账户缓存
					delMembUser(membBaseInfo.getMembId());
				}
			}
		}else{
			resultPoJo.setCode(ConstantCodeMsg.ERR_422);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_422);
		}
		return resultPoJo;
	}
	/**
	 * 根据CODE获取地区名称的处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年6月14日
	 * @version 1.0
	 */
	public static String getAreaNameByCode(String code){
		if(ConverterUtil.isEmpty(code)){
			return null;
		}
		AreaTree area = systemCacheService.getArea(code);
		if(area != null){
			return area.getCode();
		}
		return null;
	}
	/**
	 * 获取要发送消息的会员列表
	 * @param types 多个用逗号分隔
	 *              0：全部会员
	 *				1:全部供应商
	 *				2:全部采购商
	 *				3:供应商企业认证会员
	 *				4:供应商个体户认证会员
	 *				5:采购商企业认证会员
	 *				6:采购商个体户认证会员
	 *				7:采购商个人认证会员
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月26日
	 * @version 1.0
	 */
	public static List<String> findMembListForMsg(String types){
		if(types == null){
			return null;
		}
		List<String> paraList = Lists.newArrayList();
		// 查看是否是全部
		if(types.contains("0")){
			return membInfoMapper.findAllMembList();
		// 全部供应商的情况
		}/*else if(types.contains("1")){
			paraList.add("3");
			paraList.add("4");
		}else if(types.contains("2")){
			paraList.add("5");
			paraList.add("6");
			paraList.add("7");
		}*/
		for(String str : types.split(",")){
			paraList.add(str);
		}
		return membInfoMapper.findMembListForMsg(paraList);
	}
	/**
	 * 随机用户名处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年11月13日
	 * @version 1.0
	 */
	public static String getRandomUserName(){
		while (true) {
			String userName = IdGen.randomBase62(8);
			MembCheckLoginNamePo membCheckLoginNamePo = new MembCheckLoginNamePo();
			membCheckLoginNamePo.setLoginName(userName);
            int userNameCount = membInfoMapper.checkLoginNameExist(membCheckLoginNamePo);
            if (userNameCount <= 0) {
                return userName;
            }
        }
	}
	/**
     * 返回长度为【strLength】的随机数，数字
     *
     * @param strLength
     * @return
     */
    public static String getFixLenthString(int strLength) {
        Random rm = new Random();
        // 获得随机数
        Long pross = Math.abs(rm.nextLong());
        // 将获得的获得随机数转化为字符串
        String fixLenthString = String.valueOf(pross);
        // 返回固定的长度的随机数
        return fixLenthString.substring(0, strLength);
    }
	/**
	 * 删除手机号登录后保存的刷新token信息的标识的KEY
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年8月11日
	 * @version 1.0
	 */
	public static String mobileLoginRefreshKey(String id){
		return RedisKeyConstants.MOBILE_LOGIN_REFRESH_KEY + id;
	}
}
