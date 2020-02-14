package com.smile.donate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smile.donate.dto.DonationResponseDto;
import com.smile.donate.service.DonationService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
@RequestMapping("/{schemeId}/contributors")
@Slf4j
public class AdminController {
	
	@Autowired
	DonationService donationService;
	
	@GetMapping
	public ResponseEntity<DonationResponseDto> getSlots(@PathVariable Long schemeId) {
		DonationResponseDto donationResponseDto= donationService.getDonationsList(schemeId);
		return new ResponseEntity<DonationResponseDto>(donationResponseDto, HttpStatus.OK);
	}
	
	

}
