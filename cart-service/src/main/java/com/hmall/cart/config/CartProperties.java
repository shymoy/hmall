package com.hmall.cart.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * ClassName: CartProperties
 * Package:com.hmall.cart.config
 * Description:
 *
 * @Author: shymoy
 * @Create: 2025/10/14 -23:56
 * @Version: v1.0
 */
@ConfigurationProperties(prefix = "hm.cart")
@Component
@Data
public class CartProperties {
    private Integer maxItems;
}
