package com.cherry.blogging.execption;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

    private String resourceName;
    private String fieldName;
    private int fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, int fieldValue) {

        super(String.format("%s not found with %s : %d", resourceName, fieldName, fieldValue));
        this.resourceName=resourceName;
        this.fieldValue=fieldValue;
        this.fieldName=fieldName;
    }

}
