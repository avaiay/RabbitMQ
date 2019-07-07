package com.example.rabbitmq_consumer.bean;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 消息接收者
 * bingdings:绑定队列
 */
@Component
@RabbitListener(
        bindings =  @QueueBinding(
                value=@Queue(value="${mq.config.queue.info}",autoDelete = "true"),
                exchange = @Exchange(value = "${mq.config.exchange}"),
                key = "${mq.config.queue.info.routing.key}"
        )
)
public class InfoReceiver {

    /**
     * 接收消息方法
     * @param message
     */
    @RabbitHandler
    public void process(String message){
        System.out.println("info......receiver: "+ message);
    }
}
