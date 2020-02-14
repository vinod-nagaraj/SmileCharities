package com.smile.donate.service;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	public void sendEmailWithAttachment() throws MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		
        helper.setTo("karthika.selvam16@gmail.com");
        helper.setFrom("vinodnagaraj043@gmail.com");
        helper.setSubject("Testing from Spring Boot");
        helper.setText("<h1>Check attachment for tax report!</h1>", true);
        helper.addAttachment("taxreport.pdf", new File("C:\\Users\\User1\\Downloads\\taxreport.pdf"));

        javaMailSender.send(msg);

    }

}
