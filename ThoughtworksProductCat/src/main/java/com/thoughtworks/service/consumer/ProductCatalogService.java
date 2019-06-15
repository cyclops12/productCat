package com.thoughtworks.service.consumer;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.parser.ProductParser;
import com.thoughtworks.entity.Product;

@Service
public class ProductCatalogService {
	private static final String url = "http://demo7594616.mockable.io/products";
	
	private Map<Integer, Product> productCatalog;
	public void getProducts() {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		String body = response.getBody();
		productCatalog = ProductParser.parseProduct(body);
	}

	public Product getProduct(Integer productId) {
		return productCatalog.get(productId);
	}
	
}
