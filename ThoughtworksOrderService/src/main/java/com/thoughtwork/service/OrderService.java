package com.thoughtwork.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.factory.OrderFactory;
import com.order.exception.OrderNotFoundException;
import com.thoughtworks.entity.Cart;
import com.thoughtworks.entity.Order;

@Service
public class OrderService {

	private static final String CART_SERVICE_URL_VIEW = "http://127.0.0.1:8080/Cart/viewCart";
	
	private HashMap<String, Order> orders = new HashMap<String, Order>();
	
	private HashMap<Integer, Order> userOrderMap = new HashMap<>();
	
	
	public String placeOrder(int userID) {
		RestTemplate restTemplate = new RestTemplate();
		Cart cart = restTemplate.getForObject(CART_SERVICE_URL_VIEW, Cart.class);
		
		Order order = OrderFactory.createOrder(cart,userID);
		orders.put(order.getOrderID(),order);
		userOrderMap.put(userID, order);
		return order.getOrderID();
	}
	
	public Order getOrder(String orderId)throws OrderNotFoundException {
		if(!orders.containsKey(orderId)) {
			throw new OrderNotFoundException("order not found");
		}
		return orders.get(orderId);
	}
	
	public Order getOrderByUser(String userID)throws OrderNotFoundException {
		if(!userOrderMap.containsKey(userID)) {
			throw new OrderNotFoundException("order not found");
		}
		return userOrderMap.get(userID);
	}



}
