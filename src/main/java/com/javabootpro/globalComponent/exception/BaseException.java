package com.javabootpro.globalComponent.exception;

import lombok.Data;

@Data
public class BaseException extends RuntimeException{
    Integer errorCode;
    public BaseException(String message) {
        super(message);
    }

    public BaseException(Integer code , String message) {
        super(message);
        errorCode =code;
    }
}
