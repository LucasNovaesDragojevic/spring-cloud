package com.purchase.repository;

import java.util.Optional;

import com.purchase.model.Purchase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer>
{
    Optional<Purchase> findByUuid(String uuid);
}
