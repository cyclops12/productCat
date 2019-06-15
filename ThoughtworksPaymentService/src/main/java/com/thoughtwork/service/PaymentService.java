package com.thoughtwork.service;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.exception.PaymentFailedException;
import com.thoughtworks.entity.Order;

@Service
public class PaymentService {
	private static String PAYMENT_GATEWAY_URL = "http://demo7594616.mockable.io/payment";
	private static String ORDER_SERVICE_URL = "http://127.0.0.1:8080/order/";

	public void initPayment(int userId, String orderId) throws PaymentFailedException {
		Order order = new RestTemplate().getForObject(ORDER_SERVICE_URL, Order.class, orderId);
		this.makePayment(order.getFinalAmount(),userId);
	}

	private void makePayment(float amount, int userId) throws PaymentFailedException {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(PAYMENT_GATEWAY_URL, HttpMethod.POST, null,
				String.class);
		String body = response.getBody();

		JSONParser parser = new JSONParser();

		try {
			JSONObject jsonObject = (JSONObject) parser.parse(body);
			String responseStatus = (String) jsonObject.get("response");
			if (!response.equals("success")) {
				throw new PaymentFailedException("Payment failed");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
