package com.smile.donate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smile.donate.constant.ApplicationConstants;
import com.smile.donate.dto.DonationResponse;
import com.smile.donate.dto.DonationResponseDto;
import com.smile.donate.entity.Donation;
import com.smile.donate.repository.DonationRepository;

@Service
public class DonationServiceImpl implements DonationService {

	@Autowired
	DonationRepository donationRepository;

	@Override
	public DonationResponseDto getDonationsList(Long schemeId) {

		List<Donation> donationdetails = donationRepository.findBySchemeId(schemeId);

		DonationResponseDto donationResponseDto = new DonationResponseDto();
		if (donationdetails.isEmpty()) {
			donationResponseDto.setStatusCode(ApplicationConstants.NOTFOUND_CODE);
			donationResponseDto.setContributorDetails(null);

		} else {
			List<DonationResponse> donationResponse = new ArrayList();
			for (Donation d : donationdetails) {
				DonationResponse donationResponse1 = new DonationResponse();
				donationResponse1.setEmail(d.getEmail());
				donationResponse1.setMobNumber(d.getMobileNumber());
				donationResponse1.setPanNumber(d.getPanNumber());
				donationResponse1.setUserName(d.getUserName());
				donationResponse.add(donationResponse1);
			}
			donationResponseDto.setStatusCode(ApplicationConstants.SUCCESS_CODE);
			donationResponseDto.setContributorDetails(donationResponse);

		}
		return donationResponseDto;

	}

}
