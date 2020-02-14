package com.smile.donate.dto;

public class SchemeDetail {

	private Long schemeId;
	private String schemeName;
	private Double amount;
	private String description;
	private String contributors;
	private String taxBenefit;

	public Long getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(Long schemeId) {
		this.schemeId = schemeId;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContributors() {
		return contributors;
	}

	public void setContributors(String contributors) {
		this.contributors = contributors;
	}

	public String getTaxBenefit() {
		return taxBenefit;
	}

	public void setTaxBenefit(String taxBenefit) {
		this.taxBenefit = taxBenefit;
	}
}
