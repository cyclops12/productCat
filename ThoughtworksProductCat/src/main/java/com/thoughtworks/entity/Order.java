package com.thoughtworks.entity;

import java.util.Map;
import java.util.UUID;

public class Order {

	private String orderID;
	private Map<Product, Integer> products;
	private float totalAmount;
	private float discount;
	private float finalAmount;

	public Order(String orderID, Map<Product, Integer> products) {
		super();
		this.orderID = UUID.randomUUID().toString();
		this.products = products;
	}

	private void calculateBillingAmount() {
		totalAmount = 0;
		discount = 0;
		finalAmount = 0;
	}

}
