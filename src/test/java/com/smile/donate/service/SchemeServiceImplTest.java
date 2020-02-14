package com.smile.donate.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.smile.donate.dto.CategoryDetails;
import com.smile.donate.dto.CategoryResponseDto;
import com.smile.donate.dto.SchemeDetail;
import com.smile.donate.entity.Category;
import com.smile.donate.entity.DonationScheme;
import com.smile.donate.repository.CategoryRepository;
import com.smile.donate.repository.DonationSchemeRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SchemeServiceImplTest {

	@InjectMocks
	SchemeServiceImpl SchemeServiceImpl;
	
	@Mock
	CategoryRepository categoryRepository;
	 
	@Mock
	DonationSchemeRepository donationSchemeRepository;
	
	@Test
	public void getCategoryTest() {
		List<Category> cat = new ArrayList<>();
		Category category = new Category();
		CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
		category.setCategoryId(1L);
		category.setCategoryName("NGO");
		cat.add(category);
		Mockito.when(categoryRepository.findAll()).thenReturn(cat);
		categoryResponseDto.setStatusCode(200);
		cat.forEach(cats->{
			CategoryDetails categoryDetail = new CategoryDetails();
			BeanUtils.copyProperties(cats, categoryDetail);
			
		});
		assertNotNull(cat);
	} 
	
	@Test
	public void getCategoryTestNegative() {
		List<Category> cat = new ArrayList<>();
		Category category = new Category();
		category.setCategoryId(null);
		category.setCategoryName(null);
		cat.add(category);
		Mockito.when(categoryRepository.findAll()).thenReturn(cat);
	}
	
	@Test
	public void getScheme() {
		List<DonationScheme> don = new ArrayList<>();
		DonationScheme donsch = new DonationScheme();
		donsch.setAmount(200.0);
		donsch.setCategoryId(1L);
		donsch.setContributors(3);
		donsch.setDescription("its for flood");
		donsch.setSchemeId(1L);
		donsch.setSchemeName("NGO");
		donsch.setTaxBenefit("Upto 20%");
		don.add(donsch);
		Mockito.when(donationSchemeRepository.findByCategoryId(1L)).thenReturn(don);
		List<SchemeDetail> schemeDetails = new ArrayList<>();
		don.forEach(dons->{
			SchemeDetail schemeDetail = new SchemeDetail();
			BeanUtils.copyProperties(dons, schemeDetail);
			schemeDetails.add(schemeDetail);
		});
		assertNotNull(don);
	}
	
	@Test
	public void getSchemeNegative() {
		List<DonationScheme> don = new ArrayList<>();
		DonationScheme donsch = new DonationScheme();
		donsch.setAmount(200.0);
		donsch.setCategoryId(1L);
		donsch.setContributors(3);
		donsch.setDescription("its for flood");
		donsch.setSchemeId(1L);
		donsch.setSchemeName("NGO");
		donsch.setTaxBenefit("Upto 20%");
		don.add(donsch);
		Mockito.when(donationSchemeRepository.findByCategoryId(null)).thenReturn(don);
		
	}
}
