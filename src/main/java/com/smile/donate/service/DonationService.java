package com.smile.donate.service;

import com.smile.donate.dto.DonationResponseDto;
import com.smile.donate.entity.Donation;

public interface DonationService {

	public DonationResponseDto getDonationsList(Long schemeId);

	Donation findDonationById(Long donationId);

}