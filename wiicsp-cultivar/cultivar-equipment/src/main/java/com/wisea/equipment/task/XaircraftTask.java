package com.wisea.equipment.task;

import com.wisea.cloud.common.annotation.TimerSchedule;
import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.quartz.QuartzManager;
import com.wisea.cloud.quartz.entity.QuartzJob;
import com.wisea.cloud.quartz.entity.QuartzJobOptions;
import com.wisea.cloud.quartz.job.DisallowConcurrentJob;
import com.wisea.equipment.service.task.XaircraftTaskService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

/**
 * @author jirg
 * @version 1.0
 * @className XaircraftTask
 * @date 2019/6/25 16:45
 * @Description 极飞物联定时任务
 */
@TimerSchedule
public class XaircraftTask extends DisallowConcurrentJob implements QuartzJob {
    @Value("${equipment.xaircraft.enable:false}")
    private Boolean enabled;

    @Autowired(required = false)
    private XaircraftTaskService service;
    /**
     * 定时任务参数
     */
    private QuartzJobOptions option;

    @Override
    public QuartzJobOptions getOption() {
        if (ConverterUtil.isEmpty(option)) {
            option = new QuartzJobOptions("XaircraftTask", QuartzManager.JOB_GROUP, this.getClass());
            // 设置任务说明
            option.setDescription("极飞物联抓取数据定时任务");
            // 设置触发器名称
            option.setTriggerName("xaircraft_task_every_five_minutes");
            // 设置触发器分组0
            option.setTriggerGroupName(QuartzManager.TRIGGER_GROUP);
            // 设置触发器说明
            option.setTriggerDescription("每7分钟执行一次【极飞物联抓取数据定时任务】");
            // 设置CRON表达式
            option.setCron("25 0/7 * * * ? ");
            //设置定时任务是否有效
            option.setEnabled(enabled);
            // 立即执行
            option.setStartNow(true);
        }
        return option;

    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.debug("【极飞物联抓取数据定时任务】定时任务 开始执行:" + ConverterUtil.dateToString(new Date(), ConverterUtil.FORMATE_DATE_TIME_24H));
        //极飞物联抓取数据定时任务
        if (ConverterUtil.isEmpty(service)) {
            service = SpringBootContext.getBean(XaircraftTaskService.class);
        }
        if (ConverterUtil.isNotEmpty(service)) {
            service.xaircraftTask();
            logger.debug("【极飞物联抓取数据定时任务】定时任务 执行完成:" + ConverterUtil.dateToString(new Date(), ConverterUtil.FORMATE_DATE_TIME_24H));
        }else{
            logger.warn("XaircraftTaskService Not Loaded!");
        }
    }
}
