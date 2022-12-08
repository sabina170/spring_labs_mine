package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> retrieveListProduct();
    ProductDTO updateProduct(ProductDTO productDTO);

    ProductDTO createProduct(ProductDTO productDTO);

    ProductDTO retrieveProductByCategoryAndPrice();

    ProductDTO retrieveByName(String name);

    List<ProductDTO> retrieveProductByTup3ProductByPrice();
}
