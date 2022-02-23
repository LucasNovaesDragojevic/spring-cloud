package com.store.dto;

import lombok.Data;

@Data 
public class PurchaseResponse 
{
    private String id;
    private String address;
    private Integer timeToFinish;
}
