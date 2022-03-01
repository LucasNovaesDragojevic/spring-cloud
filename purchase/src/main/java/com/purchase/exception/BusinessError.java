package com.purchase.exception;

public enum BusinessError 
{
    NOT_FOUND_PRODUCTS_WITH_UUID("ERROR.PRODUCT.NOT_FOUND", "Not found product(s) with UUID(s) informed."), 
    NOT_FOUND_PURCHASE_WITH_UUID("ERROR.PURCHASE.NOT_FOUND", "Not found purchase(s) with UUID(s) informed.");

    private String errorCode;
    private String errorMessage;
    
    BusinessError(String errorCode, String errorMessage)
    {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getCode() 
    {
        return this.errorCode;
    }

    public String getErrorMessage()
    {
        return this.errorMessage;
    }
}
