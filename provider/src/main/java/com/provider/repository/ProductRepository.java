package com.provider.repository;

import java.util.List;

import com.provider.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>
{
    List<Product> findByState(String state);
}
