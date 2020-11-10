package com.springframework.spring5restmvc.repositories;

import com.springframework.spring5restmvc.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByFirstName(String firstName);
}
