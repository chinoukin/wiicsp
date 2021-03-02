package com.wisea.cultivar;

import com.wisea.cloud.common.annotation.OauthJwtResourceServer;
import com.wisea.cloud.monitor.annotation.EnableWbfcMonitor;
import com.wisea.cloud.tencentim.annotation.EnableWbfcTencentIM;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 产业标准管理系统
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.wisea.cultivar"})
@ComponentScan(basePackages = { "com.wisea.cloud.common", "com.wisea.cultivar" })
@MapperScan(basePackages = { "com.wisea.cultivar" })
@OauthJwtResourceServer
@EnableWbfcMonitor // 开启健康监控
@EnableWbfcTencentIM // 开启TIM通讯
@EnableScheduling //开启定时注解
public class CultivarStandardsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CultivarStandardsApplication.class, args);
    }
}
