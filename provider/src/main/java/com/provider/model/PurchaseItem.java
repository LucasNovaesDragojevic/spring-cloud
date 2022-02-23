package com.provider.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class PurchaseItem
{
    @Id
    private String id = UUID.randomUUID().toString();

    private Integer quantity;
	
	@ManyToOne
	private Product product;
}
