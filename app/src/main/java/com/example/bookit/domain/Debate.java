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
    private List<Comment> comments;

    public Debate(int id, User user, String title, Category category, String contents, Calendar calendar, List<Comment> comments) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.category = category;
        this.contents = contents;
        this.calendar = calendar;
        this.comments = comments;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
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
                ", comments=" + comments +
                '}';
    }
}
