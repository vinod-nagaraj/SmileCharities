package com.smile.donate.service;

import com.smile.donate.dto.DonationResponseDto;

public interface DonationService {
	
	public DonationResponseDto getDonationsList(Long schemeId);

}
