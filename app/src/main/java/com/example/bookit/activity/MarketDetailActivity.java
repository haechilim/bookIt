package com.example.bookit.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bookit.R;
import com.example.bookit.domain.Market;
import com.example.bookit.helper.Util;
import com.example.bookit.manager.ApiManager;
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

        Log.d("haechilim", ApiManager.HOST + market.getImage());

        Glide.with(this).load(ApiManager.HOST + market.getImage()).into((ImageView) findViewById(R.id.image));
        ((LinearLayout)findViewById(R.id.userContainer)).addView(new UserView(this, market.getUser(), true));
        ((TextView)findViewById(R.id.title)).setText(market.getTitle());
        ((TextView) findViewById(R.id.status)).setText(market.getStatus().getMessage());
        ((TextView) findViewById(R.id.date)).setText(Util.getDateMessage(market.getDate()));
        ((TextView) findViewById(R.id.contents)).setText(market.getContents());
        ((TextView) findViewById(R.id.price)).setText(Util.getPriceMessage(market.getPrice()));
    }

    private void bindEvents() {
        findViewById(R.id.back).setOnClickListener(v -> finish());
    }
}