package com.smile.donate.dto;

public class DonationResponseDto {

	private Integer statusCode;
	private Long donationId;

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public Long getDonationId() {
		return donationId;
	}

	public void setDonationId(Long donationId) {
		this.donationId = donationId;

	}

}
