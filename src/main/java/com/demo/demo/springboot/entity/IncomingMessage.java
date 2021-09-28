package com.demo.demo.springboot.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table
public class IncomingMessage {
	@Id
	private String message;

	public IncomingMessage() {
		super();
	}

	public IncomingMessage( String message) {
		
		this.message = message;
	}

	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "IncomingMessage [message=" + message + "]";
	}

	
	
	

}
