package com.order.exception;

public class PaymentFailedException extends Exception{
	public PaymentFailedException(String exp) {
		super(exp);
	}
}
