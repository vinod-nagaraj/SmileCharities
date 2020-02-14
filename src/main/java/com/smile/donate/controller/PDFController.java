package com.smile.donate.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.smile.donate.entity.Donation;
import com.smile.donate.service.DonationService;
import com.smile.donate.service.EmailService;
import com.smile.donate.util.GeneratePdfReport;

@RestController
public class PDFController {

	@Autowired
	private DonationService donationService;

	@Autowired
	private EmailService emailService;

	/**
	 * @author Kathika T
	 * 
	 * 
	 * @param Donation of donationId
	 * @return List of Donation
	 * @return response with User message and status code
	 * 
	 */
	@RequestMapping(value = "/{donationId}/pdfreport", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	public void taxReport(@PathVariable Long donationId)
			throws FileNotFoundException, DocumentException {

		Donation donation = donationService.findDonationById(donationId);

		Document pdfDocument = GeneratePdfReport.taxReport(donation);

		try {
			emailService.sendEmailWithAttachment();
		} catch (MessagingException | IOException e) {
			e.printStackTrace();
		}

	}
}
