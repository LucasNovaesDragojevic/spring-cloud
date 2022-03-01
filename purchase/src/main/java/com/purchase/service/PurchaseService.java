package com.purchase.service;

import static com.purchase.exception.BusinessError.NOT_FOUND_PURCHASE_WITH_UUID;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.Set;

import javax.transaction.Transactional;

import com.purchase.exception.BusinessException;
import com.purchase.model.Address;
import com.purchase.model.Product;
import com.purchase.model.Purchase;
import com.purchase.repository.PurchaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PurchaseService 
{
    @Autowired
    private PurchaseRepository purchaseRepository;

    public Purchase createPurchase(String providerUuid, Address destinationAddress, Set<Product> products) 
    {
        var purchase = new Purchase();
        purchase.setProducts(products);
        purchase.setProviderUuid(providerUuid);
        purchase.setDestinationAddress(destinationAddress);
        return purchaseRepository.save(purchase);
    }

    public Page<Purchase> findAll(Pageable pageable) 
    {
        return purchaseRepository.findAll(pageable);
    }

    public Purchase findByUuid(String uuid) 
    {
        return purchaseRepository.findByUuid(uuid).orElseThrow(() -> new BusinessException("Can not find purchase by uuid " + uuid, NOT_FOUND, NOT_FOUND_PURCHASE_WITH_UUID));
    }
}
