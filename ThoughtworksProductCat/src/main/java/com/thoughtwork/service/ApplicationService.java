package com.thoughtwork.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.thoughtworks.entity.Cart;

public class ApplicationService {
	private Map<Integer, Cart> userCart;

	@PostConstruct
	public void init() {
		userCart = new HashMap<>();
	}
}
