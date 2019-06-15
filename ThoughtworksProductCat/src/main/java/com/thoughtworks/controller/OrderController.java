package com.thoughtworks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.requests.OrderRequest;
import com.thoughtwork.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/placeOrder", method = RequestMethod.POST)
	public ResponseEntity placeOrder(@RequestBody OrderRequest orderRequest) {
		try {
			String orderID = orderService.placeOrder(orderRequest.getUserID());
			return ResponseEntity.ok().body(orderID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
