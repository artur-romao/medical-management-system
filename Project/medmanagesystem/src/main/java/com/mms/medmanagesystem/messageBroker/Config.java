package com.mms.medmanagesystem.messageBroker;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //needed
public class Config {
    public static final String hbq = "hb";
    public static final String oxiq = "oxi";
    public static final String tempq = "temp";
    public static final String pressq = "press";
    public static final String[] QUEUE = {hbq, oxiq, tempq, pressq};

    public static final String EXCHANGE_NAME = "";
    @Bean
	Queue queue1() { return new Queue(pressq, true); }

    @Bean
	Queue queue2() { return new Queue(tempq, true); }

    @Bean
	Queue queue3() { return new Queue(oxiq, true); }

    @Bean
	Queue queue4() { return new Queue(hbq, true); }


    @Bean
	DirectExchange exchange() { return new DirectExchange(EXCHANGE_NAME); }

    @Bean
    Binding binding1(@Qualifier("queue1") Queue queue, DirectExchange exchange) { return BindingBuilder.bind(queue).to(exchange).with(pressq); }

    @Bean
    Binding binding4(@Qualifier("queue4") Queue queue, DirectExchange exchange) { return BindingBuilder.bind(queue).to(exchange).with(hbq); }

    @Bean
    Binding binding3(@Qualifier("queue3") Queue queue, DirectExchange exchange) { return BindingBuilder.bind(queue).to(exchange).with(oxiq); }

    @Bean
    Binding binding2(@Qualifier("queue2") Queue queue, DirectExchange exchange) { return BindingBuilder.bind(queue).to(exchange).with(tempq); }
    

    @Bean
    public newConsumer receiver() { return new newConsumer(); }
} 