package com.mms.medmanagesystem.messageBroker;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class MQConsumer {

    @RabbitListener(queues = Config.QUEUE)
    public void listen(String input) {
        System.out.println("   Receiver#receive input: " + input);
    }

}