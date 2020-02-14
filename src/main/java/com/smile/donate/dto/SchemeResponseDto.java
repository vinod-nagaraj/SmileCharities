package com.smile.donate.dto;

import java.util.List;

public class SchemeResponseDto {
	
	private int statusCode;
	private List<SchemeDetail>schemeDetails;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public List<SchemeDetail> getSchemeDetails() {
		return schemeDetails;
	}
	public void setSchemeDetails(List<SchemeDetail> schemeDetails) {
		this.schemeDetails = schemeDetails;
	}


}
