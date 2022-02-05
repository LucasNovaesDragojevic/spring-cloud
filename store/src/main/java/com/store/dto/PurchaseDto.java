package com.store.dto;

import java.util.List;

import lombok.Data;

@Data
public class PurchaseDto 
{
    private List<ItemDto> itens;
    private AddressDto address;
}
