package com.store.book.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.store.book.exception.SNNotFoundException;

class PricingServiceImplTest {

	private final PricingServiceImpl pricingService = new PricingServiceImpl();

	@Test
	void shouldReturnPriceForValidSerialNumber() {
		String serialNumber = "10001";

		BigDecimal price = pricingService.getPrice(serialNumber);

		assertNotNull(price, "Price should not be null");
		assertEquals(new BigDecimal("50"), price, "Price should match expected value");
	}

	@Test
	void shouldThrowExceptionForInvalidSerialNumber() {
		String invalidSerialNumber = "99999";

		assertThrows(SNNotFoundException.class, () -> pricingService.getPrice(invalidSerialNumber),
				"Should throw SNNotFoundException for invalid serial number");
	}

}
