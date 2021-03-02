package com.wisea.transac.tp.trade.task;

import java.util.Date;

import com.wisea.transac.tp.trade.service.SettleBillService;
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

/**
 * 自动对账定时任务
 * @author yangtao
 *
 */
@TimerSchedule
public class ReconSettleTask extends DisallowConcurrentJob implements QuartzJob {

    private SettleBillService service;
    /**
     * 定时任务参数
     */
    private QuartzJobOptions option;

    @Override
    public QuartzJobOptions getOption() {
        if (ConverterUtil.isEmpty(option)) {
            option = new QuartzJobOptions("ReconSettleTask", QuartzManager.JOB_GROUP, this.getClass());
            // 设置任务说明
            option.setDescription("自动对账定时任务");
            // 设置触发器名称
            option.setTriggerName("Recon_Settle_Task_every_minute");
            // 设置触发器分组
            option.setTriggerGroupName(QuartzManager.TRIGGER_GROUP);
            // 设置触发器说明
            option.setTriggerDescription("每分钟执行一次【自动对账定时任务】");
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
        logger.debug("【自动对账定时任务】定时任务 开始执行:" + ConverterUtil.dateToString(new Date(), ConverterUtil.FORMATE_DATE_TIME_24H_MLINE));
        if (ConverterUtil.isEmpty(service)) {
            service = SpringBootContext.getBean(SettleBillService.class);
        }
        //自动对账定时任务
        ResultPoJo<Object> resultPoJo = service.findOutReconSettle();
        context.setResult(resultPoJo);
        logger.debug("【自动对账定时任务】定时任务 执行结束:{}", ConverterUtil.dateToString(new Date(), ConverterUtil.FORMATE_DATE_TIME_24H_MLINE));
    }
}
