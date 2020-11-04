package com.springframework.spring5restmvc.api.v1.mapper;

import com.springframework.spring5restmvc.api.v1.model.CustomerDTO;
import com.springframework.spring5restmvc.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    CustomerDTO customerToCustomerDTO(Customer customer);
}