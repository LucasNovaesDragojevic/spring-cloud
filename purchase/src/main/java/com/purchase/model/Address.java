package com.purchase.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address 
{
    @Id
    @GeneratedValue
    private Integer id;
    
    @EqualsAndHashCode.Include
    @Column(nullable = false, unique = true)
    private String uuid = UUID.randomUUID().toString();

    @Column(nullable = false)
    private String street;
    
    @Column(nullable = false)
    private String number;
    
    @Column(nullable = false)
    private String complement;
    
    @Column(nullable = false)
    private String city;
    
    @Column(nullable = false)
    private String region;
    
    @Column(nullable = false)
    private String zip;
    
    @Column(nullable = false)
    private String country;
}
