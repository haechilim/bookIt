package com.example.bookit.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bookit.R;
import com.example.bookit.activity.ReadingDiaryDetailActivity;
import com.example.bookit.domain.ReadingDiary;
import com.example.bookit.helper.Util;

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
        View view = ((LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.layout_reading_diary_list_item, parent, false);
        ReadingDiary readingDiary = readingDiaryList.get(position);

        init(view, readingDiary);
        bindEvents(view, readingDiary);

        return view;
    }

    private void init(View view, ReadingDiary readingDiary) {
        ((TextView) view.findViewById(R.id.title)).setText(readingDiary.getTitle());
        ((TextView) view.findViewById(R.id.contents)).setText(readingDiary.getContents());
        //((TextView) view.findViewById(R.id.time)).setText(readingDiary.getTime().toString());
    }

    private void bindEvents(View view, ReadingDiary readingDiary) {
        view.setOnClickListener(v -> Util.startActivity(activity, ReadingDiaryDetailActivity.class, Intent.FLAG_ACTIVITY_CLEAR_TOP, "readingDiary", readingDiary));
    }
}
