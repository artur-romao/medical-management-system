package com.mms.medmanagesystem;
import com.mms.medmanagesystem.messageBroker.MQConsumer;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableRabbit
@SpringBootApplication 
public class MedmanagesystemApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MedmanagesystemApplication.class, args);
		MQConsumer.main(args);
	}

}
