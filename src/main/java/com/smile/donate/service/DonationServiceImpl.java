package com.smile.donate.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smile.donate.entity.Donation;
import com.smile.donate.repository.DonationRepository;

@Service
public class DonationServiceImpl implements DonationService {

	@Autowired
	private DonationRepository donationRepository;
	
	@Override
	public Donation findDonationById(Long donationId) {
		Optional<Donation> donation= donationRepository.findById(donationId);
		if(donation.isPresent()) {
			return donation.get();
		}
		return null;
	}

}
