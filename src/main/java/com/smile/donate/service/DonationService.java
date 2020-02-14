package com.smile.donate.service;

import com.smile.donate.dto.AdminResponseDto;
import com.smile.donate.dto.DonationRequestDto;

import com.smile.donate.dto.DonationResponseDto;
import com.smile.donate.entity.Donation;

public interface DonationService {

	 AdminResponseDto getDonationsList(Long schemeId);

	Donation findDonationById(Long donationId);
	DonationResponseDto donate(DonationRequestDto donationRequestDto);


}

