package com.provider.model;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Product 
{
    @Id
    private String id = UUID.randomUUID().toString();
	
	private String name;
	
	private String state;
	
	private String description;
	
	private BigDecimal price;
}
