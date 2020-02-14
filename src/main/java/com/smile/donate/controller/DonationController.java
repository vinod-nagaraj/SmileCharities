package com.smile.donate.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.smile.donate.dto.DonationRequestDto;
import com.smile.donate.dto.DonationResponseDto;
import com.smile.donate.entity.Donation;
import com.smile.donate.service.DonationService;
import com.smile.donate.service.EmailService;
import com.smile.donate.util.GeneratePdfReport;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/donations")
public class DonationController {
	
	@Autowired
	private DonationService donationService;
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping
	public ResponseEntity<DonationResponseDto> donate(@RequestBody DonationRequestDto donationRequestDto) throws FileNotFoundException, DocumentException{
		DonationResponseDto donationResponseDto=donationService.donate(donationRequestDto);
		Donation donation = donationService.findDonationById(donationResponseDto.getDonationId());

		Document pdfDocument = GeneratePdfReport.taxReport(donation);

		try {
			emailService.sendEmailWithAttachment();
		} catch (MessagingException | IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<DonationResponseDto>(donationResponseDto, HttpStatus.OK);
		
	}

}
