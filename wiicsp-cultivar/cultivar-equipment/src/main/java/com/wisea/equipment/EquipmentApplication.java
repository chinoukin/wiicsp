package com.wisea.equipment;

import com.wisea.cloud.common.annotation.OauthJwtResourceServer;
import com.wisea.cloud.influxdb.annotation.EnableWbfcInfluxdb;
import com.wisea.cloud.monitor.annotation.EnableWbfcMonitor;
import com.wisea.cloud.quartz.annotation.EnableWbfcQuartzScheduler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author jirg
 * @version 1.0
 * @className EquipmentApplication
 * @date 2020/7/6 14:36
 * @Description 设备服务，设备厂商、设备型号、设备管理。定时获取设备信息，提供信息展示。
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = { "com.wisea.cloud.common", "com.wisea.equipment" })
@MapperScan(basePackages = { "com.wisea.equipment" })
@EnableWbfcMonitor
@OauthJwtResourceServer
@EnableWbfcQuartzScheduler
@EnableWbfcInfluxdb
public class EquipmentApplication {
    public static void main(String[] args) {
        SpringApplication.run(EquipmentApplication.class, args);
    }
}
