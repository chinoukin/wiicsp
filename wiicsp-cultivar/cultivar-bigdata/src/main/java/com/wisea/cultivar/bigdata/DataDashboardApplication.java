package com.wisea.cultivar.bigdata;

import com.wisea.cloud.common.annotation.CORS;
import com.wisea.cloud.monitor.annotation.EnableWbfcMonitor;
import com.wisea.cloud.quartz.annotation.EnableWbfcQuartzScheduler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 大数据展示平台
 *
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.wisea.cultivar"})
@EnableFeignClients
@ComponentScan(basePackages = { "com.wisea.cloud.common", "com.wisea.cultivar.bigdata" })
@EnableWbfcMonitor // 开启健康监控
@EnableWbfcQuartzScheduler
@EnableEurekaClient
public class DataDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataDashboardApplication.class, args);
    }

}
