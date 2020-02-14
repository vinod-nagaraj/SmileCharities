package com.smile.donate.exception;

public class NoCategoryFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String message;
	public NoCategoryFoundException(String message) {
		super(message);
		this.message=message;
	}

}
