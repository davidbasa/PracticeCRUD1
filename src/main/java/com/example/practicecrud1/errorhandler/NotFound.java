package com.example.practicecrud1.errorhandler;

public class NotFound {
    String resourceName;
    String fieldName;
    Object fieldValue;

    public NotFound(String resourceName,String fieldName,Object fieldValue){
        this.resourceName=resourceName;
        this.fieldName=fieldName;
        this.fieldValue=fieldValue;
    }
}
