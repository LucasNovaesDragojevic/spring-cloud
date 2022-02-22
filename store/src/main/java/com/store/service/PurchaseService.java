package com.store.service;

import com.store.client.ProviderClient;
import com.store.dto.PurchaseDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService 
{
    @Autowired
    private ProviderClient providerClient;

    public void executePurchase(PurchaseDto purchaseDto)
    {
        var provider = providerClient.getProviderByState(purchaseDto.getAddress().getState());
        System.out.println(provider);
    }
}
