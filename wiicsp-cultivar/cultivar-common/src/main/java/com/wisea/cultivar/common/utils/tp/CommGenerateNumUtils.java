package com.wisea.cultivar.common.utils.tp;

import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.cache.jedis.JedisDao;

/**
 * Auth： itudou
 * CreateDate:  2017/12/21
 * projectName:  wtp
 * remark:  单号生成工具类
 */
public class CommGenerateNumUtils {

    private static JedisDao jedisdao = SpringBootContext.getBean(JedisDao.class);

    /**
     * 获取编号
     * @param key  缓存key
     * @param prefix  编号前缀
     * @param middle  编号中部内容
     * @return
     */
    public static String getNumber(String key, String prefix, String middle) {
        return getNumber(key, prefix, middle, "%05d");
    }

    /**
     * 获取编号
     * @param key  缓存key
     * @param prefix  编号前缀
     * @param middle  编号中部内容
     * @param format  格式化
     * @return
     */
    public static String getNumber(String key, String prefix, String middle, String format) {
        Long index = jedisdao.incr(key);
        //设置key过期时间
        jedisdao.setExpire(key, OffsetDateTimeUtils.getExpiration());
        return prefix.concat(middle).concat(String.format(format, index));
    }
}
