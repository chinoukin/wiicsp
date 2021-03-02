package com.wisea.transac.tp.trade.task;

import com.wisea.cloud.common.annotation.TimerSchedule;
import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.quartz.QuartzManager;
import com.wisea.cloud.quartz.entity.QuartzJob;
import com.wisea.cloud.quartz.entity.QuartzJobOptions;
import com.wisea.cloud.quartz.job.DisallowConcurrentJob;
import com.wisea.transac.tp.trade.service.OrderSyncService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @Author jirg
 * @Date 2019/8/21 17:12
 * @Description TODO 订单同步定时任务，此功能为产品项目特有，如代码同步到洪九果品记得删除
 **/
@TimerSchedule
public class OrderSyncTask extends DisallowConcurrentJob implements QuartzJob {

    private OrderSyncService orderSyncService;

    /**
     * 定时任务参数
     */
    private QuartzJobOptions option;

    @Override
    public QuartzJobOptions getOption() {
        if (ConverterUtil.isEmpty(option)) {
            option = new QuartzJobOptions("OrderSyncTask", QuartzManager.JOB_GROUP, this.getClass());
            // 设置任务说明
            option.setDescription("订单同步定时任务");
            // 设置触发器名称
            option.setTriggerName("order_syncTask_every_five_minute");
            // 设置触发器分组
            option.setTriggerGroupName(QuartzManager.TRIGGER_GROUP);
            // 设置触发器说明
            option.setTriggerDescription("每15秒执行一次【订单同步定时任务】");
            // 设置CRON表达式
            option.setCron("30 */1 * * * ?"); //每分钟执行
            // 立即执行
            option.setStartNow(true);
        }
        return option;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.debug("【订单同步定时任务】定时任务 开始执行:" + ConverterUtil.dateToString(new Date(), ConverterUtil.FORMATE_DATE_TIME_24H));
        if (ConverterUtil.isEmpty(orderSyncService)) {
            orderSyncService = SpringBootContext.getBean(OrderSyncService.class);
        }
        //订单同步定时任务
        orderSyncService.orderSync();
        logger.debug("【订单同步定时任务】定时任务 执行完成:" + ConverterUtil.dateToString(new Date(), ConverterUtil.FORMATE_DATE_TIME_24H));
    }
}
