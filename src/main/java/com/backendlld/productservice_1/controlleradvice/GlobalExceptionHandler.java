package com.backendlld.productservice_1.controlleradvice;

import com.backendlld.productservice_1.dtos.MethodArgumentNotValidExceptionResponseDto;
import com.backendlld.productservice_1.dtos.ProductNotFoundExceptionDto;
import com.backendlld.productservice_1.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
    public ResponseEntity<MethodArgumentNotValidExceptionResponseDto> handleIllegalArgument(IllegalArgumentException e) {
        MethodArgumentNotValidExceptionResponseDto responseDto = new MethodArgumentNotValidExceptionResponseDto();
        responseDto.setMessage(e.getMessage());
        responseDto.setResolution("Please provide valid input1");
        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MethodArgumentNotValidExceptionResponseDto> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        MethodArgumentNotValidExceptionResponseDto responseDto = new MethodArgumentNotValidExceptionResponseDto();
        responseDto.setMessage(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        responseDto.setResolution("Please provide valid input");
        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }
}
