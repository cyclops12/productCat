package com.requests;

public class PaymentRequest extends UserRequest{
	private String orderId;

	
	public PaymentRequest(String orderId,int userId) {
		super(userId);
		this.orderId = orderId;
	}


	public String getOrderId() {
		return orderId;
	}
	

}
