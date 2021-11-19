package com.example.bookit.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.bookit.R;
import com.example.bookit.domain.Market;
import com.example.bookit.view.UserView;

public class MarketDetailActivity extends AppCompatActivity {
    private Market market;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_detail);

        init();
        bindEvents();
    }

    private void init() {
        Intent intent = getIntent();
        market = (Market) intent.getSerializableExtra("marketBook");

        ((LinearLayout)findViewById(R.id.userContainer)).addView(new UserView(this, market.getUser(), true));
    }

    private void bindEvents() {
        findViewById(R.id.back).setOnClickListener(v -> finish());
    }
}