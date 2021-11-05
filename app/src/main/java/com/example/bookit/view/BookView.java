package com.example.bookit.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.bookit.R;
import com.example.bookit.activity.BookActivity;
import com.example.bookit.domain.Book;

public class BookView extends LinearLayout {
    private Context context;
    private Book book;

    public BookView(Context context, Book book) {
        super(context);

        this.context = context;
        this.book = book;

        initView();
    }

    public BookView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BookView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BookView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initView() {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.layout_book, this, true);

        ((TextView)view.findViewById(R.id.title)).setText(book.getTitle());

        view.setOnClickListener(v -> {
            Intent intent = new Intent(context, BookActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("book", book);
            context.startActivity(intent);
        });
    }
}
