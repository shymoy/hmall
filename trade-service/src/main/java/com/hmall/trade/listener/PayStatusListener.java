package com.hmall.trade.listener;

import com.hmall.trade.service.IOrderService;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ClassName: PayStatusListener
 * Package:com.hmall.pay.listener
 * Description:
 *
 * @Author: shymoy
 * @Create: 2025/10/16 -14:58
 * @Version: v1.0
 */
@Component
public class PayStatusListener {
    @Autowired
    private IOrderService iOrderService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "trade.pay.success.queue", durable = "true"),
            exchange = @Exchange(name = "pay.direct"),
            key = "pay.success"
    ))
    public void listenPaySuccess(Long orderId) {
        iOrderService.markOrderPaySuccess(orderId);
    }
}
