package com.requests;

public class DeleteProductRequest extends UserRequest {
	private int productId;

	public int getProductId() {
		return productId;
	}

	public DeleteProductRequest(int userID, int productId) {
		super(userID);
		this.productId = productId;
	}

	
	
}
