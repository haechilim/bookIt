package com.example.bookit.domain;

import java.io.Serializable;
import java.util.Calendar;

public class ChattingRoom implements Serializable {
    private User user;
    private String lastMessage;
    private Calendar time;

    public ChattingRoom(User user, String lastMessage, Calendar time) {
        this.user = user;
        this.lastMessage = lastMessage;
        this.time = time;
    }

    public ChattingRoom(User user, String lastMessage) {
        this.user = user;
        this.lastMessage = lastMessage;
        this.time = Calendar.getInstance();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
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
                "user=" + user +
                ", lastMessage='" + lastMessage + '\'' +
                ", time=" + time +
                '}';
    }
}
