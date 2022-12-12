package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.CustomerDTO;
import com.cydeo.lab08rest.dto.DiscountDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO findById(Long customerId);

    List<CustomerDTO> retrieveAll();

    CustomerDTO update(CustomerDTO customerDTO);

    CustomerDTO create(CustomerDTO customerDTO);

    CustomerDTO retrieveByEmail(String email);
}
