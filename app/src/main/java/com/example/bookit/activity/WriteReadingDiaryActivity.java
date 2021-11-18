package com.example.bookit.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.bookit.R;
import com.example.bookit.fragment.FragmentReadingDiary;
import com.example.bookit.helper.Util;
import com.example.bookit.manager.ApiManager;

public class WriteReadingDiaryActivity extends AppCompatActivity {
    private EditText inputTitle;
    private EditText inputDate;
    private EditText inputContents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_reading_diary);

        init();
        bindEvents();
    }

    private void init() {
        inputTitle = findViewById(R.id.inputTitle);
        inputDate = findViewById(R.id.inputDate);
        inputContents = findViewById(R.id.inputContents);
    }

    private void bindEvents() {
        findViewById(R.id.cancel).setOnClickListener(v -> finish());

        findViewById(R.id.upload).setOnClickListener(v -> {
            String title = inputTitle.getText().toString().trim();
            String date = inputDate.getText().toString().trim();
            String contents = inputContents.getText().toString().trim();

            if(title.isEmpty() || date.isEmpty() || contents.isEmpty()) return;

            ApiManager.writeReadingDiary(title, date, contents, success -> {
                if(success) {
                    FragmentReadingDiary.updateList();
                    finish();
                }
                else Util.toast(this, "독서기록을 작성하지 못했습니다.", false);
            });
        });
    }
}