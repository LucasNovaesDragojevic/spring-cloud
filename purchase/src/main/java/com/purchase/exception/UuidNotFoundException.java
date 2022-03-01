package com.purchase.exception;

import java.util.Set;

import org.springframework.http.HttpStatus;

import lombok.Getter;

public class UuidNotFoundException extends BusinessException
{
    @Getter
    private Set<String> uuids;

    public UuidNotFoundException(String message, HttpStatus status, BusinessError businessError, Set<String> uuids)
    {
        super(message, status, businessError);
        this.uuids = uuids;
    }
    
}
