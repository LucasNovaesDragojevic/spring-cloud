package com.purchase.service;

import static com.purchase.exception.BusinessError.NOT_FOUND_PRODUCTS_WITH_UUID;
import static java.util.stream.Collectors.toSet;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

import java.util.HashSet;
import java.util.Set;

import com.purchase.client.ProductClient;
import com.purchase.dto.ProductDto;
import com.purchase.dto.PurchaseItemsDto;
import com.purchase.exception.UuidNotFoundException;
import com.purchase.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;

@Service
public class ProductService
{
    @Autowired
    private ProductClient productClient;

    @Bulkhead(name = "ProductService.findByUuidIn")
    public Set<ProductDto> findByUuidIn(Set<String> itemsIds) 
    {
        var collectionModel = productClient.findByUuidIn(itemsIds);
        var productsDtosCollection = collectionModel.getContent();
        
        if (itemsIds.size() != productsDtosCollection.size())
        {
            var productsDtosUuids = productsDtosCollection.stream().map(productDto -> productDto.getUuid()).collect(toSet());
            var itemsIdsNotFounded = itemsIds.stream().filter(itemUuid -> !productsDtosUuids.contains(itemUuid)).collect(toSet());
            throw new UuidNotFoundException("Not found products with UUIDs: " + itemsIdsNotFounded, BAD_REQUEST, NOT_FOUND_PRODUCTS_WITH_UUID, itemsIdsNotFounded);
        }

        return productsDtosCollection.stream().collect(toSet());
    }

    public Set<Product> generateProducts(Set<PurchaseItemsDto> purchaseItemsDtos, Set<ProductDto> productsDtos) 
    {
        var products = new HashSet<Product>();
        purchaseItemsDtos.forEach(purchaseItemDto -> {
            productsDtos.forEach(productDto -> {
                if (purchaseItemDto.getUuid().equals(productDto.getUuid())) {
                    products.add(new Product(purchaseItemDto.getUuid(), purchaseItemDto.getQuantity(), productDto.getPrice()));
                }
            });
        });
        return products;
    }
}
