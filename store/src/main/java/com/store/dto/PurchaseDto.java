package com.store.dto;

import java.util.List;

import lombok.Data;

@Data
public class PurchaseDto 
{
    private List<ItemDto> items;
    private AddressDto address;

    public String getAddressInOneString() 
    {
        return this.address.getAddressInOneString();
    }
}
