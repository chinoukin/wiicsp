package com.wisea.transac.operation;

import com.wisea.cloud.backup.annotation.EnableWbfcBackup;
import com.wisea.cloud.common.annotation.OauthJwtResourceServer;
import com.wisea.cloud.files.annotation.EnableWbfcFiles;
import com.wisea.cloud.monitor.annotation.EnableWbfcMonitor;
import com.wisea.cloud.quartz.annotation.EnableWbfcQuartzScheduler;
import com.wisea.cloud.seata.annotation.EnableWbfcSeata;
import com.wisea.cloud.security.annotation.EnableWbfcSecurity;
import com.wisea.cloud.system.annotation.EnableWbfcSystem;
import com.wisea.cloud.tencentim.annotation.EnableWbfcTencentIM;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 新盟风控果品产业互联网综合服务平台-交易服务-运营平台-基础框架服务集成
 *
 * @author XuDL(Wisea)
 *
 *         2020年4月1日 下午2:14:51
 */
@EnableFeignClients(basePackages = { "com.wisea.transac" })
@ComponentScan(basePackages = { "com.wisea.cloud.common", "com.wisea.transac" })
@MapperScan(basePackages = { "com.wisea.transac" })
@SpringBootApplication
@EnableWbfcSecurity // 用户服务
@EnableWbfcFiles // 文件服务
@EnableWbfcSystem // 系统服务
@OauthJwtResourceServer // 接口需要认证
@EnableWbfcTencentIM // 开启即时通讯相关功能
@EnableWbfcBackup // 开启数据备份相关功能
@EnableWbfcQuartzScheduler // 开启定时任务
@EnableWbfcMonitor // 开启健康监控
@EnableWbfcSeata
public class TransacOperationApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransacOperationApplication.class, args);
    }
}
