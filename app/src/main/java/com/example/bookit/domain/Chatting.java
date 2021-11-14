package com.example.bookit.domain;

import java.io.Serializable;

public class Chatting implements Serializable {
    private User user;
    private String message;

    public Chatting(User user, String message) {
        this.user = user;
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Chatting{" +
                "user=" + user +
                ", message='" + message + '\'' +
                '}';
    }
}
