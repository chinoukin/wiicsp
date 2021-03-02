package com.wisea.transac.seller.utils;


import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * [合作方后台上送身份信息 获取faceId]
 * [功能详细描述]
 *
 * @author  fwq
 * @version  [v1.0, 2017年11月7日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class GetH5FaceId {

//	final static  String orderNo = "orderNo19959248596551";
//	final static  String name = "张三";
//	final static  String idNo = "429006199009157019";
//	final static  String version = "1.0.0";

	public static Map<String,Object> 	getH5FaceIdStr(String userId, String apiticket, String webankAppId, String orderNo, String name, String idNo,String version)  throws Exception{

		//设置签名所需要的参数
		ArrayList<String> list = new ArrayList<String>();
		list.add(webankAppId);
		list.add(orderNo);
		list.add(name);
		list.add(idNo);
		list.add(userId);
		list.add(version);

		//获取签名
		String getqianming = QianMingUitls.getqianming(list, apiticket);


		final String Url="https://idasc.webank.com/api/server/h5/geth5faceid";


		    JSONObject params = new JSONObject();
		    params.put("webankAppId", webankAppId);
		    params.put("orderNo", orderNo);
		    params.put("name", name);
		    params.put("idNo", idNo);
		    params.put("userId", userId);
		    params.put("version", version);
		    params.put("sign", getqianming);
		  /*  params.put("sourcePhotoStr", sourcePhotoStr);
		    params.put("sourcePhotoType", sourcePhotoType);*/

		HttpClientUtil httpClientUtil = new HttpClientUtil();
        String xmlData = httpClientUtil.doPost(Url, params.toString(), "utf-8");


        Map<String,Object> map = JsonUtil.fromJson(xmlData.toString(),  Map.class);

         //Object object=map.get("result");
        //String json = JsonUtil.toJson(object);

       // Map fromJson = JsonUtil.fromJson(json,  Map.class);


 		//return (String) fromJson.get("h5faceId");
         return map;
	}

}
