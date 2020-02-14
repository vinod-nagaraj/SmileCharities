package com.smile.donate.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smile.donate.dto.LoginRequestDto;
import com.smile.donate.dto.LoginResponseDto;
import com.smile.donate.exception.NotFoundException;
import com.smile.donate.service.LoginService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {

	/**
	 * This will inject all the implementations in the loginService.
	 */
	@Autowired
	LoginService loginService;

	/**
	 * @author Raghib
	 * 
	 *         this API is used to authenticate the User
	 * 
	 * @param mobileNumber & Password of Doctor will be used for Login.
	 * @return statusCode,userName,userId.
	 * @throws NotFoundException
	 * 
	 */

	@PostMapping
	public ResponseEntity<LoginResponseDto> authenticateCustomer(@Valid @RequestBody LoginRequestDto loginRequestDto)
			throws NotFoundException {

		return ResponseEntity.ok().body(loginService.authenticateCustomer(loginRequestDto));
	}

}
