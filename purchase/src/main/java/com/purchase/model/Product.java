package com.purchase.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product 
{
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Integer id;
    
    @EqualsAndHashCode.Include
    @Column(nullable = false)
    private String uuid;

    @Column(nullable = false)
    private Short quantity;

    @Column(nullable = false)
    private BigDecimal price;

    public Product(String uuid, Short quantity, BigDecimal price) 
    {
        this.uuid = uuid;
        this.quantity = quantity;
        this.price = price;
    }
}
