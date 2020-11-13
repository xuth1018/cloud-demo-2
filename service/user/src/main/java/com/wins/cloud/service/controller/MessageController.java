package com.wins.cloud.service.controller;

import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    @Qualifier("output")
    private MessageChannel messageChannel;
    private final AtomicInteger num = new AtomicInteger(1);

    @RequestMapping(value = "/send")
    public void send(){
        int i = num.getAndIncrement();
        System.out.println("开始发送消息");
        messageChannel.send(MessageBuilder.withPayload("大家好"+i).build());
    }

    @StreamListener(Processor.INPUT)
    public void enrichLogMessage(Message<String> message) {
        System.out.println("监听到消息："+message.getPayload());
    }



}
