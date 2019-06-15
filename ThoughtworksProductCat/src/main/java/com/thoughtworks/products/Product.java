package com.thoughtworks.products;

public class Product {
	private int id;
	private float price;
	private Size size;
	private Gender gender;
	private String category;
	private String name;
	private String brand;
	private float discount;
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

	
	
}
