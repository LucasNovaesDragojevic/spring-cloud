package com.store.service;

import com.store.client.ProviderClient;
import com.store.dto.InfoPurchaseDto;
import com.store.dto.PurchaseDto;
import com.store.dto.PurchaseResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.var;

@Service
public class PurchaseService 
{
    @Autowired
    private ProviderClient providerClient;

    public PurchaseResponse executePurchase(PurchaseDto purchaseDto)
    {
        //var provider = providerClient.getProviderByState(purchaseDto.getAddress().getState());
        var infoPurchaseDto = providerClient.executePurchase(purchaseDto.getItems());
        //System.out.println(provider);
        var purchaseResponse = new PurchaseResponse();
        purchaseResponse.setId(infoPurchaseDto.getId());
        purchaseResponse.setTimeToFinish(infoPurchaseDto.getTimeToFinish());
        purchaseResponse.setAddress(purchaseDto.getAddressInOneString());
        return purchaseResponse;
    }
}
