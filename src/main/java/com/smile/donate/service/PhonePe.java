package com.smile.donate.service;

import org.springframework.stereotype.Service;

import com.smile.donate.constant.ApplicationConstants;

@Service("PhonePe")
public class PhonePe implements PaymentService {

	@Override
	public String payment(String paymentType) {
		return ApplicationConstants.PHONEPE_PAYMENT;

	}

}
