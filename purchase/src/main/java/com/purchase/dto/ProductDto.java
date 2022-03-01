package com.purchase.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductDto
{
    @NotEmpty
    @EqualsAndHashCode.Include
    private String uuid;

    @NotNull
    private BigDecimal price;
}
