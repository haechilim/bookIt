package com.example.bookit.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bookit.R;
import com.example.bookit.domain.Debate;
import com.example.bookit.domain.MarketBook;
import com.example.bookit.helper.DebateManager;
import com.example.bookit.view.UserView;

public class MarketDetailActivity extends AppCompatActivity {
    private MarketBook marketBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_detail);

        init();
        bindEvents();
    }

    private void init() {
        Intent intent = getIntent();
        marketBook = (MarketBook) intent.getSerializableExtra("marketBook");

        ((LinearLayout)findViewById(R.id.userContainer)).addView(new UserView(this, marketBook.getUser(), true));
    }

    private void bindEvents() {
        findViewById(R.id.back).setOnClickListener(v -> finish());
    }
}