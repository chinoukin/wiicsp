package com.wisea.transac.seller.utils;

import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.transac.common.vo.seller.H5FaceVo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class OrderNoUtil {

    private static final SimpleDateFormat dateFormatOne=new SimpleDateFormat("yyyyMMddHHmmssSS");
    private static JedisDao jedisdao = SpringBootContext.getBean(JedisDao.class);
    public final static String ORDER_NO = "ORDER_NO";

    private static final ThreadLocalRandom random=ThreadLocalRandom.current();
    //生成订单编号-方式一
    public static String generateOrderCode(){

      String result = dateFormatOne.format(new Date())+ generateNumber(4);
        //TODO:时间戳+N为随机数流水号
        H5FaceVo vo = jedisdao.getSerialize(ORDER_NO + result, H5FaceVo.class);
        if (ConverterUtil.isNotEmpty(vo)){
            return generateOrderCode();
        }else{
            return result;
        }

    }

    //N为随机数流水号
    public static String generateNumber(final int num){
        StringBuffer sb=new StringBuffer();
        for (int i=1;i<=num;i++){
            sb.append(random.nextInt(9));
        }
        return sb.toString();
    }


}
