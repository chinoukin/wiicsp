package com.wisea.transac.seller.utils;

import com.google.gson.Gson;

import java.util.Map;

/**
 *
 * [获取token]
 * [功能详细描述]
 *
 * @author  fwq
 * @version  [v1.0, 2017年11月7日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class access_token {

    public static String getToken(String appid,String secret) throws Exception {
        String tokenUrl="https://idasc.webank.com/api/oauth2/access_token?app_id="+appid+"&secret="+secret+"&grant_type=client_credential&version=1.0.0";
        //建立连接
        StringBuffer stringBuffer = getUtils.get(tokenUrl);
        Gson gs = new Gson();
        Map<String,String> map = gs.fromJson(stringBuffer.toString(), Map.class);
        System.out.println(map.get("access_token"));
        return map.get("access_token");
    }

}
