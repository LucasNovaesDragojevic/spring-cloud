package com.purchase.dto;

import javax.validation.constraints.NotEmpty;

import com.purchase.model.Address;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AddressDto 
{
    private String uuid;

    @NotEmpty
    private String street, number, complement, city, region, zip, country;

    public AddressDto(Address address) 
    {
        this.uuid = address.getUuid();
        this.street = address.getStreet();
        this.number = address.getNumber();
        this.complement = address.getComplement();
        this.city = address.getCity();
        this.region = address.getRegion();
        this.zip = address.getZip();
        this.country = address.getCountry();
    }

    public Address generateAddress()
    {
        var address = new Address();
        address.setStreet(street);
        address.setNumber(number);
        address.setComplement(complement);
        address.setCity(city);
        address.setRegion(region);
        address.setZip(zip);
        address.setCountry(country);
        return address;
    }
}
