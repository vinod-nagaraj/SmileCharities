package com.smile.donate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smile.donate.dto.CategoryResponseDto;
import com.smile.donate.dto.SchemeResponseDto;
import com.smile.donate.service.SchemeService;

@RestController
@RequestMapping("/Categories")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class SchemeController {
	
	@Autowired
	SchemeService schemeService;
	/**
	 * @author Vinod B N
	 * 
	 * 
	 * 
	 * @return List of category
	 * @return response with User message and status code
	 * 
	 */
	@GetMapping
	public CategoryResponseDto getCategory(){
		CategoryResponseDto category = schemeService.getCategory();
		return category;
	}
	/**
	 * @author Vinod B N
	 * 
	 * 
	 * @param Category of categoryId
	 * @return List of Category
	 * @return response with User message and status code
	 * 
	 */
	@GetMapping("{categoryId}/schemes")
	public SchemeResponseDto getScheme (@PathVariable Long categoryId) {
		SchemeResponseDto scheme = schemeService.getScheme(categoryId);
		return scheme;
		
	}
}
