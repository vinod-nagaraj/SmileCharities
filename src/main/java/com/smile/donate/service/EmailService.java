package com.smile.donate.service;

import java.io.IOException;

import javax.mail.MessagingException;

public interface EmailService {
	
	public void sendEmailWithAttachment() throws MessagingException, IOException;
}
