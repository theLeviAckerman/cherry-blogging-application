package com.cherry.blogging.execption;

import com.cherry.blogging.dto.CommonApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CommonApiResponse> resourceNotFound (ResourceNotFoundException exception){

        String exceptionMessage = exception.getMessage();
        CommonApiResponse apiResponse = new CommonApiResponse(exceptionMessage, false, HttpStatus.NOT_FOUND);
        return new ResponseEntity<CommonApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
    }
}
