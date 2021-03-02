package com.wisea.cultivar.common.utils.tp;

import java.util.Arrays;

import com.wisea.cultivar.common.dao.tp.MembInfoMapper;
import com.wisea.cultivar.common.entity.tp.MembBaseInfo;
import com.wisea.cultivar.common.entity.tp.MembInfo;
import com.wisea.cultivar.common.constants.tp.ConstantCodeMsg;
import com.wisea.cultivar.common.constants.tp.DictConstants;
import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.util.ConverterUtil;

/**
 * 会员相关的接口
 *
 * @author wangh(wisea)
 *
 * @date 2018年10月8日
 * @version 1.0
 */
public class MembUtils {

	/* 会员基础信息 */
    public static final String MEMB_USERID = "MEMB_USERID_";

	private static JedisDao jedisdao = SpringBootContext.getBean(JedisDao.class);
	private static MembInfoMapper membInfoMapper = SpringBootContext.getBean(MembInfoMapper.class);

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
			if(ConverterUtil.isNotEmpty(user.getParentId())){
				membId = user.getParentId();
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
						&& DictConstants.NFKFP_TYPE_0.equals(membBaseInfo.getNfkfpType())
						&& ConverterUtil.isNotEmpty(membBaseInfo.getInvoType())){
					membBaseInfo.setInvoList(Arrays.asList(membBaseInfo.getInvoType().split(",")));
				}
			}
			jedisdao.setSerialize(key, membBaseInfo);
		}
		return membBaseInfo;
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
    public static void delMembUser(Long userId){
    	if (ConverterUtil.isEmpty(userId)) {
            return;
        }
    	String key = getMembUserId(userId);
    	jedisdao.delSerialize(key);
    }

    /**
     * 通过手机号或者用户名查询登录用户名
     *
     * @author wangh(wisea)
     *
     * @date 2019年5月7日
     * @version 1.0
     */
    public static String getLoginNameByUserName(String userName){
    	return membInfoMapper.getLoginNameByUserNameOrMobile(userName);
    }
    /**
     * @Author jirg
     * @Date 2019/4/22 14:20
     * @Description 会员开通账期支付功能
     **/
	public static ResultPoJo<?> openingService(Long userId) {
		ResultPoJo<?> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		MembBaseInfo membBaseInfo = getMembInfoByUserId(userId);
		//
		if(membBaseInfo.getMemberType().equals(DictConstants.MEMBER_TYPE_1) &&
				membBaseInfo.getEntpAuthStateType().equals(DictConstants.ENTP_AUTH_STATE_TYPE_0)){
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
}
