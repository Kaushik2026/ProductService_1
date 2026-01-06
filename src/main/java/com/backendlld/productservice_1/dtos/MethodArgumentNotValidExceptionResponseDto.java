package com.backendlld.productservice_1.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MethodArgumentNotValidExceptionResponseDto {
    private String message;
    private String resolution;

}
