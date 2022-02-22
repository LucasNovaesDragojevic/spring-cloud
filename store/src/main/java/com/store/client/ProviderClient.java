package com.store.client;

import com.store.dto.InfoProviderDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("provider")
public interface ProviderClient 
{
    @GetMapping("info/{state}")
    InfoProviderDto getProviderByState(@PathVariable String state);
}
