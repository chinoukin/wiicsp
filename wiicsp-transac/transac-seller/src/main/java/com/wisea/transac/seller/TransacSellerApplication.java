package com.wisea.transac.seller;

import com.wisea.cloud.common.annotation.OauthJwtResourceServer;
import com.wisea.cloud.monitor.annotation.EnableWbfcMonitor;
import com.wisea.cloud.seata.annotation.EnableWbfcSeata;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 新盟风控果品产业互联网综合服务平台-交易服务-商家端APP服务
 *
 * @author XuDL(Wisea)
 *
 *         2020年5月8日 下午4:10:52
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = { "com.wisea.transac.common", "com.wisea.transac.seller" })
@ComponentScan(basePackages = { "com.wisea.cloud.common", "com.wisea.transac" })
@MapperScan(basePackages = { "com.wisea.transac" })
@OauthJwtResourceServer
@EnableWbfcMonitor
@EnableWbfcSeata
public class TransacSellerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TransacSellerApplication.class, args);
    }
}
