package com.example.rabbitmq_provider.bean;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 消息发送者
 */
@Component
public class Sender {

    /**
     * 交换器名称
     */
    @Value("${mq.config.exchange}")
    private String exchange;

    /**
     * 交换器名称
     */
    @Value("${mq.config.queue.error.routing.key}")
    private String routingKey;

    @Autowired
    private AmqpTemplate rabbit;

    public void send(String message){
        /**
         * 参数一：交换器名称
         * 参数二：路由键
         * 参数三：消息
         */
        this.rabbit.convertAndSend(this.exchange,this.routingKey, message);
    }
}
