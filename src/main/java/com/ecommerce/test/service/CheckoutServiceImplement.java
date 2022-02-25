package com.ecommerce.test.service;

import com.ecommerce.test.dao.CustomerRepository;
import com.ecommerce.test.dto.Purchase;
import com.ecommerce.test.dto.PurchaseResponse;
import com.ecommerce.test.entity.Customer;
import com.ecommerce.test.entity.Order;
import com.ecommerce.test.entity.OrderItem;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImplement implements CheckoutService {

    private CustomerRepository customerRepository;

    public CheckoutServiceImplement(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // retrieve the order info from dto
        Order order = purchase.getOrder();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        // populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        // populate customer with order
        Customer customer = purchase.getCustomer();
        String theEmail =customer.getEmail();
        Customer customerFromDB = customerRepository.findByEmail(theEmail);
        if ( customerFromDB != null){
            customer= customerFromDB;
        }
        customer.add(order);



        customerRepository.save(customer);


        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        return UUID.randomUUID().toString();
    }
}
