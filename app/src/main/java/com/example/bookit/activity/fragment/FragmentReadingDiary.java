package com.example.bookit.activity.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.bookit.R;
import com.example.bookit.activity.adapter.ReadingDiaryListAdepter;
import com.example.bookit.activity.domain.ReadingDiary;

import java.util.ArrayList;
import java.util.List;

public class FragmentReadingDiary extends Fragment {
    private Activity activity;

    public FragmentReadingDiary(Activity activity) {
        this.activity = activity;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reading_diary, container, false);

        List<ReadingDiary> readingDiaryList = new ArrayList<>();

        ListView listView = view.findViewById(R.id.readingDiaryList);
        listView.setAdapter(new ReadingDiaryListAdepter(activity, readingDiaryList));

        return view;
    }
}
