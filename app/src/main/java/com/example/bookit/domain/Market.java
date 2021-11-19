package com.example.bookit.domain;

import java.io.Serializable;
import java.util.Calendar;

public class Market implements Serializable {
    public static final StatusBook[] STATUS_LIST = {
            new StatusBook(StatusBook.STATUS_BEST, "최상"),
            new StatusBook(StatusBook.STATUS_GOOD, "상"),
            new StatusBook(StatusBook.STATUS_AVERAGE, "중"),
            new StatusBook(StatusBook.STATUS_BAD, "하"),
            new StatusBook(StatusBook.STATUS_LOWEST, "최하")
    };
    private int id;
    private User user;
    private String image;
    private String title;
    private Category category;
    private StatusBook status;
    private int price;
    private String contents;
    private Calendar date;

    public Market(int id, User user, String title, Category category, StatusBook status, int price, String contents, Calendar date) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.category = category;
        this.status = status;
        this.price = price;
        this.contents = contents;
        this.date = date;
    }

    public Market(int id, User user, String image, String title, Category category, StatusBook status, int price, String contents, Calendar date) {
        this.id = id;
        this.user = user;
        this.image = image;
        this.title = title;
        this.category = category;
        this.status = status;
        this.price = price;
        this.contents = contents;
        this.date = date;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public StatusBook getStatus() {
        return status;
    }

    public void setStatus(StatusBook status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Market{" +
                "id=" + id +
                ", user=" + user +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", category=" + category +
                ", status=" + status +
                ", price=" + price +
                ", contents='" + contents + '\'' +
                ", date=" + date +
                '}';
    }
}
