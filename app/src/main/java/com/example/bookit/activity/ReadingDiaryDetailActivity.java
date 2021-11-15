package com.example.bookit.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bookit.R;
import com.example.bookit.domain.ReadingDiary;

public class ReadingDiaryDetailActivity extends AppCompatActivity {
    private ReadingDiary readingDiary;
    private LinearLayout popupOption;

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

        ((TextView)findViewById(R.id.title)).setText(readingDiary.getTitle());
        //TODO 시간 ((TextView)findViewById(R.id.title)).setText(readingDiary.getTitle());
        ((TextView)findViewById(R.id.contents)).setText(readingDiary.getContents());
    }

    private void bindEvents() {
        findViewById(R.id.back).setOnClickListener(v -> finish());

        findViewById(R.id.option).setOnClickListener(v -> showPopupOption(true));

        findViewById(R.id.edit).setOnClickListener(v -> {
            //TODO 수정
        });

        findViewById(R.id.delete).setOnClickListener(v -> {
            //TODO 삭제
        });

        findViewById(R.id.cancel).setOnClickListener(v -> showPopupOption(false));
    }

    private void showPopupOption(boolean visibility) {
        popupOption.setVisibility(visibility ? View.VISIBLE : View.INVISIBLE);
    }
}