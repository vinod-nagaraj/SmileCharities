package com.smile.donate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smile.donate.dto.ResponseDto;
import com.smile.donate.service.PaymentRegistery;
/**
 * @author Vinod B N
 * 
 * 
 * @param Vendor of vendor
 * @return List of vendors
 * @return response with User message and status code
 * 
 */
@RestController
public class PaymentController {
	
	@Autowired
	PaymentRegistery paymentRegistery;
	
	@GetMapping("/pay/{paymentType}")
	public ResponseDto payment(@PathVariable String paymentType) {
		paymentRegistery.getServiceBean(paymentType).payment(paymentType);
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage("Payment done through "+paymentType);
		responseDto.setStatusCode(HttpStatus.ACCEPTED.value());
		return responseDto;

	
	}
}
