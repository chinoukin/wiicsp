package com.wisea.equipment.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author jirg
 * @Date 2020/11/30 9:15
 * @Description
 **/
@Component
@ConfigurationProperties(prefix = "equipment.jxiotcity")
public class JxiotcityConfig {
    private Integer port; //监听端口
    private Integer pingInterval; //心跳间隔

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getPingInterval() {
        return pingInterval;
    }

    public void setPingInterval(Integer pingInterval) {
        this.pingInterval = pingInterval;
    }
}
