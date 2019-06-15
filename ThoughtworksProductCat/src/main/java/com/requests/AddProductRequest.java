package com.requests;

import com.thoughtworks.entity.Product;

public class AddProductRequest extends UserRequest {
	private Product product;

	public AddProductRequest(int userId, Product product) {
		super(userId);
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}
	

	

	

}
