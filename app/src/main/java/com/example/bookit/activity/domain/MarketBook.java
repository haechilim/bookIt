package com.example.bookit.activity.domain;

import java.util.Calendar;

public class MarketBook {
    private Book book;
    private int status;
    private int price;
    private Calendar time;

    public MarketBook(Book book, int status, int price) {
        this.book = book;
        this.status = status;
        this.price = price;
        this.time = Calendar.getInstance();
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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
