package com.thoughtworks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.requests.PaymentRequest;
import com.thoughtwork.service.PaymentService;

@RestController
@RequestMapping("payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@RequestMapping(value = "/intiate", method = RequestMethod.PUT)
	public ResponseEntity doPayment(@RequestBody PaymentRequest paymentRequest) {
		 
		 try {
			 paymentService.initPayment(paymentRequest.getUserId(),paymentRequest.getOrderId());
		 }
		 catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		 return ResponseEntity.ok().build();
		 
	 }
	
	
}
