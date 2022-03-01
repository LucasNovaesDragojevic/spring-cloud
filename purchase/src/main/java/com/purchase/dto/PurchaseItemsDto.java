package com.purchase.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.purchase.model.Product;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PurchaseItemsDto 
{
    @NotEmpty
    @EqualsAndHashCode.Include
    private String uuid;

    @NotNull
    private Short quantity;

    private BigDecimal price;

    public PurchaseItemsDto(Product product)
    {
        this.uuid = product.getUuid();
        this.quantity = product.getQuantity();
        this.price = product.getPrice();
    }
}
