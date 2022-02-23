package com.store.client;

import java.util.List;

import com.store.dto.InfoProviderDto;
import com.store.dto.InfoPurchaseDto;
import com.store.dto.ItemDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("provider")
public interface ProviderClient 
{
    @GetMapping("info/{state}")
    InfoProviderDto getProviderByState(@PathVariable String state);

    @PostMapping("purchases")
    InfoPurchaseDto executePurchase(List<ItemDto> items);
}
