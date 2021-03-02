package com.wisea.cultivar.common.utils.tp;

import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.entity.AreaTree;
import com.wisea.cloud.common.service.SystemCacheService;
import com.wisea.cloud.common.util.ConverterUtil;

/**
 * 系统中地区处理工具类
 *
 * @author wangh(wisea)
 *
 * @date 2019年6月14日
 * @version 1.0
 */
public class SystemAreaUtils {

	 private static SystemCacheService systemCacheService = SpringBootContext.getBean(SystemCacheService.class);


	/**
	 * 根据CODE获取地区名称的处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年6月14日
	 * @version 1.0
	 */
	public static String getNameByCode(String code){
		if(ConverterUtil.isEmpty(code)){
			return null;
		}
		// 判断CODE
		AreaTree areaTree = systemCacheService.getArea(codeAddOne(code,12));
		if(areaTree != null){
			return areaTree.getName();
		}
		return null;
	}
	/**
	 * 字符串补0操作
	 *
	 * @author wangh(wisea)
	 * @param code 字符串
	 * @param len  需要添加后字符串的位数
	 * @date 2019年6月14日
	 * @version 1.0
	 */
	public static String codeAddOne(String code, int len){
		String  strHao = "";
		if(ConverterUtil.isNotEmpty(code)){
			strHao = code;
		}
		while (strHao.length() < len) {
			strHao = strHao + "0";
		}
		return strHao;
	}
	/**
	 *
	 *
	 * @author wangh(wisea)
	 * @param code 字符串
	 * @param len  需要减去后字符串的位数
	 * @date 2019年6月28日
	 * @version 1.0
	 */
	public static String codeMinusOne(String code,int len){
		String  strHao = "";
		if(ConverterUtil.isNotEmpty(code)){
			strHao = code;
		}
		if(strHao.length() > 6){
			strHao = strHao.substring(0,6);
		}
		return strHao;
	}
	public static void main(String[] args) {
		System.out.println(codeMinusOne(null,6));
	}
}
