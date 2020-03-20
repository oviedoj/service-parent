package com.cnbr.service.domain.transaction;

import java.math.BigDecimal;

import com.cnbr.service.domain.base.BaseDomain;

public class Registro extends BaseDomain {
	private String description;
	private BigDecimal amount;
	private Integer userId;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
