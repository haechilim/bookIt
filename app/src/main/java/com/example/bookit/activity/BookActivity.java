package com.example.bookit.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.bookit.R;
import com.example.bookit.domain.Book;

public class BookActivity extends AppCompatActivity {
    private Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.activity_book);
        init();
        eventsBind();
    }

    private void init() {
        Intent intent = getIntent();
        book = (Book)(intent.getSerializableExtra("book"));

        ((TextView)findViewById(R.id.title)).setText(book.getTitle());
        ((TextView)findViewById(R.id.writer)).setText("저자: " + book.getWriter());
        ((TextView)findViewById(R.id.publisher)).setText("출판사: " + book.getPublisher());
    }

    private void eventsBind() {
        findViewById(R.id.back).setOnClickListener(v -> finish());
    }
}