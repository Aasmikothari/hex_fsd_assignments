package com.shop.model;

public class Product {

	private int id,count,category_id;
	private String name,status;
	private double price,discount;
	
	public Product() {}

	public Product(int id, int count, int category_id, String name, String status, double price, double discount) {
		super();
		this.id = id;
		this.count = count;
		this.category_id = category_id;
		this.name = name;
		this.status = status;
		this.price = price;
		this.discount = discount;
	}

	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public int getCount() {return count;}
	public void setCount(int count) {this.count = count;}
	public int getCategory_id() {return category_id;}
	public void setCategory_id(int category_id) {this.category_id = category_id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getStatus() {return status;}
	public void setStatus(String status) {this.status = status;}
	public double getPrice() {return price;}
	public void setPrice(double price) {this.price = price;}
	public double getDiscount() {return discount;}
	public void setDiscount(double discount) {this.discount = discount;}
}