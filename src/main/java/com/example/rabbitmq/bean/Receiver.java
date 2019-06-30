package com.example.rabbitmq.bean;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息接收者
 */
@Component
public class Receiver {

    @Autowired
    private AmqpTemplate rabbit;

    /**
     * 接收消息方法
     * @param message
     */
    @RabbitListener(queues = "hello-queue")
    public void process(String message){
        System.out.println("receiver: "+ message);
    }
}
