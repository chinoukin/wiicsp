package com.wisea.cultivar.origin;

import com.wisea.cloud.monitor.annotation.EnableWbfcMonitor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import com.wisea.cloud.common.annotation.OauthJwtResourceServer;
import com.wisea.cloud.quartz.annotation.EnableWbfcQuartzScheduler;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.wisea.cultivar")
@ComponentScan(basePackages ={"com.wisea.cloud.common","com.wisea.cultivar"})
@MapperScan(basePackages = {"com.wisea.cultivar"})
@OauthJwtResourceServer
@EnableWbfcQuartzScheduler // 开启定时任务
@EnableWbfcMonitor // 开启健康监控
public class CultivarOriginApplication {

    public static void main(String[] args) {
        SpringApplication.run(CultivarOriginApplication.class, args);
    }
}
