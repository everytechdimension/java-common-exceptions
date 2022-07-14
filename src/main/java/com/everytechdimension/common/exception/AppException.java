package com.everytechdimension.common.exception;

public class AppException extends Exception {
    private final int errorCode;

    public AppException(int errorCode, String msg, Exception e) {
        super(msg, e);
        this.errorCode = errorCode;
    }

    public AppException(String msg) {
        super(msg);
        this.errorCode = 1;
    }

    public AppException(int errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}

