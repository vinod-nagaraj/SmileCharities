package com.smile.donate.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smile.donate.constant.ApplicationConstants;
import com.smile.donate.dto.DonationRequestDto;
import com.smile.donate.dto.DonationResponseDto;
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
	
	@Override
	public DonationResponseDto donate(DonationRequestDto donationRequestDto) {
		Donation donation= new Donation();
		DonationResponseDto donationResponseDto= new DonationResponseDto();
		BeanUtils.copyProperties(donationRequestDto, donation);
		Donation don=donationRepository.save(donation);
		donationResponseDto.setStatusCode(ApplicationConstants.SUCCESS_CODE);
		donationResponseDto.setDonationId(don.getDonationId());
		return donationResponseDto;
	}
}
