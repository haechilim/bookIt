package com.example.bookit.domain;

import java.io.Serializable;

public class Book implements Serializable {
    private String image;
    private String title;
    private String writer;
    private String publisher;
    private int category;
    private String contents;

    public Book(String image, String title, String writer, String publisher, int category, String contents) {
        this.image = image;
        this.title = title;
        this.writer = writer;
        this.publisher = publisher;
        this.category = category;
        this.contents = contents;
    }

    public Book(String title) {
        this.title = title;
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

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "Book{" +
                "image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", publisher='" + publisher + '\'' +
                ", category=" + category +
                ", contents='" + contents + '\'' +
                '}';
    }
}
