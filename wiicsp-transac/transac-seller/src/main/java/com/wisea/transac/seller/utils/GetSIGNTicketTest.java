package com.wisea.transac.seller.utils;

import java.util.List;
import java.util.Map;

/**
 *
 * [获取singleticket]
 * [功能详细描述]
 *
 * @author  fwq
 * @version  [v1.0, 2017年11月7日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class GetSIGNTicketTest {


   public static String getSignticket(String appid,String access_token ) throws Exception {



        //修改appID，secret
        String signticketUrl="https://idasc.webank.com/api/oauth2/api_ticket?app_id="+appid+"&access_token="+access_token+"&type=SIGN&version=1.0.0";
        StringBuffer stringBuffer = getUtils.get(signticketUrl);

        Map<String,Object> map = JsonUtil.fromJson(stringBuffer.toString(),  Map.class);

        List<Object>  arr= (List<Object>) map.get("tickets");

        String json = JsonUtil.toJson(arr);

        String substring = json.substring(1, json.length()-1);

        Map fromJson = JsonUtil.fromJson(substring,  Map.class);

 		return (String) fromJson.get("value");
    }

}
