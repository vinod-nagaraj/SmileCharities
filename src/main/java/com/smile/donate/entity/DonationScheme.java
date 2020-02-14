package com.smile.donate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DonationScheme {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long schemeId;
	private String schemeName;
	private Double amount;
	private String description;
	private Integer contributors;
	private String taxBenefit;
	private Long categoryId;

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

	public Integer getContributors() {
		return contributors;
	}

	public void setContributors(Integer contributors) {
		this.contributors = contributors;
	}

	public String getTaxBenefit() {
		return taxBenefit;
	}

	public void setTaxBenefit(String taxBenefit) {
		this.taxBenefit = taxBenefit;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
}
