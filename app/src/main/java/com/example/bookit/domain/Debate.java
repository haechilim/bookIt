package com.example.bookit.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

public class Debate implements Serializable {
    private int id;
    private User user;
    private String title;
    private Category category;
    private String contents;
    private boolean agree;
    private boolean disagree;
    private Calendar calendar;
    private Comment comment;

    public Debate(int id, User user, String title, Category category, String contents, boolean agree, boolean disagree, Calendar calendar, Comment comment) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.category = category;
        this.contents = contents;
        this.agree = agree;
        this.disagree = disagree;
        this.calendar = calendar;
        this.comment = comment;
    }

    public Debate(int id, User user, String title, Category category, String contents, Calendar calendar, Comment comment) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.category = category;
        this.contents = contents;
        this.calendar = calendar;
        this.comment = comment;
    }

    public Debate(int id, User user, String title, Category category, String contents) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.category = category;
        this.contents = contents;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public boolean isAgree() {
        return agree;
    }

    public void setAgree(boolean agree) {
        this.agree = agree;
    }

    public boolean isDisagree() {
        return disagree;
    }

    public void setDisagree(boolean disagree) {
        this.disagree = disagree;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Debate{" +
                "id=" + id +
                ", user=" + user +
                ", title='" + title + '\'' +
                ", category=" + category +
                ", contents='" + contents + '\'' +
                ", agree=" + agree +
                ", disagree=" + disagree +
                ", calendar=" + calendar +
                ", comment=" + comment +
                '}';
    }
}
