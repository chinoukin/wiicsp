package com.wisea.cultivar.plant.utils;

import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.util.ConverterUtil;

/**
 * 会员相关的工具类
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月5日
 * @version 1.0
 */
public class MembUtils {

	/**
	 * 隐藏手机号中间四位
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月5日
	 * @version 1.0
	 */
	public static String phoneHidden(String phone){
		if(ConverterUtil.isEmpty(phone)){
			return null;
		}
		return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
	}
	/**
	 * 通过用户信息获取会员id
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年1月20日
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
	public static void main(String[] args) {
		System.out.println(phoneHidden("1851519"));
	}
}
