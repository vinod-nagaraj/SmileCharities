package com.smile.donate.service;

import org.springframework.stereotype.Service;

import com.smile.donate.constant.ApplicationConstants;

@Service("PayTm")
public class PayTm implements PaymentService {

	@Override
	public String payment(String paymentType) {
		return ApplicationConstants.PAYTM_PAYMENT;
	}

}