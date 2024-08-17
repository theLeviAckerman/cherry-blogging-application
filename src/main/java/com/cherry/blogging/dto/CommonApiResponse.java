package com.cherry.blogging.dto;

public class CommonApiResponse {

    private  String msg;
    private boolean isSuccess;
    public CommonApiResponse(String msg, boolean isSuccess) {
        this.msg= msg;
        this.isSuccess=isSuccess;
    }
}
