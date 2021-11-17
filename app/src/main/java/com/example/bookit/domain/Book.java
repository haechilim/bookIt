package com.example.bookit.domain;

import java.io.Serializable;

public class Book implements Serializable {
    private String image;
    private String title;
    private String writer;
    private String publisher;
    private Category category;
    private String description;

    public Book(String image, String title, String writer, String publisher, int categoryId, String description) {
        this.image = image;
        this.title = title;
        this.writer = writer;
        this.publisher = publisher;
        this.category = Category.getCategoryById(categoryId);
        this.description = description;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", publisher='" + publisher + '\'' +
                ", category=" + category +
                ", description='" + description + '\'' +
                '}';
    }
}
