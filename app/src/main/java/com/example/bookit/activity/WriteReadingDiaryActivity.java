package com.example.bookit.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.bookit.R;

public class WriteReadingDiaryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_reading_diary);

        bindEvents();
    }

    private void bindEvents() {
        findViewById(R.id.cancel).setOnClickListener(v -> finish());
    }
}