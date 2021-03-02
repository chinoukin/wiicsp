package com.wisea.cultivar.plant.schedule;

import com.wisea.cloud.common.annotation.TimerSchedule;
import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.quartz.QuartzManager;
import com.wisea.cloud.quartz.entity.QuartzJob;
import com.wisea.cloud.quartz.entity.QuartzJobOptions;
import com.wisea.cloud.quartz.job.DisallowConcurrentJob;
import com.wisea.cultivar.plant.service.SerListMageService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @ClassNameSerListMage
 * @Description
 * @Author zhangbo
 * @Date2020/8/10 14:47
 **/
@TimerSchedule
public class SerListMageCancleTaskService extends DisallowConcurrentJob implements QuartzJob {

    /**
     * 定时任务参数
     */
    private QuartzJobOptions option;

    @Override
    public QuartzJobOptions getOption() {
        if (ConverterUtil.isEmpty(option)) {
            option = new QuartzJobOptions("cancleSerListMageTask", QuartzManager.JOB_GROUP, this.getClass());
            // 设置任务说明
            option.setDescription("服务单自动取消");
            // 设置触发器名称
            option.setTriggerName("cancle_serListMageTask");
            // 设置触发器分组
            option.setTriggerGroupName(QuartzManager.TRIGGER_GROUP);
            // 设置触发器说明
            option.setTriggerDescription("每隔一分钟执行一次【服务单自动取消】");
            // 设置CRON表达式
            option.setCron("0 */1 * * * ?");
            // 立即执行
            option.setStartNow(true);
        }
        return option;

    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.debug("【服务单取消定时任务】定时任务 开始执行:" + ConverterUtil.dateToString(new Date(), ConverterUtil.FORMATE_DATE_TIME_24H));
        try {
            // 定时任务因为是单独的线程池启动，不受SpringContext管理，所以若需要使用Service或Dao等不能直接注入，要从SpringBootContext里get
            SerListMageService serListMageService = SpringBootContext.getBean(SerListMageService.class);
            serListMageService.cancleSerListMageTask();
        } catch (Exception e) {
            logger.error("exception in TestTask", e);
        }

        logger.debug("【服务单取消定时任务】定时任务 执行完成:" + ConverterUtil.dateToString(new Date(), ConverterUtil.FORMATE_DATE_TIME_24H));

    }
}
