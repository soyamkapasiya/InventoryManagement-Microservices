package com.kapasiya.product_service.utils;

import com.kapasiya.product_service.dto.response.CustomErrorResponseDto;
import com.kapasiya.product_service.dto.response.CustomResponseDto;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


public abstract class ResponseUtil {

    private ResponseUtil() {
        throw new UnsupportedOperationException("Util Class");
    }

    public static <T> CustomResponseDto<T> successDataResponse(HttpStatus status, String message, T data) {
        return CustomResponseDto.<T>builder()
                .message(message)
                .success(true)
                .status(status.getReasonPhrase())
                .statusCode(status.value())
                .data(data)
                .build();
    }

    public static CustomResponseDto<Void> successMessageResponse(HttpStatus status, String message) {
        return CustomResponseDto.<Void>builder()
                .message(message)
                .status(status.getReasonPhrase())
                .success(true)
                .statusCode(status.value())
                .build();
    }

    public static CustomResponseDto<Void> errorMessageResponse(HttpStatus status, String message) {
        return CustomResponseDto.<Void>builder()
                .message(message)
                .success(false)
                .status(status.getReasonPhrase())
                .statusCode(status.value())
                .build();
    }

    public static CustomErrorResponseDto buildErrorResponse(HttpStatus status,String message, String endPoint){
        return CustomErrorResponseDto.builder()
                .timestamp(LocalDateTime.now())
                .success(false)
                .message(message)
                .status(status.value())
                .endpoint(endPoint)
                .build();
    }
}
