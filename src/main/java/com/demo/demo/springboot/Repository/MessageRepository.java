package com.demo.demo.springboot.Repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.demo.demo.springboot.entity.IncomingMessage;

public interface MessageRepository extends ReactiveCrudRepository<IncomingMessage, Integer> {

}
