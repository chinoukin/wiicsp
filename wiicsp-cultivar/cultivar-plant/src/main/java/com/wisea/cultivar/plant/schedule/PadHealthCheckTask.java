package com.wisea.cultivar.plant.schedule;

import com.wisea.cloud.common.annotation.TimerSchedule;
import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.quartz.QuartzManager;
import com.wisea.cloud.quartz.entity.QuartzJob;
import com.wisea.cloud.quartz.entity.QuartzJobOptions;
import com.wisea.cloud.quartz.job.DisallowConcurrentJob;
import com.wisea.cultivar.plant.service.oritrapla.PadMageService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;


/**
 * @author jirg
 * @date 2020/8/11 16:42
 * @Description 病虫害监测定时任务
 */
@TimerSchedule
public class PadHealthCheckTask extends DisallowConcurrentJob implements QuartzJob {

    private PadMageService padMageService;
    /**
     * 定时任务参数
     */
    private QuartzJobOptions option;

    @Override
    public QuartzJobOptions getOption() {
        if (ConverterUtil.isEmpty(option)) {
            option = new QuartzJobOptions("PadHealthCheckTask", QuartzManager.JOB_GROUP, this.getClass());
            // 设置任务说明
            option.setDescription("病虫害监测定时任务");
            // 设置触发器名称
            option.setTriggerName("pad_health_check_task_every_five_minute");
            // 设置触发器分组
            option.setTriggerGroupName(QuartzManager.TRIGGER_GROUP);
            // 设置触发器说明
            option.setTriggerDescription("每五分钟执行一次【病虫害监测定时任务】");
            // 设置CRON表达式
            option.setCron("0 */5 * * * ?");
            // 立即执行
            option.setStartNow(true);
        }
        return option;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.debug("【病虫害监测定时任务】定时任务 开始执行:" + ConverterUtil.dateToString(new Date(), ConverterUtil.FORMATE_DATE_TIME_24H));
        if (ConverterUtil.isEmpty(padMageService)) {
            padMageService = SpringBootContext.getBean(PadMageService.class);
        }
        //病虫害监测定时任务
        padMageService.healthCheck();
        logger.debug("【病虫害监测定时任务】定时任务 执行完成:" + ConverterUtil.dateToString(new Date(), ConverterUtil.FORMATE_DATE_TIME_24H));
    }
}
