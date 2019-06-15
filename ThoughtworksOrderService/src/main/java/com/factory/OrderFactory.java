package com.factory;

import com.thoughtworks.entity.Cart;
import com.thoughtworks.entity.Order;

public class OrderFactory {
	
	public static Order createOrder(Cart cart,int userID) {
		Order order = new Order(cart.getProducts(), userID);
		return order;
		
		
	}
}
