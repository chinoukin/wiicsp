package com.wisea.transac.tp.trade.task;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.wisea.cloud.common.annotation.TimerSchedule;
import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.quartz.QuartzManager;
import com.wisea.cloud.quartz.entity.QuartzJob;
import com.wisea.cloud.quartz.entity.QuartzJobOptions;
import com.wisea.cloud.quartz.job.DisallowConcurrentJob;
import com.wisea.transac.tp.trade.service.OrderInfoService;

/**
 * 取消订单定时任务（待确认、待付款超时）
 * @author yangtao
 *
 */
@TimerSchedule
public class OrderCancelTask extends DisallowConcurrentJob implements QuartzJob {

    private OrderInfoService service;
    /**
     * 定时任务参数
     */
    private QuartzJobOptions option;

    @Override
    public QuartzJobOptions getOption() {
        if (ConverterUtil.isEmpty(option)) {
            option = new QuartzJobOptions("OrderCancelTask", QuartzManager.JOB_GROUP, this.getClass());
            // 设置任务说明
            option.setDescription("取消订单定时任务");
            // 设置触发器名称
            option.setTriggerName("Order_Cancel_Task_every_minute");
            // 设置触发器分组
            option.setTriggerGroupName(QuartzManager.TRIGGER_GROUP);
            // 设置触发器说明
            option.setTriggerDescription("每分钟执行一次【取消订单定时任务】");
            // 设置CRON表达式
            option.setCron("30 */1 * * * ?"); //每分钟执行
            // 立即执行
            option.setStartNow(true);
        }
        return option;
    }

    /**
     * 具体执行的任务
     * @param context
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.debug("【取消订单】定时任务 开始执行:" + ConverterUtil.dateToString(new Date(), ConverterUtil.FORMATE_DATE_TIME_24H_MLINE));
        if (ConverterUtil.isEmpty(service)) {
            service = SpringBootContext.getBean(OrderInfoService.class);
        }
        //取消订单定时任务
        ResultPoJo<Object> resultPoJo = service.orderCancelTask();
        context.setResult(resultPoJo);
        logger.debug("【取消订单】定时任务 执行结束:{}", ConverterUtil.dateToString(new Date(), ConverterUtil.FORMATE_DATE_TIME_24H_MLINE));
    }
}
