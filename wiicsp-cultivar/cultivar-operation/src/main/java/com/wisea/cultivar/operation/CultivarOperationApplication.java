package com.wisea.cultivar.operation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import com.wisea.cloud.backup.annotation.EnableWbfcBackup;
import com.wisea.cloud.common.annotation.OauthJwtResourceServer;
import com.wisea.cloud.files.annotation.EnableWbfcFiles;
import com.wisea.cloud.monitor.annotation.EnableWbfcMonitor;
import com.wisea.cloud.quartz.annotation.EnableWbfcQuartzScheduler;
import com.wisea.cloud.security.annotation.EnableWbfcSecurity;
import com.wisea.cloud.system.annotation.EnableWbfcSystem;
import com.wisea.cloud.tencentim.annotation.EnableWbfcTencentIM;

/**
 * 运营平台-基础框架服务集成
 *
 * @author XuDL(Wisea)
 *
 *         2020年4月1日 下午2:14:51
 */
@ComponentScan(basePackages = { "com.wisea.cultivar.common", "com.wisea.cultivar.operation", "com.wisea.cloud.common", "com.wisea.cloud.tencentim" })
@MapperScan(basePackages = { "com.wisea.cultivar.common.dao", "com.wisea.cultivar.operation" })
@EnableFeignClients(basePackages = { "com.wisea.cultivar.common" })
@SpringBootApplication
@EnableWbfcSecurity // 用户服务
@EnableWbfcFiles // 文件服务
@EnableWbfcSystem // 系统服务
@OauthJwtResourceServer // 接口需要认证
@EnableWbfcTencentIM // 开启即时通讯相关功能
@EnableWbfcBackup // 开启数据备份相关功能applic
@EnableWbfcQuartzScheduler // 开启定时任务
@EnableWbfcMonitor // 开启健康监控
public class CultivarOperationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CultivarOperationApplication.class, args);
    }
}
