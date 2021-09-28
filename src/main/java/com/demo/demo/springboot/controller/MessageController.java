package com.demo.demo.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.springboot.Repository.MessageRepository;
import com.demo.demo.springboot.entity.IncomingMessage;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class MessageController {
	
	private MessageRepository messageRepository;

	public MessageController(MessageRepository messageRepository) {
		
		this.messageRepository = messageRepository;
	}
	
	 @GetMapping("/incomingMessage")
	    Flux<IncomingMessage> getAll() {
	        return messageRepository.findAll();
	    }
	
	

}
