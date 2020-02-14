package com.smile.donate.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.smile.donate.dto.CategoryResponseDto;
import com.smile.donate.entity.Category;
import com.smile.donate.service.SchemeService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SchemeControllerTest {

	@InjectMocks
	SchemeController schemeController;
	
	@Mock
	SchemeService schemeService;
	@Test
	public void getCategory() {
		List<Category> cat = new ArrayList<>(); 
		Category category = new Category();
		CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
		category.setCategoryId(1L);
		category.setCategoryName("NGO");
		cat.add(category);
		Mockito.when(schemeService.getCategory()).thenReturn(categoryResponseDto);
	}
	
}
