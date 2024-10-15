package com.kapasiya.inventory_service.exceptions.global;

import com.kapasiya.inventory_service.dto.CustomErrorResponseDto;
import com.kapasiya.inventory_service.exceptions.custom.InventoryException;
import com.kapasiya.inventory_service.utils.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InventoryException.class)
    public ResponseEntity<CustomErrorResponseDto> handelOrderException(
            InventoryException ix, WebRequest request){
        CustomErrorResponseDto response = ResponseUtil.buildErrorResponse(
                HttpStatus.NOT_FOUND,ix.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
