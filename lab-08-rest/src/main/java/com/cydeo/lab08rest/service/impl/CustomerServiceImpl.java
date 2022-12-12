package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.CustomerDTO;
import com.cydeo.lab08rest.dto.DiscountDTO;
import com.cydeo.lab08rest.entity.Customer;
import com.cydeo.lab08rest.entity.Discount;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.CustomerRepository;
import com.cydeo.lab08rest.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final MapperUtil mapperUtil;
    private final CustomerRepository customerRepository;;

    public CustomerServiceImpl(MapperUtil mapperUtil, CustomerRepository customerRepository) {
        this.mapperUtil = mapperUtil;
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDTO findById(Long customerId) {
        return customerRepository.findById(customerId).stream()
                .map(customer -> mapperUtil.convert(customer, new CustomerDTO())).findFirst().orElseThrow();
    }

    @Override
    public List<CustomerDTO> retrieveAll() {
        return customerRepository.findAll().stream()
                .map(customer->mapperUtil.convert(customer, new CustomerDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO update(CustomerDTO customerDTO) {
//        Customer customer = customerRepository.save(mapperUtil.convert(customerDTO, new Customer()));
//        return mapperUtil.convert(customer, new CustomerDTO());

        //assume that userName - is unique field:
        Customer customer = customerRepository.findByUserName(customerDTO.getUserName());
        //all fields will assigne:
        //customerRepository.save(mapperUtil.convert(customer, new CustomerDTO());

        //i want to set specific field:
        customer.setEmail(customerDTO.getEmail());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());

        Customer savedCustomer = customerRepository.save(customer);

        return mapperUtil.convert(savedCustomer, new CustomerDTO());
    }

    @Override
    public CustomerDTO create(CustomerDTO customerDTO) {
        Customer customer = customerRepository.save(mapperUtil.convert(customerDTO, new Customer()));
        return mapperUtil.convert(customer, new CustomerDTO());
    }

    @Override
    public CustomerDTO retrieveByEmail(String email) {
        return mapperUtil.convert(customerRepository.retrieveByCustomerEmail(email), new CustomerDTO());
    }
}
