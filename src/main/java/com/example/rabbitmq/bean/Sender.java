package com.example.rabbitmq.bean;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息发送者
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbit;

    public void send(String message){
        this.rabbit.convertAndSend("hello-queue", message);
    }
}
