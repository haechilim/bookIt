package com.example.bookit.domain;

import java.io.Serializable;
import java.util.Calendar;

public class Comment implements Serializable {
    private int id;
    private User user;
    private String contents;
    private Calendar calendar;

    public Comment(int id, User user, String contents, Calendar calendar) {
        this.id = id;
        this.user = user;
        this.contents = contents;
        this.calendar = calendar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", user=" + user +
                ", contents='" + contents + '\'' +
                ", calendar=" + calendar +
                '}';
    }
}
