package com.purchase.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException
{
    private HttpStatus status;
    private BusinessError businessError;
    
    public BusinessException(String message, HttpStatus status, BusinessError businessError)
    {
        super(message);
        this.status = status;
        this.businessError = businessError;
    }

    @JsonIgnore
    public HttpStatus getStatus()
    {
        return this.status;
    }

    public String getErrorCode()
    {
        return this.businessError.getCode();
    }

    public String getErrorMessage()
    {
        return this.businessError.getErrorMessage();
    }

    @Override
    @JsonIgnore
    public synchronized Throwable getCause() 
    {
        return super.getCause();
    }

    @Override
    @JsonIgnore
    public String getLocalizedMessage() 
    {
        return super.getLocalizedMessage();
    }

    @Override
    @JsonIgnore
    public String getMessage()
    {
        return super.getMessage();
    }

    @Override
    @JsonIgnore
    public StackTraceElement[] getStackTrace() 
    {
        return super.getStackTrace();
    }    
}
