package com.thoughtworks.entity;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	//product::quantity
	private Map<Product, Integer> products;

	public Cart() {
		products = new HashMap<>();
	}

	public void addProduct(Product product) {
		if (products.containsKey(product)) {
			products.put(product, products.get(product) + 1);
		} else {
			products.put(product, 1);
		}
	}

	public void removeProduct(Product product) {
		products.remove(product);
	}
	
	public Map<Product, Integer> viewCart() {
		int counter = 0;
		for(Product product:products.keySet()) {
			System.out.println(counter+" : "+product+" : Quantity: "+products.get(product));
		}
		return products;
	}

}
