package com.thoughtworks.entity;

import java.util.Map;
import java.util.UUID;

public class Order {

	private String orderID;
	private Map<Product, Integer> products;
	private float totalAmount;
	private float discount;
	private float finalAmount;
	private int userID;

	public Order(Map<Product, Integer> products,int userID) {
		super();
		this.orderID = UUID.randomUUID().toString();
		this.products = products;
		this.userID = userID;
		calculateBillingAmount();
	}

	private void calculateBillingAmount() {
		totalAmount = 0;
		discount = 0;
		finalAmount = 0;
	}

	public String getOrderID() {
		return orderID;
	}

	public Map<Product, Integer> getProducts() {
		return products;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public float getDiscount() {
		return discount;
	}

	public float getFinalAmount() {
		return finalAmount;
	}

	public int getUserID() {
		return userID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (orderID == null) {
			if (other.orderID != null)
				return false;
		} else if (!orderID.equals(other.orderID))
			return false;
		return true;
	}
	

}
