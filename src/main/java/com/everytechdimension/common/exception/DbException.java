package com.everytechdimension.common.exception;

public class DbException extends StorageException {
    public DbException(String tablename, String method, String sql) {
        this(tablename, method, new Exception("couldn't execute SQL: '" + sql + "'"));
    }

    public DbException(String tablename, String method, Exception e) {
        super("Error occurred: " + e.getMessage() + ". TableName: " + tablename + " could not be " + method + ". ", e);
    }
    public DbException(String tablename, String method, Exception e, String sql) {
        super("Error occurred: " + e.getMessage() + ". TableName: " + tablename + " could not be " + method + ". ", e);
    }
}
