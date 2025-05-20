package com.shop.dao;

import java.util.List;

import com.shop.exception.*;
import com.shop.model.Product;

public interface ProductDao {
    void insert(Product product) throws InvalidInputException;
    List<Product> getByCategoryId(int categoryId) throws InvalidIdException;
}
