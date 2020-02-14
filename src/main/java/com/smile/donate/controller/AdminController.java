package com.smile.donate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smile.donate.dto.AdminResponseDto;
import com.smile.donate.service.DonationService;

@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
@RequestMapping("/{schemeId}/contributors")

public class AdminController {

	@Autowired
	DonationService donationService;

	@GetMapping
	public ResponseEntity<AdminResponseDto> getDonationsList(@PathVariable Long schemeId) {
		AdminResponseDto adminResponseDto = donationService.getDonationsList(schemeId);
		return new ResponseEntity<AdminResponseDto>(adminResponseDto, HttpStatus.OK);
	}

}
