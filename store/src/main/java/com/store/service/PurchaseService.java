package com.store.service;

import com.store.dto.InfoProviderDto;
import com.store.dto.PurchaseDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PurchaseService 
{
    @Autowired
    private RestTemplate restTemplate;

    public void executePurchase(PurchaseDto purchaseDto)
    {
        var exchange = restTemplate.exchange("http://provider/info/" + purchaseDto.getAddress().getState(),
                                HttpMethod.GET, 
                                null, 
                                InfoProviderDto.class);
        System.out.println(exchange);
    }
}
