package com.thoughtwork.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

	private String cartServiceURL = "http://127.0.0.1:8080/Cart/viewCart";
	public String placeOrder(int userID) {
		RestTemplate restTemplate = new RestTemplate();
		
		return null;
	}



}
