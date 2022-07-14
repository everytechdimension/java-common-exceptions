package com.everytechdimension.common.exception;

public class StorageException extends AppException {
    public StorageException() {
        super(3, "Insufficient Storage, pleasee contact support. ");
    }

    public StorageException(Exception e) {
        super(3, "Insufficient Storage, pleasee contact support. ", e);
    }

    public StorageException(String msg) {
        super(3, msg);
    }

    public StorageException(String msg, Exception e) {
        super(3, msg, e);
    }
}
