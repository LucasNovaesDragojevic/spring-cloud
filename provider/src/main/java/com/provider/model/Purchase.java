package com.provider.model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.EnumType.STRING;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.provider.enumerator.PurchaseStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor
public class Purchase 
{
    @Id
    private String id = UUID.randomUUID().toString();

    private Integer timeToFinish;
	
	@Enumerated(STRING)
	private PurchaseStatus status;
	
	@OneToMany(cascade = ALL)
	private List<PurchaseItem> items;
	
	public Purchase(List<PurchaseItem> items)
    {
		this.items = items;
		this.status = PurchaseStatus.RECEIVED;
	}
}
