package com.hmall.api.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

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
}
