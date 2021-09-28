package com.demo.demo.springboot.Repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.demo.springboot.entity.IncomingMessage;


@Repository
public interface MessageRepository extends ReactiveCrudRepository<IncomingMessage, String> {

}
