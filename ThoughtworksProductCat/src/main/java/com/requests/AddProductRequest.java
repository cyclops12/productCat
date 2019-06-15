package com.requests;

public class AddProductRequest extends UserRequest {
	private Integer productID;

	public Integer getProductID() {
		return productID;
	}

	public AddProductRequest(int userID, Integer productID) {
		super(userID);
		this.productID = productID;
	}

	

}
