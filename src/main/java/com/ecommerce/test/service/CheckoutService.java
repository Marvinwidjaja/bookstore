package com.ecommerce.test.service;

import com.ecommerce.test.dto.Purchase;
import com.ecommerce.test.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
