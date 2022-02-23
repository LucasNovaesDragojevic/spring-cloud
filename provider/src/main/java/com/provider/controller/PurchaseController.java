package com.provider.controller;

import java.util.List;

import com.provider.dto.PurchaseItemDto;
import com.provider.model.Purchase;
import com.provider.service.PurchaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("purchases")
public class PurchaseController
{
    @Autowired
	private PurchaseService purchaseService;	
	
	@GetMapping("{id}")
	public Purchase findById(@PathVariable String id) 
    {
        return purchaseService.findById(id);
	}

    @PostMapping
    public Purchase execute(@RequestBody List<PurchaseItemDto> purchaseItemsDto) 
    {
        return purchaseService.execute(purchaseItemsDto);
    }
}
