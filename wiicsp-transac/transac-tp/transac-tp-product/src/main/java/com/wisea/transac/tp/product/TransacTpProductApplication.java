package com.wisea.transac.tp.product;

import com.wisea.cloud.common.annotation.OauthJwtResourceServer;
import com.wisea.cloud.monitor.annotation.EnableWbfcMonitor;
import com.wisea.cloud.quartz.annotation.EnableWbfcQuartzScheduler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = { "com.wisea.transac.common" ,"com.wisea.transac.tp.product.mss"})
@ComponentScan(basePackages = { "com.wisea.cloud.common", "com.wisea.transac.common", "com.wisea.transac.tp.product" })
@MapperScan(basePackages = { "com.wisea.transac" })
@OauthJwtResourceServer
@EnableWbfcQuartzScheduler
@EnableWbfcMonitor
public class TransacTpProductApplication {

    public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(TransacTpProductApplication.class, args);
    }
}
