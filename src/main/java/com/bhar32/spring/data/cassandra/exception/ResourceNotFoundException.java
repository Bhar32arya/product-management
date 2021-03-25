package com.bhar32.spring.data.cassandra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2287648084851449465L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
