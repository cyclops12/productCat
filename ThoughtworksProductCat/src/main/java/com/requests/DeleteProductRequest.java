package com.requests;

import com.thoughtworks.entity.Product;

public class DeleteProductRequest extends UserRequest {
	private Product product;

	public DeleteProductRequest(int userId, Product product) {
		super(userId);
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	

	
	
}
