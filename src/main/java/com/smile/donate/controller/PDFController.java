package com.smile.donate.controller;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smile.donate.entity.Donation;
import com.smile.donate.service.DonationService;
import com.smile.donate.util.GeneratePdfReport;

@RestController
public class PDFController {

	@Autowired
	private DonationService donationService;

	@RequestMapping(value = "/{donationId}/pdfreport", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> citiesReport(@PathVariable Long donationId) {

		Donation donation = donationService.findDonationById(donationId);

		ByteArrayInputStream bis = GeneratePdfReport.taxReport(donation);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=taxreport.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
}
