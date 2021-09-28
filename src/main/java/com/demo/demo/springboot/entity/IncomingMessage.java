package com.demo.demo.springboot.entity;



public class IncomingMessage {
	
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
