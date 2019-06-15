package com.requests;

public class PaymentRequest extends UserRequest{
	private String orderID;

	
	public PaymentRequest(String orderID,int userID) {
		super(userID);
		this.orderID = orderID;
	}


	public String getOrderID() {
		return orderID;
	}
	

}
