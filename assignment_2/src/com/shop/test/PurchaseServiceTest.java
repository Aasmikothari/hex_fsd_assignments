package com.shop.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.shop.enums.Cupon;
import com.shop.model.Purchase;
import com.shop.service.PurchaseService;

public class PurchaseServiceTest {

	PurchaseService purchaseService;
	Purchase purchase;

	@BeforeEach
	public void init() {
		purchaseService = new PurchaseService();
		purchase = new Purchase();
		purchase.setCustomer_id(101);
		purchase.setProduct_id(202);
		purchase.setCoupon_code(Cupon.DIWALI_05);
	}

	@Test
	public void testInsertPurchase() {
		// Use Case: Inserting a valid purchase
		assertDoesNotThrow(() -> {
			purchaseService.insert(purchase);
		});

		// Validate that values were set
		assertNotNull(purchase.getId(), "Purchase ID should be auto-assigned");
		assertNotNull(purchase.getDate(), "Purchase date should be auto-assigned");

		// Validate date is today
		assertNotNull(purchase.getDate());
		assert purchase.getDate().equals(LocalDate.now());
	}
}

