package com.smile.donate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.smile.donate.constant.ApplicationConstants;
import com.smile.donate.dto.CategoryDetails;
import com.smile.donate.dto.CategoryResponseDto;
import com.smile.donate.dto.SchemeDetail;
import com.smile.donate.dto.SchemeResponseDto;
import com.smile.donate.entity.Category;
import com.smile.donate.entity.DonationScheme;
import com.smile.donate.exception.NoCategoryFoundException;
import com.smile.donate.exception.NoDonationSchemeFoundException;
import com.smile.donate.repository.CategoryRepository;
import com.smile.donate.repository.DonationSchemeRepository;

@Service
public class SchemeServiceImpl implements SchemeService {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	DonationSchemeRepository DonationSchemeRepository;

	@Override
	public CategoryResponseDto getCategory() {
		List<Category> categories = categoryRepository.findAll();
		if (categories.isEmpty()) {
			throw new NoCategoryFoundException(ApplicationConstants.NO_RESULTS_FOUND);
		}
		List<CategoryDetails> categoryDetails = new ArrayList<>();
		categories.forEach(category -> {
			CategoryDetails categoryDetail = new CategoryDetails();
			BeanUtils.copyProperties(category, categoryDetail);
			categoryDetails.add(categoryDetail);
		});
		CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
		categoryResponseDto.setStatusCode(HttpStatus.OK.value());
		categoryResponseDto.setCategoryDetails(categoryDetails);
		return categoryResponseDto;
	}

	@Override
	public SchemeResponseDto getScheme(Long categoryId) {
		List<DonationScheme> donations = DonationSchemeRepository.findByCategoryId(categoryId);
		if(ObjectUtils.isEmpty(donations)) {
			throw new NoDonationSchemeFoundException(ApplicationConstants.NO_RESULTS_FOUND);
		}
		List<SchemeDetail> schemeDetails = new ArrayList<>();
		donations.forEach(donation->{
			SchemeDetail schemeDetail = new SchemeDetail();
			
			BeanUtils.copyProperties(donation, schemeDetail);
			schemeDetails.add(schemeDetail);
		});
		SchemeResponseDto schemeResponseDto = new SchemeResponseDto();
		schemeResponseDto.setStatusCode(HttpStatus.OK.value());
		schemeResponseDto.setSchemeDetails(schemeDetails);
		return schemeResponseDto;
	}




}
