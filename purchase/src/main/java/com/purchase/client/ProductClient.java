package com.purchase.client;

import java.util.Set;

import com.purchase.dto.ProductDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("product")
public interface ProductClient
{
    @GetMapping("products/search/findByUuidIn")
    CollectionModel<ProductDto> findByUuidIn(@RequestParam Set<String> uuids);
}
