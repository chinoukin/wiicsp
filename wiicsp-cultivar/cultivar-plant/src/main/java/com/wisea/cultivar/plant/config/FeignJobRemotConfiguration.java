package com.wisea.cultivar.plant.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.feign.interceptor.StaticAuthInterceptor;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;

/**
 * feign-formdata配置项
 *
 * @author XuDL(Wisea)
 *
 *         2018年1月30日 下午5:17:25
 */
@Configuration
public class FeignJobRemotConfiguration {

    /** 读取配置文件中的静态token */
    @Value("${wbfc.security.staticToken:}")
    public String staticToken;

    public String getStaticToken() {
        return staticToken;
    }

    public void setStaticToken(String staticToken) {
        this.staticToken = staticToken;
    }

    @Bean
    public StaticAuthInterceptor StaticAuthInterceptor() {
        // 默认是所有url都进行设置的(/**)，如果有需要可以添加url数组
        // StaticAuthInterceptor interceptor = new StaticAuthInterceptor("/**");
        StaticAuthInterceptor interceptor = new StaticAuthInterceptor();
        if (ConverterUtil.isNotEmpty(staticToken)) {
            interceptor.setStaticToken(staticToken);
        }
        return interceptor;
    }
}
