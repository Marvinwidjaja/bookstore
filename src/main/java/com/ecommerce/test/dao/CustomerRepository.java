package com.ecommerce.test.dao;

import com.ecommerce.test.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
        Customer findByEmail(String theEmail);
}

