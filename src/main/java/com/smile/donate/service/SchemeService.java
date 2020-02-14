package com.smile.donate.service;

import com.smile.donate.dto.CategoryResponseDto;
import com.smile.donate.dto.SchemeResponseDto;

public interface SchemeService {
	
	CategoryResponseDto getCategory();
	
	SchemeResponseDto getScheme(Long categoryId);
}
