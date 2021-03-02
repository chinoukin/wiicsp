package com.wisea.transac.common.utils;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.context.ApplicationContext;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.util.ConverterUtil;

/**
 * 批量处理工具类
 *
 * @author XuDL(Wisea)
 *
 *         2020年5月7日 上午10:34:04
 */
public class BatchUtil {
    /**
     * 批处理SQL
     *
     * @param list
     *            列表
     * @param func
     *            处理函数
     */
    public static <T> void batchSQL(List<T> list, Consumer<List<T>> func) {
        // SQL批量最大值300 避免数量过多导致执行缓慢的问题
        ApplicationContext app = SpringBootContext.getApplicationContext();
        int size = 300;
        if (null != app) {
            size = ConverterUtil.toInteger(app.getEnvironment().getProperty("wbfc.batch.sqlsize"), 300);
        }
        batch(list, size, func);
    }

    /**
     * 执行批处理任务
     *
     * @param list
     *            列表
     * @param size
     *            每次处理的大小
     * @param func
     *            处理函数
     */
    public static <T> void batch(List<T> list, int size, Consumer<List<T>> func) {
        // 都不能为空
        if (ConverterUtil.isNotEmpty(list, func)) {
            // 安装大小进行列表拆分
            List<List<T>> batchList = Lists.partition(list, size);
            // 循环批处理动作
            for (List<T> s : batchList) {
                func.accept(s);
            }
        }
    }
}
