package com.example.bookit.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.bookit.R;
import com.example.bookit.domain.Category;
import com.example.bookit.domain.MarketBook;

import java.util.Collections;

public class WriteMarketActivity extends AppCompatActivity {
    private Spinner categorySpinner;
    private Spinner statusSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_market);

        init();
        bindEvents();
    }

    private void init() {
        categorySpinner = findViewById(R.id.category);
        statusSpinner = findViewById(R.id.status);

        categorySpinner.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item, Category.CATEGORY_LIST));
        statusSpinner.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item, MarketBook.STATUS_LIST));
    }

    private void bindEvents() {
        findViewById(R.id.cancel).setOnClickListener(v -> finish());
    }
}