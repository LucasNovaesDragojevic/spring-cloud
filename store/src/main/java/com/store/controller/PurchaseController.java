package com.store.controller;

import com.store.dto.PurchaseDto;
import com.store.dto.PurchaseResponse;
import com.store.service.PurchaseService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("purchases")
public class PurchaseController 
{
    private static final Logger LOG = LoggerFactory.getLogger(PurchaseController.class);

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping
    PurchaseResponse purchase(@RequestBody PurchaseDto purchaseDto)
    {
        LOG.info("Executing purchase");
        return purchaseService.executePurchase(purchaseDto);
    }
}
