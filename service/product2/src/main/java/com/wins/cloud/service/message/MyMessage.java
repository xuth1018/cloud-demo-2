package com.wins.cloud.service.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MyMessage {

    String out = "myMessageOut";
    String in = "myMessageIn";

    @Output(out)
    MessageChannel messageout();

    @Input(in)
    SubscribableChannel messagein();

}
