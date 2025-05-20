package com.shop.dao;

import com.shop.exception.InvalidInputException;
import com.shop.model.Purchase;

public interface PurchaseDao {
    void insert(Purchase purchase)throws InvalidInputException;
    }
