package com.example.bookit.domain;

import java.io.Serializable;
import java.util.Calendar;

public class ReadingDiary implements Serializable {
    private String title;
    private String contents;
    private Calendar time;

    public ReadingDiary(String title, String contents) {
        this.title = title;
        this.contents = contents;
        this.time = Calendar.getInstance();
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

    public Calendar getTime() {
        return time;
    }

    public void setTime(Calendar time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ReadingDiary{" +
                "title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", calendar=" + time +
                '}';
    }
}
