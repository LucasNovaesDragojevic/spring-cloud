package com.provider.repository;

import java.util.Optional;

import com.provider.model.InfoProvider;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepository extends JpaRepository<InfoProvider, String>
{
    Optional<InfoProvider> findByState(String state);
}
