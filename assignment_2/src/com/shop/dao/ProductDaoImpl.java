package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.exception.*;
import com.shop.model.Product;
import com.shop.utility.DBUtility;

public class ProductDaoImpl implements ProductDao{
	DBUtility db=DBUtility.getInstance();
	@Override
	public void insert(Product product) throws InvalidInputException {
		// TODO Auto-generated method stub
		Connection conn=db.connect();
		String query="insert into product (id,name,count,status,category_id,price) "
				+ "values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, product.getId());
			ps.setString(2, product.getName());
			ps.setInt(3, product.getCount());
			ps.setString(4, product.getStatus());
			ps.setInt(5, product.getCategory_id());
			ps.setDouble(6, product.getPrice());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}finally {
			db.close();
		}
		
	}

	@Override
	public List<Product> getByCategoryId(int id) throws InvalidIdException{
		String query="Select * from product where category_id=?";
		List<Product> list=new ArrayList<Product>();
		Connection conn=db.connect();
		Product product=new Product();
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				product.setId(rs.getInt("id"));
				product.setStatus(rs.getString("status"));
				product.setCategory_id(rs.getInt("category_id"));
				product.setName(rs.getString("name"));
				list.add(product);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error retreving data: "+e.getMessage());
		}
		
		return null;
		// TODO Auto-generated method stub	
		
	}
}