package com.billgenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.billgenerator.dto.BillRequest;
import com.billgenerator.service.BillGeneratorService;


@RestController
public class BillGeneratorController {

	@Autowired
	BillGeneratorService service;
	
	@GetMapping("/api/calculate")
	public String generateBill(@RequestBody BillRequest billRequest)
	{
		double finalBillAmount = service.generateBill(billRequest);
		return "Final amount of the bill is "+finalBillAmount+" "+billRequest.getTargetCurrency();
	}
	
	
}
