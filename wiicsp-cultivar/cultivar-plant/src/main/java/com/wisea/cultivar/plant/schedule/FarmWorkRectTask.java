package com.wisea.cultivar.plant.schedule;

import com.wisea.cloud.common.annotation.TimerSchedule;
import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.quartz.QuartzManager;
import com.wisea.cloud.quartz.entity.QuartzJob;
import com.wisea.cloud.quartz.entity.QuartzJobOptions;
import com.wisea.cloud.quartz.job.DisallowConcurrentJob;
import com.wisea.cultivar.plant.service.oritrapla.ArchManageService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;


/**
 * 自动刷新农事记录状态定时任务
 * @author yangtao
 * @version 1.0
 *
 */
@TimerSchedule
public class FarmWorkRectTask extends DisallowConcurrentJob implements QuartzJob {

  private ArchManageService archManageService;
  /**
   * 定时任务参数
   */
  private QuartzJobOptions option;

  @Override
  public QuartzJobOptions getOption() {
    if (ConverterUtil.isEmpty(option)) {
      option = new QuartzJobOptions("FarmWorkRectTask", QuartzManager.JOB_GROUP, this.getClass());
      // 设置任务说明
      option.setDescription("自动刷新农事记录状态定时任务");
      // 设置触发器名称
      option.setTriggerName("farm_work_every_minute");
      // 设置触发器分组
      option.setTriggerGroupName(QuartzManager.TRIGGER_GROUP);
      // 设置触发器说明
      option.setTriggerDescription("每天晚上00点执行一次【自动刷新农事记录状态定时任务】");
      // 设置CRON表达式
      option.setCron("0 1 0 * * ?");
      //option.setCron("10 */1 * * * ?");
      // 立即执行
      option.setStartNow(true);
    }
    return option;

  }

  @Override
  public void execute(JobExecutionContext context) throws JobExecutionException {

      logger.debug("【自动刷新农事记录状态定时任务】定时任务 开始执行:" + ConverterUtil.dateToString(new Date(), ConverterUtil.FORMATE_DATE_TIME_24H));
      if (ConverterUtil.isEmpty(archManageService)) {
    	  archManageService = SpringBootContext.getBean(ArchManageService.class);
      }
      //自动刷新农事记录状态
      archManageService.farmWorkTask();
      logger.debug("【自动刷新农事记录状态定时任务】定时任务 执行完成:" + ConverterUtil.dateToString(new Date(), ConverterUtil.FORMATE_DATE_TIME_24H));
  }
}
