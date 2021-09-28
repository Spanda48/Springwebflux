package com.demo.demo.springboot.project;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.core.DatabaseClient;

import com.demo.demo.springboot.Repository.MessageRepository;
import com.demo.demo.springboot.entity.IncomingMessage;

import reactor.core.publisher.Flux;

@SpringBootApplication
@ComponentScan(basePackages = "com.demo.demo.springboot.Repository")
@Configuration
@ComponentScan(basePackages = "com.demo.demo.springboot.entity")
public class DemoSpringbootProjectApplication {

	public static void main(String[] args) {
		//ConfigurableApplicationContext context =
				
				SpringApplication.run(DemoSpringbootProjectApplication.class, args);
		
		
		
	}		
		
		
		/*
		 * MessageClient messageClient = context.getBean(MessageClient.class);
		 * 
		 * System.out.println(">> message = " + messageClient.getMessage().block());
		 */
				
	@Bean
	ApplicationRunner init(MessageRepository messageRepository, DatabaseClient client) {
		return args -> {
			client.execute("create table IF NOT EXISTS IncomingMessage (message varchar (255) not null);").fetch().first().subscribe();
			client.execute("DELETE FROM IncomingMessage;").fetch().first().subscribe();

			Stream<IncomingMessage> stream = Stream.of(new IncomingMessage("Hi this is my first message!"),
					new IncomingMessage( "This one I have acomplished!"));

			// initialize the database

			messageRepository.saveAll(Flux.fromStream(stream)).then().subscribe(); // execute

		};

	}

}
