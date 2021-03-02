package com.wisea.cultivar.origin.schedule.task;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.wisea.cloud.common.annotation.TimerSchedule;
import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.quartz.QuartzManager;
import com.wisea.cloud.quartz.entity.QuartzJob;
import com.wisea.cloud.quartz.entity.QuartzJobOptions;
import com.wisea.cloud.quartz.job.DisallowConcurrentJob;
import com.wisea.cultivar.origin.service.SampInfoService;

/**
 * 样品的定时器任务
 *
 * @author wangh(wisea)
 *
 * @date 2018年9月19日
 * @version 1.0
 */
@TimerSchedule
public class SampInfoTask extends DisallowConcurrentJob implements QuartzJob {

	@Autowired
	private SampInfoService sampInfoService;
	/** 定时任务参数 */
    private QuartzJobOptions option;

    /**
     * 执行定时器
     */
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.debug("【刷新样品检测的状态】定时任务 开始执行:" + ConverterUtil.dateToString(new Date(), ConverterUtil.FORMATE_DATE_TIME_24H));
		if(ConverterUtil.isEmpty(sampInfoService)){
			sampInfoService= SpringBootContext.getBean(SampInfoService.class);
        }
		sampInfoService.freshen();
        logger.debug("run test task");
        logger.debug("【刷新样品检测的状态】定时任务 执行完成:" + ConverterUtil.dateToString(new Date(), ConverterUtil.FORMATE_DATE_TIME_24H));

	}

	/**
	 * 设置定时器的参数
	 */
	@Override
	public QuartzJobOptions getOption() {
		if (ConverterUtil.isEmpty(option)) {
            option = new QuartzJobOptions("SampInfoTask", QuartzManager.JOB_GROUP, this.getClass());
            // 设置任务说明
            option.setDescription("刷新样品检测的状态");
            // 设置触发器名称
            option.setTriggerName("SampInfoTask_every_day");
            // 设置触发器分组
            option.setTriggerGroupName(QuartzManager.TRIGGER_GROUP);
            // 设置触发器说明
            option.setTriggerDescription("每小时过10分执行一次【刷新样品检测的状态】");
            // 设置CRON表达式
            option.setCron("0 10 * * * ?");
            //option.setCron("0 0/5 * * * ?");
            // 立即执行
            option.setStartNow(true);
        }
        return option;
	}

}
