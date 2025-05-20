package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.shop.exception.InvalidInputException;
import com.shop.model.Purchase;
import com.shop.utility.DBUtility;

public class PurchaseDaoImpl implements PurchaseDao{

	DBUtility db=DBUtility.getInstance();
	@Override
	public void insert(Purchase purchase)throws InvalidInputException {
		// TODO Auto-generated method stub
		String query="insert into purchase(id,customer_id,product_id,purchase_date,cupon_code)"
				+ "values(?,?,?,?,?)";
		Connection conn=db.connect();
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, purchase.getId());
			ps.setInt(2, purchase.getCustomer_id());
			ps.setInt(3, purchase.getProduct_id());
			ps.setString(4, purchase.getDate().toString());
			ps.setString(5, purchase.getCoupon_code().toString());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error inserting data: "+e.getMessage());
		}
		
	}

}