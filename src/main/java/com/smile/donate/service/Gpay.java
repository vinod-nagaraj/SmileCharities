package com.smile.donate.service;

import com.smile.donate.constant.ApplicationConstants;
@Service("GPay")
public class Gpay implements PaymentService {
	@Override
	public String payment(String paymentType) {
		return ApplicationConstants.GPAY_PAYMENT;
	}


}
