package com.example.bookit.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bookit.R;
import com.example.bookit.domain.ReadingDiary;
import com.example.bookit.fragment.FragmentReadingDiary;
import com.example.bookit.helper.Util;
import com.example.bookit.manager.ApiManager;

public class ReadingDiaryDetailActivity extends AppCompatActivity {
    private ReadingDiary readingDiary;
    private LinearLayout popupOption;
    private static TextView titleView;
    private static TextView dateView;
    private static TextView contentsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_diary_detail);

        init();
        bindEvents();
    }

    private void init() {
        Intent intent = getIntent();
        readingDiary = (ReadingDiary) intent.getSerializableExtra("readingDiary");
        popupOption = findViewById(R.id.popupOption);
        titleView = findViewById(R.id.title);
        dateView = findViewById(R.id.date);
        contentsView = findViewById(R.id.contents);

        updateReadingDiary(readingDiary.getTitle(), readingDiary.getDate(), readingDiary.getContents());
    }

    public static void updateReadingDiary(String title, String date, String contents) {
        titleView.setText(title);
        dateView.setText(date);
        contentsView.setText(contents);
    }

    private void bindEvents() {
        findViewById(R.id.back).setOnClickListener(v -> finish());

        findViewById(R.id.option).setOnClickListener(v -> showPopupOption(true));

        findViewById(R.id.edit).setOnClickListener(v -> {
            showPopupOption(false);
            Util.startActivity(this, WriteReadingDiaryActivity.class, Intent.FLAG_ACTIVITY_CLEAR_TOP, "readingDiary", readingDiary);
        });

        findViewById(R.id.delete).setOnClickListener(v -> {
            ApiManager.deleteReadingDiary(readingDiary.getId(), success -> {
                Util.toast(this, "독서기록이 삭제되었습니다.", true);
                FragmentReadingDiary.updateList();
                finish();
            });
        });

        findViewById(R.id.cancel).setOnClickListener(v -> showPopupOption(false));
    }

    private void showPopupOption(boolean visibility) {
        popupOption.setVisibility(visibility ? View.VISIBLE : View.INVISIBLE);
    }
}