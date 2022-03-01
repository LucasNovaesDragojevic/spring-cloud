package com.purchase.client;

import com.purchase.dto.ProviderDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("provider")
public interface ProviderClient 
{
    @GetMapping("providers/search/findByAddressRegion")
    CollectionModel<ProviderDto> findByRegion(@RequestParam String region);
}
