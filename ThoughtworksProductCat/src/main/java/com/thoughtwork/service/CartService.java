package com.thoughtwork.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.thoughtworks.entity.Cart;
import com.thoughtworks.entity.Product;

public class CartService {
    //userid::cart
	private Map<Integer, Cart> userCart;


	@PostConstruct
	public void init() {
		userCart = new HashMap<>();
	}

	public void addProduct(Product product, Integer userID) {

		if (!userCart.containsKey(userID)) {
			createCart(userID);
		}
		userCart.get(userID).addProduct(product);
	}

	private void createCart(Integer userID) {
		userCart.put(userID, new Cart());

	}

	public void deleteProduct(Product product, int userID) {
		userCart.get(userID).removeProduct(product);
		
	}

	public Cart getCart(int userID) {
		return userCart.get(userID);
	}

}
