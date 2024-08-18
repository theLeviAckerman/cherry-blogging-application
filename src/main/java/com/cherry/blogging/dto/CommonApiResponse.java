package com.cherry.blogging.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class CommonApiResponse {

    private  String msg;
    private boolean isSuccess;
    private HttpStatus status;

    public CommonApiResponse(String msg, boolean isSuccess, HttpStatus status) {
        this.msg= msg;
        this.isSuccess=isSuccess;
        this.status= status;
    }
}
