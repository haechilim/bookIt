package com.example.bookit.domain;

import java.io.Serializable;

public class ReadingDiary implements Serializable {
    private int id;
    private String title;
    private String date;
    private String contents;

    public ReadingDiary(int id, String title, String date, String contents) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.contents = contents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "ReadingDiary{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", time='" + date + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}
