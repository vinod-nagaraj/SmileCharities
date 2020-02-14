package com.smile.donate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smile.donate.dto.DonationRequestDto;
import com.smile.donate.dto.DonationResponseDto;
import com.smile.donate.service.DonationService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/donations")
public class DonationController {
	
	@Autowired
	private DonationService donationService;
	
	@PostMapping
	public ResponseEntity<DonationResponseDto> donate(@RequestBody DonationRequestDto donationRequestDto){
		DonationResponseDto donationResponseDto=donationService.donate(donationRequestDto);
		return new ResponseEntity<DonationResponseDto>(donationResponseDto, HttpStatus.OK);
		
	}

}
