package com.everytechdimension.common.exception;

import java.util.HashMap;

public class AppApiException extends AppException {
    private final static HashMap<Integer, Integer> mapOfStatus = new HashMap<Integer, Integer>();

    static {
        mapOfStatus.put(1, 500);
        mapOfStatus.put(2, 404);
        mapOfStatus.put(3, 400);
    }

    private final int statusCode;

    public AppApiException(AppException e) {
        super(e.getErrorCode(), e.getMessage(), e);
        int errorCode = e.getErrorCode();
        this.statusCode = mapOfStatus.containsKey(errorCode) ? mapOfStatus.get(errorCode) : 500;
    }

    public AppApiException(int statusCode, int errorCode, String msg) {
        super(errorCode, msg);
        this.statusCode = statusCode;
    }

    public AppApiException(int statusCode, int errorCode, String msg, Exception e) {
        super(errorCode, msg, e);
        this.statusCode = statusCode;
    }

    public AppApiException(ErrorCode error, String msg, Exception e) {
        this(error.statusCode, error.value, msg, e);
    }

    public AppApiException(ErrorCode error, String msg) {
        this(error.statusCode, error.value, msg);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public HashMap toJson() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("errorCode", getErrorCode());
        map.put("message", getMessage());
        return map;
    }

    public enum ErrorCode {
        UNKNOWN(1, 500),
        FORBIDDEN(5, 403),
        NOT_FOUND(2, 404),
        VALIDATION(3, 400),
        ERROR(4, 400),
        UNRECOVERABLE_ERROR(8, 500);

        private final int value;
        private final int statusCode;

        ErrorCode(int value, int statusCode) {
            this.value = value;
            this.statusCode = statusCode;
        }

        public int getValue() {
            return value;
        }

        public int getStatusCode() {
            return statusCode;
        }
    }
}
