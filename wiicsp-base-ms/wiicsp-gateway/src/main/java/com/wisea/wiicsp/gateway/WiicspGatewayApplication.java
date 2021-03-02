package com.wisea.wiicsp.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.wisea.cloud.gateway.annotation.EnableWbfcGateway;

/**
 * 新盟风控果品产业互联网综合服务平台-基础服务-网关
 *
 * @author XuDL(Wisea)
 *
 *         2020年4月1日 上午11:18:29
 */
@SpringBootApplication
@EnableWbfcGateway
@EnableEurekaClient
public class WiicspGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(WiicspGatewayApplication.class, args);
    }
}
