package com.example.bookit.activity.domain;

import java.util.Calendar;

public class ReadingDiary {
    private String title;
    private String contents;
    private Calendar calendar;

    public ReadingDiary(String title, String contents) {
        this.title = title;
        this.contents = contents;
        this.calendar = Calendar.getInstance();
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

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public String toString() {
        return "ReadingDiary{" +
                "title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", calendar=" + calendar +
                '}';
    }
}
