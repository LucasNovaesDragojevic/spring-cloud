package com.provider.repository;

import java.util.List;

import com.provider.model.Provider;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, String>
{
    List<Provider> findByAddressRegion(String region);
}
