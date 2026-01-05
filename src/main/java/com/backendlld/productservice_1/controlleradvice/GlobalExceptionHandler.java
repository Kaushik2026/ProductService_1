package com.backendlld.productservice_1.controlleradvice;

import com.backendlld.productservice_1.dtos.ProductNotFoundExceptionDto;
import com.backendlld.productservice_1.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDto> productNotFound(ProductNotFoundException productNotFoundException){
        ProductNotFoundExceptionDto productNotFoundExceptionDto = new ProductNotFoundExceptionDto();
        productNotFoundExceptionDto.setMessage("Product Not Found with given Id - "+productNotFoundException.getId());
        productNotFoundExceptionDto.setResolution("Please try passing a valid Id");
        return new ResponseEntity<>(productNotFoundExceptionDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgument(IllegalArgumentException e) {
        Map<String, String> error = Map.of(
                "error", "Validation Failed",
                "message", e.getMessage()
        );
        return ResponseEntity.badRequest().body(error);
    }
}
