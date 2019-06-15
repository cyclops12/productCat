package com.thoughtworks.entity;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Product {
	private int id;
	private float price;///
	private Size size;
	private Gender gender;
	private String category;
	private String name;
	private String brand;
	private float discount;////

	private static final String PRODUCT_DEATIL_URL = "http://demo7594616.mockable.io/products";

	public Product(int id, float price, Size size, Gender gender, String category, String name, String brand,
			float discount) {
		this.id = id;
		this.price = price;
		this.size = size;
		this.gender = gender;
		this.category = category;
		this.name = name;
		this.brand = brand;
		this.discount = discount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", price=" + price + ", size=" + size + ", gender=" + gender + ", category="
				+ category + ", name=" + name + ", brand=" + brand + ", discount=" + discount + "]";
	}

	public float getFinalPrice() {
		getMRP();
		getDiscount();
		return price * (1 - discount / 100);
	}

	public float getDiscount() {
		String discountStr = (String) getProductData().get("discount");
		discount = Float.parseFloat(discountStr.split("%")[0]);
		return price * (discount / 100);
	}

	public float getMRP() {
		price = (float) getProductData().get("price");
		return price;
	}

	private JSONObject getProductData() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(PRODUCT_DEATIL_URL, String.class, id);
		try {
			JSONObject jsonObject = (JSONObject) new JSONParser().parse(response.getBody());
			return jsonObject;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
