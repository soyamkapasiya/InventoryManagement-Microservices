package com.kapasiya.product_service.exceptions.global;

import com.kapasiya.product_service.dto.response.CustomErrorResponseDto;
import com.kapasiya.product_service.exceptions.custom.ProductException;
import com.kapasiya.product_service.utils.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<CustomErrorResponseDto> handelProductException(
            ProductException px, WebRequest request){
        CustomErrorResponseDto response = ResponseUtil.buildErrorResponse(
                HttpStatus.NOT_FOUND,px.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
