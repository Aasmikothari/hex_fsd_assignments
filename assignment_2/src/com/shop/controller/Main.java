package com.shop.controller;

import java.util.Scanner;

import com.shop.dao.ProductDaoImpl;
import com.shop.dao.PurchaseDaoImpl;
import com.shop.enums.Cupon;
import com.shop.model.Product;
import com.shop.model.Purchase;
import com.shop.service.ProductService;
import com.shop.service.PurchaseService;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Product product=new Product();
		ProductDaoImpl productDao=new ProductDaoImpl();
		ProductService productService=new ProductService();
		Purchase purchase=new Purchase();
		PurchaseDaoImpl purchaseDao=new PurchaseDaoImpl();
		PurchaseService purchaseService=new PurchaseService();
		while(true) {
			System.out.println("----------STORE--------");
			System.out.println("1.Add product");
			System.out.println("2.View products by category");
			System.out.println("3.Purchase product");
			System.out.println("0.EXIT");
			switch(sc.nextInt()) {
			
			case 1:
				System.out.println("Enter product name: ");
				sc.nextLine();
				product.setName(sc.nextLine());
				System.out.println("Enter category id: ");
				product.setCategory_id(sc.nextInt());
				System.out.println("Enter price: ");
				product.setPrice(sc.nextDouble());
				System.out.println("Enter product count: ");
				product.setCount(sc.nextInt());
				productService.addProduct(product);
				break;
			case 2:
				System.out.println("Enter Category ID: ");
				productService.viewByCategory(sc.nextInt());
				break;
			case 3:
				System.out.println("Enter customer id");
				purchase.setCustomer_id(sc.nextInt());
				System.out.println("Enter purchase id");
				purchase.setProduct_id(sc.nextInt());
				sc.nextLine();
				System.out.println("Do you have any cupon code(Y/N)");
				if(sc.nextLine().equalsIgnoreCase("Y")) {
					System.out.println("Enter coupon code");
					String cupon=sc.nextLine();
					try {
						purchase.setCoupon_code(Cupon.valueOf(cupon));
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("Coupon not available");
					}
				}
				purchaseService.insert(purchase);
				break;
			case 0:
			{
				System.out.println("Exiting....");
				return;
			}
			default:{
				System.out.println("Enter valid choice");
			}
					
			}
		}
	}
}