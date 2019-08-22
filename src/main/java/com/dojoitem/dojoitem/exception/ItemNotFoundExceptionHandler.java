package com.dojoitem.dojoitem.exception;


import com.dojoitem.dojoitem.item.ItemEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ItemNotFoundExceptionHandler  {
    @ExceptionHandler(DataNotFoundException.class)
    public final ResponseEntity<Object> DataNotFoundException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}