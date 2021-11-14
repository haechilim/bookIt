package com.example.bookit.domain;

public class StatusBook {
    public static final int STATUS_BEST = 0;
    public static final int STATUS_GOOD = 1;
    public static final int STATUS_AVERAGE = 2;
    public static final int STATUS_BAD = 3;
    public static final int STATUS_LOWEST = 4;

    private int status;
    private String message;

    public StatusBook(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
