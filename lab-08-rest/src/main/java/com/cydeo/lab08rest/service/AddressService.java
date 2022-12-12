package com.cydeo.lab08rest.service;


import com.cydeo.lab08rest.dto.AddressDTO;

import java.util.List;

public interface AddressService {

    List<AddressDTO> retrieveAll();
    AddressDTO update(AddressDTO addressDTO);
    AddressDTO create(AddressDTO addressDTO);

    List<AddressDTO> retrieveByStartsWith(String address);

    List<AddressDTO> retrieveByCustomerId(Long id);

    List<AddressDTO> retrieveByCustomerIdAndName(Long customerId, String name);
}
