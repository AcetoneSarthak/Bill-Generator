package com.billgenerator.dto;

import java.util.List;

import com.billgenerator.model.Item;

public class BillRequest {
	
	List<Item> items;
	String userType;
	int tenureInYears;
	String originalCurrency;
	String targetCurrency;
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public int getTenureInYears() {
		return tenureInYears;
	}
	public void setTenureInYears(int tenureInYears) {
		this.tenureInYears = tenureInYears;
	}
	public String getOriginalCurrency() {
		return originalCurrency;
	}
	public void setOriginalCurrency(String originalCurrency) {
		this.originalCurrency = originalCurrency;
	}
	public String getTargetCurrency() {
		return targetCurrency;
	}
	public void setTargetCurrency(String targetCurrency) {
		this.targetCurrency = targetCurrency;
	}
	public BillRequest(List<Item> items, String userType, int tenureInYears, String originalCurrency,
			String targetCurrency) {
		super();
		this.items = items;
	
		this.userType = userType;
		this.tenureInYears = tenureInYears;
		this.originalCurrency = originalCurrency;
		this.targetCurrency = targetCurrency;
	}
	@Override
	public String toString() {
		return "BillRequest [items=" + items + ", userType=" + userType
				+ ", tenureInYears=" + tenureInYears + ", originalCurrency=" + originalCurrency + ", targetCurrency="
				+ targetCurrency + "]";
	}
	
	
	
	

}
