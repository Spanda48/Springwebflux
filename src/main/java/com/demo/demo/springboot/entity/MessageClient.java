package com.demo.demo.springboot.entity;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Component
public class MessageClient {

	// The WebClient class uses reactive features, in the form of a Mono to hold the
	// content of the message (returned by the getMessage method).

	private final WebClient client;

	public MessageClient(WebClient.Builder builder) {
		this.client = builder.baseUrl("http://localhost:8088").build();
	}

	public Mono<String> getMessage() {
		return this.client.get().uri("/hello").accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(IncomingMessage.class).map(IncomingMessage::getMessage);
	}

}
