package com.smile.donate.service;

import com.smile.donate.entity.Donation;

public interface DonationService {

	Donation findDonationById(Long donationId);

}
