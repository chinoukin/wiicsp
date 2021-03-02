package com.wisea.transac.tp.system;

import com.wisea.cloud.common.annotation.OauthJwtResourceServer;
import com.wisea.cloud.monitor.annotation.EnableWbfcMonitor;
import com.wisea.cloud.quartz.annotation.EnableWbfcQuartzScheduler;
import com.wisea.cloud.seata.annotation.EnableWbfcSeata;
import com.wisea.yspay.annotation.EnablePayYspay;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author jirg
 * @Date 2020/4/28 15:31
 * @Description 新盟风控果品产业互联网综合服务平台-交易服务-系统设置服务
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = { "com.wisea.transac" })
@ComponentScan(basePackages = { "com.wisea.cloud.common", "com.wisea.transac" })
@MapperScan(basePackages = { "com.wisea.transac" })
@OauthJwtResourceServer
@EnableWbfcQuartzScheduler // 开启定时任务
@EnableWbfcMonitor // 开启健康监控
@EnablePayYspay
@EnableWbfcSeata
//@CORS
public class TransacTpSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(TransacTpSystemApplication.class, args);
    }
}
