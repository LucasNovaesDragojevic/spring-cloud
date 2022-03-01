package com.purchase.dto;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.purchase.model.Purchase;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PurchaseDto
{
    private String uuid;

    @NotEmpty
    private Set<PurchaseItemsDto> items;

    @NotNull
    private AddressDto destinationAddress;

    public Set<String> takeItemsIds() 
    {
        return this.items.stream().map(item -> item.getUuid()).collect(Collectors.toSet());
    }

    public String takeDestinationAddressRegion() 
    {
        return this.destinationAddress.getRegion();
    }

    public PurchaseDto(Purchase purchase) 
    {
        this.uuid = purchase.getUuid();
        this.items = purchase.getProducts().stream().map(PurchaseItemsDto::new).collect(Collectors.toSet());
        this.destinationAddress = new AddressDto(purchase.getDestinationAddress());
    }
}
