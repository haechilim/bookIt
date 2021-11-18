package com.example.bookit.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bookit.R;
import com.example.bookit.domain.Book;

public class BookDetailActivity extends AppCompatActivity {
    private Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.activity_book_detail);
        init();
        eventsBind();
    }

    private void init() {
        Intent intent = getIntent();
        book = (Book)(intent.getSerializableExtra("book"));

        Glide.with(this).load(book.getImage()).into((ImageView) findViewById(R.id.image));
        ((TextView)findViewById(R.id.title)).setText(book.getTitle());
        ((TextView)findViewById(R.id.writer)).setText("저자: " + book.getWriter());
        ((TextView)findViewById(R.id.publisher)).setText("출판사: " + book.getPublisher());
        ((TextView)findViewById(R.id.category)).setText("분야: " + book.getCategory().getName());
        ((TextView)findViewById(R.id.description)).setText(book.getDescription());
    }

    private void eventsBind() {
        findViewById(R.id.back).setOnClickListener(v -> finish());
    }
}