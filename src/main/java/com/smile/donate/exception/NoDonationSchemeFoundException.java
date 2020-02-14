package com.smile.donate.exception;

public class NoDonationSchemeFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String message;
	public NoDonationSchemeFoundException(String message) {
		super(message);
		this.message=message;
	}

	

}
