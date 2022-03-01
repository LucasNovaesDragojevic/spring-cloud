package com.product.repository;

import java.util.Collection;

import com.product.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String>
{
    Collection<Product> findByUuidIn(Collection<String> uuids);
}
