package com.store.dto;

import lombok.Data;

@Data
public class AddressDto 
{
    private String street;
    private String number;
    private String state;

    public String getAddressInOneString() 
    {
        return street + " " + number + " " + state;
    }

}
