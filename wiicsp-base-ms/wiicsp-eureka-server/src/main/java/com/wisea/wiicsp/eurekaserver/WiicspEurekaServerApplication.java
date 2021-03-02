package com.wisea.wiicsp.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 新盟风控果品产业互联网综合服务平台-基础服务-Eureka服务
 *
 * @author XuDL(Wisea)
 *
 *         2020年4月1日 上午11:09:05
 */
@SpringBootApplication
@EnableEurekaServer
public class WiicspEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WiicspEurekaServerApplication.class, args);
    }
}
