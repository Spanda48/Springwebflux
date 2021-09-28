package com.demo.demo.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.springboot.Repository.MessageRepository;
import com.demo.demo.springboot.entity.IncomingMessage;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class MessageController {

	@Autowired
	private MessageRepository messageRepository;
	
	
	@Autowired
	public MessageController(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	@GetMapping("/incomingMessage")
	Flux<IncomingMessage> getAll() {
		return messageRepository.findAll();
	}

//	@PostMapping("/incomingMessage")
//	Mono<IncomingMessage> addIncomingMessage(@RequestBody IncomingMessage incomingMessage) {
//		return messageRepository.save(incomingMessage);
//	}

	/*
	 * @PutMapping("/incomingMessage") Mono<IncomingMessage> updateTodo(@RequestBody
	 * IncomingMessage incomingMessage) { return
	 * messageRepository.save(incomingMessage); }
	 * 
	 * @DeleteMapping("/incomingMessage/{id}") Mono<Void>
	 * deleteById(@PathVariable("id") Long id) { return
	 * messageRepository.deleteById(id); }
	 */

}
