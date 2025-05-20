package com.shop.enums;

public enum Cupon {
	BLACK_FRIDAY_10(10),
	BLACK_FRIDAY_20(20),
	DIWALI_05(5),
	DIWALI_10(10);
	
	private int value;
	
	Cupon(int val){
		this.value=val;
	}

	public int getValue() {
		return value;
	}
	
	
}