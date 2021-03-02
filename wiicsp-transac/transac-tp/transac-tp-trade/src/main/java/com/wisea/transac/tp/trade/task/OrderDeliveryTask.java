package com.wisea.transac.tp.trade.task;

import com.wisea.cloud.common.annotation.TimerSchedule;
import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.quartz.QuartzManager;
import com.wisea.cloud.quartz.entity.QuartzJob;
import com.wisea.cloud.quartz.entity.QuartzJobOptions;
import com.wisea.cloud.quartz.job.DisallowConcurrentJob;
import com.wisea.transac.common.entity.OrderInfo;
import com.wisea.transac.tp.trade.service.OrderInfoService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;
import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className OrderDeliveryTask
 * @date 2020/5/26 16:35
 * @Description 订单超时提货定时任务 - 订单状态修改为【争议订单】
 */
@TimerSchedule
public class OrderDeliveryTask extends DisallowConcurrentJob implements QuartzJob {
    private OrderInfoService service;
    /**
     * 定时任务参数
     */
    private QuartzJobOptions option;

    @Override
    public QuartzJobOptions getOption() {
        if (ConverterUtil.isEmpty(option)) {
            option = new QuartzJobOptions("OrderDeliveryTask", QuartzManager.JOB_GROUP, this.getClass());
            // 设置任务说明
            option.setDescription("订单超时提货定时任务");
            // 设置触发器名称
            option.setTriggerName("Order_Delivery_Task_every_day");
            // 设置触发器分组
            option.setTriggerGroupName(QuartzManager.TRIGGER_GROUP);
            // 设置触发器说明
            option.setTriggerDescription("每天0点0分15秒执行一次【订单超时提货定时任务】");
            // 设置CRON表达式
            option.setCron("15 0 0 */1 * ?"); //每天0点0分15秒执行
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
        logger.debug("【订单超时提货定时任务】定时任务 开始执行:" + ConverterUtil.dateToString(new Date(), ConverterUtil.FORMATE_DATE_TIME_24H_MLINE));
        if (ConverterUtil.isEmpty(service)) {
            service = SpringBootContext.getBean(OrderInfoService.class);
        }
        //逾期结算单定时任务
        ResultPoJo<List<OrderInfo>> resultPoJo = service.orderDeliveryTask();
        context.setResult(resultPoJo);
        logger.debug("【订单超时提货定时任务】定时任务 执行结束:{}", ConverterUtil.dateToString(new Date(), ConverterUtil.FORMATE_DATE_TIME_24H_MLINE));
    }
}
