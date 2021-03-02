package com.wisea.transac.tp.trade.task;

import com.wisea.cloud.common.annotation.TimerSchedule;
import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.quartz.QuartzManager;
import com.wisea.cloud.quartz.entity.QuartzJob;
import com.wisea.cloud.quartz.entity.QuartzJobOptions;
import com.wisea.cloud.quartz.job.DisallowConcurrentJob;
import com.wisea.transac.common.entity.SettleBill;
import com.wisea.transac.tp.trade.service.SettleBillService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;
import java.util.List;

/**
 * @Author jirg
 * @Date 2019/8/21 17:12
 * @Description 取消结算单定时任务
 **/
@TimerSchedule
public class CancelSettleBillTask extends DisallowConcurrentJob implements QuartzJob {

    private SettleBillService service;
    /**
     * 定时任务参数
     */
    private QuartzJobOptions option;

    @Override
    public QuartzJobOptions getOption() {
        if (ConverterUtil.isEmpty(option)) {
            option = new QuartzJobOptions("CancelSettleBillTask", QuartzManager.JOB_GROUP, this.getClass());
            // 设置任务说明
            option.setDescription("取消结算单定时任务");
            // 设置触发器名称
            option.setTriggerName("Cancel_Settle_Bill_Task_every_day");
            // 设置触发器分组
            option.setTriggerGroupName(QuartzManager.TRIGGER_GROUP);
            // 设置触发器说明
            option.setTriggerDescription("每天0点执行一次【取消结算单定时任务】");
            // 设置CRON表达式
            option.setCron("5 0 0 */1 * ?"); //每天0点执行
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
        logger.debug("【取消结算单】定时任务 开始执行:" + ConverterUtil.dateToString(new Date(), ConverterUtil.FORMATE_DATE_TIME_24H_MLINE));
        if (ConverterUtil.isEmpty(service)) {
            service = SpringBootContext.getBean(SettleBillService.class);
        }
        //取消结算单定时任务
        ResultPoJo<List<SettleBill>> resultPoJo = service.cancelSettleBillTask();
        context.setResult(resultPoJo);
        logger.debug("【取消结算单】定时任务 执行结束:{}", ConverterUtil.dateToString(new Date(), ConverterUtil.FORMATE_DATE_TIME_24H_MLINE));
    }
}
