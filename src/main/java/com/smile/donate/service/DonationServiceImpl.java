package com.smile.donate.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.smile.donate.constant.ApplicationConstants;
import com.smile.donate.dto.AdminResponseDto;
import com.smile.donate.dto.DonationRequestDto;
import com.smile.donate.dto.DonationResponse;
import com.smile.donate.dto.DonationResponseDto;
import com.smile.donate.entity.Donation;
import com.smile.donate.entity.DonationScheme;
import com.smile.donate.repository.DonationRepository;
import com.smile.donate.repository.DonationSchemeRepository;

@Service
public class DonationServiceImpl implements DonationService {

	@Autowired

	private DonationRepository donationRepository;
	
	@Autowired

	private DonationSchemeRepository donationSchemeRepository;
	
	RestTemplate restTemplate= new RestTemplate();
	
	@Override
	public AdminResponseDto getDonationsList(Long schemeId) {

		List<Donation> donationdetails = donationRepository.findBySchemeId(schemeId);

		AdminResponseDto adminResponseDto = new AdminResponseDto();
		if (donationdetails.isEmpty()) {
			adminResponseDto.setStatusCode(ApplicationConstants.NOTFOUND_CODE);
			adminResponseDto.setContributorDetails(null);

		} else {
			List<DonationResponse> donationResponse = new ArrayList<>();
			for (Donation d : donationdetails) {
				DonationResponse donationResponse1 = new DonationResponse();
				donationResponse1.setEmail(d.getEmail());
				donationResponse1.setMobNumber(d.getMobileNumber());
				donationResponse1.setPanNumber(d.getPanNumber());
				donationResponse1.setUserName(d.getUserName());
				donationResponse.add(donationResponse1);
			}
			adminResponseDto.setStatusCode(ApplicationConstants.SUCCESS_CODE);
			adminResponseDto.setContributorDetails(donationResponse);

		}
		return adminResponseDto;
	}


	@Override
	public Donation findDonationById(Long donationId) {
		Optional<Donation> donation = donationRepository.findById(donationId);
		if (donation.isPresent()) {
			return donation.get();
		}
		

		return null;

	}
	

	@Override
	public DonationResponseDto donate(DonationRequestDto donationRequestDto) {
		Donation donation = new Donation();
		DonationResponseDto donationResponseDto = new DonationResponseDto();
		BeanUtils.copyProperties(donationRequestDto, donation);
		HttpHeaders headers= new HttpHeaders();
		
		HttpEntity ent= new HttpEntity<>(headers);
		ResponseEntity<String> response=restTemplate.exchange("http://localhost:8686/smilecharities/pay/{paymentType}", HttpMethod.GET, ent, String.class, donationRequestDto.getPaymentType());
		System.out.println(response.getBody());
		//String response=restTemplate.getForObject("http://localhost:8686/smilecharities/pay/{paymentType}",String.class);
		Donation don = donationRepository.save(donation);
		Optional<DonationScheme> scheme=donationSchemeRepository.findById(donationRequestDto.getSchemeId());
		scheme.get().setContributors(scheme.get().getContributors()+1);
		donationSchemeRepository.save(scheme.get());
		donationResponseDto.setStatusCode(ApplicationConstants.SUCCESS_CODE);
		donationResponseDto.setDonationId(don.getDonationId());
		return donationResponseDto;

	}
}
