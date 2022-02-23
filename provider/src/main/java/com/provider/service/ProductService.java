package com.provider.service;

import java.util.List;

import com.provider.model.Product;
import com.provider.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService 
{
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findByState(String state) 
    {
        return productRepository.findByState(state);
    }
}
