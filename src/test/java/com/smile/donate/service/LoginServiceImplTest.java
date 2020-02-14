package com.smile.donate.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.smile.donate.dto.LoginRequestDto;
import com.smile.donate.dto.LoginResponseDto;
import com.smile.donate.entity.Admin;
import com.smile.donate.exception.NotFoundException;
import com.smile.donate.repository.AdminRepository;


@RunWith(MockitoJUnitRunner.Silent.class)
public class LoginServiceImplTest {
	
	@InjectMocks
	LoginServiceImpl loginServiceImpl;
	
	@Mock
	AdminRepository adminRepository;
	
	@Before
	public void before() {

	}
	@Test
	public void authenticateCustomer() throws NotFoundException {
		LoginRequestDto req = new LoginRequestDto();
		LoginRequestDto req1 = new LoginRequestDto();
		Admin admin1 = new Admin();
		admin1.setMobileNumber("9513090306");
		admin1.setPassword("vinod123");
		req.setPassword("vinod");
		req.setMobileNumber("9513090306");
		req1.setMobileNumber("9513090305");
		req1.setPassword("r@sid1000");
		Mockito.when(adminRepository.findByMobileNumberAndPassword(req.getMobileNumber(), req.getPassword())).thenReturn(Optional.of(admin1));
		LoginResponseDto resp = loginServiceImpl.authenticateCustomer(req);
		assertEquals(200, resp.getStatusCode());
		
	
		

		
	}

}
