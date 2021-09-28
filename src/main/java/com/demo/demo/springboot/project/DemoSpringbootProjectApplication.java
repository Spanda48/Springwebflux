package com.demo.demo.springboot.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.demo.demo.springboot.entity.MessageClient;

@SpringBootApplication
@ComponentScan(basePackages = "com.demo.demo.springboot.entity")
public class DemoSpringbootProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoSpringbootProjectApplication.class, args);
		
		MessageClient messageClient = context.getBean(MessageClient.class);
		
		System.out.println(">> message = " + messageClient.getMessage().block());
	}

}
