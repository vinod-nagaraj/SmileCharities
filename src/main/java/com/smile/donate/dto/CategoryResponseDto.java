package com.smile.donate.dto;

import java.util.List;

public class CategoryResponseDto {
	
	private Integer statusCode;
	private List<CategoryDetails> categoryDetails;
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public List<CategoryDetails> getCategoryDetails() {
		return categoryDetails;
	}
	public void setCategoryDetails(List<CategoryDetails> categoryDetails) {
		this.categoryDetails = categoryDetails;
	}

}
