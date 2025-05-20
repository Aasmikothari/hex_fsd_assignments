package com.shop.model;

import java.time.LocalDate;

import com.shop.enums.Cupon;

public class Purchase {

	private int id,customer_id,product_id;
	private LocalDate date;
	private Cupon coupon_code;
	
	
	public Purchase() {}

	

	public Purchase(int id, int customer_id, int product_id, LocalDate date, Cupon coupon_code) {
		super();
		this.id = id;
		this.customer_id = customer_id;
		this.product_id = product_id;
		this.date = date;
		this.coupon_code = coupon_code;
		
	}



	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public int getCustomer_id() {return customer_id;}
	public void setCustomer_id(int customer_id) {this.customer_id = customer_id;}
	public int getProduct_id() {return product_id;}
	public void setProduct_id(int product_id) {this.product_id = product_id;}
	public LocalDate getDate() {return date;}
	public void setDate(LocalDate date) {this.date = date;}
	public Cupon getCoupon_code() {return coupon_code;}
	public void setCoupon_code(Cupon coupon_code) {this.coupon_code = coupon_code;}
	
}