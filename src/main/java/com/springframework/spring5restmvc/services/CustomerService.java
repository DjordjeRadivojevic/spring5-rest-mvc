package com.springframework.spring5restmvc.services;

import com.springframework.spring5restmvc.api.v1.model.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    CustomerDTO findByFirstName(String firstName);
    CustomerDTO getCustomerById(Long id);
}
