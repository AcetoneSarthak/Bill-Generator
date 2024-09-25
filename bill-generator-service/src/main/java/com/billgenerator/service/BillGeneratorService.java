package com.billgenerator.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.billgenerator.dto.BillRequest;
import com.billgenerator.model.APIResponse;
import com.billgenerator.model.Item;

@Service
public class BillGeneratorService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${apiBaseUrl}")
	String baseUrl;
	
	@Value("${apikey}")
	String apiKey;
	
	public double generateBill(@RequestBody BillRequest billRequest)
	{
		
		String url = baseUrl+billRequest.getOriginalCurrency()+"?apikey="+apiKey;
		System.out.println("URL IS "+url);
	
	   APIResponse response = restTemplate.getForObject(url,APIResponse.class);
	   Map<String,Double> rates =  response.getRates();
	   
	  double targetBaseRate = rates.entrySet().stream().filter(e->e.getKey().equalsIgnoreCase(billRequest.getTargetCurrency())).findFirst().get().getValue();
	   
	   List<Item> allitems = billRequest.getItems();
	   
	   double billTotalAmount = allitems.stream().mapToDouble(i->i.getAmount()).sum();
	   
	   List<Item> groceriesItems = allitems.stream().filter(i->i.getCategory().equalsIgnoreCase("Groceries")).toList();
	   
	   double groceriesItemsAmount = groceriesItems.stream().mapToDouble(i->i.getAmount()).sum();
	   
	   double nonGroceriesItemsAmount = billTotalAmount - groceriesItemsAmount;
	   double nonGroceriesItemsAmountAfterDiscount = nonGroceriesItemsAmount;
	   
	   //Discount Logic based on percent
	   
	   if(billRequest.getUserType().equalsIgnoreCase("Employee"))
	   {
		    nonGroceriesItemsAmountAfterDiscount = nonGroceriesItemsAmount*0.7;
	   }
	   
	   else
		   if(billRequest.getUserType().equalsIgnoreCase("Affiliated"))
	   {
		    nonGroceriesItemsAmountAfterDiscount = nonGroceriesItemsAmount*0.9;
	   }
	   
	    else
		    if(billRequest.getUserType().equalsIgnoreCase("Customer") && billRequest.getTenureInYears()>2)
		   {
			    nonGroceriesItemsAmountAfterDiscount = nonGroceriesItemsAmount*0.95;
		   }
		    
	   
	double billAmountJustBeforePercentageDiscount = nonGroceriesItemsAmountAfterDiscount+groceriesItemsAmount;

	//Flat discount of $5 on every $100
	
		double billAmountAfterAllDiscountsinOriginalCurrency = (billAmountJustBeforePercentageDiscount-((billAmountJustBeforePercentageDiscount/100)*5));
	
	double billAmountAfterAllDiscountsinTargetCurrency = billAmountAfterAllDiscountsinOriginalCurrency*targetBaseRate;
	return billAmountAfterAllDiscountsinTargetCurrency;
}
}
