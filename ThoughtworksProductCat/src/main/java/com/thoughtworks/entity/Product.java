package com.thoughtworks.entity;

public class Product {
	private int id;
	private float price;///
	private Size size;
	private Gender gender;
	private String category;
	private String name;
	private String brand;
	private float discount;////
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
		return price*(1-discount/100);
	}
	
	public float getDiscount() {
		return price*(discount/100);
	}
	public float getMRP() {
		return price;
	}
	
	
	
	
	
	
	

	
	
}
