package com.billgenerator.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.ArrayList;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.billgenerator.dto.BillRequest;
import com.billgenerator.model.Item;
import com.billgenerator.service.BillGeneratorService;
import com.fasterxml.jackson.databind.ObjectMapper;



@WebMvcTest(BillGeneratorController.class)
@ExtendWith(MockitoExtension.class)
//@ContextConfiguration(classes =
public class BillGeneratorControllerTest {

	  @MockBean
	  private BillGeneratorService billGeneratorService;
	  
	  @Autowired
	  private MockMvc mockMvc;
	  
	  @Autowired
	  ObjectMapper obj;

	  
	  @DisplayName("Success Case")
	  @Test
	  void shouldReturnFinalAmountAfterDiscounts() throws Exception {
		  
		  List<Item> listOfItems = new ArrayList<>();
		  
		  Item i1 = new Item("Televison","Electronics",500);
		  listOfItems.add(i1);
	   
	    BillRequest request = new BillRequest(listOfItems, "Employee", 2, "USD", "INR");
	    when(billGeneratorService.generateBill(request)).thenReturn(500.0);
	    mockMvc.perform(get("/api/calculate").content(obj.writeValueAsString(request)).contentType(MediaType.APPLICATION_JSON))
    .andExpect(status().isOk());
	      
	  }
	 
}
