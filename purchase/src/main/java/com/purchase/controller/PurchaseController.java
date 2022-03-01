package com.purchase.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import javax.validation.Valid;

import com.purchase.dto.PurchaseDto;
import com.purchase.service.ProductService;
import com.purchase.service.ProviderService;
import com.purchase.service.PurchaseService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("purchases")
class PurchaseController
{
    private static final Logger LOG = LoggerFactory.getLogger(PurchaseController.class);

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private ProviderService providerService;

    @Autowired
    private ProductService productService;

    @PostMapping
    ResponseEntity<EntityModel<PurchaseDto>> createPurchase(@RequestBody @Valid PurchaseDto purchaseDto)
    {
        LOG.debug("Received request to create purchase with object: {} ", purchaseDto);
        var region = purchaseDto.takeDestinationAddressRegion();
        var providersDtos = providerService.findByRegion(region);
        var providerDto = providerService.chooseTheBest(providersDtos);
        var itemsIds = purchaseDto.takeItemsIds();        
        var productsDtos = productService.findByUuidIn(itemsIds);
        var products = productService.generateProducts(purchaseDto.getItems(), productsDtos);
        var destinationAddress = purchaseDto.getDestinationAddress().generateAddress();
        var purchase = purchaseService.createPurchase(providerDto.getUuid(), destinationAddress, products);
        var purchaseDtoResponse = new PurchaseDto(purchase);
        var link = linkTo(PurchaseController.class).slash(purchase.getUuid()).withSelfRel();
        var purchaseHateoas = EntityModel.of(purchaseDtoResponse).add(link);
        return ResponseEntity.created(link.toUri()).body(purchaseHateoas);
    }

    @GetMapping
    Page<EntityModel<PurchaseDto>> findAll(Pageable pageable)
    {
        var pageOfPurchase = purchaseService.findAll(pageable);
        var pageOfEntityModel = pageOfPurchase.map(purchase -> {
            var link = linkTo(PurchaseController.class).slash(purchase.getUuid()).withSelfRel();
            var purchaseDtoResponse = new PurchaseDto(purchase);
            return EntityModel.of(purchaseDtoResponse).add(link);
        });
        return pageOfEntityModel;
    }
    
    @GetMapping("{uuid}")
    EntityModel<PurchaseDto> findByUuid(@PathVariable String uuid)
    {
        var purchase = purchaseService.findByUuid(uuid);
        var link = linkTo(PurchaseController.class).slash(purchase.getUuid()).withSelfRel();
        var purchaseDtoResponse = new PurchaseDto(purchase);
        return EntityModel.of(purchaseDtoResponse).add(link);
    }
}
