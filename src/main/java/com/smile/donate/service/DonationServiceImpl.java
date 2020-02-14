package com.smile.donate.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.smile.donate.constant.ApplicationConstants;
import com.smile.donate.dto.AdminResponseDto;
import com.smile.donate.dto.DonationRequestDto;
import com.smile.donate.dto.DonationResponse;
import com.smile.donate.dto.DonationResponseDto;
import com.smile.donate.entity.Donation;
import com.smile.donate.repository.DonationRepository;

@Service
public class DonationServiceImpl implements DonationService {

	@Autowired

	DonationRepository donationRepository;

	@Override
	public AdminResponseDto getDonationsList(Long schemeId) {

		List<Donation> donationdetails = donationRepository.findBySchemeId(schemeId);

		AdminResponseDto adminResponseDto = new AdminResponseDto();
		if (donationdetails.isEmpty()) {
			adminResponseDto.setStatusCode(ApplicationConstants.NOTFOUND_CODE);
			adminResponseDto.setContributorDetails(null);

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
			adminResponseDto.setStatusCode(ApplicationConstants.SUCCESS_CODE);
			adminResponseDto.setContributorDetails(donationResponse);

		}
		return adminResponseDto;
	}

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public Donation findDonationById(Long donationId) {
		Optional<Donation> donation = donationRepository.findById(donationId);
		if (donation.isPresent()) {
			return donation.get();
		}

		try {
			sendEmailWithAttachment();
		} catch (MessagingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	void sendEmailWithAttachment() throws MessagingException, IOException {

		MimeMessage msg = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(msg, true);

		helper.setTo("karthika.thiru@hcl.com");

		helper.setSubject("Testing from Spring Boot");
		helper.setText("<h1>Check attachment for image!</h1>", true);

		helper.addAttachment("my_photo.png", new ClassPathResource("karthika.txt"));

		javaMailSender.send(msg);

	}

	@Override
	public DonationResponseDto donate(DonationRequestDto donationRequestDto) {
		Donation donation = new Donation();
		DonationResponseDto donationResponseDto = new DonationResponseDto();
		BeanUtils.copyProperties(donationRequestDto, donation);
		Donation don = donationRepository.save(donation);
		donationResponseDto.setStatusCode(ApplicationConstants.SUCCESS_CODE);
		donationResponseDto.setDonationId(don.getDonationId());
		return donationResponseDto;

	}
}
