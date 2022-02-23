package com.provider.controller;

import java.util.List;

import com.provider.model.Product;
import com.provider.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController 
{
    @Autowired
    private ProductService productService;

    @GetMapping("{state}")
    List<Product> findByState(@PathVariable String state)
    {
        return productService.findByState(state);
    }
}
