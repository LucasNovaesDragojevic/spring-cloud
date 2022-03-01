package com.purchase.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class ExceptionHadler
{
    private static final Logger LOG = LoggerFactory.getLogger(ExceptionHadler.class);

    @ExceptionHandler(BusinessException.class)
    ResponseEntity<BusinessException> handleException(BusinessException businessException)
    {
        LOG.error(businessException.getMessage());
        return ResponseEntity.status(businessException.getStatus()).body(businessException);
    }

    @ExceptionHandler(UuidNotFoundException.class)
    ResponseEntity<BusinessException> handleException(UuidNotFoundException uuidNotFoundException)
    {
        LOG.error(uuidNotFoundException.getMessage());
        return ResponseEntity.status(uuidNotFoundException.getStatus()).body(uuidNotFoundException);
    }
}
