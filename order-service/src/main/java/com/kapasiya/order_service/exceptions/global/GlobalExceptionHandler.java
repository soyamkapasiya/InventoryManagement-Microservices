package com.kapasiya.order_service.exceptions.global;

import com.kapasiya.order_service.dto.response.CustomErrorResponseDto;
import com.kapasiya.order_service.exceptions.custom.OrderException;
import com.kapasiya.order_service.utils.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OrderException.class)
    public ResponseEntity<CustomErrorResponseDto> handelOrderException(
            OrderException ox, WebRequest request){
        CustomErrorResponseDto response = ResponseUtil.buildErrorResponse(
                HttpStatus.NOT_FOUND,ox.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
