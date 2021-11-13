package com.example.bookit.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookit.R;
import com.example.bookit.domain.Category;

public class WriteDebateActivity extends AppCompatActivity {
    private Spinner categorySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_debate);

        init();
        bindEvents();
    }

    private void init() {
        categorySpinner = findViewById(R.id.category);
        categorySpinner.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item, Category.CATEGORY_LIST));
    }

    private void bindEvents() {
         findViewById(R.id.cancel).setOnClickListener(v -> finish());
    }
}