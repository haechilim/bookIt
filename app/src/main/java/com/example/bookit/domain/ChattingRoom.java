package com.example.bookit.domain;

import java.util.Calendar;

public class ChattingRoom {
    private String name;
    private String message;
    private Calendar time;

    public ChattingRoom(String name, String message, Calendar time) {
        this.name = name;
        this.message = message;
        this.time = time;
    }

    public ChattingRoom(String name, String message) {
        this.name = name;
        this.message = message;
        this.time = Calendar.getInstance();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Calendar getTime() {
        return time;
    }

    public void setTime(Calendar time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ChattingRoom{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", time=" + time +
                '}';
    }
}
