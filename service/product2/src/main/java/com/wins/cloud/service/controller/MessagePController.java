package com.wins.cloud.service.controller;

import com.wins.cloud.service.message.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/message")
@EnableBinding(MyMessage.class)
public class MessagePController {

    private AtomicInteger count = new AtomicInteger();
    private AtomicInteger count2 = new AtomicInteger();

    @Autowired
    private MyMessage myMessage;

    @RequestMapping(value = "/send/{mess}", method = RequestMethod.GET)
    public int sendMessage(@PathVariable("mess") String mess){
        myMessage.messageout().send(MessageBuilder.withPayload(mess).build());
        System.out.println(LocalDateTime.now()+" ---sendMessage()---send message: "+mess);
        return count.getAndIncrement();
    }

    @StreamListener(MyMessage.in)
    public void receive(String mess){
        System.out.println(count2.getAndIncrement()+" "+LocalDateTime.now()+"product2---receive()---receive message: "+mess);
    }
}
