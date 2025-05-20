package com.shop.service;

import java.time.LocalDate;

import com.shop.dao.PurchaseDaoImpl;
import com.shop.exception.InvalidInputException;
import com.shop.model.Purchase;

public class PurchaseService {

	PurchaseDaoImpl dao=new PurchaseDaoImpl();
	public void insert(Purchase purchase) {
		// TODO Auto-generated method stub
		int id=(int)(Math.random()*1000);
		purchase.setId(id);
		purchase.setDate(LocalDate.now());
		try {
			dao.insert(purchase);
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

}