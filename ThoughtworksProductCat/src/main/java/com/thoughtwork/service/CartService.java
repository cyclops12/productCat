package com.thoughtwork.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.thoughtworks.entity.Cart;
import com.thoughtworks.service.consumer.ProductCatalogService;

public class CartService {
//userid::cart
	private Map<Integer, Cart> userCart;

	private ProductCatalogService productCatalogService;

	@PostConstruct
	public void init() {
		userCart = new HashMap<>();
	}

	public void addProduct(Integer productID, Integer userID) {

		if (!userCart.containsKey(userID)) {
			createCart(userID);
		}
		userCart.get(userID).addProduct(productCatalogService.getProduct(productID));
	}

	private void createCart(Integer userID) {
		userCart.put(userID, new Cart());

	}

	public void deleteProduct(int productId, int userID) {
		userCart.get(userID).removeProduct(productCatalogService.getProduct(productId));
		
	}

	public Cart getCart(int userID) {
		return userCart.get(userID);
	}

}
