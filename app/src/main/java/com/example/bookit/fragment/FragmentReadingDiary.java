package com.example.bookit.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.bookit.R;
import com.example.bookit.activity.WriteReadingDiaryActivity;
import com.example.bookit.adapter.ReadingDiaryListAdapter;
import com.example.bookit.helper.Util;
import com.example.bookit.manager.ApiManager;

public class FragmentReadingDiary extends Fragment {
    private static Activity activity;
    private static View view;

    public FragmentReadingDiary(Activity activity) {
        this.activity = activity;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_reading_diary, container, false);

        updateList();
        bindEvents(view);

        return view;
    }

    public static void updateList() {
        ApiManager.getReadingDiary(readingDiaryList -> {
            ListView listView = view.findViewById(R.id.readingDiaryList);
            listView.setAdapter(new ReadingDiaryListAdapter(activity, readingDiaryList));
        });
    }

    private void bindEvents(View view) {
        view.findViewById(R.id.addButton).setOnClickListener(v -> Util.startActivity(activity, WriteReadingDiaryActivity.class, Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }
}
