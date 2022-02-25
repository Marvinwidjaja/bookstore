package com.ecommerce.test.dto;


import com.ecommerce.test.entity.Address;
import com.ecommerce.test.entity.Customer;
import com.ecommerce.test.entity.Order;
import com.ecommerce.test.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
