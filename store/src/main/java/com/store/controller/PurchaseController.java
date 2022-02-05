package com.store.controller;

import com.store.dto.PurchaseDto;
import com.store.service.PurchaseService;

import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    void purchase(@RequestBody PurchaseDto purchaseDto)
    {
        purchaseService.executePurchase(purchaseDto);
    }
}
