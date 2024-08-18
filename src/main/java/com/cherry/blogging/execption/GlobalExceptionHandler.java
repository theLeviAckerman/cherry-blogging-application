package com.cherry.blogging.execption;

import com.cherry.blogging.dto.CommonApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CommonApiResponse> resourceNotFound (ResourceNotFoundException exception){

        String exceptionMessage = exception.getMessage();
        CommonApiResponse apiResponse = new CommonApiResponse(exceptionMessage, false, HttpStatus.NOT_FOUND);
        return new ResponseEntity<CommonApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> methodArgumentNotValidException (MethodArgumentNotValidException exception){

       Map<String,String> errorMap = new HashMap<>();

       exception.getBindingResult().getAllErrors().forEach((error) -> {
           String field = ((FieldError) error).getField();
           String errorMessage = error.getDefaultMessage();
           errorMap.put(field,errorMessage);
       });

       return new ResponseEntity<>(errorMap,HttpStatus.BAD_GATEWAY);



    }
}
