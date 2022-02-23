package com.provider.service;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.List;

import javax.transaction.Transactional;

import com.provider.dto.PurchaseItemDto;
import com.provider.model.Purchase;
import com.provider.model.PurchaseItem;
import com.provider.repository.PurchaseRepository;
import com.provider.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import ch.qos.logback.core.net.SyslogOutputStream;

@Service
@Transactional
public class PurchaseService
{
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ProductRepository productRepository;

    public Purchase findById(String id) 
    {
        return this.purchaseRepository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
    }

    public Purchase execute(List<PurchaseItemDto> purchaseItemsDto) 
    {
        var purchaseItems = this.toPurchaseItems(purchaseItemsDto);
        var purchase = new Purchase(purchaseItems);
        purchase.setTimeToFinish(purchaseItemsDto.size());
        return purchaseRepository.save(purchase);
    }

    private List<PurchaseItem> toPurchaseItems(List<PurchaseItemDto> purchaseItemsDto)
    {
        var idsOfProducts = purchaseItemsDto.stream().map(item -> item.getId()).collect(toList());
        var products = productRepository.findAllById(idsOfProducts);
        var purchaseItems = purchaseItemsDto.stream()
                                            .map(purchaseItemDto -> {
                                                var product = products.stream().filter(p -> purchaseItemDto.getId().equals(p.getId())).findFirst().get();
                                                var purchaseItem = new PurchaseItem();
                                                purchaseItem.setProduct(product);
                                                purchaseItem.setQuantity(purchaseItemDto.getQuantity());
                                                return purchaseItem;
                                            })
                                            .collect(toList());
        return purchaseItems;
    }
}
