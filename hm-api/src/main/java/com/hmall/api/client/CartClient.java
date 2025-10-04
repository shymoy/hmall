package com.hmall.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

/**
 * ClassName: CartClient
 * Package:com.hmall.api.client
 * Description:
 *
 * @Author: shymoy
 * @Create: 2025/10/4 -21:46
 * @Version: v1.0
 */
@FeignClient("cart-service")
public interface CartClient {
    @DeleteMapping("/carts")
    void removeByItemIds(@RequestParam("ids") Collection<Long> ids);
}
