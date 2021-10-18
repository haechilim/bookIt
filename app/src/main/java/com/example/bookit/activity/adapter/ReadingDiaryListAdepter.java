package com.example.bookit.activity.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.bookit.activity.domain.ReadingDiary;

import java.util.List;

public class ReadingDiaryListAdepter extends BaseAdapter {
    private Activity activity;
    private List<ReadingDiary> readingDiaryList;

    public ReadingDiaryListAdepter(Activity activity, List<ReadingDiary> readingDiaryList) {
        this.activity = activity;
        this.readingDiaryList = readingDiaryList;
    }

    @Override
    public int getCount() {
        return readingDiaryList.size();
    }

    @Override
    public Object getItem(int position) {
        return readingDiaryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
