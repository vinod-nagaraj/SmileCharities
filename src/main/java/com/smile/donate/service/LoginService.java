package com.smile.donate.service;

import com.smile.donate.dto.LoginRequestDto;
import com.smile.donate.dto.LoginResponseDto;
import com.smile.donate.exception.NotFoundException;

public interface LoginService {

	public LoginResponseDto authenticateCustomer(LoginRequestDto loginRequestDto) throws NotFoundException;

}
