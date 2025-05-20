package com.shop.service;

import java.util.List;

import com.shop.dao.ProductDaoImpl;
import com.shop.exception.*;
import com.shop.model.Product;

public class ProductService {

	ProductDaoImpl dao=new ProductDaoImpl();
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		
		int id=(int)(Math.random()*1000);
		id+=20250000;
		product.setId(id);
		if(product.getCount() == 0) product.setStatus("OUT-OF-STOCK");
		else product.setStatus("IN-STOCK");
		
		try {
			dao.insert(product);
			System.out.println("Product added Successfully");
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			System.out.println("Input error: "+e.getMessage());
		}
		
	}
	public void viewByCategory(int id) {
		// TODO Auto-generated method stub
		try {
			List<Product> product=dao.getByCategoryId(id);
			product.stream().forEach(l->System.out.println("id: "+l.getId()+" |name: "+l.getName()+
					"| Category_id: "+l.getCategory_id()+"| status "+l.getStatus()));
		} catch (InvalidIdException e) {
			// TODO Auto-generated catch block
			System.out.println("ID not found");
		}
	}

}