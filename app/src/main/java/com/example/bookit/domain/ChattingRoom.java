package com.example.bookit.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

public class ChattingRoom implements Serializable {
    private User user;
    private String lastMessage;
    private Calendar time;
    private List<Chatting> chattingList;

    public ChattingRoom(User user, String lastMessage) {
        this.user = user;
        this.lastMessage = lastMessage;
        this.time = time;
    }

    public ChattingRoom(User user, String lastMessage, Calendar time, List<Chatting> chattingList) {
        this.user = user;
        this.lastMessage = lastMessage;
        this.time = time;
        this.chattingList = chattingList;
    }

    public ChattingRoom(User user, String lastMessage, List<Chatting> chattingList) {
        this.user = user;
        this.lastMessage = lastMessage;
        this.time = Calendar.getInstance();
        this.chattingList = chattingList;
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

    public List<Chatting> getChattingList() {
        return chattingList;
    }

    public void setChattingList(List<Chatting> chattingList) {
        this.chattingList = chattingList;
    }

    @Override
    public String toString() {
        return "ChattingRoom{" +
                "user=" + user +
                ", lastMessage='" + lastMessage + '\'' +
                ", time=" + time +
                ", chattingList=" + chattingList +
                '}';
    }
}
