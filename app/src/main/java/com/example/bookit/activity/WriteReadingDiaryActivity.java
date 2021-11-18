package com.example.bookit.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bookit.R;
import com.example.bookit.domain.ReadingDiary;
import com.example.bookit.fragment.FragmentReadingDiary;
import com.example.bookit.helper.Util;
import com.example.bookit.manager.ApiManager;

public class WriteReadingDiaryActivity extends AppCompatActivity {
    private EditText inputTitle;
    private EditText inputDate;
    private EditText inputContents;
    private TextView upload;
    private TextView edit;

    private ReadingDiary readingDiary;

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
        upload = findViewById(R.id.upload);
        edit = findViewById(R.id.edit);

        Intent intent = getIntent();
        readingDiary = (ReadingDiary) intent.getSerializableExtra("readingDiary");

        showUploadButton(readingDiary == null);

        if(readingDiary != null) {
            inputTitle.setText(readingDiary.getTitle());
            inputDate.setText(readingDiary.getDate());
            inputContents.setText(readingDiary.getContents());
        }
    }

    private void bindEvents() {
        findViewById(R.id.cancel).setOnClickListener(v -> finish());

        upload.setOnClickListener(v -> {
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

        edit.setOnClickListener(v -> {
            int id = readingDiary.getId();
            String title = inputTitle.getText().toString().trim();
            String date = inputDate.getText().toString().trim();
            String contents = inputContents.getText().toString().trim();

            ApiManager.editReadingDiary(id, title, date, contents, success -> {
                if(success) {
                    FragmentReadingDiary.updateList();
                    ReadingDiaryDetailActivity.updateReadingDiary(title, date, contents);
                    finish();
                }
                else Util.toast(this, "독서기록을 수정하지 못했습니다.", false);
            });
        });
    }


    private void showUploadButton(boolean visibility) {
        upload.setVisibility(visibility ? View.VISIBLE : View.GONE);
        edit.setVisibility(visibility ? View.GONE : View.VISIBLE);
    }
}