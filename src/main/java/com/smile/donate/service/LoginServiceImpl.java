package com.smile.donate.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smile.donate.constant.ApplicationConstants;
import com.smile.donate.dto.LoginRequestDto;
import com.smile.donate.dto.LoginResponseDto;
import com.smile.donate.entity.Admin;
import com.smile.donate.exception.NotFoundException;
import com.smile.donate.repository.AdminRepository;


/**
 * 
 * @author Raghib
 * 
 *         Login Service has the implementations for Login related api's.
 * 
 *
 */

@Service
public class LoginServiceImpl implements LoginService {
	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	AdminRepository adminRepository;

	@Override
	public LoginResponseDto authenticateCustomer(LoginRequestDto loginRequestDto) throws NotFoundException {
		logger.info("LoginServiceImpl authenticateCustomer ---> autheticating customer");
		
		Optional<Admin> admin = adminRepository.findByMobileNumberAndPassword(loginRequestDto.getMobileNumber(),
				loginRequestDto.getPassword());

		if (admin.isPresent()) {
			LoginResponseDto loginResponseDto = new LoginResponseDto();
			BeanUtils.copyProperties(admin.get(), loginResponseDto);		
			loginResponseDto.setAdminName(admin.get().getAdminName());
			loginResponseDto.setStatusCode(ApplicationConstants.SUCCESS_CODE);
			logger.info("LoginServiceImpl authenticateCustomer ---> Admin signed in");
			return loginResponseDto;
		} else {
			logger.error("LoginServiceImpl authenticateCustomer ---> NotFoundException occured");
			throw new NotFoundException(ApplicationConstants.USER_NOT_FOUND);
			
		}

	}

}
