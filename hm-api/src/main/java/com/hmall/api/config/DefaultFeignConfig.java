package com.hmall.api.config;

import com.hmall.common.utils.UserContext;
import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

/**
 * ClassName: DefaultFeignConfig
 * Package:com.hmall.api.config
 * Description:
 *
 * @Author: shymoy
 * @Create: 2025/10/1 -10:45
 * @Version: v1.0
 */
public class DefaultFeignConfig {
    @Bean
    public Logger.Level feignLogLevel(){
        return Logger.Level.FULL;
    }

    @Bean
    public RequestInterceptor userinfoRequestInterceptor(){
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                Long user = UserContext.getUser();
                if (user != null) {
                    requestTemplate.header("user-info", user.toString());
                }
            }
        };
    }
}
