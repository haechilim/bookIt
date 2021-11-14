package com.example.bookit.domain;

import java.util.Calendar;

public class MarketBook {
    public static final StatusBook[] STATUS_LIST = {
            new StatusBook(StatusBook.STATUS_BEST, "최상"),
            new StatusBook(StatusBook.STATUS_GOOD, "상"),
            new StatusBook(StatusBook.STATUS_AVERAGE, "중"),
            new StatusBook(StatusBook.STATUS_BAD, "하"),
            new StatusBook(StatusBook.STATUS_LOWEST, "최하")
    };

    private Book book;
    private StatusBook status;
    private int price;
    private Calendar time;

    public MarketBook(Book book, StatusBook status, int price) {
        this.book = book;
        this.status = status;
        this.price = price;
    }

    public MarketBook(Book book, StatusBook status, int price, Calendar time) {
        this.book = book;
        this.status = status;
        this.price = price;
        this.time = time;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
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

    public Calendar getTime() {
        return time;
    }

    public void setTime(Calendar time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "MarketBook{" +
                "book=" + book +
                ", status=" + status +
                ", price=" + price +
                ", time=" + time +
                '}';
    }
}
