package com.purchase.dto;

import javax.validation.constraints.NotEmpty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProviderDto 
{
    @NotEmpty
    @EqualsAndHashCode.Include
    private String uuid;
}
