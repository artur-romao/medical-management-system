package com.mms.medmanagesystem;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableRabbit
@SpringBootApplication
public class MedmanagesystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedmanagesystemApplication.class, args);
	}

}
