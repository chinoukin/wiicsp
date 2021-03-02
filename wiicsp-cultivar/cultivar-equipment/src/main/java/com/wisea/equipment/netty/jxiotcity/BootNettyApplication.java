package com.wisea.equipment.netty.jxiotcity;

import com.wisea.equipment.config.JxiotcityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;


/**
 * netty服务端服务启动类
 * @author chengq
 * @date 2020/11/24 10:49
 */
@Component
@EnableAsync
@ConditionalOnProperty(name = "equipment.jxiotcity.enable", havingValue = "true", matchIfMissing = false)
public class BootNettyApplication implements CommandLineRunner {
	@Autowired
	private JxiotcityConfig config;

	@Async
	@Override
	public void run(String... args){
		//使用异步注解方式启动netty服务端服务
		new BootNettyServer().bind(config.getPort());
	}
}
