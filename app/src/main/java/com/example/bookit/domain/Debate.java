package com.example.bookit.domain;

import java.io.Serializable;
import java.util.List;

public class Debate implements Serializable {
    private User user;
    private int category;
    private String title;
    private String contents;
    private boolean agree;
    private boolean disagree;
    private List<Comment> comments;

    public Debate(User user, int category, String title, String contents, boolean agree, boolean disagree) {
        this.user = user;
        this.category = category;
        this.title = title;
        this.contents = contents;
        this.agree = agree;
        this.disagree = disagree;
    }

    public Debate(User user, int category, String title, String contents, boolean agree, boolean disagree, List<Comment> comments) {
        this.user = user;
        this.category = category;
        this.title = title;
        this.contents = contents;
        this.agree = agree;
        this.disagree = disagree;
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
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
                "user=" + user +
                ", category=" + category +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", agree=" + agree +
                ", disagree=" + disagree +
                ", comments=" + comments +
                '}';
    }
}
