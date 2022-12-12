package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.DiscountDTO;
import com.cydeo.lab08rest.dto.ProductDTO;

import java.util.List;

public interface DiscountService {

    List<DiscountDTO> retrieveAll();

    DiscountDTO update(DiscountDTO discountDTO);

    DiscountDTO create(DiscountDTO discountDTO);

    DiscountDTO retrieveByName(String name);
}
