package com.smile.donate.dto;

import java.util.List;

public class DonationResponseDto {

	private Integer statusCode;
	private List<DonationResponse> contributorDetails;

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public List<DonationResponse> getContributorDetails() {
		return contributorDetails;
	}

	public void setContributorDetails(List<DonationResponse> contributorDetails) {
		this.contributorDetails = contributorDetails;
	}

}
