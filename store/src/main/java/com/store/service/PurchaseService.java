package com.store.service;

import com.store.dto.InfoProviderDto;
import com.store.dto.PurchaseDto;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PurchaseService 
{
    public void executePurchase(PurchaseDto purchaseDto)
    {
        var restTemplate = new RestTemplate();
        var exchange = restTemplate.exchange("http://localhost:8081/info/" + purchaseDto.getAddress().getState(),
                                HttpMethod.GET, 
                                null, 
                                InfoProviderDto.class);
        System.out.println(exchange);
    }
}
